public class MilitarExercito extends Militar {
    private boolean participouGuerra;
    private boolean ganhouGuerra;

    public MilitarExercito(boolean participouGuerra, boolean ganhouGuerra, int matricula, String patente){
        super(matricula, patente);
        this.participouGuerra = participouGuerra;
        this.ganhouGuerra = ganhouGuerra;
    }

    @Override
    public boolean podeProgredir() {
        if (this.participouGuerra == true && this.ganhouGuerra == true) {
            return true;
        }else{
            System.out.println("PROMOÇÃO DE PATENTE NEGADA");
        }
        return super.podeProgredir();
    }

    public void status() {
        System.out.println("Matricula: " + getMatricula());
        System.out.println("Patente: " + getPatente());
        System.out.println("Participou da guerra: " + isParticipouGuerra());
        System.out.println("Ganhou a guerra: " + isGanhouGuerra());
    }

    public boolean isParticipouGuerra() {
        return participouGuerra;
    }

    public void setParticipouGuerra(boolean participouGuerra) {
        this.participouGuerra = participouGuerra;
    }

    public boolean isGanhouGuerra() {
        return ganhouGuerra;
    }

    public void setGanhouGuerra(boolean ganhouGuerra) {
        this.ganhouGuerra = ganhouGuerra;
    }

    
}
