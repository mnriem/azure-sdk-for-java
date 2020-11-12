/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.monitor.v2019_11_01.implementation;

import com.microsoft.azure.management.monitor.v2019_11_01.CategoryType;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.microsoft.rest.serializer.JsonFlatten;
import com.microsoft.azure.management.monitor.v2019_11_01.ProxyOnlyResource;

/**
 * The diagnostic settings category resource.
 */
@JsonFlatten
public class DiagnosticSettingsCategoryResourceInner extends ProxyOnlyResource {
    /**
     * The type of the diagnostic settings category. Possible values include:
     * 'Metrics', 'Logs'.
     */
    @JsonProperty(value = "properties.categoryType")
    private CategoryType categoryType;

    /**
     * Get the type of the diagnostic settings category. Possible values include: 'Metrics', 'Logs'.
     *
     * @return the categoryType value
     */
    public CategoryType categoryType() {
        return this.categoryType;
    }

    /**
     * Set the type of the diagnostic settings category. Possible values include: 'Metrics', 'Logs'.
     *
     * @param categoryType the categoryType value to set
     * @return the DiagnosticSettingsCategoryResourceInner object itself.
     */
    public DiagnosticSettingsCategoryResourceInner withCategoryType(CategoryType categoryType) {
        this.categoryType = categoryType;
        return this;
    }

}
