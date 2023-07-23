package B1_Objects.Dice;

public class DadoTester {
    public static void main(String[] args) {
        Dado d10 = new Dado(10);
        int risultato = d10.lancia();

        System.out.println("Lancio: " + risultato);
    }
}
