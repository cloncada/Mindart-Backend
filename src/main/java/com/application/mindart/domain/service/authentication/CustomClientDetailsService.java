package com.application.mindart.domain.service.authentication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.ClientRegistrationException;
import org.springframework.stereotype.Service;

import com.application.mindart.domain.repository.CredentialRepository;

@Primary
@Service
public class CustomClientDetailsService implements ClientDetailsService {

    private final CredentialRepository credentialRepository;

    @Autowired
    public CustomClientDetailsService(CredentialRepository credentialRepository) {
        this.credentialRepository = credentialRepository;
    }

    @Override
    public ClientDetails loadClientByClientId(String clientId) {
        return credentialRepository.findByClientId(clientId)
                .map(CustomClientCredentials::new)
                .orElseThrow(() -> new ClientRegistrationException("ClientId not found."));
    }

}
