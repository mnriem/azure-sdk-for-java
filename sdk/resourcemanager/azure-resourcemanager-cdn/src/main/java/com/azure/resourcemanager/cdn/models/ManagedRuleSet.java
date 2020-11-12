// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.cdn.models;

import com.azure.core.annotation.Fluent;
import com.azure.core.util.logging.ClientLogger;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

/** Defines a managed rule set. */
@Fluent
public final class ManagedRuleSet {
    @JsonIgnore private final ClientLogger logger = new ClientLogger(ManagedRuleSet.class);

    /*
     * Defines the rule set type to use.
     */
    @JsonProperty(value = "ruleSetType", required = true)
    private String ruleSetType;

    /*
     * Defines the version of the rule set to use.
     */
    @JsonProperty(value = "ruleSetVersion", required = true)
    private String ruleSetVersion;

    /*
     * Verizon only : If the rule set supports anomaly detection mode, this
     * describes the threshold for blocking requests.
     */
    @JsonProperty(value = "anomalyScore")
    private Integer anomalyScore;

    /*
     * Defines the rule overrides to apply to the rule set.
     */
    @JsonProperty(value = "ruleGroupOverrides")
    private List<ManagedRuleGroupOverride> ruleGroupOverrides;

    /**
     * Get the ruleSetType property: Defines the rule set type to use.
     *
     * @return the ruleSetType value.
     */
    public String ruleSetType() {
        return this.ruleSetType;
    }

    /**
     * Set the ruleSetType property: Defines the rule set type to use.
     *
     * @param ruleSetType the ruleSetType value to set.
     * @return the ManagedRuleSet object itself.
     */
    public ManagedRuleSet withRuleSetType(String ruleSetType) {
        this.ruleSetType = ruleSetType;
        return this;
    }

    /**
     * Get the ruleSetVersion property: Defines the version of the rule set to use.
     *
     * @return the ruleSetVersion value.
     */
    public String ruleSetVersion() {
        return this.ruleSetVersion;
    }

    /**
     * Set the ruleSetVersion property: Defines the version of the rule set to use.
     *
     * @param ruleSetVersion the ruleSetVersion value to set.
     * @return the ManagedRuleSet object itself.
     */
    public ManagedRuleSet withRuleSetVersion(String ruleSetVersion) {
        this.ruleSetVersion = ruleSetVersion;
        return this;
    }

    /**
     * Get the anomalyScore property: Verizon only : If the rule set supports anomaly detection mode, this describes the
     * threshold for blocking requests.
     *
     * @return the anomalyScore value.
     */
    public Integer anomalyScore() {
        return this.anomalyScore;
    }

    /**
     * Set the anomalyScore property: Verizon only : If the rule set supports anomaly detection mode, this describes the
     * threshold for blocking requests.
     *
     * @param anomalyScore the anomalyScore value to set.
     * @return the ManagedRuleSet object itself.
     */
    public ManagedRuleSet withAnomalyScore(Integer anomalyScore) {
        this.anomalyScore = anomalyScore;
        return this;
    }

    /**
     * Get the ruleGroupOverrides property: Defines the rule overrides to apply to the rule set.
     *
     * @return the ruleGroupOverrides value.
     */
    public List<ManagedRuleGroupOverride> ruleGroupOverrides() {
        return this.ruleGroupOverrides;
    }

    /**
     * Set the ruleGroupOverrides property: Defines the rule overrides to apply to the rule set.
     *
     * @param ruleGroupOverrides the ruleGroupOverrides value to set.
     * @return the ManagedRuleSet object itself.
     */
    public ManagedRuleSet withRuleGroupOverrides(List<ManagedRuleGroupOverride> ruleGroupOverrides) {
        this.ruleGroupOverrides = ruleGroupOverrides;
        return this;
    }

    /**
     * Validates the instance.
     *
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
        if (ruleSetType() == null) {
            throw logger
                .logExceptionAsError(
                    new IllegalArgumentException("Missing required property ruleSetType in model ManagedRuleSet"));
        }
        if (ruleSetVersion() == null) {
            throw logger
                .logExceptionAsError(
                    new IllegalArgumentException("Missing required property ruleSetVersion in model ManagedRuleSet"));
        }
        if (ruleGroupOverrides() != null) {
            ruleGroupOverrides().forEach(e -> e.validate());
        }
    }
}
