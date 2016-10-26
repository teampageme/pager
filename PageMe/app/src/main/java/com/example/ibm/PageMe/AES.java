package com.example.ibm.PageMe;

import android.util.Base64;
import java.security.Key;
import java.security.MessageDigest;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import android.util.Base64;
import java.security.Key;
import java.security.MessageDigest;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class AES
{
    //declaring algorithm
    private static final String ALGO = "AES";
    //128-bit key (keyStr is going to be hardcoded in the program, but we still need to generate a key for using the AES algorithm)
    private static final String keyStr = "Z8LSq0wWwB5v+6YJzurcP463H3F12iZh74fDj4S74oUH4EONkiKb2FmiWUbtFh97GG/c/lbDE47mvw6j94yXxKHOpoqu6zpLKMKPcOoSppcVWb2q34qENBJkudXUh4MWcreondLmLL2UyydtFKuU9Sa5VgY/CzGaVGJABK2ZR94=";

    //generating key
    private static Key generateKey() throws Exception
    {
        byte[] keyValue = keyStr.getBytes("UTF-8");
        MessageDigest sha = MessageDigest.getInstance("SHA-1");
        keyValue = sha.digest(keyValue);
        keyValue = Arrays.copyOf(keyValue, 16); // use only first 128 bit
        Key key = new SecretKeySpec(keyValue, ALGO); //generates key that works with AES algorithm
        return key;
    }

    public static String encrypt(String Data) throws Exception
    {
        Key key = generateKey();
        Cipher c = Cipher.getInstance(ALGO);
        c.init(Cipher.ENCRYPT_MODE, key); //Selecting encryption mode
        byte[] encVal = c.doFinal(Data.getBytes());
        //String encryptedValue = DatatypeConverter.printBase64Binary(encVal);
        String encryptedValue = android.util.Base64.encodeToString(encVal, 16); //replacement code for xml methods because they don't work on android.
        return encryptedValue;
    }

    public static String decrypt(String encryptedData) throws Exception
    {
        Key key = generateKey();
        Cipher c = Cipher.getInstance(ALGO);
        c.init(Cipher.DECRYPT_MODE, key); //selecting decryption mode
        byte[] decordedValue = android.util.Base64.decode(encryptedData, 16); //replacement code for xml methods because they don't work on android.
        byte[] decValue = c.doFinal(decordedValue);
        String decryptedValue = new String(decValue);
        return decryptedValue;
    }
}
