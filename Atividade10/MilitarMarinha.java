public class MilitarMarinha extends Militar{
    private boolean participouConserto;

    public MilitarMarinha(int matricula, String patente, boolean participouConserto){
        super(matricula,patente);
        this.participouConserto = participouConserto;
    }

    @Override
    public boolean podeProgredir() {
        if (getParticipouConserto() == true) {
        
            return true  ;
        }else{
            System.out.println("PROMOÇÃO DE PATENTE NEGADA");
        }      
        return super.podeProgredir();
    }

    public boolean getParticipouConserto(){
        return this.participouConserto;
    }

    public void setParticipouConserto(boolean PC){
        this.participouConserto = PC;
    }
}
