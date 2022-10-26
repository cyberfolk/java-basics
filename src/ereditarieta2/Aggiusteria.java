package ereditarieta2;

import java.util.Scanner;

public class Aggiusteria {
    public static MezzoAgricolo postiOfficina[];
    public static int elementiInseriti=0;
    public static final int LENGHT=10;

    public static int getLenght() {
        return LENGHT;
    }

    public Aggiusteria() {
        postiOfficina = new MezzoAgricolo[10];
        for (int i = 0; i < LENGHT; i++)
            postiOfficina[i] = new MezzoAgricolo("", 0);
    }

    public void eli(Scanner in) { // elimina
        System.out.print("ins.id:");
        int id = Integer.parseInt(in.nextLine());
        int posto = getPostoDaId(id);
        postiOfficina[posto] = new Motozappa("", 0, 0);
        elementiInseriti--;
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
        for (int j = 0; j < LENGHT; j++)
            if (postiOfficina[j].getIdentificativo() != 0)
                System.out.println(postiOfficina[j]);
    }// fine print

    public void ins(Scanner in) { 
        String marca;
        char tipoMezzo;
        int n, id;
        
        do {
            System.out.print("[M]otozappa [T]osaerba [D]ecesp. e[X]it:");
            tipoMezzo = in.nextLine().toUpperCase().charAt(0);
            if (tipoMezzo == 'D' || tipoMezzo == 'M' || tipoMezzo == 'T') {
                System.out.print("ins.marca:");
                marca = in.nextLine();
                elementiInseriti++;
                id = getPrimoPostoLibero(); // Serve nel caso venissero eliminati degli ID e si generano dei buchi 
                //con questa istruzione identifichiamo i primi posti da riempire
                switch (tipoMezzo){
                    case 'M':
                        System.out.print("ins.n.ruote:");
                        n = Integer.parseInt(in.nextLine());
                        postiOfficina[id] = new Motozappa(marca, id+1, n);
                        break;
                    case 'T':
                        System.out.print("ins.n.ruote:");
                        n = Integer.parseInt(in.nextLine());
                        postiOfficina[id] = new Tosaerba(marca, id+1, n);
                        break;
                    case 'D':
                        System.out.print("acc.elettr.(0/1)?:");
                        n = Integer.parseInt(in.nextLine());
                        postiOfficina[id] = new Decespugliatore(marca, id+1, (n!=0));
                        break;
                }
            } // fine if
        } while (tipoMezzo != 'X' && elementiInseriti < 10);
    }// fine ins

    static private int getPrimoPostoLibero(){
        for (int i = 0; i < LENGHT; i++){
            if (postiOfficina[i].getIdentificativo() == 0)
                return i;    
        }
        return -1;
    }
    
    private int getPostoDaId(int id){
        for (int i = 0; i < LENGHT; i++){
            if (postiOfficina[i].getIdentificativo() == id) 
                return i;
        }
        return -1;
    }

}
