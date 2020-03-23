// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
package com.microsoft.azure.telemetry;

public final class TelemetryData {

    public static final String INSTALLATION_ID = "installationId";
    public static final String PROJECT_VERSION = "version";
    public static final String SERVICE_NAME = "serviceName";
    public static final String HASHED_ACCOUNT_NAME = "hashedAccountName";
    public static final String HASHED_NAMESPACE = "hashedNamespace";
    public static final String TENANT_NAME = "tenantName";

    private TelemetryData() {

    }

    public static String getClassPackageSimpleName(Class<?> clazz) {
        if (clazz == null) {
            return "unknown";
        }

        return clazz.getPackage().getName().replaceAll("\\w+\\.", "");
    }
}