/* ES 3.2 -REALIZZARE CLASSI
 * Lo scopo del programma è riadattare il programma presente nel libro di testo,
 * introducendo il metodo boolean controlloPassword, che restituisce true se la
 * password inserita corrisponde a quella del conto corrente cercato, e il metodo
 * boolean controlloPrelievo, che restituisce true se la somma inserita è
 * disponibile nel conto corrente. 
 */

import java.util.Scanner;

public class Conto_PswdTester {
    public static void main(String[] args) {

        // Inizializzo la variabile che userò per inserire i dati da tastiera 
        Scanner in = new Scanner(System.in);

        // Costruisco conto1. avrà saldo iniziale pari a zero e password definita da
        // utente
        System.out.println("Inserire un numero che sarà password del conto1");
        Conto_Pswd conto1 = new Conto_Pswd(in.nextInt());

        // stampa di verifica dei dati inseriti
        System.out.println("Il saldo del conto1 è: " + conto1.getSaldo());
        System.out.println("la password del conto 1 è: " + conto1.getPassword());

        // Costruisco conto2. con saldo iniziale e password definiti da utente
        System.out.println("Inserire un numero che sarà password del conto2");
        int pswdTmp = in.nextInt();
        System.out.println("Inserire il saldo iniziale del conto 2");
        double saldoTmp = in.nextDouble();
        Conto_Pswd conto2 = new Conto_Pswd(saldoTmp, pswdTmp);

        // stampa di verifica dei dati inseriti
        System.out.println("Il saldo del conto 2 è: " + conto2.getSaldo());
        System.out.println("la password del conto 2 è: " + conto2.getPassword());

        // si preleva una somma dal conto 2
        System.out.println("Prelievo dal conto 2:\nInserire la password del conto 2");
        if (conto2.controlloPassword(in.nextInt())) {
            System.out.println("Inserire la somma da prelevare:");
            double amount = in.nextDouble();
            // controlla che la somma sia disponibile e in caso
            // affermativo la preleva
            if (conto2.controlloPrelievo(amount))
                conto2.preleva(amount);
            else
                System.out.println("Somma non disponibile nel conto");
        } else
            System.out.println("Password errata. Impossibile effettuare il prelievo.");

        // si versa una somma sul conto 1
        System.out.println("Versamento sul conto 1:\nInserire la password del conto 1");
        if (conto1.controlloPassword(in.nextInt())) {
            System.out.println("Inserire la somma da versare:");
            conto1.versa(in.nextDouble());
        } else
            System.out.println("Password errata. Impossibile effettuare il versamento.");
        // stampa un resoconto dei saldi
        System.out.println("Nuovi saldi:\nconto 1: " + conto1.getSaldo() + "\nconto 2: " + conto2.getSaldo());

        in.close();
    }
}
