/* Es 4.3 – Tipi dati
 * Scrivere un programma che, dato un certo tempo in secondi restituisca il numero
 * di giorni, ore, minuti e secondi. 
 */
public class SecondConverter {
    private int sTot;
    private final int SECONDI_AL_MINUTO = 60;
    private final int SECONDI_ALL_ORA = 3600;
    private final int SECONDI_AL_GIORNO = 86400;

    /**
     * si costruisce un convertitore da secondi a gg, h, min, sec
     * 
     * @param secondi i secondi totali
     */
    public SecondConverter(int secondi) {
        sTot = secondi;
    }

    /*
     * si restituisce il numero dei giorni
     * 
     * @return dLocal giorni
     */
    public int getDays() {
        int dLocal = sTot / SECONDI_AL_GIORNO;
        return dLocal;
    }

    /*
     * si restituisce il numero delle ore
     * 
     * @return hLocal ore
     */
    public int getHours() {
        int sSurplus = sTot % SECONDI_AL_GIORNO;
        int hLocal = sSurplus / SECONDI_ALL_ORA;
        return hLocal;
    }

    /**
     * si restituisce il numero dei minuti
     * 
     * @return mLocal minuti
     */
    public int getMin() {
        int sSurplus = (sTot % SECONDI_AL_GIORNO) % SECONDI_ALL_ORA;
        int mLocal = sSurplus / SECONDI_AL_MINUTO;
        return mLocal;
    }

    /**
     * si restituisce il numero dei secondi
     * 
     * @return sLocal secondi
     */
    public int getSec() {
        int sSurplus = ((sTot % SECONDI_AL_GIORNO) % SECONDI_ALL_ORA) %
                SECONDI_AL_MINUTO;
        return sSurplus;
    }

}