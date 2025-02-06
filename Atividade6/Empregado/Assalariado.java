package Empregado;

public class Assalariado extends Empregado {
    private double salario;
    
    public Assalariado(String nome, double salario) {
        super(nome);
        this.salario = salario;
    }
    
    @Override
    public double calcularVencimento() {
        return salario;
    }
}