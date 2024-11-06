package quadrado;

public class Quadrado {
    // Atributos 
    private float lado;

    // Construtor 
    public Quadrado( float lado){
        this.lado = lado;
    }
    
    // Metodo
    public float calcularPerimetro(){
        return lado * lado;
    }

    public float calcularArea(){
        return lado * 4;
    }

    public void inprimir(){
        System.out.printf("O lado do quadrado é %.2f \n", lado);
        System.out.printf("O perimetro do quadrado é %.2f \n", calcularPerimetro() );
        System.out.printf("A área do quatrado é %.2f \n", calcularArea());
    }
}
