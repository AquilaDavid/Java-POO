package Empregado;


public abstract class Empregado {
    protected String nome;
    
    public Empregado(String nome) {
        this.nome = nome;
    }
    
    public abstract double calcularVencimento();
    
    public String getNome() {
        return nome;
    }
}