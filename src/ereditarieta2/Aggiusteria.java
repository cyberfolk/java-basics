package ereditarieta2;

import java.util.Scanner;

public class Aggiusteria {
    public static MezzoAgricolo postiOfficina[] = new MezzoAgricolo[10];
    public static int elementiInseriti=0;
    public static final int N_POSTI=10;

    public static int getLenght() {
        return N_POSTI;
    }

    public Aggiusteria() {
        for (int i = 0; i < N_POSTI; i++)
            postiOfficina[i] = new MezzoAgricolo("", 0);
    }

    public void eli(Scanner in) { // elimina
        System.out.println("\nSUB ROUTINE ELIMINA");
        if (getPostiOccupati().equals("nessuno")){
            System.out.println("> Non ci sono id da Eliminare");
            return;
        }
        System.out.println("> Scegli che id eliminare tra: " + getPostiOccupati());
        System.out.print("> Inserire id:_ ");
        try{
            int id = Integer.parseInt(in.nextLine());
            int posto = getPostoDaId(id);
            postiOfficina[posto] = new Motozappa("", 0, 0);
            elementiInseriti--;
            System.out.println("> Mezzo eliminato con successo");
        }catch(StringIndexOutOfBoundsException e){
            System.out.println("> Si prega di inserire un id tra: "+getPostiOccupati());
        }catch(java.lang.ArrayIndexOutOfBoundsException e){
            System.out.println("> Si prega di inserire un id tra: "+getPostiOccupati());
        }catch(java.lang.NumberFormatException e){
            System.out.println("> Si prega di inserire un id tra: "+getPostiOccupati());
        }
    }

    public void mod(Scanner in) { // modifica
        char ch;
        String voce;
        int prezzo;
        System.out.print("ins.id:");
        int id = Integer.parseInt(in.nextLine());
        int posto = getPostoDaId(id);

        do {
            System.out.print("ins.voce:");
            voce = in.nextLine();
            System.out.print("ins.prezzo:");
            prezzo = Integer.parseInt(in.nextLine());
            postiOfficina[posto].setlista(voce, prezzo);
            System.out.print("Continuare?(S/N):");
            ch = in.next().toUpperCase().charAt(0);
        } while (ch == 'S');
    }// fine mod

    public void print() {
        System.out.println("\nSUB ROUTINE PRINT");
        if (getPostiOccupati().equals("nessuno")){
            System.out.println("> Non ci sono id da visualizzare");
            return;
        }
        for (int j = 0; j < N_POSTI; j++)
            if (postiOfficina[j].getIdentificativo() != 0)
                System.out.println(postiOfficina[j]);
    }// fine print

    public void ins(Scanner in) {
        String marca;
        char tipoMezzo=' ';
        int n, id;
        
        while (tipoMezzo != 'X' && elementiInseriti < 10){
            System.out.print("\nSUB ROUTINE INSERIMENTO\n> [M]otozappa\n> [T]osaerba\n> [D]ecesp.\n> e[X]it: \n> Inserire mezzo:_ ");
            try{
                tipoMezzo = in.nextLine().toUpperCase().charAt(0);
                if (tipoMezzo == 'D' || tipoMezzo == 'M' || tipoMezzo == 'T') {
                    System.out.print("> Inserire marca:_ ");
                    marca = in.nextLine();
                    elementiInseriti++;
                    id = getPrimoPostoLibero(); // Serve nel caso venissero eliminati degli ID e si generano dei buchi 
                    //con questa istruzione identifichiamo i primi posti da riempire
                    switch (tipoMezzo){
                        case 'M':
                            System.out.print("> Inserire numero ruote:_ ");
                            n = Integer.parseInt(in.nextLine());
                            postiOfficina[id] = new Motozappa(marca, id+1, n);
                            System.out.println("> Mezzo inserito con successo");
                            break;
                        case 'T':
                            System.out.print("> Inserire numero ruote:_ ");
                            n = Integer.parseInt(in.nextLine());
                            postiOfficina[id] = new Tosaerba(marca, id+1, n);
                            System.out.println("> Mezzo inserito con successo");
                            break;
                        case 'D':
                            System.out.print("> Ha accensione Elettrica(0/1)?:_ ");
                            n = Integer.parseInt(in.nextLine());
                            postiOfficina[id] = new Decespugliatore(marca, id+1, (n!=0));
                            System.out.println("> Mezzo inserito con successo");
                            break;
                        default: 
                            System.out.println("> Scelta non valida");
                            break;
                        }
                    } // fine if
                }catch(java.lang.NumberFormatException e){
                    System.out.println("> Si prega di inserire un numero intero");
                }catch(StringIndexOutOfBoundsException e){
                    System.out.println("> Si prega di inserire un numero intero");
                }
        } 
        if(elementiInseriti==10)
            System.out.println("> SUBROUTINE INTERROTA.\n> Tutti i posti al momento sono occcupati");
    }// fine ins
  
    private int getPostoDaId(int id){
        for (int i = 0; i < N_POSTI; i++)
            if (postiOfficina[i].getIdentificativo() == id) 
                return i;
        return -1;
    }

    private int getPrimoPostoLibero(){
        return getPostoDaId(0); //Se id==0 il posto + libero
    }
    
    protected String getPostiOccupati(){
        StringBuilder str = new StringBuilder("");
        try{
            for (int i = 0; i < N_POSTI; i++){
                if (postiOfficina[i].getIdentificativo() != 0){
                    str.append((i+1)+", ");
                }
            }
            str.replace(str.length()-2, str.length(), "."); // tolgo l'ultimo ", " per inserire "."
            return str.toString();
        }catch(java.lang.StringIndexOutOfBoundsException e){
            return str.replace(0, str.length(), "nessuno").toString();
        }
    }

}
