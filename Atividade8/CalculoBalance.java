package Atividade8;

import java.util.*;

public class CalculoBalance {

  // Ponto de entrada principal do programa
  public static void main(String[] args) {
    
    // Define o vetor de entradas de transações
    String[] arr = { "1001,D,300", "1002,C,200", "1001,D,300" };

    // Início do primeiro cálculo (Saldo total de -400)
    System.out.println("Primeiro Cálculo (Saldo total de -400):");

    // Criação de um HashMap para armazenar os saldos dos IDs
    Map<String, Integer> balanceMap1 = new HashMap<>();

    // Percorre todas as transações no vetor arr
    for (String entry : arr) {
        // Divide a string da transação em 3 partes: ID, operação e valor
        String[] parts = entry.split(",");
        
        // O ID é a primeira parte da transação
        String id = parts[0];
        
        // A operação é a segunda parte da transação (C para crédito, D para débito)
        String operation = parts[1];
        
        // O valor da transação, convertido para inteiro
        int amount = Integer.parseInt(parts[2]);

        // Obtém o saldo atual do ID no balanceMap1, se não houver, assume o valor 0
        int currentBalance = balanceMap1.getOrDefault(id, 0);

        // Verifica se a operação é um crédito (C)
        if (operation.equals("C")) {
            // Se for crédito, soma o valor ao saldo atual do ID
            balanceMap1.put(id, currentBalance + amount);
        } 
        // Caso contrário, se for um débito (D)
        else if (operation.equals("D")) {
            // Se for débito, subtrai o valor ao saldo atual do ID
            balanceMap1.put(id, currentBalance - amount);
        }
    }

    // Variável para armazenar o saldo total calculado
    int totalBalance1 = 0;
    
    // Percorre todos os saldos armazenados no balanceMap1 e soma-os
    for (int balance : balanceMap1.values()) {
        totalBalance1 += balance;
    }
    
    // Exibe o saldo total calculado (que deve ser -400)
    System.out.println("Total Balance -> " + totalBalance1);

    // Início do segundo cálculo (Saldo total de -100)
    System.out.println("\nSegundo Cálculo (Saldo total de -100):");

    // Criação de um novo HashMap para o segundo cálculo de saldo
    Map<String, Integer> balanceMap2 = new HashMap<>();

    // Percorre novamente todas as transações no vetor arr
    for (String entry : arr) {
        // Divide a string da transação em 3 partes: ID, operação e valor
        String[] parts = entry.split(",");
        
        // O ID é a primeira parte da transação
        String id = parts[0];
        
        // A operação é a segunda parte da transação (C para crédito, D para débito)
        String operation = parts[1];
        
        // O valor da transação, convertido para inteiro
        int amount = Integer.parseInt(parts[2]);

        // Verifica se a operação é um crédito (C)
        if (operation.equals("C")) {
            // Se for crédito, soma o valor ao saldo atual do ID
            balanceMap2.put(id, balanceMap2.getOrDefault(id, 0) + amount);
        } 
        // Caso contrário, se for um débito (D)
        else if (operation.equals("D")) {
            // Se for débito, subtrai metade do valor ao saldo atual do ID
            balanceMap2.put(id, balanceMap2.getOrDefault(id, 0) - (amount / 2));
        }
    }

    // Variável para armazenar o saldo total calculado para o segundo cálculo
    int totalBalance2 = 0;
    
    // Percorre todos os saldos armazenados no balanceMap2 e soma-os
    for (int balance : balanceMap2.values()) {
        totalBalance2 += balance;
    }
    
    // Exibe o saldo total calculado (que deve ser -100)
    System.out.println("Total Balance -> " + totalBalance2);
  }
}
