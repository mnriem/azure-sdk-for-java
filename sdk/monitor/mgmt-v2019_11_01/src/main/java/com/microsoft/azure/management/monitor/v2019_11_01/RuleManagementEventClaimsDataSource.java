/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.monitor.v2019_11_01;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The claims for a rule management event data source.
 */
public class RuleManagementEventClaimsDataSource {
    /**
     * the email address.
     */
    @JsonProperty(value = "emailAddress")
    private String emailAddress;

    /**
     * Get the email address.
     *
     * @return the emailAddress value
     */
    public String emailAddress() {
        return this.emailAddress;
    }

    /**
     * Set the email address.
     *
     * @param emailAddress the emailAddress value to set
     * @return the RuleManagementEventClaimsDataSource object itself.
     */
    public RuleManagementEventClaimsDataSource withEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
        return this;
    }

}
