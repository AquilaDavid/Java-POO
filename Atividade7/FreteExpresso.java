package Atividade7;

public class FreteExpresso extends Frete {
    private int nivelUrgencia;

    public FreteExpresso(double distancia, double valorPorKm, int nivelUrgencia) {
        super(distancia, valorPorKm);
        this.nivelUrgencia = nivelUrgencia;
    }

    @Override
    public double calcularFrete() {
        return (getDistancia() * getValorPorKm()) + (nivelUrgencia * 100);
    }
}

