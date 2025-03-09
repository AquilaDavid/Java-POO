public class MilitarAeronautica extends Militar {
    private int anosServicos;
    private int horasTrabalhadas;

    public MilitarAeronautica(int anosServicos, int horasTrabalhadas, int matricula, String patente) {
        super(matricula, patente);
        this.anosServicos = anosServicos;
        this.horasTrabalhadas = horasTrabalhadas;
    }

    @Override
public boolean podeProgredir() {
    if ((this.anosServicos >= 2 || this.horasTrabalhadas >= 200)) {
        return true ;
    }else{
        System.out.println("PROMOÇÃO DE PATENTE NEGADA");
    }
    return false;
}

    public void status() {
        System.out.println("Matricula: " + getMatricula());
        System.out.println("Patente: " + getPatente());
        System.out.println("Anos na Patente: " + getAnosServicos());
        System.out.println("Horas Trabalhadas: " + getHorasTrabalhadas());
    }

    public int getAnosServicos() {
        return anosServicos;
    }

    public void setAnosServicos(int anosServicos) {
        this.anosServicos = anosServicos;
    }

    public int getHorasTrabalhadas() {
        return horasTrabalhadas;
    }

    public void setHorasTrabalhadas(int horasTrabalhadas) {
        this.horasTrabalhadas = horasTrabalhadas;
    }

    
}
