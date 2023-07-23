package B5_Inheritance.People;

public class Studente extends Persona {
    private String matricola;
    private String universita;

    public String toString() {
        StringBuilder id = new StringBuilder();
        id.append("Studente> ");
        id.append("Nome: " + super.getNome() + ". ");
        id.append("Cognome: " + super.getCognome() + ". ");
        id.append("Codice Fiscale: " + super.getCodiceFiscale() + ". ");
        id.append("Matricola: " + matricola + ". ");
        id.append("Università: " + universita + ".");
        return id.toString();
    }

    public Studente(String nome, String cognome, String codiceFiscale, String matricola, String universita) {
        super(nome, cognome, codiceFiscale);
        this.matricola = matricola;
        this.universita = universita;
    }

    public Studente() {
    }

    public String getMatricola() {
        return matricola;
    }

    public void setMatricola(String matricola) {
        this.matricola = matricola;
    }

    public String getUniversita() {
        return universita;
    }

    public void setUniversita(String universita) {
        this.universita = universita;
    }

}