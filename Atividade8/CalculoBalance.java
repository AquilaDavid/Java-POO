package Atividade8;

import java.util.HashSet;

public class CalculoBalance {

    public static void main(String[] args) {
        String[] transacoes = { "1001,D,300", "1002,C,200", "1001,D,300" };

        System.out.println("Cálculo 1 (Saldo total de -400 sem repetições):");
        calcularSaldo(transacoes, 1);

        System.out.println("\nCálculo 2 (Saldo total de -100 sem repetições):");
        calcularSaldo(transacoes, 2);
    }

    public static void calcularSaldo(String[] transacoes, int tipoCalculo) {
        int saldoTotal = 0;
        HashSet<String> transacoesProcessadas = new HashSet<>();

        for (String transacao : transacoes) {
            String[] partes = transacao.split(",");
            String id = partes[0]; // ID da transação
            String operacao = partes[1];
            int valor = Integer.parseInt(partes[2]);

            // Se já processamos uma transação com esse ID e tipo de cálculo 2, ignoramos
            if (tipoCalculo == 2 && transacoesProcessadas.contains(id)) {
                continue;
            }

            if (operacao.equals("C")) {
                saldoTotal += valor;
            } else if (operacao.equals("D")) {
                saldoTotal -= valor;
            }

            // Marca o ID da transação como processado no tipo de cálculo 2
            if (tipoCalculo == 2) {
                transacoesProcessadas.add(id);
            }
        }

        System.out.println("Saldo Total -> " + saldoTotal);
    }
}
