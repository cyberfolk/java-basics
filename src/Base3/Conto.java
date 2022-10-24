package base3;

/* ES 3.1 -REALIZZARE CLASSI
 * Scrivere un programma che costruisca un conto bancario, versi in esso
 * $1000, prelevi da esso $500, prelevi altri $400 e infine visualizzi il saldo
 * rimanente 
 */

public class Conto {
    private double saldo;

    /** Costruisce un conto con un saldo iniziale nullo    
     *  
     */
    public Conto() {
    }

    /** Costruisce un conto con un saldo iniziale assegnato
     * @param saldo Saldo iniziale Assegnato
     */
    public Conto(double saldo) {
        this.saldo = saldo;
    }

    /** Visualizza denaro sil conto
     * @return  Il saldo del conto   
     */
    public double getSaldo() {
        return saldo;
    }

    /** Preleva denaro dal conto 
     * @param prelievo Il prelievo da fare sul conto
     */
    public void preleva(int prelievo) {
        this.saldo = this.saldo - prelievo;
    }

    /** Versa denaro nel conto 
     * @param versamento Il versamento da fare sul conto
     */
    public void versa(int versamento) {
        this.saldo = this.saldo + versamento;
    }
}