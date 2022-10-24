package base2;

/* ES 2.2 - USARE OGGETTI
 * Scrivere un programma che usi la classe Random per simulare il lancio di un
 * dado, visualizzando un numero casuale compreso tra 1 e 6 ogni volta che viene
 * eseguito.
 */

public class DadoTester {
    public static void main(String[] args) {
        Dado d10 = new Dado(10);
        int risultato = d10.lancia();

        System.out.println("Lancio: " + risultato);
    }
}
