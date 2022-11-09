package ereditarieta2;

import java.util.Scanner;

public class AggiusteriaTester {
    public static void main(String[] args) {
        Aggiusteria aggiusteria = new Aggiusteria();
        Scanner in = new Scanner(System.in);
        char modalita;

        do {
            System.out.print("\nMAIN ROUTINE\n> [i]nserisci\n> [m]odifica\n> [e]limina\n> [P]rint\n> e[x]it: \n_ ");
            
            try{
                modalita = in.nextLine().toLowerCase().charAt(0);
            }catch(StringIndexOutOfBoundsException e){
                modalita=' ';
            }

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
                    System.out.println("> Fine programma");
                    break;
                case 'p': 
                    aggiusteria.print();
                    break;
                default: 
                    System.out.println("> Scelta non valida");
                    break;
            }//Fine switch
            
        } while (modalita != 'x');

        aggiusteria.print();
        in.close();

    }//Fine Main
}