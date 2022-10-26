package ereditarieta2;

import java.util.Scanner;

public class tmp {
    public static void main(String[] args) {
        Aggiusteria aggiusteria = new Aggiusteria();
        Scanner in = new Scanner(System.in);
        char modalita;

        do {
            System.out.println("[i]nserisci\n[m]odifica\n[e]limina\ne[x]it\n[P]rint:");
            modalita = in.nextLine().toLowerCase().charAt(0);
            switch (modalita) {
                case 'i':
                    aggiusteria.ins(in);
                    break;
                case 'm': 
                    aggiusteria.mod(in);
                    break;
                case 'e': 
                    aggiusteria.eli(in);
                    break;
                case 'x': 
                    System.out.println("fine prog.");
                    break;
                case 'p': 
                    aggiusteria.print();
                    break;
                default: 
                    System.out.println("scelta non valida");
                    break;
            }
        } while (modalita != 'x');
        in.close();
    }
}