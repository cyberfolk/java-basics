package B2_Classes.Count;

public class ContoTester {
    public static void main(String[] args) {
        Conto conto1 = new Conto();
        conto1.versa(1000);
        System.out.println("Sul conto ci sono " + conto1.getSaldo() + "Euro");
        conto1.preleva(500);

        System.out.println("Sul conto ci sono " + conto1.getSaldo() + "Euro");
        conto1.preleva(400);

        System.out.println("Sul conto ci sono " + conto1.getSaldo() + "Euro");
    }

}
