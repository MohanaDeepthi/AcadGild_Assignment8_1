/*Write a program for file copy.*/
package assignment8_1;//package name

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Assignment8_1 {//class name
	//method to print the file contents
	public static void printFileContent(String filePath){
		try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {//creating buffer reader object
	    	   String line = null;
	    	   
	    	   while ((line = br.readLine()) != null) {//read till the last line of the file
	    	       System.out.println(line);//print each line
	    	   }
		} catch (FileNotFoundException e) {//catch exception
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
	public static void main(String args[]){//main method
		
		InputStream ipStream =null; //declaring input stream 
		OutputStream outStream = null;//declaring output stream
		
		try{
			 
    	    File file1 =new File("src/SourceFile.txt");//source file
    	    File file2 =new File("src/DestinationFile.txt");//destination file
 
    	    ipStream = new FileInputStream(file1);//instantiating input file stream object
    	    outStream = new FileOutputStream(file2); // for override file content
    	    
 
    	    byte[] buffer = new byte[1024];//buffer variable
 
    	    int length;
    	    while ((length = ipStream.read(buffer)) > 0){//reading contents from input stream
    	    	outStream.write(buffer, 0, length);//writing to output stream
    	    }
 
    	    if (ipStream != null)ipStream.close();//close input stream object
    	    if (outStream != null)outStream.close();//close output stream object
    	    System.out.println("Source file contents :");
    	    printFileContent("src/SourceFile.txt");//printing source file contents
 	    	
    	    System.out.println("File copy is successful");
    	    System.out.println("Destination file contents :");
    	    printFileContent("src/DestinationFile.txt");//printing destination file contents
    	}catch(IOException e){//catch exception
    		e.printStackTrace();
    	}
    }
		
	

}
