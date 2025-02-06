package Empregado;

public class Principal {
    public static void main(String[] args) {
        FolhaDePagamento folha = new FolhaDePagamento();
        
        folha.adicionarFuncionario(new Assalariado("João", 3000));
        folha.adicionarFuncionario(new Comissionado("Maria", 50000, 0.1));
        folha.adicionarFuncionario(new Horista("Carlos", 20, 160));
        
        System.out.println("Funcionários cadastrados:");
        folha.exibirTodos();
        
        System.out.println("Total da folha de pagamento: R$ " + folha.calcularValorTotal());
    }
}
