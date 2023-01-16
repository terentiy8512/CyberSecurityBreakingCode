package compsci;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Assignment11b {
	public static String getMd5(String input)
	 {
	     try {

	         // Static getInstance method is called with hashing MD5
	         MessageDigest md = MessageDigest.getInstance("MD5");

	         // digest() method is called to calculate message digest
	         //  of an input digest() return array of byte
	         byte[] messageDigest = md.digest(input.getBytes());

	         // Convert byte array into signum representation
	         BigInteger no = new BigInteger(1, messageDigest);

	         // Convert message digest into hex value
	         String hashtext = no.toString(16);
	         while (hashtext.length() < 32) {
	             hashtext = "0" + hashtext;
	         }
	         return hashtext;
	     } 

	     // For specifying wrong message digest algorithms
	     catch (NoSuchAlgorithmException e) {
	         throw new RuntimeException(e);
	     }
	 }
	
	
	public static void main(String args[]){
   	 String s1 = "alec:compsci:9lives";
   	 String h1 = getMd5(s1);
   	 
   	 String s2 = "GET:/images/14.png";
   	 String h2 = getMd5(s2);
   	 
   	 String nonce = "03e2abb8a924e696bee59d41cef32851";
   	 
   	 String response = h1 + ":" + nonce + ":" + h2;
   	 String finale = getMd5(response);
   	 System.out.println(h1);
   	 System.out.println(response);
   	 System.out.println(finale);
	}
	
	
	
	
	
	
	
	
	
	
	
}
