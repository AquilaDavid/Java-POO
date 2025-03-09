public class Principall {
    public static void main(String[] args) {
        CadastroMilitar cadastro = new CadastroMilitar();

        // Criando militares de diferentes divisões
        MilitarAeronautica militar1 = new MilitarAeronautica(123, 200, 3, "Soldado");
        MilitarExercito militar2 = new MilitarExercito(true, true, 4321, "Cabo");
        MilitarMarinha militar3 = new MilitarMarinha(789, "Soldado", false);

        // Adicionando os militares ao cadastro
        cadastro.adicionarMilitar(militar1);
        cadastro.adicionarMilitar(militar2);
        cadastro.adicionarMilitar(militar3);

        // Exibindo militares que podem progredir
        System.out.println("Militares que podem progredir:");
        for (Militar militar : cadastro.getMilitaresQuePodemProgredir()) {
            System.out.println("Matrícula: " + militar.getMatricula() + ", Patente: " + militar.getPatente());
        }

        // Realizando a progressão
        cadastro.realizarProgresso();

        // Exibindo dados após a progressão
        System.out.println("\nDados após a progressão:");
        for (Militar militar : cadastro.getMilitaresQuePodemProgredir()) {
            System.out.println("Matrícula: " + militar.getMatricula() + ", Patente: " + militar.getPatente());
        }

        // Polimorfismo:
        // O polimorfismo ocorre no método `podeProgredir`, pois ele é implementado de forma diferente em cada subclasse concreta (MilitarAeronautica, MilitarExercito, MilitarMarinha).
        // Ou seja, embora todos os objetos sejam do tipo Militar, o comportamento do método podeProgredir varia dependendo do tipo concreto de cada militar.
    }
}
