/*
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License.
 *
 */

package com.azure.cosmos;

import com.azure.cosmos.implementation.encryption.AeadAes256CbcHmac256Algorithm;
import com.azure.cosmos.implementation.encryption.AeadAes256CbcHmac256EncryptionKey;
import com.azure.cosmos.implementation.encryption.EncryptionType;
import com.azure.cosmos.implementation.encryption.JavaKeyProvider;
import com.azure.cosmos.implementation.encryption.TestUtils;
import com.azure.cosmos.implementation.encryption.api.CosmosEncryptionAlgorithm;
import com.azure.cosmos.implementation.encryption.api.DataEncryptionKey;
import com.azure.cosmos.implementation.encryption.api.EncryptionOptions;
import com.azure.cosmos.implementation.guava25.collect.ImmutableList;
import com.azure.cosmos.models.CosmosItemRequestOptions;
import com.azure.cosmos.models.CosmosItemResponse;
import com.azure.cosmos.models.FeedOptions;
import com.azure.cosmos.models.FeedResponse;
import com.azure.cosmos.models.ModelBridgeInternal;
import com.azure.cosmos.models.PartitionKey;
import com.azure.cosmos.models.SqlQuerySpec;
import com.azure.cosmos.rx.TestSuiteBase;
import com.azure.cosmos.util.CosmosPagedIterable;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

public class EncryptionTest extends TestSuiteBase {
    static JavaKeyProvider javaKeyProvider = new JavaKeyProvider();

    private CosmosClient client;
    private CosmosContainer container;
    private static final int TIMEOUT = 60_000;

    @Factory(dataProvider = "clientBuilders")
    public EncryptionTest(CosmosClientBuilder clientBuilder) {
        super(CosmosBridgeInternal.setDateKeyProvider(clientBuilder, javaKeyProvider));
    }

    @BeforeClass(groups = {"simple"}, timeOut = SETUP_TIMEOUT)
    public void before_CosmosItemTest() {
        assertThat(this.client).isNull();
        this.client = getClientBuilder().buildClient();
        CosmosAsyncContainer asyncContainer = getSharedMultiPartitionCosmosContainer(this.client.asyncClient());
        container = client.getDatabase(asyncContainer.getDatabase().getId()).getContainer(asyncContainer.getId());
    }

    @AfterClass(groups = {"simple"}, timeOut = SHUTDOWN_TIMEOUT, alwaysRun = true)
    public void afterClass() {
        assertThat(this.client).isNotNull();
        this.client.close();
    }

    @Test(groups = {"simple"}, timeOut = TIMEOUT)
    public void createItemEncrypt_readItemDecrypt() throws Exception {
        CosmosItemRequestOptions requestOptions = new CosmosItemRequestOptions();
        EncryptionOptions encryptionOptions = new EncryptionOptions();
        encryptionOptions.setPathsToEncrypt(ImmutableList.of("/sensitive"));

        DataEncryptionKey dataEncryptionKey = createDataEncryptionKey();
        javaKeyProvider.addKey(dataEncryptionKey);

        encryptionOptions.setDataEncryptionKeyId(dataEncryptionKey.getId());
        ModelBridgeInternal.setEncryptionOptions(requestOptions, encryptionOptions);

        Pojo properties = getItem(UUID.randomUUID().toString());
        CosmosItemResponse<Pojo> itemResponse = container.createItem(properties, requestOptions);
        assertThat(itemResponse.getRequestCharge()).isGreaterThan(0);

        Pojo responseItem = itemResponse.getItem();
        validateWriteResponseIsValid(properties, responseItem);

        Pojo readItem = container.readItem(properties.id, new PartitionKey(properties.mypk), requestOptions, Pojo.class).getItem();
        validateReadResponseIsValid(properties, readItem);
    }

