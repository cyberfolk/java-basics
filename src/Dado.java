/* ES 2.2 - USARE OGGETTI
 * Scrivere un programma che usi la classe Random per simulare il lancio di un
 * dado, visualizzando un numero casuale compreso tra 1 e 6 ogni volta che viene
 * eseguito.
 */

import java.util.Random;

public class Dado {
    private int nFacce;
    private Random gen;

    // costruisce un Dado a 6 facce
    public Dado(int nFacce) {
        this.nFacce = nFacce;
        // si inizializza l'oggetto gen della classe Random
        gen = new Random();
    }

    /**
     * simula il lancio del dado
     * 
     * @return il risultato del lancio
     */
    public int lancia() {
        int result = gen.nextInt(nFacce) + 1;
        return result;
    }
}