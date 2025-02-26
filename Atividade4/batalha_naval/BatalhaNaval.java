package Atividade4.batalha_naval;

import java.util.Scanner;

public class BatalhaNaval {
    private final Scanner scanner;

    public BatalhaNaval() {
        this.scanner = new Scanner(System.in);
    }

    public void iniciar() {
        boolean executando = true;

        while (executando) {
            exibirMenu();
            int escolha = scanner.nextInt();
            scanner.nextLine(); // Limpa o buffer

            switch (escolha) {
                case 1:
                    iniciarJogo();
                    break;
                case 2:
                    exibirRegras();
                    break;
                case 3:
                    System.out.println("Saindo do jogo. Até a próxima!");
                    executando = false;
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }

        scanner.close();
    }

    private void exibirMenu() {
        System.out.println("\n=== Batalha Naval - Menu Principal ===");
        System.out.println("1. Iniciar Jogo");
        System.out.println("2. Exibir Regras");
        System.out.println("3. Sair");
        System.out.print("Escolha uma opção: ");
    }

    private void iniciarJogo() {
        System.out.println("\nBem-vindo ao Jogo Batalha Naval - Versão Light!");
        Jogador jogador1 = criarJogador("Jogador 1");
        Jogador jogador2 = criarJogador("Jogador 2");

        System.out.println("\n" + jogador1.getNome() + ", posicione suas armas:");
        jogador1.posicionarArmas(scanner);

        System.out.println("\n" + jogador2.getNome() + ", posicione suas armas:");
        jogador2.posicionarArmas(scanner);

        iniciarPartida(jogador1, jogador2);
    }

    private void exibirRegras() {
        System.out.println("\n=== Regras do Jogo ===");
        System.out.println("1. Cada jogador posiciona suas armas no tabuleiro.");
        System.out.println("2. Os jogadores alternam turnos para tentar acertar as armas do adversário.");
        System.out.println("3. Ganha o jogador que afundar todas as armas do oponente primeiro.");
        System.out.println("4. Use coordenadas (linha e coluna) para posicionar ou atacar.");
        System.out.println("5. Boa sorte e divirta-se!");
    }

    private Jogador criarJogador(String identificacao) {
        System.out.print("Informe o nome do " + identificacao + ": ");
        String nome = scanner.nextLine();
        return new Jogador(nome);
    }

    private void iniciarPartida(Jogador jogador1, Jogador jogador2) {
        boolean jogoEmAndamento = true;

        while (jogoEmAndamento) {
            jogoEmAndamento = realizarTurno(jogador1, jogador2);
            if (!jogoEmAndamento) break;

            jogoEmAndamento = realizarTurno(jogador2, jogador1);
        }
    }

    private boolean realizarTurno(Jogador atacante, Jogador defensor) {
        System.out.println("\n" + atacante.getNome() + ", é sua vez de atacar!");
        System.out.println("Seu tabuleiro:");
        atacante.exibirMeuTabuleiro();

        System.out.println("\nTabuleiro do adversário:");
        atacante.exibirJogoDoAdversario();

        boolean jogoContinua = atacante.realizarTurno(scanner, defensor);

        if (!jogoContinua) {
            System.out.println("\nFim do jogo! O vencedor é " + atacante.getNome() + "!");
        }
        return jogoContinua;
    }

    public static void main(String[] args) {
        new BatalhaNaval().iniciar();
    }
}
