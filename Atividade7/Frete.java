package Atividade7;

public abstract class Frete implements Fretavel {
    private double distancia;
    private double valorPorKm;

    public Frete(double distancia, double valorPorKm) {
        this.distancia = distancia;
        this.valorPorKm = valorPorKm;
    }

    public double getDistancia() {
        return distancia;
    }

    public double getValorPorKm() {
        return valorPorKm;
    }
}
