public class Livro {
    private String titulo;
    private String autor;
    private int ano;
    private int edicao;
    private String editora;
    private String ISBN;
    private Exemplar exemplar;

    public Livro(String titulo, String autor, int ano, int edicao, String editora, String ISBN) {
        this.titulo = titulo;
        this.autor = autor;
        this.ano = ano;
        this.edicao = edicao;
        this.editora = editora;
        this.ISBN = ISBN;
    }

    public void setExemplar(Exemplar exemplar) {
        this.exemplar = exemplar;
    }

    public Exemplar getExemplar() {
        return exemplar;
    }

    public String getTitulo() { return titulo; }
    public String getAutor() { return autor; }
    public int getAno() { return ano; }
    public int getEdicao() { return edicao; }
    public String getEditora() { return editora; }
    public String getISBN() { return ISBN; }
}
