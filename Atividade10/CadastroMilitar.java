import java.util.ArrayList;
import java.util.List;

public class CadastroMilitar {
    private List<Militar> militares;

    public CadastroMilitar() {
        militares = new ArrayList<>();
    }

    public void adicionarMilitar(Militar militar) {
        militares.add(militar);
    }

    public List<Militar> getMilitaresQuePodemProgredir() {
        List<Militar> militaresAptos = new ArrayList<>();
        for (Militar militar : militares) {
            if (militar.podeProgredir()) {
                militaresAptos.add(militar);
            }
        }
        return militaresAptos;
    }

    public void realizarProgresso() {
        for (Militar militar : militares) {
            if (militar.podeProgredir()) {
                // A progressão consiste apenas em trocar a patente
                if (militar.getPatente().equals("Soldado")) {
                    militar.setPatente("Cabo");
                } else if (militar.getPatente().equals("Cabo")) {
                    militar.setPatente("Tenente");
                }
            }
        }
    }
}
