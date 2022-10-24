package base4;
/* Es 4.3 – Tipi dati
 * Scrivere un programma che, dato un certo tempo in secondi restituisca il numero
 * di giorni, ore, minuti e secondi. 
 */
import java.util.Scanner;

public class SecondConverterTester {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Iserisci il numero dei secondi totali ");
        int secTot = in.nextInt();
        SecondConverter conv = new SecondConverter(secTot);
        System.out.println("Giorni: " + conv.getDays());
        System.out.println("Ore: " + conv.getHours());
        System.out.println("Minuti: " + conv.getMin());
        System.out.println("Secondi: " + conv.getSec());
        in.close();
    }
}