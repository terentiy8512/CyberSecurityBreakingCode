package compsci;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Assignment8a {

	public static void main(String[] args) throws FileNotFoundException {
		//lower case
		String[] alphabet = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
		List<String> uppercase = new ArrayList<String>();
		uppercase.addAll(Arrays.asList(alphabet));
		
		//upper case
		String[] alphabet2 = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", " ", "!", "?", "."};
		List<String> lowercase = new ArrayList<String>();
		lowercase.addAll(Arrays.asList(alphabet2));
		
		// MAIN PART
		ArrayList<String> cypherText = new ArrayList<String>();
		cypherText.add("AE 18 AD 86 93 12 27 6E 3E 59 05 B8 83 22 63 EA 9F 6D 90 28 7D 64 61 E2 20 15");
		cypherText.add("A1 0F BA 86 DD 46 39 6E 2B 59 51 B8 93 2B 26 F7 D0 2C 91 3D 34 67 6B FF 37 15");
		cypherText.add("AF 06 AD 86 DD 53 25 2B 36 52 12 BC C1 21 74 B9 DD 69 C2 2E 3C 76 69 E5 30 15");
		cypherText.add("A7 0F A9 91 91 4B 71 65 36 1C 1E B7 84 6E 64 FC DC 6D 8F 28 7D 64 61 E2 20 15");
		cypherText.add("A7 0F BF C3 8D 40 3E 7B 38 5B 10 B7 85 2F 26 F0 CC 2C 95 22 2F 68 67 E3 23 15");
		cypherText.add("AD 05 AF 90 DD 5E 38 60 3C 1C 05 B1 93 21 71 F0 D1 6B C2 3E 29 6A 6D E6 37 15");
		cypherText.add("A7 0F BE 86 8F 12 3D 62 3C 1C 1E AB C1 2C 63 B9 DB 65 91 25 32 6D 6B FE 30 15");
		
		
		
		int counter = 0;// change to needed column
		for (String letter: alphabet) { //change to lower case alphabet2
			System.out.println("Guess for " + letter);
			String hexLetter = String.format("%x", new BigInteger(1, letter.getBytes(/*YOUR_CHARSET?*/)));
			
			String line = cypherText.get(0);
			String[] hexList = line.split(" ");
			

			int key = (Integer.parseInt(hexLetter, 16) ^ Integer.parseInt(hexList[counter], 16));
			//System.out.println((Integer.parseInt(hexLetter, 16) + " " + Integer.parseInt(hexList[counter], 16)));
			for (String checkline: cypherText) {
				
				String[] checkhexList = checkline.split(" ");

				System.out.println((char) (key ^ Integer.parseInt(checkhexList[counter], 16)));
				
			}
			
		}
	}

}
