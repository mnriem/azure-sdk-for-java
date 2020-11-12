// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.azure.spring.aad.implementation;

import org.springframework.security.oauth2.client.registration.ClientRegistration;

import java.util.Arrays;
import java.util.List;

public class DefaultClient {

    private final ClientRegistration clientRegistration;
    private final String[] scope;

    public DefaultClient(ClientRegistration clientRegistration, String[] scope) {
        this.clientRegistration = clientRegistration;
        this.scope = scope.clone();
    }

    public ClientRegistration getClientRegistration() {
        return clientRegistration;
    }

    public String[] getScope() {
        return scope.clone();
    }

    public List<String> getScopeList() {
        return Arrays.asList(scope);
    }
}