    @Test(groups = {"simple"}, timeOut = TIMEOUT)
    public void upsertItem_readItem() throws Exception {
        CosmosItemRequestOptions requestOptions = new CosmosItemRequestOptions();
        EncryptionOptions encryptionOptions = new EncryptionOptions();
        encryptionOptions.setPathsToEncrypt(ImmutableList.of("/sensitive"));

        DataEncryptionKey dataEncryptionKey = createDataEncryptionKey();
        javaKeyProvider.addKey(dataEncryptionKey);

        encryptionOptions.setDataEncryptionKeyId(dataEncryptionKey.getId());
        ModelBridgeInternal.setEncryptionOptions(requestOptions, encryptionOptions);

        Pojo properties = getItem(UUID.randomUUID().toString());
        CosmosItemResponse<Pojo> itemResponse = container.upsertItem(properties, requestOptions);
        assertThat(itemResponse.getRequestCharge()).isGreaterThan(0);

        Pojo responseItem = itemResponse.getItem();
        validateWriteResponseIsValid(properties, responseItem);

        Pojo readItem = container.readItem(properties.id, new PartitionKey(properties.mypk), requestOptions, Pojo.class).getItem();
        validateReadResponseIsValid(properties, readItem);
    }

    private void validateWriteResponseIsValid(Pojo originalItem, Pojo result) {
        assertThat(result.sensitive).isNull();
        assertThat(result.id).isEqualTo(originalItem.id);
        assertThat(result.mypk).isEqualTo(originalItem.mypk);
        assertThat(result.nonSensitive).isEqualTo(originalItem.nonSensitive);
    }

    private void validateReadResponseIsValid(Pojo originalItem, Pojo result) {
        assertThat(result.id).isEqualTo(originalItem.id);
        assertThat(result.mypk).isEqualTo(originalItem.mypk);
        assertThat(result.nonSensitive).isEqualTo(originalItem.nonSensitive);
        assertThat(result.sensitive).isEqualTo(originalItem.sensitive);
    }

    private void validateQueryResponseIsValid(Pojo originalItem, Pojo result) {
        assertThat(result.id).isEqualTo(originalItem.id);
        assertThat(result.mypk).isEqualTo(originalItem.mypk);
        assertThat(result.nonSensitive).isEqualTo(originalItem.nonSensitive);
        assertThat(result.sensitive).isNull();
    }

    @Test(groups = {"simple"}, timeOut = TIMEOUT)
    public void readItem() throws Exception {
        Pojo properties = getItem(UUID.randomUUID().toString());
        CosmosItemResponse<Pojo> itemResponse = container.createItem(properties);

        CosmosItemResponse<Pojo> readResponse1 = container.readItem(properties.id,
            new PartitionKey(properties.mypk),
            new CosmosItemRequestOptions(),
            Pojo.class);
        validateItemResponse(properties, readResponse1);
    }

    @Test(groups = {"simple"}, timeOut = TIMEOUT)
    public void readAllItems() throws Exception {
        Pojo properties = getItem(UUID.randomUUID().toString());
        CosmosItemResponse<Pojo> itemResponse = container.createItem(properties);

        FeedOptions feedOptions = new FeedOptions();

        CosmosPagedIterable<Pojo> feedResponseIterator3 =
            container.readAllItems(feedOptions, Pojo.class);
        assertThat(feedResponseIterator3.iterator().hasNext()).isTrue();
    }


    @Test(groups = {"simple"}, timeOut = TIMEOUT)
    public void queryItems() throws Exception {
        Pojo properties = getItem(UUID.randomUUID().toString());
        CosmosItemResponse<Pojo> itemResponse = container.createItem(properties);

        String query = String.format("SELECT * from c where c.id = '%s'", properties.id);
        FeedOptions feedOptions = new FeedOptions();

        CosmosPagedIterable<Pojo> feedResponseIterator1 =
            container.queryItems(query, feedOptions, Pojo.class);
        // Very basic validation
        assertThat(feedResponseIterator1.iterator().hasNext()).isTrue();

        SqlQuerySpec querySpec = new SqlQuerySpec(query);
        CosmosPagedIterable<Pojo> feedResponseIterator3 =
            container.queryItems(querySpec, feedOptions, Pojo.class);
        assertThat(feedResponseIterator3.iterator().hasNext()).isTrue();
    }

