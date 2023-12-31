package dev.baluapp.twitter.security.config;
/*
@date 30.12.2023
@author Sergey Bugaienko
*/

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;

@Configuration
public class RsaKeyConfig {

    @Bean
    public static RsaKeys generateRsaKey() {

        KeyPair keyPair;
        try {
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
            keyPairGenerator.initialize(2048);
            keyPair = keyPairGenerator.generateKeyPair();
        } catch (Exception ex) {
            throw new IllegalStateException(ex);
        }
        return new RsaKeys(
                (RSAPublicKey) keyPair.getPublic(),
                (RSAPrivateKey) keyPair.getPrivate());
    }
}
