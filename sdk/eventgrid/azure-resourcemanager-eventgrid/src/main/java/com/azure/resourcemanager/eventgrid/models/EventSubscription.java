// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.eventgrid.models;

import com.azure.core.http.rest.Response;
import com.azure.core.util.Context;
import com.azure.resourcemanager.eventgrid.fluent.models.EventSubscriptionInner;
import java.time.OffsetDateTime;
import java.util.List;

/** An immutable client-side representation of EventSubscription. */
public interface EventSubscription {
    /**
     * Gets the id property: Fully qualified resource Id for the resource.
     *
     * @return the id value.
     */
    String id();

    /**
     * Gets the name property: The name of the resource.
     *
     * @return the name value.
     */
    String name();

    /**
     * Gets the type property: The type of the resource.
     *
     * @return the type value.
     */
    String type();

    /**
     * Gets the systemData property: The system metadata relating to this resource.
     *
     * @return the systemData value.
     */
    SystemData systemData();

    /**
     * Gets the topic property: Name of the topic of the event subscription.
     *
     * @return the topic value.
     */
    String topic();

    /**
     * Gets the provisioningState property: Provisioning state of the event subscription.
     *
     * @return the provisioningState value.
     */
    EventSubscriptionProvisioningState provisioningState();

    /**
     * Gets the destination property: Information about the destination where events have to be delivered for the event
     * subscription. Uses Azure Event Grid's identity to acquire the authentication tokens being used during delivery /
     * dead-lettering.
     *
     * @return the destination value.
     */
    EventSubscriptionDestination destination();

    /**
     * Gets the deliveryWithResourceIdentity property: Information about the destination where events have to be
     * delivered for the event subscription. Uses the managed identity setup on the parent resource (namely, topic or
     * domain) to acquire the authentication tokens being used during delivery / dead-lettering.
     *
     * @return the deliveryWithResourceIdentity value.
     */
    DeliveryWithResourceIdentity deliveryWithResourceIdentity();

    /**
     * Gets the filter property: Information about the filter for the event subscription.
     *
     * @return the filter value.
     */
    EventSubscriptionFilter filter();

    /**
     * Gets the labels property: List of user defined labels.
     *
     * @return the labels value.
     */
    List<String> labels();

    /**
     * Gets the expirationTimeUtc property: Expiration time of the event subscription.
     *
     * @return the expirationTimeUtc value.
     */
    OffsetDateTime expirationTimeUtc();

    /**
     * Gets the eventDeliverySchema property: The event delivery schema for the event subscription.
     *
     * @return the eventDeliverySchema value.
     */
    EventDeliverySchema eventDeliverySchema();

    /**
     * Gets the retryPolicy property: The retry policy for events. This can be used to configure maximum number of
     * delivery attempts and time to live for events.
     *
     * @return the retryPolicy value.
     */
    RetryPolicy retryPolicy();

    /**
     * Gets the deadLetterDestination property: The dead letter destination of the event subscription. Any event that
     * cannot be delivered to its' destination is sent to the dead letter destination. Uses Azure Event Grid's identity
     * to acquire the authentication tokens being used during delivery / dead-lettering.
     *
     * @return the deadLetterDestination value.
     */
    DeadLetterDestination deadLetterDestination();

    /**
     * Gets the deadLetterWithResourceIdentity property: The dead letter destination of the event subscription. Any
     * event that cannot be delivered to its' destination is sent to the dead letter destination. Uses the managed
     * identity setup on the parent resource (namely, topic or domain) to acquire the authentication tokens being used
     * during delivery / dead-lettering.
     *
     * @return the deadLetterWithResourceIdentity value.
     */
    DeadLetterWithResourceIdentity deadLetterWithResourceIdentity();

    /**
     * Gets the inner com.azure.resourcemanager.eventgrid.fluent.models.EventSubscriptionInner object.
     *
     * @return the inner object.
     */
    EventSubscriptionInner innerModel();

