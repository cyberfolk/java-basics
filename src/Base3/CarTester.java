

public class CarTester {
    public static void main(String[] args) {
        Car ibiza = new Car(20);
        ibiza.addGas(20);
        ibiza.drive(420);
        System.out.println(ibiza.getGas());
    }
}
