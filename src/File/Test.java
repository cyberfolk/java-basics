/* BufferedReader VS FileReader 
 * BufferedWriter VS FileWriter
 */

package File;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;

public class Test {

	public static void main(String[] args){
		StringBuilder strReadNormal = new StringBuilder(); // Stringhe da appoggio per memorizzare ciò che viene letto da file.
		StringBuilder strReadBuffer = new StringBuilder(); // Stringhe da appoggio per memorizzare ciò che viene letto da file.
		String fn_read = "File/fn_read.txt";
		String fn_writeEasy_Normal = "File/fn_writeEasy_Normal.txt";
		String fn_writeEasy_Buffer = "File/fn_writeEasy_Buffer.txt";
		String fn_writeHard_Normal = "File/fn_writeHard_Normal.txt";
		String fn_writeHard_Buffer = "File/fn_writeHard_Buffer.txt";

		long readTime[] = readTest(fn_read, strReadNormal, strReadBuffer);
		System.out.println("readTimeNormal : " + readTime[0]);
		System.out.println("readTimeBuffer : " + readTime[1]);

		long writeTimeEasy[] = writeTestEasy(fn_writeEasy_Normal, fn_writeEasy_Buffer, strReadNormal);

		System.out.println("writeTimeNormalEasy : " + writeTimeEasy[0]);
		System.out.println("writeTimeBufferEasy : " + writeTimeEasy[1]);

		long writeTimeHard[] = writeTestHard(fn_writeHard_Normal, fn_writeHard_Buffer, strReadNormal);

		System.out.println("writeTimeNormalHard : " + writeTimeHard[0]);
		System.out.println("writeTimeBufferHard : " + writeTimeHard[1]);
	}



	/**Confronto i tempi di scrittura tra FileReader e BufferReader. 
	 * HARD perchè utilizza il metodo write() per ogni singolo carattere di copyString
	 * @param fn_writeNormalHard File di destinazione sul quale voglio scrivere con il FileReader
	 * @param fn_writeBufferHard File di destinazione sul quale voglio scrivere con il BufferReader
	 * @param copyString Stringa da copiare su entrambu i File
	 * @return writeTime[0] Tempo di scrittura del FileReader. writeTime[1] Tempo di scrittura del BufferReader
	 */
	public static long[] writeTestHard(String fn_writeNormalHard, String fn_writeBufferHard, StringBuilder copyString){
		long writeTime[] = new long[2];
		long initialTime;
		try {
			FileWriter fw1 = new FileWriter(fn_writeNormalHard);
			FileWriter fw2 = new FileWriter(fn_writeBufferHard);
			BufferedWriter bw = new BufferedWriter(fw2);
			
			initialTime = System.currentTimeMillis();
			for (int i=0 ; i< copyString.length(); i++) {
				fw1.write(copyString.substring(i, i+1));
			}
			writeTime[0]=System.currentTimeMillis() - initialTime;

			initialTime = System.currentTimeMillis();
			for (int i=0 ; i< copyString.length(); i++) {
				bw.write(copyString.substring(i, i+1));
			}
			writeTime[1]=System.currentTimeMillis() - initialTime;

			bw.close();
			fw2.close();
			fw1.close();

		} catch (IOException e1) {
			e1.printStackTrace();
		}
		return writeTime;
	}

	/**Confronto i tempi di scrittura tra FileReader e BufferReader. 
	 * EASY perchè utilizza il metodo write() per tutta l'intera stringa di copyString
	 * @param fn_writeNormalHard File di destinazione sul quale voglio scrivere con il FileReader
	 * @param fn_writeBufferHard File di destinazione sul quale voglio scrivere con il BufferReader
	 * @param copyString Stringa da copiare su entrambu i File
	 * @return writeTime[0] Tempo di scrittura del FileReader. writeTime[1] Tempo di scrittura del BufferReader
	 */
	public static long[] writeTestEasy(String fn_writeNormalEasy, String fn_writeBufferEasy, StringBuilder copyString){
		long writeTime[] = new long[2];
		long initialTime;
		try {
			FileWriter fw1 = new FileWriter(fn_writeNormalEasy);
			FileWriter fw2 = new FileWriter(fn_writeBufferEasy);
			BufferedWriter bw = new BufferedWriter(fw2);
			
			initialTime = System.currentTimeMillis();
			fw1.write(copyString.toString());
			writeTime[0]=System.currentTimeMillis() - initialTime;

			initialTime = System.currentTimeMillis();
			bw.write(copyString.toString());
			writeTime[1]=System.currentTimeMillis() - initialTime;

			bw.close();
			fw2.close();
			fw1.close();

		} catch (IOException e1) {
			e1.printStackTrace();
		}
		return writeTime;
	}

	public static long[] readTest(String fileName,StringBuilder strBNormal, StringBuilder strBBuffer){
		long readTime[] = new long[2];
		try{
			String readLine = "";	// A String to store the String returned by FileReader#readLine() method
			int readInt =-2;		// An integer to store the integer returned by FileReader#read() method
			FileReader fr1 = new FileReader(fileName);
			FileReader fr2 = new FileReader(fileName);
			BufferedReader br = new BufferedReader(fr2);

			readTime[0] = readNormal(readInt, fr1, strBNormal);
			readTime[1] = readBuffer(readLine, br, strBBuffer);
			
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
		return readTime;
	}

	public static long readNormal(int readInt, FileReader fr, StringBuilder str ){
		long initialTime = System.currentTimeMillis();
		str.append("LETTURA NORMALE");
		do{ 
			try { 
				readInt = fr.read(); // Reads one character at a time and returns it as an integer
			} catch (IOException e) {
				e.printStackTrace();
			}
			if (readInt!=-1) str.append((char)readInt);
		} while (readInt!=-1); // When the "End Of File" is reached the read() method returns -1
		long finalTime = System.currentTimeMillis() - initialTime;
		return finalTime;
	}
	
	public static long readBuffer(String readLine, BufferedReader br, StringBuilder str){
		long initialTime = System.currentTimeMillis();
		str.append("LETTURA BUFFER");
		do{ 
			try {
				readLine = br.readLine();	// readLine() method of BufferedReader returns a whole line at a time
			} catch (IOException e) {
				e.printStackTrace();
			}
			if(readLine != null) str.append(readLine+"\n");
		} while(readLine != null); // When the read head reaches the "End Of File" the readLine method returns null
		long finalTime = System.currentTimeMillis() - initialTime;
		return finalTime;
	}
}