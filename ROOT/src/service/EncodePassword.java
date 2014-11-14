package service;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class EncodePassword {

	public static String hash(String password) throws NoSuchAlgorithmException
	{
		String hashingPassword = null;
		MessageDigest digest = MessageDigest.getInstance("MD5");
		digest.update(password.getBytes(), 0, password.length());
		  
	        //Converts message digest value in base 16 (hex) 
	        hashingPassword = new BigInteger(1, digest.digest()).toString(16);
		
		
		return hashingPassword;
	}
	
}
