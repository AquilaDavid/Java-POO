package Atividade7;

public class FreteSuperExpresso extends Frete {
    private int nivelUrgencia;
    private double valorDoSeguro;

    public FreteSuperExpresso(double distancia, double valorPorKm, int nivelUrgencia, double valorDoSeguro) {
        super(distancia, valorPorKm);
        this.nivelUrgencia = nivelUrgencia;
        this.valorDoSeguro = valorDoSeguro;
    }

    @Override
    public double calcularFrete() {
        return (getDistancia() * getValorPorKm()) + (nivelUrgencia * 100) + valorDoSeguro;
    }
}
