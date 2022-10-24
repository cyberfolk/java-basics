package ereditarieta;

import java.util.Scanner;

public class ElencoPersoneTester {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Quanto la vuoi lunga la lista di personae?");
        ElencoPersone elenco = new ElencoPersone(Integer.parseInt(in.nextLine()));

        for(int i=0; i<elenco.getDIM();i++){
            String str;
            Boolean flag;
            System.out.println("Cosa vuoi inserire? Persona, Studente o Docente?");
            do {
                str = in.nextLine();
                flag =true;
                switch(str){
                    case "Persona":
                        System.out.println("Hai digitato Persona");
                        elenco.addPersona( new Persona(str, str, str));
                        flag=false;
                        break;
                    case "Studente":
                        System.out.println("Hai digitato Studente");
                        elenco.addPersona(  new Studente(str, str, str, str, str));
                        flag=false;
                        break;
                    case "Docente":
                        System.out.println("Hai digitato Docente");
                        elenco.addPersona(  new Docente(str, str, str, str, 1));
                        flag=false;
                        break;
                    default:
                        System.out.println("Il parametro inserito non è corretto. Reinserirlo");
                }
            } while(flag);
        }
        System.out.println(elenco.toString());
        in.close();
    }
}