    /** The entirety of the EventSubscription definition. */
    interface Definition extends DefinitionStages.Blank, DefinitionStages.WithScope, DefinitionStages.WithCreate {
    }
    /** The EventSubscription definition stages. */
    interface DefinitionStages {
        /** The first stage of the EventSubscription definition. */
        interface Blank extends WithScope {
        }
        /** The stage of the EventSubscription definition allowing to specify parent resource. */
        interface WithScope {
            /**
             * Specifies scope.
             *
             * @param scope The identifier of the resource to which the event subscription needs to be created or
             *     updated. The scope can be a subscription, or a resource group, or a top level resource belonging to a
             *     resource provider namespace, or an EventGrid topic. For example, use
             *     '/subscriptions/{subscriptionId}/' for a subscription,
             *     '/subscriptions/{subscriptionId}/resourceGroups/{resourceGroupName}' for a resource group, and
             *     '/subscriptions/{subscriptionId}/resourceGroups/{resourceGroupName}/providers/{resourceProviderNamespace}/{resourceType}/{resourceName}'
             *     for a resource, and
             *     '/subscriptions/{subscriptionId}/resourceGroups/{resourceGroupName}/providers/Microsoft.EventGrid/topics/{topicName}'
             *     for an EventGrid topic.
             * @return the next definition stage.
             */
            WithCreate withExistingScope(String scope);
        }
        /**
         * The stage of the EventSubscription definition which contains all the minimum required properties for the
         * resource to be created, but also allows for any other optional properties to be specified.
         */
        interface WithCreate
            extends DefinitionStages.WithDestination,
                DefinitionStages.WithDeliveryWithResourceIdentity,
                DefinitionStages.WithFilter,
                DefinitionStages.WithLabels,
                DefinitionStages.WithExpirationTimeUtc,
                DefinitionStages.WithEventDeliverySchema,
                DefinitionStages.WithRetryPolicy,
                DefinitionStages.WithDeadLetterDestination,
                DefinitionStages.WithDeadLetterWithResourceIdentity {
            /**
             * Executes the create request.
             *
             * @return the created resource.
             */
            EventSubscription create();

            /**
             * Executes the create request.
             *
             * @param context The context to associate with this operation.
             * @return the created resource.
             */
            EventSubscription create(Context context);
        }
        /** The stage of the EventSubscription definition allowing to specify destination. */
        interface WithDestination {
            /**
             * Specifies the destination property: Information about the destination where events have to be delivered
             * for the event subscription. Uses Azure Event Grid's identity to acquire the authentication tokens being
             * used during delivery / dead-lettering..
             *
             * @param destination Information about the destination where events have to be delivered for the event
             *     subscription. Uses Azure Event Grid's identity to acquire the authentication tokens being used during
             *     delivery / dead-lettering.
             * @return the next definition stage.
             */
            WithCreate withDestination(EventSubscriptionDestination destination);
        }
        /** The stage of the EventSubscription definition allowing to specify deliveryWithResourceIdentity. */
        interface WithDeliveryWithResourceIdentity {
            /**
             * Specifies the deliveryWithResourceIdentity property: Information about the destination where events have
             * to be delivered for the event subscription. Uses the managed identity setup on the parent resource
             * (namely, topic or domain) to acquire the authentication tokens being used during delivery /
             * dead-lettering..
             *
             * @param deliveryWithResourceIdentity Information about the destination where events have to be delivered
             *     for the event subscription. Uses the managed identity setup on the parent resource (namely, topic or
             *     domain) to acquire the authentication tokens being used during delivery / dead-lettering.
             * @return the next definition stage.
             */
            WithCreate withDeliveryWithResourceIdentity(DeliveryWithResourceIdentity deliveryWithResourceIdentity);
        }
        /** The stage of the EventSubscription definition allowing to specify filter. */
        interface WithFilter {
            /**
             * Specifies the filter property: Information about the filter for the event subscription..
             *
             * @param filter Information about the filter for the event subscription.
             * @return the next definition stage.
             */
            WithCreate withFilter(EventSubscriptionFilter filter);
        }
        /** The stage of the EventSubscription definition allowing to specify labels. */
        interface WithLabels {
            /**
             * Specifies the labels property: List of user defined labels..
             *
             * @param labels List of user defined labels.
             * @return the next definition stage.
             */
            WithCreate withLabels(List<String> labels);
        }
        /** The stage of the EventSubscription definition allowing to specify expirationTimeUtc. */
        interface WithExpirationTimeUtc {
            /**
             * Specifies the expirationTimeUtc property: Expiration time of the event subscription..
             *
             * @param expirationTimeUtc Expiration time of the event subscription.
             * @return the next definition stage.
             */
            WithCreate withExpirationTimeUtc(OffsetDateTime expirationTimeUtc);
        }
        /** The stage of the EventSubscription definition allowing to specify eventDeliverySchema. */
        interface WithEventDeliverySchema {
            /**
             * Specifies the eventDeliverySchema property: The event delivery schema for the event subscription..
             *
             * @param eventDeliverySchema The event delivery schema for the event subscription.
             * @return the next definition stage.
             */
            WithCreate withEventDeliverySchema(EventDeliverySchema eventDeliverySchema);
        }
        /** The stage of the EventSubscription definition allowing to specify retryPolicy. */
        interface WithRetryPolicy {
            /**
             * Specifies the retryPolicy property: The retry policy for events. This can be used to configure maximum
             * number of delivery attempts and time to live for events..
             *
             * @param retryPolicy The retry policy for events. This can be used to configure maximum number of delivery
             *     attempts and time to live for events.
             * @return the next definition stage.
             */
            WithCreate withRetryPolicy(RetryPolicy retryPolicy);
        }
        /** The stage of the EventSubscription definition allowing to specify deadLetterDestination. */
        interface WithDeadLetterDestination {
            /**
             * Specifies the deadLetterDestination property: The dead letter destination of the event subscription. Any
             * event that cannot be delivered to its' destination is sent to the dead letter destination. Uses Azure
             * Event Grid's identity to acquire the authentication tokens being used during delivery / dead-lettering..
             *
             * @param deadLetterDestination The dead letter destination of the event subscription. Any event that cannot
             *     be delivered to its' destination is sent to the dead letter destination. Uses Azure Event Grid's
             *     identity to acquire the authentication tokens being used during delivery / dead-lettering.
             * @return the next definition stage.
             */
            WithCreate withDeadLetterDestination(DeadLetterDestination deadLetterDestination);
        }
        /** The stage of the EventSubscription definition allowing to specify deadLetterWithResourceIdentity. */
        interface WithDeadLetterWithResourceIdentity {
            /**
             * Specifies the deadLetterWithResourceIdentity property: The dead letter destination of the event
             * subscription. Any event that cannot be delivered to its' destination is sent to the dead letter
             * destination. Uses the managed identity setup on the parent resource (namely, topic or domain) to acquire
             * the authentication tokens being used during delivery / dead-lettering..
             *
             * @param deadLetterWithResourceIdentity The dead letter destination of the event subscription. Any event
             *     that cannot be delivered to its' destination is sent to the dead letter destination. Uses the managed
             *     identity setup on the parent resource (namely, topic or domain) to acquire the authentication tokens
             *     being used during delivery / dead-lettering.
             * @return the next definition stage.
             */
            WithCreate withDeadLetterWithResourceIdentity(
                DeadLetterWithResourceIdentity deadLetterWithResourceIdentity);
        }
    }
    /**
     * Begins update for the EventSubscription resource.
     *
     * @return the stage of resource update.
     */
    EventSubscription.Update update();

