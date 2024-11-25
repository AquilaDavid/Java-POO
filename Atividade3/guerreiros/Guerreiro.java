package guerreiros;

import java.util.Random;

public class Guerreiro {
    private int codigo;
    private String nome;
    private int energia;

    // Construtor
    public Guerreiro(int codigo, String nome) {
        this.codigo = codigo;
        this.nome = nome;
        this.energia = 5; // Inicializa com energia máxima
    }

    // Método de acesso à energia
    public int getEnergia() {
        return energia;
    }

    // Incremento de energia (até o máximo de 5)
    public void incremento() {
        if (energia < 5) {
            energia++;
        } else {
            System.out.println(nome + " já está com energia máxima!");
        }
    }

    // Decremento de energia
    public void decremento() {
        if (energia > 0) {
            energia--;
            if (energia == 0) {
                System.out.println(nome + " está sem energia!");
            }
        }
    }

    // Alimentar-se
    public void alimentar() {
        incremento();
        System.out.println(nome + " se alimentou e recuperou energia. Energia atual: " + energia);
    }

    // Método atacar (retorna 0 ou 1 aleatoriamente)
    private int atacar() {
        Random random = new Random();
        return random.nextInt(2); // 0 ou 1
    }

    // Método lutar (com laço)
    public void lutar(Guerreiro oponente) {
        System.out.println("\nInício da luta entre " + nome + " e " + oponente.nome);

        while (this.energia > 0 && oponente.energia > 0) {
            if (this.atacar() == 1) {
                oponente.decremento();
                System.out.println(this.nome + " atacou com sucesso! Energia de " + oponente.nome + ": " + oponente.getEnergia());
            }

            if (oponente.atacar() == 1) {
                this.decremento();
                System.out.println(oponente.nome + " atacou com sucesso! Energia de " + this.nome + ": " + this.getEnergia());
            }
        }

        if (this.energia == 0) {
            System.out.println(oponente.nome + " venceu a luta!");
        } else {
            System.out.println(this.nome + " venceu a luta!");
        }
    }

    // Método lutar (com recursividade)
    public void lutarRecursivo(Guerreiro oponente) {
        if (this.energia == 0) {
            System.out.println(oponente.nome + " venceu a luta!");
            return;
        }

        if (oponente.energia == 0) {
            System.out.println(this.nome + " venceu a luta!");
            return;
        }

        if (this.atacar() == 1) {
            oponente.decremento();
            System.out.println(this.nome + " atacou com sucesso! Energia de " + oponente.nome + ": " + oponente.getEnergia());
        }

        if (oponente.atacar() == 1) {
            this.decremento();
            System.out.println(oponente.nome + " atacou com sucesso! Energia de " + this.nome + ": " + this.getEnergia());
        }

        lutarRecursivo(oponente); // Chamando novamente
    }

    // toString para exibir o estado do guerreiro
    @Override
    public String toString() {
        return "Guerreiro{" +
                "Código=" + codigo +
                ", Nome='" + nome + '\'' +
                ", Energia=" + energia +
                '}';
    }
}
