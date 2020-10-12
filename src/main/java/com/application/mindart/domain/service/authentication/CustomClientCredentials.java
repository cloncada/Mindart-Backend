package com.application.mindart.domain.service.authentication;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.provider.ClientDetails;

import com.application.mindart.domain.entity.Credential;

public class CustomClientCredentials extends Credential implements ClientDetails {

    public CustomClientCredentials(Credential credential) {
        super.setClientId(credential.getClientId());
        super.setClientSecret(credential.getClientSecret());
        super.setGrantType(credential.getGrantType());
        super.setScopes(credential.getScopes());
    }

    @Override
    public String getClientId() {
        return super.getClientId();
    }

    @Override
    public String getClientSecret() {
        return super.getClientSecret();
    }

    @Override
    public Set<String> getScope() {
        return Collections.singleton(super.getScopes());
    }

    @Override
    public Set<String> getAuthorizedGrantTypes() {
        return Collections.singleton(super.getGrantType());

    }

    @Override
    public boolean isSecretRequired() {
        return false;
    }

    @Override
    public Set<String> getResourceIds() {
        return Collections.emptySet();
    }

    @Override
    public boolean isScoped() {
        return true;
    }

    @Override
    public Set<String> getRegisteredRedirectUri() {
        return Collections.emptySet();
    }

    @Override
    public Collection<GrantedAuthority> getAuthorities() {
        return Collections.emptySet();
    }

    @Override
    public Integer getAccessTokenValiditySeconds() {
        return null;
    }

    @Override
    public Integer getRefreshTokenValiditySeconds() {
        return null;
    }

    @Override
    public boolean isAutoApprove(String scope) {
        return false;
    }

    @Override
    public Map<String, Object> getAdditionalInformation() {
        return null;
    }

}
