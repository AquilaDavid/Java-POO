package helicoptero;

public class Helicoptero {
    // Atributos
    private boolean ligarHelicoptero = false;
    private float altura = 0;
    private int capacidade = 0;

    // Construtor
    public Helicoptero(boolean ligarHelicoptero, float altura, int capacidade) {
        this.altura = altura;
        this.capacidade = capacidade;
        this.ligarHelicoptero = ligarHelicoptero;
    }

    // Métodos
    public void estadoHelicoptero() {
        if (ligarHelicoptero) {
            System.out.println("O helicóptero está ligado e pronto para decolar.");
        } else {
            System.out.println("O helicóptero está desligado.");
        }

        if (altura > 0) {
            voo();
        } else {
            noChao();
        }
    }

    public void ligarHelicoptero() {
        if (!ligarHelicoptero) {
            ligarHelicoptero = true; // Altera o estado para ligado
            System.out.println("O helicóptero foi ligado.");
        } else {
            System.out.println("O helicóptero já está ligado!");
        }
    }

    public void desligarHelicoptero() {
        if (ligarHelicoptero) {
            ligarHelicoptero = false; // Altera o estado para desligado
            System.out.println("O helicóptero foi desligado.");
        } else {
            System.out.println("O helicóptero já está desligado!");
        }
    }

    public void voo() {
        System.out.printf("O helicóptero está em voo e está a %.2f metros de altura.%n", altura);
    }

    public void aterrissar() {
        if (altura > 0) {
            altura = 0;
            System.out.println("O helicóptero aterrissou em segurança.");
        } else {
            System.out.println("O helicóptero já está no chão.");
        }
    }

    public void noChao() {
        System.out.println("O helicóptero está em terra firme.");
    }

    public void adicionarPessoa() {
        capacidade++;
        System.out.println("Uma pessoa foi adicionada. Capacidade atual: " + capacidade);
        if (capacidade > 5) {
            System.out.println("Não é possivel adicionar mais pesoas! Atigimos o numero maximo!");
        }
    }

    public void removerPessoa() {
        if (capacidade > 0) {
            capacidade--;
            System.out.println("Uma pessoa foi removida. Capacidade atual: " + capacidade);
        } else {
            System.out.println("Não há pessoas para remover.");
        }
    }

    public void subir(float alturaDesejada) {
        if (ligarHelicoptero) {
            if (alturaDesejada > 0) {
                altura += alturaDesejada;
                System.out.printf("O helicóptero subiu %.2f metros. Altura atual: %.2f metros.%n", alturaDesejada, altura);
            } else {
                System.out.println("Altura inválida para subir.");
            }
        } else {
            System.out.println("O helicóptero precisa estar ligado para subir.");
        }
    }

    public void descer(float alturaDesejada) {
        if (ligarHelicoptero) {
            if (alturaDesejada > 0 && altura - alturaDesejada >= 0) {
                altura -= alturaDesejada;
                System.out.printf("O helicóptero desceu %.2f metros. Altura atual: %.2f metros.%n", alturaDesejada, altura);
            } else {
                System.out.println("Altura inválida para descer.");
            }
        } else {
            System.out.println("O helicóptero precisa estar ligado para descer.");
        }
    }
}
