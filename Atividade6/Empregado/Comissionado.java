package Empregado;

public class Comissionado extends Empregado {
    private double totalVenda;
    private double taxaComissao;
    
    public Comissionado(String nome, double totalVenda, double taxaComissao) {
        super(nome);
        this.totalVenda = totalVenda;
        this.taxaComissao = taxaComissao;
    }
    
    @Override
    public double calcularVencimento() {
        return totalVenda * taxaComissao;
    }
}