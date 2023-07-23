package B3_DataType.TimeConverterTester;

import java.util.Scanner;

public class TimeConverterTester {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Inserisci il numero dei giorni ");
        int dd = in.nextInt();
        System.out.print("\nInserisci il numero delle ore ");
        int hours = in.nextInt();
        System.out.print("\nInserisci il numero dei minuti ");
        int min = in.nextInt();
        System.out.print("\nInserisci il numero dei secondi ");
        int sec = in.nextInt();
        TimeConverter conv = new TimeConverter(dd, hours, min, sec);
        System.out.println("\nSecondi totali : " + conv.getSecTot());

        in.close();
    }
}
