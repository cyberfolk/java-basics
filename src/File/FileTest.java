/* BufferedReader VS FileReader 
 * BufferedReader = Può leggere riga per riga guadagnando velocità
 * FileReader = Legge solo carattere per carattere
 * BufferedWriter VS FileWriter
 * Se devono scrivere la stessa quantità di caratterei in una volta solo hanno la stessa efficacia.
 * Se devono scrivere scrivere più volte sullo stesso file, il BufferedWriter è più efficente, 
 *   perchè prima riempie il buffer e poi lo trascrive sul file in una volta sola.
 *   si da per assodato che accedere e scrivere sul file è molto più lento che scrivere nel buffer
 */

package File;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;

public class FileTest {

	public static void main(String[] args){
		StringBuilder strBldrNormal = new StringBuilder(); // Stringhe da appoggio per memorizzare ciò che viene letto da file.
		StringBuilder strBldrBuffer = new StringBuilder(); // Stringhe da appoggio per memorizzare ciò che viene letto da file.
		String fn_read = "File/fn_read.txt";
		String fn_writeEasy_Normal = "File/fn_writeEasy_Normal.txt";
		String fn_writeEasy_Buffer = "File/fn_writeEasy_Buffer.txt";
		String fn_writeHard_Normal = "File/fn_writeHard_Normal.txt";
		String fn_writeHard_Buffer = "File/fn_writeHard_Buffer.txt";

		long readTime[] = readTest(fn_read, strBldrNormal, strBldrBuffer);
		System.out.println("Read Time Normal: " + readTime[0]);
		System.out.println("Read Time Buffer: " + readTime[1]);
		System.out.printf("Efficenza: %.2f\n\n" , (1-((double)readTime[1]/readTime[0])));

		long writeTimeEasy[] = writeTestEasy(fn_writeEasy_Normal, fn_writeEasy_Buffer, strBldrNormal);
		System.out.println("Write Time Normal Easy: " + writeTimeEasy[0]);
		System.out.println("Write Time Buffer Easy: " + writeTimeEasy[1]);
		System.out.printf("Efficenza: %.2f\n\n" , (1-((double)writeTimeEasy[1]/writeTimeEasy[0])));

		long writeTimeHard[] = writeTestHard(fn_writeHard_Normal, fn_writeHard_Buffer, strBldrNormal);
		System.out.println("Write Time Normal Hard: " + writeTimeHard[0]);
		System.out.println("Write Time Buffer Hard: " + writeTimeHard[1]); 
		System.out.printf("Efficenza: %.2f\n\n" , (1-((double)writeTimeHard[1]/writeTimeHard[0])));
	}

	/**Confronto i tempi di scrittura tra FileWriter e BufferedWriter. 
	 * HARD perchè utilizza il metodo write() per ogni singolo carattere di copyString
	 * @param fn_writeNormalHard File di destinazione sul quale voglio scrivere con il FileWriter
	 * @param fn_writeBufferHard File di destinazione sul quale voglio scrivere con il BufferWriter
	 * @param copyString Stringa da copiare su entrambu i File
	 * @return writeTime[0] Tempo di scrittura del FileReader. writeTime[1] Tempo di scrittura del BufferReader
	 */
	private static long[] writeTestHard(String fn_writeNormalHard, String fn_writeBufferHard, StringBuilder copyString){
		long writeTime[] = new long[2];
		long initialTime;

		try(
			FileWriter fw1 = new FileWriter(fn_writeNormalHard);
			FileWriter fw2 = new FileWriter(fn_writeBufferHard);
			BufferedWriter bw = new BufferedWriter(fw2);
		){
			initialTime = System.currentTimeMillis();
			for (int i=0 ; i< copyString.length(); i++)
				fw1.write(copyString.substring(i, i+1));
			writeTime[0]=System.currentTimeMillis() - initialTime;

			initialTime = System.currentTimeMillis();
			for (int i=0 ; i< copyString.length(); i++) 
				bw.write(copyString.substring(i, i+1));
			writeTime[1]=System.currentTimeMillis() - initialTime;

		} catch (IOException e1) {
			e1.printStackTrace();
		}
		return writeTime;
	}

