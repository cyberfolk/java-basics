package ereditarieta2;

public class Decespugliatore extends MezzoAgricolo {
    private boolean accensioneElettrica;

    public Decespugliatore(String modello, int identificativo, boolean accensioneElettrica) {
        super(modello, identificativo);
        this.accensioneElettrica=accensioneElettrica;
    }
    
    public boolean isAccensioneElettrica() {
        return accensioneElettrica;
    }

    public String toString() {
        String s = super.toString() + " acc.el:" + accensioneElettrica;
        return s;
    }
}
