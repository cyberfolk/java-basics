package ereditarieta1;

import java.util.ArrayList;
import java.util.Iterator;

public class ElencoPersone {
    private ArrayList<Persona> elenco;
    private int DIM;

    public int getDIM() {
        return DIM;
    }

    public ElencoPersone(int DIM) {
        this.DIM=DIM;
        this.elenco = new ArrayList<Persona>(DIM);
    }

    public Boolean addPersona(Persona persona){
        if(elenco.size()<DIM){
            elenco.add(persona);
            return true;
        } else
            return false;
    }
    
    public String toString(){
        Iterator<Persona> i;
        i = elenco.iterator();

        StringBuilder returnString = new StringBuilder();
        while(i.hasNext()){
            returnString.append(i.next().toString());
            returnString.append("\n");
        }
        return returnString.toString();
    }
}