    @Test(groups = {"simple"}, timeOut = TIMEOUT)
    public void queryItemsWithContinuationTokenAndPageSize() throws Exception {
        List<String> actualIds = new ArrayList<>();
        Pojo properties = getItem(UUID.randomUUID().toString());
        container.createItem(properties);
        actualIds.add(properties.id);
        properties = getItem(UUID.randomUUID().toString());
        container.createItem(properties);
        actualIds.add(properties.id);
        properties = getItem(UUID.randomUUID().toString());
        container.createItem(properties);
        actualIds.add(properties.id);


        String query = String.format("SELECT * from c where c.id in ('%s', '%s', '%s')", actualIds.get(0), actualIds.get(1), actualIds.get(2));
        FeedOptions feedOptions = new FeedOptions();
        String continuationToken = null;
        int pageSize = 1;

        int initialDocumentCount = 3;
        int finalDocumentCount = 0;

        CosmosPagedIterable<Pojo> feedResponseIterator1 =
            container.queryItems(query, feedOptions, Pojo.class);

        do {
            Iterable<FeedResponse<Pojo>> feedResponseIterable =
                feedResponseIterator1.iterableByPage(continuationToken, pageSize);
            for (FeedResponse<Pojo> fr : feedResponseIterable) {
                int resultSize = fr.getResults().size();
                assertThat(resultSize).isEqualTo(pageSize);
                finalDocumentCount += fr.getResults().size();
                continuationToken = fr.getContinuationToken();
            }
        } while (continuationToken != null);

        assertThat(finalDocumentCount).isEqualTo(initialDocumentCount);

    }


    private Pojo getItem(String documentId) {
        final String uuid = UUID.randomUUID().toString();

        Pojo pojo = new Pojo();
        pojo.id = uuid;
        pojo.mypk = uuid;
        pojo.nonSensitive = UUID.randomUUID().toString();
        pojo.sensitive = UUID.randomUUID().toString();

        return pojo;
    }

    private void validateItemResponse(Pojo containerProperties,
                                      CosmosItemResponse<Pojo> createResponse) {
        // Basic validation
        assertThat(BridgeInternal.getProperties(createResponse).getId()).isNotNull();
        assertThat(BridgeInternal.getProperties(createResponse).getId())
            .as("check Resource Id")
            .isEqualTo(containerProperties.id);
    }

    public static class Pojo {
        public String id;
        @JsonProperty
        public String mypk;
        @JsonProperty
        public String sensitive;
        @JsonProperty
        public String nonSensitive;
    }

    private DataEncryptionKey createDataEncryptionKey() throws Exception {
        byte[] key = TestUtils.generatePBEKeySpec("testPass");

        AeadAes256CbcHmac256EncryptionKey aeadAesKey = TestUtils.instantiateAeadAes256CbcHmac256EncryptionKey(key);
        AeadAes256CbcHmac256Algorithm encryptionAlgorithm = TestUtils.instantiateAeadAes256CbcHmac256Algorithm(aeadAesKey, EncryptionType.RANDOMIZED, (byte) 0x01);
        DataEncryptionKey javaDataEncryptionKey = new DataEncryptionKey() {
            String id = UUID.randomUUID().toString();

            @Override
            public String getId() {
                return id;
            }

            @Override
            public byte[] getRawKey() {
                return key;
            }

            @Override
            public CosmosEncryptionAlgorithm getCosmosEncryptionAlgorithm() {
                return CosmosEncryptionAlgorithm.AE_AES_256_CBC_HMAC_SHA_256_RANDOMIZED;
            }

            @Override
            public byte[] encryptData(byte[] plainText) {
                return encryptionAlgorithm.encryptData(plainText);
            }

            @Override
            public byte[] decryptData(byte[] cipherText) {
                return encryptionAlgorithm.decryptData(cipherText);
            }
        };
        return javaDataEncryptionKey;
    }
}