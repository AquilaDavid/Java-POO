package Desenhar;

public class Principal {
    public static void main(String[] args) {
        CadastroDeDesenhos cadastro = new CadastroDeDesenhos();
        
        cadastro.adicionarDesenho(new Retangulo());
        cadastro.adicionarDesenho(new Circulo());
        cadastro.adicionarDesenho(new Quadrado());
        cadastro.adicionarDesenho(new Pessoa());
        
        cadastro.desenharTodos();
    }
}
