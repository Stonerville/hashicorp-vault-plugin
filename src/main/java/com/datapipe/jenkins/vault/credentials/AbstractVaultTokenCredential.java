package com.datapipe.jenkins.vault.credentials;

import com.bettercloud.vault.Vault;
import com.bettercloud.vault.VaultConfig;
import com.cloudbees.plugins.credentials.CredentialsScope;
import com.cloudbees.plugins.credentials.impl.BaseStandardCredentials;

public abstract class AbstractVaultTokenCredential extends BaseStandardCredentials implements VaultCredential {

    protected AbstractVaultTokenCredential(CredentialsScope scope, String id, String description) {
        super(scope, id, description);
    }

    protected abstract String getToken();

    @Override
    public Vault authorizeWithVault(Vault vault, VaultConfig config) {
        return new Vault(config.token(getToken()));
    }
}
