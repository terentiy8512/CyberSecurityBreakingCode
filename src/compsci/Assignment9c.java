package compsci;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


public class Assignment9c {
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

 // Driver code
 public static void main(String args[]) throws NoSuchAlgorithmException
 {
     String s = "";
     int n = 1; //change here for number of 0's n+1!!!
     String hash = "";
     int counter = 0;
     
     boolean execute = true;
     while (execute) {
    	 s = "vessel:" + String.valueOf(counter);
    	 counter++;
    	 hash = getMd5(s);

    	 for(int i = 0; i <= n; i++) {
    		 if(!(hash.charAt(i) == '0')) {
    			 break;
    		 }

    		 if (i==n & (int) hash.charAt(i+1) > 55) {
    			 execute = false;
    			 System.out.println("Hash: " + hash );
    			 System.out.println(s);
    		 }
    			 
    			 
    	 }
     }
 }
}


