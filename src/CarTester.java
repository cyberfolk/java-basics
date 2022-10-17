/* ES 3.3 -REALIZZARE CLASSI
 * Progettare e realizzare una classe Car(automobile) con le proprietà seguenti.
 * Un’automobile ha una determinata resa del carburante (misurata in miglia/galloni
 * o in litri/chilometri: scegliete il sistema che preferite) e una certa quantità
 * di carburante nel serbatoio. La resa è specificata dal costruttore e il livello
 * iniziale del carburante è a zero. Fornire questi metodi: un metodo drive per
 * simulare il percorso di un’automobile per una certa distanza, riducendo il
 * livello di carburante nel serbatoio; un metodo getGas, per ispezionare il
 * livello corrente del carburante; un metodo addGas per far rifornimento. 
 */

public class CarTester {
    public static void main(String[] args) {
        Car ibiza = new Car(20);
        ibiza.addGas(20);
        ibiza.drive(420);
        System.out.println(ibiza.getGas());
    }
}
