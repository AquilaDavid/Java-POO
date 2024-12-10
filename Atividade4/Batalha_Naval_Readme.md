
# Documentação do Projeto: **Batalha Naval**

## Visão Geral

Este projeto implementa um jogo de **Batalha Naval** com duas classes principais:

- **`Jogador`**: Gerencia as operações relacionadas aos jogadores, como posicionar armas e atirar.
- **`BatalhaNaval`**: Controla a interação geral do jogo, incluindo o menu, regras e o fluxo de turnos.

---

## Estrutura do Código

A estrutura do código consiste nas seguintes classes:

1. **`Jogador`**: Contém a lógica de cada jogador (posicionamento de armas, execução de ataques).
2. **`BatalhaNaval`**: Controla o fluxo de interação entre os jogadores e o menu principal.

---

## **Classe: `Jogador`**

A classe `Jogador` é responsável por gerenciar as operações do tabuleiro de um jogador, como o posicionamento das armas, ataques ao oponente, e marcação de acertos ou erros no jogo.

### Atributos:

- **`nome`**: O nome do jogador.
- **`meuJogo`**: O tabuleiro do jogador, representado por uma matriz 2D de caracteres (`char[][]`).
- **`jogoDoAdversario`**: O tabuleiro do adversário, representado de forma semelhante ao tabuleiro do jogador.

### Métodos:

#### `Jogador(String nome)`
Construtor da classe, que inicializa o nome do jogador e os tabuleiros (`meuJogo` e `jogoDoAdversario`).

```java
public Jogador(String nome) {
    this.nome = nome;
    this.meuJogo = criarTabuleiro();
    this.jogoDoAdversario = criarTabuleiro();
}
```

#### `private char[][] criarTabuleiro()`
Este método cria e retorna um novo tabuleiro 8x8, onde todos os elementos são inicialmente definidos como `'~'` (representando água).

```java
private char[][] criarTabuleiro() {
    char[][] tabuleiro = new char[TAMANHO_TABULEIRO][TAMANHO_TABULEIRO];
    for (int i = 0; i < TAMANHO_TABULEIRO; i++) {
        for (int j = 0; j < TAMANHO_TABULEIRO; j++) {
            tabuleiro[i][j] = '~'; // '~' representa água
        }
    }
    return tabuleiro;
}
```

#### `public void posicionarArmas(Scanner scanner)`
Este método permite que o jogador posicione suas armas no tabuleiro, passando pela posição e orientação (horizontal ou vertical) para cada tipo de arma.

```java
public void posicionarArmas(Scanner scanner) {
    System.out.println("Posicione suas armas no tabuleiro:");
    posicionarArma(scanner, 3, 's', 1, "Submarino");
    posicionarArma(scanner, 2, 'c', 2, "Cruzador");
    posicionarArma(scanner, 1, 'p', 3, "Porta-aviões");
}
```

#### `private void posicionarArma(Scanner scanner, int quantidade, char simbolo, int tamanho, String nomeArma)`
Esse método auxilia na colocação das armas de acordo com a quantidade, o símbolo que representa a arma (ex. `'s'` para submarino), o tamanho da arma (quantos quadrados ela ocupa), e a orientação.

```java
private void posicionarArma(Scanner scanner, int quantidade, char simbolo, int tamanho, String nomeArma) {
    System.out.printf("Posicione %d %s(s) (%d quadrado(s) cada, representado por '%c')
",
                      quantidade, nomeArma, tamanho, simbolo);
    // Loop para posicionar as armas no tabuleiro
}
```

#### `public boolean atirar(Scanner scanner, Jogador adversario)`
Este método gerencia a ação de atirar no tabuleiro do adversário. Após o ataque, ele verifica se o tiro foi um acerto ou erro e marca no tabuleiro do adversário.

```java
public boolean atirar(Scanner scanner, Jogador adversario) {
    for (int i = 0; i < 2; i++) {
        // Logica de entrada de posição para o ataque
        if (adversario.verificarSeAcertou(linha, coluna)) {
            System.out.println("Acertou uma arma!");
            marcarNoTabuleiro(jogoDoAdversario, linha, coluna, 'X'); // Marca acerto
        } else {
            System.out.println("Água!");
            marcarNoTabuleiro(jogoDoAdversario, linha, coluna, 'O'); // Marca erro
        }
    }
    return true;
}
```

#### `private boolean verificarSeAcertou(int linha, int coluna)`
Este método verifica se a posição informada corresponde a um acerto em uma arma do adversário, marcando-a no tabuleiro.

```java
private boolean verificarSeAcertou(int linha, int coluna) {
    if (meuJogo[linha][coluna] != '~' && meuJogo[linha][coluna] != 'X') {
        meuJogo[linha][coluna] = 'X'; // Marca como destruído
        return true;
    }
    return false;
}
```

#### `private boolean verificarSeTodasArmasAfundaram()`
Este método verifica se todas as armas do jogador foram afundadas, ou seja, se todas as posições de armas foram atingidas.

```java
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
```

---

## **Classe: `BatalhaNaval`**

A classe `BatalhaNaval` controla a interação geral do jogo, incluindo o menu, regras, criação de jogadores e o fluxo de turnos.

### Atributos:

- **`scanner`**: O objeto `Scanner` utilizado para capturar as entradas dos jogadores.

### Métodos:

#### `public void iniciar()`
Este método gerencia o menu principal do jogo. Ele permite ao jogador escolher entre iniciar o jogo, exibir as regras ou sair.

```java
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
```

#### `private void exibirMenu()`
Este método exibe o menu principal com as opções de iniciar o jogo, ver as regras ou sair.

```java
private void exibirMenu() {
    System.out.println("\n=== Batalha Naval - Menu Principal ===");
    System.out.println("1. Iniciar Jogo");
    System.out.println("2. Exibir Regras");
    System.out.println("3. Sair");
    System.out.print("Escolha uma opção: ");
}
```

#### `private void iniciarJogo()`
Este método inicia o jogo, criando dois jogadores e posicionando suas armas. Após isso, a partida começa e os jogadores alternam turnos.

```java
private void iniciarJogo() {
    System.out.println("\nBem-vindo ao Jogo Batalha Naval - Versão Light!");
    Jogador jogador1 = criarJogador("Jogador 1");
    Jogador jogador2 = criarJogador("Jogador 2");

    jogador1.posicionarArmas(scanner);
    jogador2.posicionarArmas(scanner);

    iniciarPartida(jogador1, jogador2);
}
```

#### `private void exibirRegras()`
Este método exibe as regras do jogo.

```java
private void exibirRegras() {
    System.out.println("\n=== Regras do Jogo ===");
    System.out.println("1. Cada jogador posiciona suas armas no tabuleiro.");
    System.out.println("2. Os jogadores alternam turnos para tentar acertar as armas do adversário.");
    System.out.println("3. Ganha o jogador que afundar todas as armas do oponente primeiro.");
    System.out.println("4. Use coordenadas (linha e coluna) para posicionar ou atacar.");
    System.out.println("5. Boa sorte e divirta-se!");
}
```

---

## Conclusão

Essa documentação descreve a estrutura e funcionalidade de cada parte do código do jogo **Batalha Naval**. Com ela, qualquer desenvolvedor ou usuário pode compreender como o jogo funciona e como as interações entre os jogadores acontecem. A lógica de jogo é clara e permite personalização e expansão, como a inclusão de novas armas ou funcionalidades.
