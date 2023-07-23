package B2_Classes.Car;

public class Car {
    private double gas; // quantità di carburante nel serbatoio
    private double kmL; // prestazioni della vettura

    // si costruisce un'automobile con carburante uguale a zero
    public Car(double resa) {
        kmL = resa;
        gas = 0;
    }

    /**
     * Calcola il livello di carburante rimasto dopo un certo percorso
     * 
     * @param km i chilometri percorsi
     */
    public void drive(double km) {
        gas = gas - (km / kmL);
    }

    /**
     * ispeziona il livello di carburante rimasto
     * 
     * @return il carburante rimasta
     */
    public double getGas() {
        return gas;
    }

    /**
     * aggiunge carburante nel serbatoio
     * 
     * @param rifornimento il carburante da aggiungere
     */
    public void addGas(double rifornimento) {
        gas = gas + rifornimento;
    }
}