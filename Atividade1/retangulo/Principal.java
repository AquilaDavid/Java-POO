package retangulo;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        float compri = teclado.nextFloat();
        float area = teclado.nextFloat();
        Retangulo retangulo = new Retangulo(area, compri);
        retangulo.inprimir();
        teclado.close();
    }
}
