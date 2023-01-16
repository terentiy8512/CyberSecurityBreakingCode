package compsci;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class Assignment11c {
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
	
	
	public static void main(String args[]) throws IOException{
		boolean exec = true;
		
	   	String s2 = "GET:/Public/CS/Home.png";
	   	String h2 = getMd5(s2);
	   	 
	   	String nonce = "03e2abb8a924e966bee59d41cef32851";
	   	
	   	String s1 = "leonardo:Mordor:";
	   	
		ArrayList<String> words = new ArrayList<String>();
		
		BufferedReader br = new BufferedReader(new FileReader("words.txt"));
		
		String st;
		while ((st = br.readLine()) != null) {
			words.add(st);
		}
		System.out.println("Words read complete!");
		
		int counter = 0;
		while(exec == true){
			String string = s1 + words.get(counter);
		   	String h1 = getMd5(string);
		   	
		   	String response = h1 + ":" + nonce + ":" + h2;
		   	
		   	
		   	String finale = getMd5(response);
			
			if (finale.equals("8bb73df7b5281d87ef58ab5d74bea6fe")) { // change here..
				exec = false;
			   	System.out.println(finale);
			   	System.out.println(string);
			}
			counter++;
			  
		}
	   	 
	   	
	}
	
	
	
	
	
	
	
	
	
	
	
}
