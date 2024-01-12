package utils;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class RSA {
    public static KeyPair createKey(){
        try {
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
            keyPairGenerator.initialize(2048);
            return keyPairGenerator.generateKeyPair();
        } catch (NoSuchAlgorithmException e) {
            return null;
        }
    }

    public static String createPublicKey(KeyPair key){
        return Base64.getEncoder().encodeToString(key.getPublic().getEncoded());
    }

    public static String createPrivateKey(KeyPair key){
        return Base64.getEncoder().encodeToString(key.getPrivate().getEncoded());
    }
}