    /** The template for EventSubscription update. */
    interface Update
        extends UpdateStages.WithDestination,
            UpdateStages.WithDeliveryWithResourceIdentity,
            UpdateStages.WithFilter,
            UpdateStages.WithLabels,
            UpdateStages.WithExpirationTimeUtc,
            UpdateStages.WithEventDeliverySchema,
            UpdateStages.WithRetryPolicy,
            UpdateStages.WithDeadLetterDestination,
            UpdateStages.WithDeadLetterWithResourceIdentity {
        /**
         * Executes the update request.
         *
         * @return the updated resource.
         */
        EventSubscription apply();

        /**
         * Executes the update request.
         *
         * @param context The context to associate with this operation.
         * @return the updated resource.
         */
        EventSubscription apply(Context context);
    }
    /** The EventSubscription update stages. */
    interface UpdateStages {
        /** The stage of the EventSubscription update allowing to specify destination. */
        interface WithDestination {
            /**
             * Specifies the destination property: Information about the destination where events have to be delivered
             * for the event subscription. Uses Azure Event Grid's identity to acquire the authentication tokens being
             * used during delivery / dead-lettering..
             *
             * @param destination Information about the destination where events have to be delivered for the event
             *     subscription. Uses Azure Event Grid's identity to acquire the authentication tokens being used during
             *     delivery / dead-lettering.
             * @return the next definition stage.
             */
            Update withDestination(EventSubscriptionDestination destination);
        }
        /** The stage of the EventSubscription update allowing to specify deliveryWithResourceIdentity. */
        interface WithDeliveryWithResourceIdentity {
            /**
             * Specifies the deliveryWithResourceIdentity property: Information about the destination where events have
             * to be delivered for the event subscription. Uses the managed identity setup on the parent resource (topic
             * / domain) to acquire the authentication tokens being used during delivery / dead-lettering..
             *
             * @param deliveryWithResourceIdentity Information about the destination where events have to be delivered
             *     for the event subscription. Uses the managed identity setup on the parent resource (topic / domain)
             *     to acquire the authentication tokens being used during delivery / dead-lettering.
             * @return the next definition stage.
             */
            Update withDeliveryWithResourceIdentity(DeliveryWithResourceIdentity deliveryWithResourceIdentity);
        }
        /** The stage of the EventSubscription update allowing to specify filter. */
        interface WithFilter {
            /**
             * Specifies the filter property: Information about the filter for the event subscription..
             *
             * @param filter Information about the filter for the event subscription.
             * @return the next definition stage.
             */
            Update withFilter(EventSubscriptionFilter filter);
        }
        /** The stage of the EventSubscription update allowing to specify labels. */
        interface WithLabels {
            /**
             * Specifies the labels property: List of user defined labels..
             *
             * @param labels List of user defined labels.
             * @return the next definition stage.
             */
            Update withLabels(List<String> labels);
        }
        /** The stage of the EventSubscription update allowing to specify expirationTimeUtc. */
        interface WithExpirationTimeUtc {
            /**
             * Specifies the expirationTimeUtc property: Information about the expiration time for the event
             * subscription..
             *
             * @param expirationTimeUtc Information about the expiration time for the event subscription.
             * @return the next definition stage.
             */
            Update withExpirationTimeUtc(OffsetDateTime expirationTimeUtc);
        }
        /** The stage of the EventSubscription update allowing to specify eventDeliverySchema. */
        interface WithEventDeliverySchema {
            /**
             * Specifies the eventDeliverySchema property: The event delivery schema for the event subscription..
             *
             * @param eventDeliverySchema The event delivery schema for the event subscription.
             * @return the next definition stage.
             */
            Update withEventDeliverySchema(EventDeliverySchema eventDeliverySchema);
        }
        /** The stage of the EventSubscription update allowing to specify retryPolicy. */
        interface WithRetryPolicy {
            /**
             * Specifies the retryPolicy property: The retry policy for events. This can be used to configure maximum
             * number of delivery attempts and time to live for events..
             *
             * @param retryPolicy The retry policy for events. This can be used to configure maximum number of delivery
             *     attempts and time to live for events.
             * @return the next definition stage.
             */
            Update withRetryPolicy(RetryPolicy retryPolicy);
        }
        /** The stage of the EventSubscription update allowing to specify deadLetterDestination. */
        interface WithDeadLetterDestination {
            /**
             * Specifies the deadLetterDestination property: The dead letter destination of the event subscription. Any
             * event that cannot be delivered to its' destination is sent to the dead letter destination. Uses Azure
             * Event Grid's identity to acquire the authentication tokens being used during delivery / dead-lettering..
             *
             * @param deadLetterDestination The dead letter destination of the event subscription. Any event that cannot
             *     be delivered to its' destination is sent to the dead letter destination. Uses Azure Event Grid's
             *     identity to acquire the authentication tokens being used during delivery / dead-lettering.
             * @return the next definition stage.
             */
            Update withDeadLetterDestination(DeadLetterDestination deadLetterDestination);
        }
        /** The stage of the EventSubscription update allowing to specify deadLetterWithResourceIdentity. */
        interface WithDeadLetterWithResourceIdentity {
            /**
             * Specifies the deadLetterWithResourceIdentity property: The dead letter destination of the event
             * subscription. Any event that cannot be delivered to its' destination is sent to the dead letter
             * destination. Uses the managed identity setup on the parent resource (topic / domain) to acquire the
             * authentication tokens being used during delivery / dead-lettering..
             *
             * @param deadLetterWithResourceIdentity The dead letter destination of the event subscription. Any event
             *     that cannot be delivered to its' destination is sent to the dead letter destination. Uses the managed
             *     identity setup on the parent resource (topic / domain) to acquire the authentication tokens being
             *     used during delivery / dead-lettering.
             * @return the next definition stage.
             */
            Update withDeadLetterWithResourceIdentity(DeadLetterWithResourceIdentity deadLetterWithResourceIdentity);
        }
    }
    /**
     * Refreshes the resource to sync with Azure.
     *
     * @return the refreshed resource.
     */
    EventSubscription refresh();

    /**
     * Refreshes the resource to sync with Azure.
     *
     * @param context The context to associate with this operation.
     * @return the refreshed resource.
     */
    EventSubscription refresh(Context context);

    /**
     * Get the full endpoint URL for an event subscription.
     *
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the full endpoint URL for an event subscription.
     */
    EventSubscriptionFullUrl getFullUrl();

    /**
     * Get the full endpoint URL for an event subscription.
     *
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the full endpoint URL for an event subscription.
     */
    Response<EventSubscriptionFullUrl> getFullUrlWithResponse(Context context);

    /**
     * Get all delivery attributes for an event subscription.
     *
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return all delivery attributes for an event subscription.
     */
    DeliveryAttributeListResult getDeliveryAttributes();

    /**
     * Get all delivery attributes for an event subscription.
     *
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return all delivery attributes for an event subscription.
     */
    Response<DeliveryAttributeListResult> getDeliveryAttributesWithResponse(Context context);
}
