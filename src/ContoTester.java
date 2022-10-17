/* ES 3.1 - REALIZZARE CLASSI
 * Scrivere un programma che costruisca un conto bancario, versi in esso
 * $1000, prelevi da esso $500, prelevi altri $400 e infine visualizzi il saldo
 * rimanente 
 */

public class ContoTester {
    public static void main(String[] args) {
        Conto conto1 = new Conto();
        conto1.versa(1000);
        System.out.println("Sul conto ci sono "+conto1.getSaldo()+"Euro");
        conto1.preleva(500);;
        System.out.println("Sul conto ci sono "+conto1.getSaldo()+"Euro");
        conto1.preleva(400);;
        System.out.println("Sul conto ci sono "+conto1.getSaldo()+"Euro");
    }

}
