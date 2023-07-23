package B5_Inheritance.People;

public class Persona {
    private String nome;
    private String cognome;
    private String codiceFiscale;

    public String toString() {
        StringBuilder id = new StringBuilder();
        id.append("Persona> ");
        id.append("Nome: " + nome + ". ");
        id.append("Cognome: " + cognome + ". ");
        id.append("Codice Fiscale: " + codiceFiscale + ".");
        return id.toString();
    }

    public Persona(String nome, String cognome, String codiceFiscale) {
        this.nome = nome;
        this.cognome = cognome;
        this.codiceFiscale = codiceFiscale;
    }

    public Persona() {
    }

    /**
     * @return nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return cognome
     */
    public String getCognome() {
        return cognome;
    }

    /**
     * @param cognome
     */
    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    /**
     * @return codiceFiscale
     */
    public String getCodiceFiscale() {
        return codiceFiscale;
    }

    /**
     * @param codiceFiscale
     */
    public void setCodiceFiscale(String codiceFiscale) {
        this.codiceFiscale = codiceFiscale;
    }

}