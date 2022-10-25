package ereditarieta;

public class Docente extends Persona{
    private String materia;
    private int salario;

    public String toString(){
        StringBuilder id = new StringBuilder();
        id.append("Docente> ");
        id.append("Nome: "+super.getNome()+". ");
        id.append("Cognome: "+super.getCognome()+". ");
        id.append("Codice Fiscale: "+super.getCodiceFiscale()+". ");
        id.append("Materia: "+materia+". ");
        id.append("Salario: "+salario+".");
        return id.toString();
    } 

    public Docente(String nome, String cognome, String codiceFiscale, String materia, int salario) {
        super(nome, cognome, codiceFiscale);
        this.materia = materia;
        this.salario = salario;
    }

    public Docente() {
    }

    public String getMatricola() {
        return materia;
    }
    public void setMatricola(String matricola) {
        this.materia = matricola;
    }

    public int getSalario() {
        return salario;
    }
    public void setSalario(int salario) {
        this.salario = salario;
    }

    
}