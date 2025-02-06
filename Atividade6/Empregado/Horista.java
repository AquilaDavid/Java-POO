package Empregado;

public class Horista extends Empregado {
    private double precoHora;
    private int horasTrabalhadas;
    
    public Horista(String nome, double precoHora, int horasTrabalhadas) {
        super(nome);
        this.precoHora = precoHora;
        this.horasTrabalhadas = horasTrabalhadas;
    }
    
    @Override
    public double calcularVencimento() {
        return precoHora * horasTrabalhadas;
    }
}