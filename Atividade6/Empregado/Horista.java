package Empregado;

public class Horista extends Empregado {
    private double precoHora;
    private int horasTrabalhadas;
    
    public Horista(String nome, String sobrenome, int cpf, double precoHora, int horasTrabalhadas) {
        super(nome,sobrenome,cpf);
        this.precoHora = precoHora;
        this.horasTrabalhadas = horasTrabalhadas;
    }
    
    @Override
    public double calcularVencimento() {
        return precoHora * horasTrabalhadas;
    }
}