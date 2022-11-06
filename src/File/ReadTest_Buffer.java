/* Java Program to differentiate between
 * BufferedReader and FileReader in Java
 * Reading lines using BufferedReader
 */

package File;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;

public class ReadTest_Buffer {

	public static void main(String[] args){
		FileReader reader;
		long initialTime = System.currentTimeMillis();	//Stores the initial current time
		String line = "";	//A String to store the String returned by FileReader#readLine() method
		int bufferSize = 16384;

		try {
			reader = new FileReader("File/geeks.txt");
			BufferedReader buffer = new BufferedReader(reader, bufferSize);

			do{ 
				try {
					line = buffer.readLine();	// readLine() method of BufferedReader returns a whole line at a time
				} catch (IOException e) {
					e.printStackTrace();
				}
				System.out.println(line);
			} while(line != null); // When the read head reaches the "End Of File" the readLine method returns null

			// New Line + Display the time taken to read the data
			System.out.println("\nTime taken : " + (System.currentTimeMillis() - initialTime));

			try {
				buffer.close();
				reader.close();
			} catch (IOException e) { 
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}