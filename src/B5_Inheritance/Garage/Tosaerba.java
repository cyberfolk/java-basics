package B5_Inheritance.Garage;

public class Tosaerba extends MezzoAgricolo {
    private int numRuote;

    public Tosaerba(String modello, int identificativo, int numRuote) {
        super(modello, identificativo);
        this.numRuote = numRuote;
    }

    public int getNumRuote() {
        return numRuote;
    }

    public String toString() {
        String s = super.toString() + " num ruote:" + numRuote;
        return s;
    }
}
