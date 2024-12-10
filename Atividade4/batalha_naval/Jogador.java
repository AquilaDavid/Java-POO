package Atividade4.batalha_naval;

import java.util.Scanner;

public class Jogador {
    private static final int TAMANHO_TABULEIRO = 8;
    private final String nome;
    private final char[][] meuJogo;
    private final char[][] jogoDoAdversario;

    public Jogador(String nome) {
        this.nome = nome;
        this.meuJogo = criarTabuleiro();
        this.jogoDoAdversario = criarTabuleiro();
    }

    public String getNome() {
        return nome;
    }

    private char[][] criarTabuleiro() {
        char[][] tabuleiro = new char[TAMANHO_TABULEIRO][TAMANHO_TABULEIRO];
        for (int i = 0; i < TAMANHO_TABULEIRO; i++) {
            for (int j = 0; j < TAMANHO_TABULEIRO; j++) {
                tabuleiro[i][j] = '~'; // '~' representa água
            }
        }
        return tabuleiro;
    }

    public void exibirTabuleiro(boolean meuTabuleiro) {
        char[][] tabuleiro = meuTabuleiro ? meuJogo : jogoDoAdversario;

        System.out.println(meuTabuleiro ? "\nSeu Tabuleiro:" : "\nTabuleiro do Adversário:");
        System.out.print("  ");
        for (int i = 1; i <= TAMANHO_TABULEIRO; i++) {
            System.out.print(i + " ");
        }
        System.out.println();

        for (int i = 0; i < TAMANHO_TABULEIRO; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < TAMANHO_TABULEIRO; j++) {
                System.out.print(tabuleiro[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void posicionarArmas(Scanner scanner) {
        System.out.println("Posicione suas armas no tabuleiro:");
        posicionarArma(scanner, 3, 's', 1, "Submarino");
        posicionarArma(scanner, 2, 'c', 2, "Cruzador");
        posicionarArma(scanner, 1, 'p', 3, "Porta-aviões");
    }

    private void posicionarArma(Scanner scanner, int quantidade, char simbolo, int tamanho, String nomeArma) {
        System.out.printf("Posicione %d %s(s) (%d quadrado(s) cada, representado por '%c')\n",
                          quantidade, nomeArma, tamanho, simbolo);

        for (int i = 0; i < quantidade; i++) {
            boolean posicionado = false;
            while (!posicionado) {
                System.out.println("Digite a posição inicial da arma (linha e coluna, ex: 1 2):");
                int linha = scanner.nextInt();
                int coluna = scanner.nextInt();
                System.out.println("Digite a orientação (H para horizontal, V para vertical):");
                char orientacao = scanner.next().toUpperCase().charAt(0);

                posicionado = validarEPosicionar(linha - 1, coluna - 1, tamanho, orientacao, simbolo);
                if (!posicionado) {
                    System.out.println("Posição inválida. Tente novamente.");
                }
            }
        }
    }

    private boolean validarEPosicionar(int linha, int coluna, int tamanho, char orientacao, char simbolo) {
        if (orientacao == 'H') {
            if (coluna + tamanho > TAMANHO_TABULEIRO) return false;
            for (int j = 0; j < tamanho; j++) {
                if (meuJogo[linha][coluna + j] != '~') return false;
            }
            for (int j = 0; j < tamanho; j++) {
                meuJogo[linha][coluna + j] = simbolo;
            }
        } else if (orientacao == 'V') {
            if (linha + tamanho > TAMANHO_TABULEIRO) return false;
            for (int i = 0; i < tamanho; i++) {
                if (meuJogo[linha + i][coluna] != '~') return false;
            }
            for (int i = 0; i < tamanho; i++) {
                meuJogo[linha + i][coluna] = simbolo;
            }
        } else {
            return false;
        }
        return true;
    }

    public boolean atirar(Scanner scanner, Jogador adversario) {
        for (int i = 0; i < 2; i++) {
            System.out.println("Digite a posição do tiro (linha e coluna, ex: 1 2):");
            int linha = scanner.nextInt() - 1;
            int coluna = scanner.nextInt() - 1;

            if (adversario.verificarSeAcertou(linha, coluna)) {
                System.out.println("Acertou uma arma!");
                marcarNoTabuleiro(jogoDoAdversario, linha, coluna, 'X'); // Marca acerto
            } else {
                System.out.println("Água!");
                marcarNoTabuleiro(jogoDoAdversario, linha, coluna, 'O'); // Marca erro
            }

            if (adversario.verificarSeTodasArmasAfundaram()) {
                System.out.println("Parabéns, " + nome + "! Você venceu!");
                return false;
            }
        }
        return true;
    }

    private void marcarNoTabuleiro(char[][] tabuleiro, int linha, int coluna, char simbolo) {
        tabuleiro[linha][coluna] = simbolo;
    }

    private boolean verificarSeAcertou(int linha, int coluna) {
        if (meuJogo[linha][coluna] != '~' && meuJogo[linha][coluna] != 'X') {
            meuJogo[linha][coluna] = 'X'; // Marca como destruído
            return true;
        }
        return false;
    }

    private boolean verificarSeTodasArmasAfundaram() {
        for (int i = 0; i < TAMANHO_TABULEIRO; i++) {
            for (int j = 0; j < TAMANHO_TABULEIRO; j++) {
                if (meuJogo[i][j] == 's' || meuJogo[i][j] == 'c' || meuJogo[i][j] == 'p') {
                    return false; // Ainda há armas não destruídas
                }
            }
        }
        return true;
    }
}
