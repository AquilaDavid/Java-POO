package circulo;

public class Circulo {
    // Atributos
    private float pi = 3.141516f;
    private float raio;

    // Contrutor
    public Circulo(float raio){
        this.raio = raio;
    }

    // Metodos
    public float calcularArea(){
        return pi * raio * raio;
    }

    public float calcularPerimetro(){
        return 2 * pi * raio;
    }

    public void imprimir(){
        System.out.printf("O Raio é %.2f \n", raio);
        System.out.printf("O perimetro do circulo é %.2f \n", calcularPerimetro() );
        System.out.printf("A área do circulo é %.2f \n", calcularArea());
    }
}
