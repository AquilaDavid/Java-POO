package helicoptero;

import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Solicitar capacidade inicial dos helicópteros
        System.out.println("Insira a capacidade máxima do primeiro helicóptero:");
        int capacidadeHeli1 = scanner.nextInt();
        System.out.println("Insira a capacidade máxima do segundo helicóptero:");
        int capacidadeHeli2 = scanner.nextInt();

        // Criar os helicópteros com base na entrada do usuário
        Helicoptero heli1 = new Helicoptero(capacidadeHeli1);
        Helicoptero heli2 = new Helicoptero(capacidadeHeli2);

        boolean executando = true;

        while (executando) {
            // Exibir menu
            System.out.println("\n=== MENU ===");
            System.out.println("1. Exibir estado dos helicópteros");
            System.out.println("2. Adicionar pessoas ao helicóptero");
            System.out.println("3. Remover pessoas do helicóptero");
            System.out.println("4. Ligar helicóptero");
            System.out.println("5. Desligar helicóptero");
            System.out.println("6. Decolar helicóptero");
            System.out.println("7. Aterrissar helicóptero");
            System.out.println("8. Sair do programa");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    // Exibir estado dos helicópteros
                    System.out.println("\nEstado dos helicópteros:");
                    System.out.println("Helicóptero 1: " + heli1);
                    System.out.println("Helicóptero 2: " + heli2);
                    break;

                case 2:
                    // Adicionar pessoas
                    System.out.println("Escolha o helicóptero (1 ou 2):");
                    int heliAdd = scanner.nextInt();
                    if (heliAdd == 1) {
                        heli1.entra();
                    } else if (heliAdd == 2) {
                        heli2.entra();
                    } else {
                        System.out.println("Helicóptero inválido.");
                    }
                    break;

                case 3:
                    // Remover pessoas
                    System.out.println("Escolha o helicóptero (1 ou 2):");
                    int heliRemove = scanner.nextInt();
                    if (heliRemove == 1) {
                        heli1.sai();
                    } else if (heliRemove == 2) {
                        heli2.sai();
                    } else {
                        System.out.println("Helicóptero inválido.");
                    }
                    break;

                case 4:
                    // Ligar helicóptero
                    System.out.println("Escolha o helicóptero (1 ou 2):");
                    int heliLigar = scanner.nextInt();
                    if (heliLigar == 1) {
                        heli1.ligar();
                    } else if (heliLigar == 2) {
                        heli2.ligar();
                    } else {
                        System.out.println("Helicóptero inválido.");
                    }
                    break;

                case 5:
                    // Desligar helicóptero
                    System.out.println("Escolha o helicóptero (1 ou 2):");
                    int heliDesligar = scanner.nextInt();
                    if (heliDesligar == 1) {
                        heli1.desligar();
                    } else if (heliDesligar == 2) {
                        heli2.desligar();
                    } else {
                        System.out.println("Helicóptero inválido.");
                    }
                    break;

                case 6:
                    // Decolar helicóptero
                    System.out.println("Escolha o helicóptero (1 ou 2):");
                    int heliDecolar = scanner.nextInt();
                    System.out.println("Digite a altitude para decolar:");
                    float altitudeDecolar = scanner.nextFloat();
                    if (heliDecolar == 1) {
                        heli1.decolar(altitudeDecolar);
                    } else if (heliDecolar == 2) {
                        heli2.decolar(altitudeDecolar);
                    } else {
                        System.out.println("Helicóptero inválido.");
                    }
                    break;

                case 7:
                    // Aterrissar helicóptero
                    System.out.println("Escolha o helicóptero (1 ou 2):");
                    int heliAterrissar = scanner.nextInt();
                    if (heliAterrissar == 1) {
                        heli1.aterrissar();
                    } else if (heliAterrissar == 2) {
                        heli2.aterrissar();
                    } else {
                        System.out.println("Helicóptero inválido.");
                    }
                    break;

                case 8:
                    // Sair do programa
                    System.out.println("Encerrando o programa...");
                    executando = false;
                    break;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }

        scanner.close(); // Fechar o scanner
    }
}
