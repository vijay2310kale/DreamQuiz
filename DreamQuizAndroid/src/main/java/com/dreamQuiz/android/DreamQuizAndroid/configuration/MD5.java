package com.dreamQuiz.android.DreamQuizAndroid.configuration;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5 {
	
	  private  byte[] digest;
	    
	    public  String getpass(String pass) throws NoSuchAlgorithmException, UnsupportedEncodingException
	    {
	        String newPass=encryptMD5(pass, "VivekSatpute");
	        return newPass;
	    }
	    
	    public  String encryptMD5(String data, String salt) throws NoSuchAlgorithmException, 
	                                                              UnsupportedEncodingException
	    {
	        StringBuffer strbuf = new StringBuffer();
	        MessageDigest md5 = MessageDigest.getInstance("md5"); //encrypt using md5
	        md5.reset();
	        md5.update(salt.getBytes()); //use given salt
	        md5.update(data.getBytes(), 0, data.length()); 
	        digest = md5.digest();      
	        for (int i = 0; i < digest.length; i++) 
	        {
	            strbuf.append(toHexString(digest[i]));
	        } 
	        return strbuf.toString();      
	    }
	 
	    /**
	     * toHexString
	     * Convert byte <--> hex string
	     * (message digists works with bytes but we want to compare strings) 
	     */
	    public String toHexString(byte b) 
	    {
	        int value = (b & 0x7F) + (b < 0 ? 128 : 0);
	        String ret = (value < 16 ? "0" : "");
	        ret += Integer.toHexString(value);
	        return ret.toLowerCase();
	    }
	    
	    
	 /*   public String decrypt(String encrypted) {
	    	SecretKey secretKey;
	        try {
	            // Decode Base 64 String into bytes array.
	        	Base64.Decoder decoder=Base64.getDecoder();
	            byte[] encryptedByte = decoder.decode(encrypted);

	            //Do the decryption
	            Cipher cipher = Cipher.getInstance("AES");
	            cipher.init(Cipher.DECRYPT_MODE, secretKey);
	            byte decryptedByte = cipher.doFinal(encryptedByte);
	            byte de=cipher.getInstance(encryptedByte)
	            // Get hexadecimal string from the byte array.
	            return toHexString(decryptedByte);

	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return null;
	    }*/
	    public static void main(String[] args) throws NoSuchAlgorithmException, UnsupportedEncodingException {
	        System.out.println(new MD5().getpass("admin"));
	       String s="2019-04-04 08:43:36.0";
	       String stars=s.substring(0, s.length() - 2);
	        System.out.println("stars "+stars);
	    }

	   

}
