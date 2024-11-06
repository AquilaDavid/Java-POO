package circulo;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        float raio = teclado.nextFloat();
        Circulo circulo = new Circulo(raio);
        circulo.imprimir();
        teclado.close();
    }
}
