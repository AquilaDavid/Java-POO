package helicoptero;

public class Helicoptero {
    // Atributos
    private boolean ligado;
    private float altitude;
    private final int capacidadeMaxima;
    private int pessoasPresentes;

    // Construtor
    public Helicoptero(int capacidadeMaxima) {
        this.ligado = false;
        this.altitude = 0;
        this.capacidadeMaxima = capacidadeMaxima;
        this.pessoasPresentes = 0;
    }

    // Métodos get e set
    public boolean isLigado() {
        return ligado;
    }

    public float getAltitude() {
        return altitude;
    }

    public int getCapacidadeMaxima() {
        return capacidadeMaxima;
    }

    public int getPessoasPresentes() {
        return pessoasPresentes;
    }

    // Método para adicionar pessoa
    public void entra() {
        if (pessoasPresentes < capacidadeMaxima) {
            pessoasPresentes++;
            System.out.println("Uma pessoa entrou no helicóptero. Total de pessoas: " + pessoasPresentes);
        } else {
            System.out.println("O helicóptero já está cheio!");
        }
    }

    // Método para remover pessoa
    public void sai() {
        if (pessoasPresentes > 0) {
            pessoasPresentes--;
            System.out.println("Uma pessoa saiu do helicóptero. Total de pessoas: " + pessoasPresentes);
        } else {
            System.out.println("Não há ninguém no helicóptero para sair.");
        }
    }

    // Método para ligar o helicóptero
    public void ligar() {
        if (!ligado) {
            ligado = true;
            System.out.println("O helicóptero foi ligado.");
        } else {
            System.out.println("O helicóptero já está ligado.");
        }
    }

    // Método para desligar o helicóptero
    public void desligar() {
        if (ligado && altitude == 0) {
            ligado = false;
            System.out.println("O helicóptero foi desligado.");
        } else if (!ligado) {
            System.out.println("O helicóptero já está desligado.");
        } else {
            System.out.println("Não é possível desligar o helicóptero enquanto ele estiver no ar.");
        }
    }

    // Método para decolar
    public void decolar(float novaAltitude) {
        if (ligado && altitude == 0) {
            altitude = novaAltitude;
            System.out.printf("O helicóptero decolou e atingiu %.2f metros de altitude.%n", altitude);
        } else if (!ligado) {
            System.out.println("O helicóptero precisa estar ligado para decolar.");
        } else {
            System.out.println("O helicóptero já está no ar.");
        }
    }

    // Método para aterrissar
    public void aterrissar() {
        if (ligado && altitude > 0) {
            altitude = 0;
            System.out.println("O helicóptero aterrissou com segurança.");
        } else if (altitude == 0) {
            System.out.println("O helicóptero já está no chão.");
        } else {
            System.out.println("O helicóptero precisa estar ligado para aterrissar.");
        }
    }

    // Método toString
    @Override
    public String toString() {
        return String.format(
            "Helicóptero [Ligado: %s, Altitude: %.2f metros, Capacidade: %d/%d]",
            ligado ? "Sim" : "Não", altitude, pessoasPresentes, capacidadeMaxima
        );
    }
}
