package B5_Inheritance.Garage;

public class Lavoro {
    String rip;
    int prz;

    Lavoro(String r, int p) {
        rip = r;
        prz = p;
    }

    public int getprz() {
        return prz;
    }

    public String toString() {
        String s = "\tvoce:" + rip + " costo:" + prz + "\n";
        return s;
    }
}// fine classe L