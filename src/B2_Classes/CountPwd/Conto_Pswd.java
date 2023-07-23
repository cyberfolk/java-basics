/**
 * PER INFO: vedi Conto_PswdTester.java
 */

package B2_Classes.CountPwd;

public class Conto_Pswd {
    private double saldo;
    private int password;

    /**
     * Costruisce un conto con un saldo iniziale nullo
     * 
     */
    public Conto_Pswd(int Password) {
        this.saldo = 0;
        this.password = Password;
    }

    /**
     * Costruisce un conto con un saldo iniziale assegnato
     * 
     * @param saldo Saldo iniziale Assegnato
     */
    public Conto_Pswd(double saldo, int password) {
        this.saldo = saldo;
        this.password = password;
    }

    /**
     * Visualizza denaro sil conto
     * 
     * @return Il saldo del conto
     */
    public double getSaldo() {
        return saldo;
    }

    /**
     * Preleva denaro dal conto
     * 
     * @param prelievo Il prelievo da fare sul conto
     */
    public void preleva(Double prelievo) {
        this.saldo = this.saldo - prelievo;
    }

    /**
     * Versa denaro nel conto
     * 
     * @param versamento Il versamento da fare sul conto
     */
    public void versa(Double versamento) {
        this.saldo = this.saldo + versamento;
    }

    /**
     * restituisce la password del conto
     * 
     * @return la password del conto
     */
    public int getPassword() {
        return password;
    }

    /**
     * verifica la validità della password immessa
     * 
     * @param password la password da verificare
     * 
     * @return true se corretta, false se errata
     */
    public boolean controlloPassword(int password) {
        if (this.password == password)
            return true;
        return false;
    }

    /**
     * verifica che la somma da prelevare sia disponibile nel conto
     * 
     * @param prelievo la somma da prelevare
     * 
     * @return true se disponibile, false se non disponibile
     */
    public boolean controlloPrelievo(double prelievo) {
        if (prelievo <= saldo)
            return true;
        return false;
    }

}