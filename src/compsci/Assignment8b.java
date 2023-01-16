package compsci;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Assignment8b {
	public static void main(String[] args){
	    Scanner myObj = new Scanner(System.in);  
	    System.out.println("Enter One Hex Letter: ");
	    String firstWord = myObj.nextLine(); 
	    
	    System.out.println("Enter Second Hex Letter: ");
	    String secondWord = myObj.nextLine(); 
	    
	    System.out.println((Integer.parseInt(firstWord, 8) ^ Integer.parseInt(secondWord, 8)));
	    
	}
}


