package com.gloomy.util;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Hash {
    public static String hashString(String input) {
        String hashInput = "";
        try
        {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update( input.getBytes( StandardCharsets.UTF_8 ) );
            byte[] digest = md.digest();

            hashInput = String.format( "%064x", new BigInteger( 1, digest ) );
        }
        catch (NoSuchAlgorithmException e)
        {
            e.printStackTrace();
        }
        return hashInput;
    }
}
