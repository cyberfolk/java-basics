/* ES 2.1 - USARE OGGETTI
 * Costruire un rettangolo partendo da una base, un’altezza e dalle coordinate del piano. 
 */

public class RettangoloTester {
    public static void main(String[] args) {
        Rettangolo rettangolo1 = new Rettangolo();
        System.out.println("Perimetro: " + rettangolo1.getPerimetro());
        System.out.println("Area: " + rettangolo1.getArea());
        System.out.println("Expected perimetro: 4");
        System.out.println("Expected area: 1");

        Rettangolo rettangolo2 = new Rettangolo(5, 3, 9, 2);
        System.out.println("Perimetro: " + rettangolo2.getPerimetro());
        System.out.println("Area: " + rettangolo2.getArea());
        System.out.println("Expected perimetro: 16");
        System.out.println("Expected area: 15");
    }
}