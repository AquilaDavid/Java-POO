public abstract class Militar implements Carreira{
    private int matricula;
    private String patente;

    public Militar(int matricula, String patente){
        this.matricula = matricula;
        this.patente = patente;
    }

    @Override
    public boolean podeProgredir() {
        return false;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    
}