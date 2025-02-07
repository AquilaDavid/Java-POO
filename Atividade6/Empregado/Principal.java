package Empregado;

public class Principal {
    public static void main(String[] args) {
        FolhaDePagamento folha = new FolhaDePagamento();
        
        folha.adicionarFuncionario(new Assalariado("João", "Miguel", 12341234, 3000));
        folha.adicionarFuncionario(new Comissionado("Maria", "Ludez", 12121221, 50000, 0.1));
        folha.adicionarFuncionario(new Horista("Carlos", "Andre", 6262626, 20, 160));
        
        System.out.println("Funcionários cadastrados:");
        folha.exibirTodos();
        
        System.out.println("Total da folha de pagamento: R$ " + folha.calcularValorTotal());
    }
}
