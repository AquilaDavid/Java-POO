# Documentação do Jogo Batalha Naval

Este documento descreve detalhadamente o funcionamento e a estrutura do código do jogo **Batalha Naval - Versão Light**, implementado em Java.

## Estrutura do Código

O projeto é composto pelas seguintes classes principais:

1. **`Jogador`**: Representa os jogadores do jogo.
2. **`BatalhaNaval`**: Gerencia o fluxo principal do jogo, incluindo a interação com os jogadores e a execução das rodadas.

---

## Classe `Jogador`

### Responsabilidade

A classe `Jogador` encapsula as informações e a lógica relacionadas a cada jogador, como a configuração de armas, gerenciamento de tabuleiros, e execução de ataques.

### Atributos

- **`nome`** (*String*): Nome do jogador.
- **`meuJogo`** (*char[][]*): Tabuleiro que representa as armas do próprio jogador.
- **`jogoDoAdversario`** (*char[][]*): Tabuleiro que registra os tiros disparados contra o adversário.

### Principais Métodos

#### `public Jogador(String nome)`

Construtor que inicializa o jogador com um nome e cria os tabuleiros (`meuJogo` e `jogoDoAdversario`) com dimensão 8x8, preenchidos com o caractere `'-'`.

#### `public void posicionarArmas(Scanner scanner)`

Permite ao jogador posicionar suas armas no tabuleiro:

- Submarinos (3)
- Cruzadores (2)
- Porta-avião (1)

As armas são posicionadas horizontalmente no tabuleiro com validação para evitar sobreposições ou posicionamentos inválidos.

#### `public void exibirMeuTabuleiro()`

Exibe o tabuleiro `meuJogo`, mostrando as armas posicionadas.

#### `public void exibirJogoDoAdversario()`

Exibe o tabuleiro `jogoDoAdversario`, destacando tiros acertados (`'X'`) e água (`'~'`).

#### `public boolean realizarTurno(Scanner scanner, Jogador adversario)`

Permite ao jogador realizar um turno de ataque:

1. Solicita duas coordenadas de ataque ao jogador.
2. Verifica se as coordenadas acertaram ou erraram armas do adversário.
3. Atualiza o tabuleiro do adversário e o próprio `jogoDoAdversario`.
4. Retorna `false` caso todas as armas do adversário tenham sido destruídas, indicando o fim do jogo.

---

## Classe `BatalhaNaval`

### Responsabilidade

A classe `BatalhaNaval` gerencia o fluxo geral do jogo, incluindo:

- Exibição do menu principal.
- Inicialização de jogadores e tabuleiros.
- Controle das rodadas até a determinação de um vencedor.

### Atributos

- **`scanner`** (*Scanner*): Gerencia a entrada de dados do usuário.

### Principais Métodos

#### `public void iniciar()`

Controla o loop principal do jogo. Exibe o menu e executa a opção escolhida:

- **1. Iniciar Jogo**: Começa uma nova partida.
- **2. Exibir Regras**: Exibe as regras do jogo.
- **3. Sair**: Encerra o programa.

#### `private void exibirMenu()`

Exibe as opções do menu principal.

#### `private void iniciarJogo()`

1. Solicita os nomes dos jogadores e cria suas instâncias.
2. Permite que cada jogador posicione suas armas.
3. Inicia a partida utilizando o método `iniciarPartida`.

#### `private void exibirRegras()`

Exibe as regras básicas do jogo para os jogadores.

#### `private void iniciarPartida(Jogador jogador1, Jogador jogador2)`

Gerencia as rodadas do jogo:

- Alterna turnos entre os jogadores.
- Exibe os tabuleiros atualizados após cada turno.
- Encerra o jogo assim que todas as armas de um jogador forem destruídas.

#### `private boolean realizarTurno(Jogador atacante, Jogador defensor)`

1. Permite que o jogador atacante dispare contra o defensor.
2. Atualiza os tabuleiros e exibe o estado atual.
3. Retorna `false` se o defensor perder todas as suas armas, indicando o fim do jogo.

---

## Fluxo do Jogo

1. **Inicialização**:

   - Os jogadores informam seus nomes.
   - Cada jogador posiciona suas armas em seu tabuleiro.

2. **Rodadas**:

   - Os jogadores alternam turnos.
   - Cada turno permite dois ataques.
   - Os ataques são marcados como `X` (acerto) ou `~` (erro) no tabuleiro `jogoDoAdversario`.

3. **Encerramento**:

   - O jogo termina quando todas as armas de um jogador forem destruídas.
   - O vencedor é anunciado.

---

## Exemplo de Execução

### Menu Principal

```text
=== Batalha Naval - Menu Principal ===
1. Iniciar Jogo
2. Exibir Regras
3. Sair
Escolha uma opção: 1
```

### Posicionamento de Armas

```text
Jogador 1, posicione suas armas:
Posicione o Submarino (tamanho 1):
Linha: 2
Coluna: 3
...
```

### Rodadas

```text
Jogador 1, é sua vez de atacar!
Seu tabuleiro:
- - - - - - - -
- - - - - - - -
...
Tabuleiro do adversário:
~ - - - - - - -
X - - - - - - -
...
Informe a linha para o tiro: 3
Informe a coluna para o tiro: 4
Resultado: Água!
...
```

### Fim do Jogo

```text
Fim do jogo! O vencedor é Jogador 1!
```

---

## Considerações Finais

O código é modular e utiliza encapsulamento para garantir organização e clareza. O uso de arrays bidimensionais para os tabuleiros facilita a visualização e manipulação do estado do jogo. Sugestões de melhoria incluem:

- Implementar salvação e carregamento de jogos.
- Melhorar a interface do usuário para torná-la mais intuitiva.
- Adicionar dificuldade configurável (como tamanho do tabuleiro e número de armas).

