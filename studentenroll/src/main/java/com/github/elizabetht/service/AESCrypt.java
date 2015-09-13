package com.github.elizabetht.service;
import java.security.Key;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import org.springframework.stereotype.Component;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;
@Component("aesCrypt")
public class AESCrypt 
{
    private static final String ALGORITHM = "AES";
    /*Remember that for AES alogithm your key must have 16 chars. For DES algorithm it will be 8 chars.*/
    private static final String KEY = "1Hbfh667adfDEJ79";
 
    public static String encrypt(String value) throws Exception
    {
        Key key = generateKey();
        Cipher cipher = Cipher.getInstance(AESCrypt.ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, key);
        byte [] encryptedByteValue = cipher.doFinal(value.getBytes("utf-8"));
        String encryptedValue64 = new BASE64Encoder().encode(encryptedByteValue);
        return encryptedValue64;
               
    }
    
    public static String decrypt(String value) throws Exception
    {
        Key key = generateKey();
        Cipher cipher = Cipher.getInstance(AESCrypt.ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, key);
        byte [] decryptedValue64 = new BASE64Decoder().decodeBuffer(value);
        byte [] decryptedByteValue = cipher.doFinal(decryptedValue64);
        String decryptedValue = new String(decryptedByteValue,"utf-8");
        return decryptedValue;
                
    }
    
    private static Key generateKey() throws Exception 
    {
        Key key = new SecretKeySpec(AESCrypt.KEY.getBytes(),AESCrypt.ALGORITHM);
        return key;
    }
    public static void main(String[] args) {
        try {
        String password = "Summer2014";
            System.out.println("plain pass="+password);
        String encryptedPassword = AESCrypt.encrypt(password);
            System.out.println("encrypted pass="+encryptedPassword);
        String decryptedPassword = AESCrypt.decrypt(encryptedPassword);    
                System.out.println("decrypted pass="+decryptedPassword);
        } catch(Exception e) { System.out.println("bug"+e.getMessage()); }
    }
}