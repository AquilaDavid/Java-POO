package Desenhar;

import java.util.ArrayList;

public class CadastroDeDesenhos {
    private ArrayList<Desenho> desenhos = new ArrayList<>();
    
    public void adicionarDesenho(Desenho desenho) {
        desenhos.add(desenho);
    }
    
    public void desenharTodos() {
        for (Desenho d : desenhos) {
            d.desenhar();
        }
    }
}
