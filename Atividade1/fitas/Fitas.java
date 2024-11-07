package fitas;

public class Fitas {
    // Atributos
    private String titulo;
    private final double precoAluguel = 7;

    // Construtor
    public Fitas(String titulo){
        this.titulo = titulo;
    }

    // Metodos 
    public double getPrecoAluguel(){
        return precoAluguel;
    }

    public String getTitulo(){
        return titulo;
    }

    public double getValorAluguel(int numeroDeDiasAlugada){
        return precoAluguel * numeroDeDiasAlugada;
    }

    public String toFilme() {
        return String.format("Filme: %s", titulo);
    }

    public void imprimir(int numeroDeDiasAlugada){
        System.out.printf( "%s \n", toFilme());
        System.out.printf("Volor por Dia: %.2f \n", getPrecoAluguel());
        System.out.printf("Total de dias alugados: %d \n", numeroDeDiasAlugada);
        System.out.printf("Valor total do aluguel: %.2f\n", getValorAluguel(numeroDeDiasAlugada));
    }
}
