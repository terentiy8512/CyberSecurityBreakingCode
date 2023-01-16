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

public class Assignment10a {
	
	public static void main(String args[])throws Exception {
	      FileWriter writer = new FileWriter("pixel_values.txt");
	      //Reading the image
	      File file= new File("Steganography-262767078.png");
	      BufferedImage img = ImageIO.read(file);
	      
	      ArrayList list = new ArrayList();
	      
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
	            list.add(red);
	            list.add(green);
	            list.add(blue);
	            //list.add(list2);
	         }
	      }
	      writer.close();
	      System.out.println("RGB values at each pixel are stored in the specified file");
	      //System.out.print(list);
	      
	      int counter = 1;
	      for (int i = 0; i < list.size(); i++) {
	    	  if(counter <= 200) {
	    		  String number = Integer.toBinaryString((int) list.get(i));
		    	  System.out.print(number.charAt(number.length() - 1));
		    	  if (counter%8 == 0) {
		    		  System.out.print(" ");
		    	  }
	    	  }
	    	  counter++;
	    	  
	      }
	   }

}
