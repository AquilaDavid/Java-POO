package Atividade7;

import java.util.ArrayList;
import java.util.List;

public class CadastroFrete {
    private List<Fretavel> fretes = new ArrayList<>();

    public void adicionarFrete(Fretavel frete) {
        fretes.add(frete);
    }

    public double calcularTotalFretes() {
        double total = 0;
        for (Fretavel frete : fretes) {
            total += frete.calcularFrete();
        }
        return total;
    }
}