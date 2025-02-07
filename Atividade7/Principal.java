package Atividade7;

public class Principal {
    public static void main(String[] args) {
        CadastroFrete cadastro = new CadastroFrete();

        // Criando diferentes tipos de fretes
        Fretavel frete1 = new FretePadrao(100, 5);
        Fretavel frete2 = new FreteExpresso(200, 6, 2);
        Fretavel frete3 = new FreteSuperExpresso(300, 7, 3, 500);

        // Adicionando ao cadastro
        cadastro.adicionarFrete(frete1);
        cadastro.adicionarFrete(frete2);
        cadastro.adicionarFrete(frete3);

        // Exibindo os valores individuais dos fretes
        System.out.println("Valores individuais dos fretes:");
        System.out.println("Frete Padrão: R$ " + frete1.calcularFrete());
        System.out.println("Frete Expresso: R$ " + frete2.calcularFrete());
        System.out.println("Frete Super Expresso: R$ " + frete3.calcularFrete());

        // Exibindo o valor total dos fretes cadastrados
        System.out.println("\nValor total dos fretes: R$ " + cadastro.calcularTotalFretes());
    }
}

