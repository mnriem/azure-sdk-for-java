/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.frontdoor.v2020_05_01.implementation;

import retrofit2.Retrofit;
import com.google.common.reflect.TypeToken;
import com.microsoft.azure.management.frontdoor.v2020_05_01.CheckNameAvailabilityInput;
import com.microsoft.azure.management.frontdoor.v2020_05_01.ErrorResponseException;
import com.microsoft.rest.ServiceCallback;
import com.microsoft.rest.ServiceFuture;
import com.microsoft.rest.ServiceResponse;
import com.microsoft.rest.Validator;
import java.io.IOException;
import okhttp3.ResponseBody;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import retrofit2.http.POST;
import retrofit2.http.Query;
import retrofit2.Response;
import rx.functions.Func1;
import rx.Observable;

/**
 * An instance of this class provides access to all the operations defined
 * in FrontDoorNameAvailabilityWithSubscriptions.
 */
public class FrontDoorNameAvailabilityWithSubscriptionsInner {
    /** The Retrofit service to perform REST calls. */
    private FrontDoorNameAvailabilityWithSubscriptionsService service;
    /** The service client containing this operation class. */
    private FrontDoorManagementClientImpl client;

    /**
     * Initializes an instance of FrontDoorNameAvailabilityWithSubscriptionsInner.
     *
     * @param retrofit the Retrofit instance built from a Retrofit Builder.
     * @param client the instance of the service client containing this operation class.
     */
    public FrontDoorNameAvailabilityWithSubscriptionsInner(Retrofit retrofit, FrontDoorManagementClientImpl client) {
        this.service = retrofit.create(FrontDoorNameAvailabilityWithSubscriptionsService.class);
        this.client = client;
    }

    /**
     * The interface defining all the services for FrontDoorNameAvailabilityWithSubscriptions to be
     * used by Retrofit to perform actually REST calls.
     */
    interface FrontDoorNameAvailabilityWithSubscriptionsService {
        @Headers({ "Content-Type: application/json; charset=utf-8", "x-ms-logging-context: com.microsoft.azure.management.frontdoor.v2020_05_01.FrontDoorNameAvailabilityWithSubscriptions check" })
        @POST("subscriptions/{subscriptionId}/providers/Microsoft.Network/checkFrontDoorNameAvailability")
        Observable<Response<ResponseBody>> check(@Path("subscriptionId") String subscriptionId, @Body CheckNameAvailabilityInput checkFrontDoorNameAvailabilityInput, @Query("api-version") String apiVersion, @Header("accept-language") String acceptLanguage, @Header("User-Agent") String userAgent);

    }

    /**
     * Check the availability of a Front Door subdomain.
     *
     * @param checkFrontDoorNameAvailabilityInput Input to check.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @throws ErrorResponseException thrown if the request is rejected by server
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent
     * @return the CheckNameAvailabilityOutputInner object if successful.
     */
    public CheckNameAvailabilityOutputInner check(CheckNameAvailabilityInput checkFrontDoorNameAvailabilityInput) {
        return checkWithServiceResponseAsync(checkFrontDoorNameAvailabilityInput).toBlocking().single().body();
    }

    /**
     * Check the availability of a Front Door subdomain.
     *
     * @param checkFrontDoorNameAvailabilityInput Input to check.
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the {@link ServiceFuture} object
     */
    public ServiceFuture<CheckNameAvailabilityOutputInner> checkAsync(CheckNameAvailabilityInput checkFrontDoorNameAvailabilityInput, final ServiceCallback<CheckNameAvailabilityOutputInner> serviceCallback) {
        return ServiceFuture.fromResponse(checkWithServiceResponseAsync(checkFrontDoorNameAvailabilityInput), serviceCallback);
    }

    /**
     * Check the availability of a Front Door subdomain.
     *
     * @param checkFrontDoorNameAvailabilityInput Input to check.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable to the CheckNameAvailabilityOutputInner object
     */
    public Observable<CheckNameAvailabilityOutputInner> checkAsync(CheckNameAvailabilityInput checkFrontDoorNameAvailabilityInput) {
        return checkWithServiceResponseAsync(checkFrontDoorNameAvailabilityInput).map(new Func1<ServiceResponse<CheckNameAvailabilityOutputInner>, CheckNameAvailabilityOutputInner>() {
            @Override
            public CheckNameAvailabilityOutputInner call(ServiceResponse<CheckNameAvailabilityOutputInner> response) {
                return response.body();
            }
        });
    }

    /**
     * Check the availability of a Front Door subdomain.
     *
     * @param checkFrontDoorNameAvailabilityInput Input to check.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable to the CheckNameAvailabilityOutputInner object
     */
    public Observable<ServiceResponse<CheckNameAvailabilityOutputInner>> checkWithServiceResponseAsync(CheckNameAvailabilityInput checkFrontDoorNameAvailabilityInput) {
        if (this.client.subscriptionId() == null) {
            throw new IllegalArgumentException("Parameter this.client.subscriptionId() is required and cannot be null.");
        }
        if (checkFrontDoorNameAvailabilityInput == null) {
            throw new IllegalArgumentException("Parameter checkFrontDoorNameAvailabilityInput is required and cannot be null.");
        }
        Validator.validate(checkFrontDoorNameAvailabilityInput);
        final String apiVersion = "2020-05-01";
        return service.check(this.client.subscriptionId(), checkFrontDoorNameAvailabilityInput, apiVersion, this.client.acceptLanguage(), this.client.userAgent())
            .flatMap(new Func1<Response<ResponseBody>, Observable<ServiceResponse<CheckNameAvailabilityOutputInner>>>() {
                @Override
                public Observable<ServiceResponse<CheckNameAvailabilityOutputInner>> call(Response<ResponseBody> response) {
                    try {
                        ServiceResponse<CheckNameAvailabilityOutputInner> clientResponse = checkDelegate(response);
                        return Observable.just(clientResponse);
                    } catch (Throwable t) {
                        return Observable.error(t);
                    }
                }
            });
    }

    private ServiceResponse<CheckNameAvailabilityOutputInner> checkDelegate(Response<ResponseBody> response) throws ErrorResponseException, IOException, IllegalArgumentException {
        return this.client.restClient().responseBuilderFactory().<CheckNameAvailabilityOutputInner, ErrorResponseException>newInstance(this.client.serializerAdapter())
                .register(200, new TypeToken<CheckNameAvailabilityOutputInner>() { }.getType())
                .registerError(ErrorResponseException.class)
                .build(response);
    }

}
