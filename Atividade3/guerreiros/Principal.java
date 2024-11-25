package guerreiros;

import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Guerreiro guerreiro1 = null;
        Guerreiro guerreiro2 = null;

        boolean executando = true;

        while (executando) {
            // Menu interativo
            System.out.println("\n=== MENU ===");
            System.out.println("1. Cadastrar dois guerreiros");
            System.out.println("2. Iniciar uma luta (com laço)");
            System.out.println("3. Iniciar uma luta (com recursividade)");
            System.out.println("4. Alimentar um guerreiro");
            System.out.println("5. Exibir informações de um guerreiro");
            System.out.println("6. Sair do programa");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    // Cadastrar guerreiros
                    System.out.println("Digite o código do primeiro guerreiro:");
                    int codigo1 = scanner.nextInt();
                    scanner.nextLine(); // Consumir nova linha
                    System.out.println("Digite o nome do primeiro guerreiro:");
                    String nome1 = scanner.nextLine();

                    System.out.println("Digite o código do segundo guerreiro:");
                    int codigo2 = scanner.nextInt();
                    scanner.nextLine(); // Consumir nova linha
                    System.out.println("Digite o nome do segundo guerreiro:");
                    String nome2 = scanner.nextLine();

                    guerreiro1 = new Guerreiro(codigo1, nome1);
                    guerreiro2 = new Guerreiro(codigo2, nome2);

                    System.out.println("Guerreiros cadastrados com sucesso!");
                    break;

                case 2:
                    // Iniciar luta com laço
                    if (guerreiro1 != null && guerreiro2 != null) {
                        guerreiro1.lutar(guerreiro2);
                    } else {
                        System.out.println("Cadastre os guerreiros antes de iniciar a luta.");
                    }
                    break;

                case 3:
                    // Iniciar luta com recursividade
                    if (guerreiro1 != null && guerreiro2 != null) {
                        guerreiro1.lutarRecursivo(guerreiro2);
                    } else {
                        System.out.println("Cadastre os guerreiros antes de iniciar a luta.");
                    }
                    break;

                case 4:
                    // Alimentar um guerreiro
                    System.out.println("Escolha o guerreiro para alimentar (1 ou 2):");
                    int escolha = scanner.nextInt();
                    if (escolha == 1 && guerreiro1 != null) {
                        guerreiro1.alimentar();
                    } else if (escolha == 2 && guerreiro2 != null) {
                        guerreiro2.alimentar();
                    } else {
                        System.out.println("Guerreiro inválido ou não cadastrado.");
                    }
                    break;

                case 5:
                    // Exibir informações de um guerreiro
                    System.out.println("Escolha o guerreiro para exibir informações (1 ou 2):");
                    escolha = scanner.nextInt();
                    if (escolha == 1 && guerreiro1 != null) {
                        System.out.println(guerreiro1);
                    } else if (escolha == 2 && guerreiro2 != null) {
                        System.out.println(guerreiro2);
                    } else {
                        System.out.println("Guerreiro inválido ou não cadastrado.");
                    }
                    break;

                case 6:
                    // Sair
                    System.out.println("Encerrando o programa...");
                    executando = false;
                    break;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }

        scanner.close(); // Fechar scanner
    }
}
