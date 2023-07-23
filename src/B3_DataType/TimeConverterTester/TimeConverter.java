package B3_DataType.TimeConverterTester;

public class TimeConverter {
    private int secondi, minuti, ore, giorni;

    /**
     * si costruisce un covertitore da giorni, ore, minuti, secondi, in
     * secondi totali
     * 
     * @param giorni  giorni
     * 
     * @param ore     ore
     * 
     * @param minuti  minuti
     * 
     * @param secondi secondi
     */
    public TimeConverter(int giorni, int ore, int minuti, int secondi) {
        this.giorni = giorni;
        this.ore = ore;
        this.minuti = minuti;
        this.secondi = secondi;
    }

    /**
     * si restituisce i secondi totali a partire da gg, h, min, sec inseriti
     * 
     * @return SecTot secondi totali
     */
    public int getSecTot() {
        int sTot = giorni * 86400 + ore * 3600 + minuti * 60 + secondi;
        return sTot;
    }
}