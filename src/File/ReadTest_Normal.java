/* Java Program to differentiate between
 * BufferedReader and FileReader in Java
 * Reading lines using FileReader
 */

package File;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileReader;
//-

public class ReadTest_Normal {

	public static void main(String[] args){
		FileReader reader;
        long initialTime = System.currentTimeMillis(); 	//Stores the initial current time
        int i =-2;			 //An integer to store the integer returned by FileReader#read() method
		//-

		try{
			reader = new FileReader("File/geeks.txt");
			//-

			do{ 
				try { 
					i = reader.read(); // Reads one character at a time and returns it as an integer
				} catch (IOException e) {
					e.printStackTrace();
				}
				if (i!=-1) System.out.print((char)i);
			} while (i!=-1); // When the "End Of File" is reached the read() method returns -1

			// New Line + Display the time taken to read the data
			System.out.println("\nTime taken : " + (System.currentTimeMillis() - initialTime));

			try {
				//-
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}