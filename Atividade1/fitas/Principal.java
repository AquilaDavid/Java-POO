package fitas;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.print("Infome o nome do filme: ");
        String nomeFilme = teclado.nextLine();
        System.out.print("Infome quantos dias pretende alugar: ");
        int numeroDeDiasAlugada = teclado.nextInt();
        Fitas f = new Fitas(nomeFilme);
        f.imprimir(numeroDeDiasAlugada);
        teclado.close();
    } 
}
