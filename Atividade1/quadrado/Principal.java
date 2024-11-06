package quadrado;

import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner p = new Scanner(System.in);
        float lado = p.nextFloat();
        Quadrado quadrado = new Quadrado(lado);
        quadrado.inprimir();
        p.close();
    }
}