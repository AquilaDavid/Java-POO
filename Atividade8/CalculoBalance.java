package Atividade8;

public class CalculoBalance {

  // Ponto de entrada principal do programa
  public static void main(String[] args) {
    
    // Define o vetor de entradas de transações
    String[] transacoes = { "1001,D,300", "1002,C,200", "1001,D,300" };

    // Chama a função para calcular o saldo de -400
    System.out.println("Cálculo 1 (Saldo total de -400):");
    calcularSaldo(transacoes, 1); // Primeiro cálculo com saldo -400

    // Chama a função para calcular o saldo de -100
    System.out.println("\nCálculo 2 (Saldo total de -100):");
    calcularSaldo(transacoes, 2); // Segundo cálculo com saldo -100
  }

  // Função que calcula o saldo total baseado nas transações e no tipo de cálculo
  public static void calcularSaldo(String[] transacoes, int tipoCalculo) {
    int saldoTotal = 0; // Variável para armazenar o saldo total

    // Percorre todas as transações no vetor transacoes
    for (String transacao : transacoes) {
        // Divide cada transação em 3 partes: ID, operação e valor
        String[] partes = transacao.split(",");
        
        // A operação é a segunda parte da transação (C para crédito, D para débito)
        String operacao = partes[1];
        
        // O valor da transação, convertido para inteiro
        int valor = Integer.parseInt(partes[2]);

        // Modifica o saldo conforme a operação (C = crédito, D = débito)
        if (operacao.equals("C")) {
            // Se for crédito, soma o valor ao saldo total
            saldoTotal += valor;
        } else if (operacao.equals("D")) {
            // Se for débito, realiza cálculos diferentes dependendo do tipo de cálculo
            if (tipoCalculo == 1) {
                // Tipo de cálculo 1: débito subtrai o valor total
                saldoTotal -= valor;
            } else if (tipoCalculo == 2) {
                // Tipo de cálculo 2: débito subtrai metade do valor
                saldoTotal -= (valor / 2);
            }
        }
    }

    // Exibe o saldo total calculado para o tipo de cálculo específico
    System.out.println("Saldo Total -> " + saldoTotal);
  }
}
