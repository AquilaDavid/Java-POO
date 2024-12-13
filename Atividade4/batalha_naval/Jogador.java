package Atividade4.batalha_naval;

import java.util.Scanner;

public class Jogador {
    private static final int TAMANHO_TABULEIRO = 8;
    private final String nome;
    private final char[][] meuJogo;
    private final char[][] jogoDoAdversario;

    public Jogador(String nome) {
        this.nome = nome;
        this.meuJogo = inicializarTabuleiro();
        this.jogoDoAdversario = inicializarTabuleiro();
    }

    public String getNome() {
        return nome;
    }

    private char[][] inicializarTabuleiro() {
        char[][] tabuleiro = new char[TAMANHO_TABULEIRO][TAMANHO_TABULEIRO];
        for (int i = 0; i < TAMANHO_TABULEIRO; i++) {
            for (int j = 0; j < TAMANHO_TABULEIRO; j++) {
                tabuleiro[i][j] = '~'; // '~' representa água
            }
        }
        return tabuleiro;
    }

    public void posicionarArmas(Scanner scanner) {
        System.out.println("Posicione suas armas no tabuleiro (alocação apenas na horizontal):");
        posicionarArma(scanner, "Submarino", 's', 1, 3);
        posicionarArma(scanner, "Cruzador", 'c', 2, 2);
        posicionarArma(scanner, "Porta-aviões", 'p', 3, 1);
    }

    private void posicionarArma(Scanner scanner, String nomeArma, char simbolo, int tamanho, int quantidade) {
        System.out.printf("Posicione %d %s(s) (%d quadrado(s) cada, representado por '%c')\n",
                          quantidade, nomeArma, tamanho, simbolo);

        for (int i = 0; i < quantidade; i++) {
            boolean posicionado = false;
            while (!posicionado) {
                System.out.printf("Digite a posição inicial do %s %d (linha coluna): ", nomeArma, i + 1);
                int linha = scanner.nextInt() - 1;
                int coluna = scanner.nextInt() - 1;

                posicionado = tentarPosicionar(linha, coluna, tamanho, simbolo);
                if (!posicionado) {
                    System.out.println("Posição inválida. Tente novamente.");
                }
            }
        }
    }

    private boolean tentarPosicionar(int linha, int coluna, int tamanho, char simbolo) {
        // Verifica se cabe horizontalmente no tabuleiro
        if (coluna + tamanho > TAMANHO_TABULEIRO || linha < 0 || coluna < 0 || linha >= TAMANHO_TABULEIRO) {
            return false;
        }

        // Verifica se as posições estão livres
        for (int i = 0; i < tamanho; i++) {
            if (meuJogo[linha][coluna + i] != '~') {
                return false;
            }
        }

        // Posiciona a arma no tabuleiro
        for (int i = 0; i < tamanho; i++) {
            meuJogo[linha][coluna + i] = simbolo;
        }

        return true;
    }

    public boolean realizarTurno(Scanner scanner, Jogador adversario) {
        for (int i = 0; i < 2; i++) {
            boolean tiroValido = false;

            while (!tiroValido) {
                System.out.printf("Tiro %d/2: Digite a posição (linha coluna): ", i + 1);
                int linha = scanner.nextInt() - 1;
                int coluna = scanner.nextInt() - 1;

                if (linha < 0 || coluna < 0 || linha >= TAMANHO_TABULEIRO || coluna >= TAMANHO_TABULEIRO) {
                    System.out.println("Coordenadas fora do tabuleiro. Tente novamente.");
                } else if (jogoDoAdversario[linha][coluna] == '~') {
                    boolean acertou = adversario.registrarTiro(linha, coluna);
                    registrarResultado(linha, coluna, acertou);

                    if (acertou) {
                        System.out.println("Acertou uma arma!");
                    } else {
                        System.out.println("Água!");
                    }

                    tiroValido = true;
                } else {
                    System.out.println("Você já atirou nessa posição. Tente novamente!");
                }
            }

            if (adversario.todosOsNaviosAfundados()) {
                System.out.println("Parabéns, " + nome + "! Você venceu o jogo!");
                return false;
            }
        }
        return true; // Continua o jogo
    }

    private void registrarResultado(int linha, int coluna, boolean acertou) {
        jogoDoAdversario[linha][coluna] = acertou ? 'X' : 'O'; // Marca acertos como 'X' e erros como 'O'
    }

    private boolean registrarTiro(int linha, int coluna) {
        if (meuJogo[linha][coluna] != '~' && meuJogo[linha][coluna] != 'X') {
            meuJogo[linha][coluna] = 'X'; // Marca a posição como atingida
            return true;
        }
        return false;
    }

    private boolean todosOsNaviosAfundados() {
        for (int i = 0; i < TAMANHO_TABULEIRO; i++) {
            for (int j = 0; j < TAMANHO_TABULEIRO; j++) {
                if (meuJogo[i][j] == 's' || meuJogo[i][j] == 'c' || meuJogo[i][j] == 'p') {
                    return false; // Ainda há partes de navios não atingidas
                }
            }
        }
        return true;
    }

    public void exibirTabuleiro(char[][] tabuleiro) {
        System.out.println("  1 2 3 4 5 6 7 8");
        for (int i = 0; i < TAMANHO_TABULEIRO; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < TAMANHO_TABULEIRO; j++) {
                System.out.print(tabuleiro[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void exibirMeuTabuleiro() {
        System.out.println("Seu tabuleiro:");
        exibirTabuleiro(meuJogo);
    }

    public void exibirJogoDoAdversario() {
        System.out.println("Tabuleiro do adversário:");
        exibirTabuleiro(jogoDoAdversario);
    }
}
