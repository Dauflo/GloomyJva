package com.gloomy.util;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

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

    public static String getSaltString() {
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 18) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr;

    }
}
