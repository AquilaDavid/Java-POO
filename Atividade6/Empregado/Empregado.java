package Empregado;


public abstract class Empregado {
    protected String nome , sobrenome;
    protected int cpf;
    
    public Empregado(String nome, String sobrenome, int cpf) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.cpf = cpf;
    }
    
    public abstract double calcularVencimento();
    
    public String getNome() {
        return nome;
    }

    public String getSobrenome(){
        return sobrenome;
    }

    public int getCpf(){
        return cpf;
    }
}