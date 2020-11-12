/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.frontdoor.v2020_05_01.implementation;

import com.microsoft.azure.arm.resources.models.implementation.GroupableResourceCoreImpl;
import com.microsoft.azure.management.frontdoor.v2020_05_01.Profile;
import rx.Observable;
import com.microsoft.azure.management.frontdoor.v2020_05_01.ProfileUpdateModel;
import com.microsoft.azure.management.frontdoor.v2020_05_01.NetworkExperimentResourceState;
import com.microsoft.azure.management.frontdoor.v2020_05_01.State;
import rx.functions.Func1;

class ProfileImpl extends GroupableResourceCoreImpl<Profile, ProfileInner, ProfileImpl, NetworkManager> implements Profile, Profile.Definition, Profile.Update {
    private ProfileUpdateModel updateParameter;
    ProfileImpl(String name, ProfileInner inner, NetworkManager manager) {
        super(name, inner, manager);
        this.updateParameter = new ProfileUpdateModel();
    }

    @Override
    public Observable<Profile> createResourceAsync() {
        NetworkExperimentProfilesInner client = this.manager().inner().networkExperimentProfiles();
        return client.createOrUpdateAsync(this.resourceGroupName(), this.name(), this.inner())
            .map(new Func1<ProfileInner, ProfileInner>() {
               @Override
               public ProfileInner call(ProfileInner resource) {
                   resetCreateUpdateParameters();
                   return resource;
               }
            })
            .map(innerToFluentMap(this));
    }

    @Override
    public Observable<Profile> updateResourceAsync() {
        NetworkExperimentProfilesInner client = this.manager().inner().networkExperimentProfiles();
        return client.updateAsync(this.resourceGroupName(), this.name(), this.updateParameter)
            .map(new Func1<ProfileInner, ProfileInner>() {
               @Override
               public ProfileInner call(ProfileInner resource) {
                   resetCreateUpdateParameters();
                   return resource;
               }
            })
            .map(innerToFluentMap(this));
    }

    @Override
    protected Observable<ProfileInner> getInnerAsync() {
        NetworkExperimentProfilesInner client = this.manager().inner().networkExperimentProfiles();
        return client.getByResourceGroupAsync(this.resourceGroupName(), this.name());
    }

    @Override
    public boolean isInCreateMode() {
        return this.inner().id() == null;
    }

    private void resetCreateUpdateParameters() {
        this.updateParameter = new ProfileUpdateModel();
    }

    @Override
    public State enabledState() {
        return this.inner().enabledState();
    }

    @Override
    public String etag() {
        return this.inner().etag();
    }

    @Override
    public NetworkExperimentResourceState resourceState() {
        return this.inner().resourceState();
    }

    @Override
    public ProfileImpl withEtag(String etag) {
        this.inner().withEtag(etag);
        return this;
    }

    @Override
    public ProfileImpl withResourceState(NetworkExperimentResourceState resourceState) {
        this.inner().withResourceState(resourceState);
        return this;
    }

    @Override
    public ProfileImpl withEnabledState(State enabledState) {
        if (isInCreateMode()) {
            this.inner().withEnabledState(enabledState);
        } else {
            this.updateParameter.withEnabledState(enabledState);
        }
        return this;
    }

}
