package retangulo;

public class Retangulo {
    // Atributos
    private float largura;
    private float comprimento;

    // Cosntrutor 
    public Retangulo(float largura, float comprimento){
        this.largura = largura;
        this.comprimento = comprimento;
    }

    // Metodos
    public float calcularLargura(){
        return largura * comprimento;
    }

    public float calcularComprimento(){
        return comprimento * 2 + largura * 2;
    }

    public void inprimir(){
        System.out.printf("Comprimento inicial %.2f \n", comprimento);
        System.out.printf("O valor inicial da largura foi %.2f \n", largura);
        System.err.printf("Comprimento após calculo: %.2f \n", calcularComprimento());
        System.err.printf("Largura após calculo: %.2f \n", calcularLargura());
    }
}
