/* Java Program to differentiate between
 * BufferedReader and FileReader in Java
 * Reading lines using FileReader
 */

package File;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;

public class ReadTest {

	public static void main(String[] args){
        String readLine = "";	// A String to store the String returned by FileReader#readLine() method
		int readInt =-2;		// An integer to store the integer returned by FileReader#read() method
		int bufferSize = 16384;
		StringBuilder strBNormal = new StringBuilder();
		StringBuilder strBBuffer = new StringBuilder();
		Long timeNormal;
		Long timeBuffer;


		try{
			FileReader fr1 = new FileReader("File/geeks.txt");
			FileReader fr2 = new FileReader("File/geeks.txt");
			BufferedReader br = new BufferedReader(fr2, bufferSize);
			
			timeNormal = readNormal(readInt, fr1, strBNormal);
			timeBuffer = readBuffer(readLine, br, strBBuffer);

			System.out.println("timeNormal : " + timeNormal);
			System.out.println("timeBuffer : " + timeBuffer);
			
			try {
				br.close();
				fr2.close();
				fr1.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

 		System.out.println();
		
		try {
			long initialTime;
			FileWriter fw1 = new FileWriter("File/geeksWN.txt");
			FileWriter fw2 = new FileWriter("File/geeksWB.txt");
			BufferedWriter bw = new BufferedWriter(fw2);
			
			initialTime = System.currentTimeMillis();
			bw.write(strBBuffer.toString());
			System.out.println("timeBuffer : "+(System.currentTimeMillis()-initialTime));

			initialTime = System.currentTimeMillis();
			fw1.write(strBNormal.toString());
			System.out.println("timeNormal : "+(System.currentTimeMillis()-initialTime));

			bw.close();
			fw2.close();
			fw1.close();

		} catch (IOException e1) {
			e1.printStackTrace();
		}

	}

	public static long readNormal(int readInt, FileReader fr, StringBuilder str ){
		long initialTime = System.currentTimeMillis();
		str.append("[START] LETTURA NORMALE");
		str.append("> ");
		do{ 
			try { 
				readInt = fr.read(); // Reads one character at a time and returns it as an integer
			} catch (IOException e) {
				e.printStackTrace();
			}
			if (readInt!=-1) str.append((char)readInt);
			if((char)readInt=='\n') str.append("> ");
		} while (readInt!=-1); // When the "End Of File" is reached the read() method returns -1
		str.append("\n[END] LETTURA NORMALE");
		long finalTime = System.currentTimeMillis() - initialTime;
		return finalTime;
	}
	
	public static long readBuffer(String readLine, BufferedReader br, StringBuilder str){
		long initialTime = System.currentTimeMillis();
		str.append("\n[START] LETTURA BUFFER");
		do{ 
			try {
				readLine = br.readLine();	// readLine() method of BufferedReader returns a whole line at a time
			} catch (IOException e) {
				e.printStackTrace();
			}
			if(readLine != null) str.append("> "+readLine+"\n");
		} while(readLine != null); // When the read head reaches the "End Of File" the readLine method returns null
		str.append("\n[END] LETTURA BUFFER");
		long finalTime = System.currentTimeMillis() - initialTime;
		return finalTime;
	}
}