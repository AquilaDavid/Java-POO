import java.util.Date;

public class Principal {
    public static void main(String[] args) {
        Usuario usuario = new Usuario("João Silva", 123456789, "987654321", "202201");

        Livro livro = new Livro("Programação Java", "Ana Oliveira", 2021, 1, "Editora Tech", "978-1234567890");

        Exemplar exemplar = new Exemplar(1, true, false);
        livro.setExemplar(exemplar);

        Date dataEmprestimo = new Date();
        Date dataPrevistaDevolucao = new Date(dataEmprestimo.getTime() + (7L * 24 * 60 * 60 * 1000));

        Emprestimo emprestimo = new Emprestimo(dataEmprestimo, dataPrevistaDevolucao, exemplar, usuario);
        usuario.setEmprestimo(emprestimo);
        exemplar.setEmprestada(true);

        System.out.println("Empréstimo realizado:");
        System.out.println("Usuário: " + usuario.getNome());
        System.out.println("Livro: " + livro.getTitulo());
        System.out.println("Exemplar Código: " + exemplar.getCodigo());
        System.out.println("Data de Empréstimo: " + emprestimo.getDataDeEmprestimo());
        System.out.println("Data Prevista para Devolução: " + emprestimo.getDataPrevistaDeDevolucao());
        System.out.println("Situação do Empréstimo: " + (emprestimo.getSituacao() == 1 ? "Ativo" : "Concluído"));

        Date dataDeEntregaReal = new Date();
        emprestimo.devolverLivro(dataDeEntregaReal);

        System.out.println("\nLivro devolvido:");
        System.out.println("Data de Entrega Real: " + emprestimo.getDataDeEntregaReal());
        System.out.println("Situação do Empréstimo: " + (emprestimo.getSituacao() == 1 ? "Ativo" : "Concluído"));
        System.out.println("Exemplar está emprestado? " + exemplar.isEmprestada());
    }
}
