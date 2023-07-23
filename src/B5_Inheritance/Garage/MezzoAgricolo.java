package B5_Inheritance.Garage;

public class MezzoAgricolo {
    private double costoRiparazione;
    private String modello;
    private int identificativo;
    Lavoro lista[];

    public MezzoAgricolo(String modello, int identificativo) {
        this.modello = modello;
        this.identificativo = identificativo;
        this.costoRiparazione = 0;

        lista = new Lavoro[10];
        for (int i = 0; i < lista.length; i++)
            lista[i] = new Lavoro("", 0);
    }

    public void setlista(String v, int p) {
        for (int j = 0; j < lista.length; j++)
            if (lista[j].getprz() == 0) {
                lista[j] = new Lavoro(v, p);
                costoRiparazione += p;// incremento il totale del costo della riparazione
                break;
            }
    }// fine setlista

    public String toString() {
        String s = "id:" + identificativo + " modello:" + modello + " tot:" + costoRiparazione;
        if (lista[0].getprz() != 0)
            s += "\n";
        for (int j = 0; j < lista.length; j++)
            if (lista[j].getprz() != 0)
                s += lista[j];
        return s;
    }

    public double getCostoRiparazione() {
        return costoRiparazione;
    }

    public void setCostoRiparazione(double costoRiparazione) {
        this.costoRiparazione = costoRiparazione;
    }

    public String getModello() {
        return modello;
    }

    public int getIdentificativo() {
        return identificativo;
    }

    public void setIdentificativo(int identificativo) {
        this.identificativo = identificativo;
    }
}