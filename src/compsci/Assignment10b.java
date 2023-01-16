package compsci;

import java.io.ByteArrayOutputStream;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileWriter;
import java.math.BigInteger;
import java.nio.file.Files;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class Assignment10b {
	
	public static void main(String args[])throws Exception {
	      FileWriter writer = new FileWriter("pixel_values.txt");
	      //Reading the image
	      File file= new File("Steganalysis-262767078.png");
	      BufferedImage img = ImageIO.read(file);
	      
	      ArrayList<ArrayList> list = new ArrayList();
	      
	      for (int y = 0; y < img.getHeight(); y++) {
	         for (int x = 0; x < img.getWidth(); x++) {
	            //Retrieving contents of a pixel
	            int pixel = img.getRGB(x,y);
	            //Creating a Color object from pixel value
	            Color color = new Color(pixel, true);
	            //Retrieving the R G B values
	            
	            String string = "";
	            ArrayList list2 = new ArrayList();
	            
	            int red = color.getRed();
	            int green = color.getGreen();
	            int blue = color.getBlue();
	            writer.append(Integer.toHexString(red)+":");
	            writer.append(Integer.toHexString(green)+":");
	            writer.append(Integer.toHexString(blue)+"");
	            writer.append("\n");
	            writer.flush();
	            list2.add(red);
	            list2.add(green);
	            list2.add(blue);
	            list.add(list2);
	         }
	      }
	      writer.close();
	      System.out.println("RGB values at each pixel are stored in the specified file");
	      //System.out.println(list);
	      
	      
	      
	      BufferedImage image = new BufferedImage(img.getTileWidth(), img.getHeight(), BufferedImage.TYPE_INT_RGB); 
	      int counter = 0;
	      
	      // check for red.
	      ArrayList colours = new ArrayList();
     	  for (ArrayList aList: list) {
     		  int Rvalue = (int) aList.get(0);
     		  //System.out.println(Rvalue);
     		  
     		  String number = Integer.toBinaryString(Rvalue);
     		  //System.out.println(number);
     		  char zeroOrOne = number.charAt(number.length() - 1);
     		  //System.out.println(zeroOrOne);
	    	  if(zeroOrOne == '1') {
	    		  colours.add(1);
	    	  }else {
	    		  colours.add(0);
	    	  }
	    	
    		 
    	 }
     	 System.out.println(colours);
     	  Color white = new Color(255, 255, 255);
     	 Color black = new Color(0, 0, 0);
     	 int counter2 = 0;
     	 int counterWhite = 0;
     	 boolean execute =true;
	      for (int y = 0; y < img.getHeight(); y++) {
	         for (int x = 0; x < img.getTileWidth(); x++) {
	        	 if ((int)colours.get(counter2) == 1) {
	        		 image.setRGB(x, y, white.getRGB());
	        	 }else {
	        		 image.setRGB(x, y, black.getRGB());
	        	 }
	        	 
	        	 
	        	 //------------------------------------
	        	 if ((int)colours.get(counter2) == 1) {
	        		 counterWhite++;
	        	 }else {
	        		 counterWhite = 0;
	        	 }
	        	 
	        	 if (counterWhite >= 15 & execute) {
	        		 System.out.println(counter2);
	        		 execute = false;
	        	 }
	        	 
	        	 counter2++;
	         }
	      }
	      System.out.println(counter);
	      File outputFile = new File("output.bmp");
	      ImageIO.write(image, "bmp", outputFile);

	   }

}
