package Empregado;

import java.util.HashSet;
import java.util.Set;

public class FolhaDePagamento {
    private Set<Empregado> funcionarios;
    
    public FolhaDePagamento() {
        this.funcionarios = new HashSet<>();
    }
    
    public void adicionarFuncionario(Empregado empregado) {
        funcionarios.add(empregado);
    }
    
    public void exibirTodos() {
        for (Empregado empregado : funcionarios) {
            System.out.println(empregado.getNome() + " "  + empregado.getSobrenome() + " - R$ " + empregado.calcularVencimento());
        }
    }
    
    public double calcularValorTotal() {
        double total = 0;
        for (Empregado empregado : funcionarios) {
            total += empregado.calcularVencimento();
        }
        return total;
    }
}