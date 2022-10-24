package base1;
/* ES 2.1 - USARE OGGETTI
 * Costruire un rettangolo partendo da una base, un’altezza e dalle coordinate del piano. 
 */

public class Rettangolo {
    private int altezza;
    private int base;
    private int ascissa;
    private int ordinata;

	/**
     * 
     */
    public Rettangolo() {
        altezza = 1;
        base = 1;
        ascissa = 0;
        ordinata = 0;
    }

    /**
     * si costruisce un rettangolo con i parametri acquisiti dall'esterno
     * 
     * @param base     la base del rettangolo
     * 
     * @param altezza  l'altezza del rettangolo
     * 
     * @param ascissa  l'ascissa del rettangolo
     * 
     * @param ordinata l'ordinata del rettangolo
     */
    public Rettangolo(int base, int altezza, int ordinata, int ascissa) {
        this.altezza = altezza;
        this.base = base;
        this.ascissa = ascissa;
        this.ordinata = ordinata;
    }

    /*
     * si acquisisce l'ordinata
     * 
     * @return l'ordinata del rettangolo
     */
    public int getOrdinata() {
        return ordinata;
    }

    /*
     * si modifica l'ordinata
     * 
     * @param nuovaOrdinata la nuova ordinata
     */
    public void setOrdinata(int nuovaOrdinata) {
        this.ordinata = nuovaOrdinata;
    }

    /*
     * si acquisisce l'acissa
     * 
     * @return l'ascissa del rettangolo
     */
    public int getAsciss() {
        return ascissa;
    }

    /*
     * si modifica l'ascissa
     * 
     * @param nuovaAscissa la nuova ascissa
     */
    public void setAscissa(int nuovaAscissa) {
        this.ascissa = nuovaAscissa;
    }

    /*
     * si acquisisce la base
     * 
     * @return la base del rettangolo
     */
    public int getBase() {
        return base;
    }

    /*
     * si modifica la base
     * 
     * @param nuovaBase la nuova misura della base
     */
    public void setBase(int nuovaBase) {
        this.base = nuovaBase;
    }

    /*
     * si acquisisce l'altezza
     * 
     * @return l'altezza del rettangolo
     */
    public int getAltezza() {
        return altezza;
    }

    /*
     * si modifica l'altezza
     * 
     * @param nuovaAltezza la nuova misura dell'altezza
     */
    public void setAltezza(int nuovaAltezza) {
        this.altezza = nuovaAltezza;
    }

    /**
     * si traslano le coordinate nel piano
     * 
     * @param trX lo spostamento in ascissa
     * 
     * @param trY lo spostamento in ordinata
     */
    public void traslazione(int trAscissa, int trOrdinata) {
        this.ascissa = this.ascissa + trAscissa;
        this.ordinata = this.ordinata + trOrdinata;
    }

    /*
     * si calcola il perimetro
     * 
     * @return il perimetro
     */
    public int getPerimetro() {
        return (base + altezza) * 2;
    }

    /*
     * si calcola l'area
     * 
     * @return l'area
     */
    public int getArea() {
        return base * altezza;
    }
}