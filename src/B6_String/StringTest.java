/**
 * String vs StringBuffer vs StringBuilder
 * String è immutabile mentre StringBuffer e StringBuilder sono classi mutabili.
 * StringBuffer è thread-safe e sincronizzato mentre StringBuilder non lo è.
 * Per questo motico StringBuilder è più veloce di StringBuffer.
 * L'operatore di concatenazione di stringhe (+) usa internamente StringBuffer o
 * StringBuilder.
 * Per manipolare stringhe in un ambiente mono-thread, è meglio usare
 * StringBuilder.
 */

package B6_String;

import java.io.IOException;

public class StringTest {

	public static void main(String[] args) {
		StringBuffer strBffr = new StringBuffer();
		StringBuilder strBldr = new StringBuilder();
		long result[];

		result = memoryTimeTest(strBffr);
		System.out.println("StringBuffer Time Taken: " + result[0]);
		System.out.println("StringBuffer Memory used: " + result[1]);

		result = memoryTimeTest(strBldr);
		System.out.println("StringBuilder Time Taken: " + result[0]);
		System.out.println("StringBuilder Memory used: " + result[1]);
	}

	/**
	 * Sub metodo per analizzare le prestazioni di StringBuilder e di StringBuffer
	 * 
	 * @param str può ricevere sia StringBuilder che StringBuffer
	 * @return resulti[]. result[0]=str Time Taken. result[1]=str Memory used.
	 */
	private static long[] memoryTimeTest(Appendable str) {
		long result[] = new long[2];
		System.gc(); // Serve per refreshare il Garbage Collector e eliminare gli oggetti
						// irraggiungibili
		long initialTime = System.currentTimeMillis();
		long initialMemory = Runtime.getRuntime().freeMemory();
		try {
			for (int i = 0; i < 1000000; i++)
				str.append(":");
		} catch (IOException e) {
			e.printStackTrace();
		}
		result[0] = System.currentTimeMillis() - initialTime;
		result[1] = initialMemory - Runtime.getRuntime().freeMemory();
		return result;
	}
}