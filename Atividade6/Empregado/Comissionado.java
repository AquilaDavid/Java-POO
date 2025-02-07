package Empregado;

public class Comissionado extends Empregado {
    private double totalVenda;
    private double taxaComissao;
    
    public Comissionado(String nome, String sobrenome, int cpf, double totalVenda, double taxaComissao) {
        super(nome, sobrenome, cpf);
        this.totalVenda = totalVenda;
        this.taxaComissao = taxaComissao;
    }
    
    @Override
    public double calcularVencimento() {
        return totalVenda * taxaComissao;
    }
}