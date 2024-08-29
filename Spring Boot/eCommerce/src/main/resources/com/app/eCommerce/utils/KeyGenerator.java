package com.app.eCommerce.utils;

import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import javax.crypto.SecretKey;
import java.util.Base64;

public class KeyGenerator {

    public static void main(String[] args) {
        // Generate a secure key for HS256 algorithm
        SecretKey secretKey = Keys.secretKeyFor(SignatureAlgorithm.HS256);

        // Encode the key to Base64
        String encodedKey = Base64.getEncoder().encodeToString(secretKey.getEncoded());

        // Print the encoded key
        System.out.println("Encoded Secret Key: " + encodedKey);
    }
}
