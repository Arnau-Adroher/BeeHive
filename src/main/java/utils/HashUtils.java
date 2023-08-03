package utils;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HashUtils {
    public static String hashString(String input) {
        try {
            // Create an instance of the SHA-256 algorithm
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            
            // Convert the input string to bytes
            byte[] encodedHash = digest.digest(input.getBytes(StandardCharsets.UTF_8));
            
            // Convert the byte array to a hexadecimal string representation
            StringBuilder hexString = new StringBuilder();
            for (byte b : encodedHash) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }
            
            // Return the hashed value as a string
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            // Handle any exceptions
            e.printStackTrace();
        }     
        return null;
    }
}