	/**Confronto i tempi di scrittura tra FileWriter e BufferedWriter. 
	 * EASY perchè utilizza il metodo write() per tutta l'intera stringa di copyString
	 * @param fn_writeNormalHard File di destinazione sul quale voglio scrivere con il FileWriter
	 * @param fn_writeBufferHard File di destinazione sul quale voglio scrivere con il BufferWriter
	 * @param copyString Stringa da copiare su entrambu i File
	 * @return writeTime[0] Tempo di scrittura del FileReader. writeTime[1] Tempo di scrittura del BufferReader
	 */
	private static long[] writeTestEasy(String fn_writeNormalEasy, String fn_writeBufferEasy, StringBuilder copyString){
		long writeTime[] = new long[2];
		long initialTime;
		
		try (
			FileWriter fw1 = new FileWriter(fn_writeNormalEasy);
			FileWriter fw2 = new FileWriter(fn_writeBufferEasy);
			BufferedWriter bw = new BufferedWriter(fw2 );
		){	
			initialTime = System.currentTimeMillis();
			fw1.write(copyString.toString());
			writeTime[0]=System.currentTimeMillis() - initialTime;

			initialTime = System.currentTimeMillis();
			bw.write(copyString.toString());
			writeTime[1]=System.currentTimeMillis() - initialTime;

		} catch (IOException e1) {
			e1.printStackTrace();
		}
		return writeTime;
	}

	/**Confronto i tempi di Lettura tra FileReader e BufferedReader. 
	 * @param fn_read File di partenza da quale voglio leggere sia con BufferedReader che con FileReader
	 * @param strBldrNormal StringBuilder sul quale riscrivo i dati letti con FileReader
	 * @param strBldrBuffer StringBuilder sul riscrivo i dati letti con BufferedReader
	 * @return readTime[0] Tempo di lettura del FileReader. readTime[1] Tempo di lettura del BufferedReader
	 */
	private static long[] readTest(String fn_read, StringBuilder strBldrNormal, StringBuilder strBldrBuffer){
		long readTime[] = new long[2];
		try(
			FileReader fr1 = new FileReader(fn_read);
			FileReader fr2 = new FileReader(fn_read);
			BufferedReader br = new BufferedReader(fr2);
		){
			readTime[0] = readNormal(fr1, strBldrNormal);
			readTime[1] = readBuffer(br, strBldrBuffer);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		return readTime;
	}

	/**Metodo che legge i dati da FileReader e li salva in strBldrNormal
	 * @param fr FileReader
	 * @param strBldrNormal StringBuilder sul quale salvo i dati letti con FileReader
	 * @return readTime Tempo di lettura del FileReader
	 */
	private static long readNormal(FileReader fr, StringBuilder strBldrNormal ) throws IOException{
		long initialTime = System.currentTimeMillis();
		int readInt; // Dove appoggio gli interi letti con il metodo read()
		
		while ((readInt = fr.read())!=-1){ // When the "End Of File" is reached the read() method returns -1			
			strBldrNormal.append((char)readInt);
		} 
		return System.currentTimeMillis() - initialTime;
	}
	
	/**Metodo che legge i dati da BufferedReader e li salva in strBldrBuffer
	 * @param br BufferedReader
	 * @param strBldrBuffer StringBuilder sul quale salvo i dati letti con BufferedReader
	 * @return readTime Tempo di lettura del BufferedReader
	 */
	private static long readBuffer(BufferedReader br, StringBuilder strBldrBuffer) throws IOException{
		long initialTime = System.currentTimeMillis();
		String readLine; // Dove appoggio le stringhe lette con il metodo readLine()
		
		while((readLine = br.readLine()) != null){ // When the "End Of File" is reached the readline() method returns null
			strBldrBuffer.append(readLine+"\n");
		}
		strBldrBuffer.deleteCharAt(strBldrBuffer.length()-1);
		return System.currentTimeMillis() - initialTime;
	}
}