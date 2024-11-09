public class Usuario {
    private String nome;
    private int CPF;
    private String telefone;
    private String matricula;
    private Emprestimo emprestimo;

    public Usuario(String nome, int CPF, String telefone, String matricula) {
        this.nome = nome;
        this.CPF = CPF;
        this.telefone = telefone;
        this.matricula = matricula;
    }

    public void setEmprestimo(Emprestimo emprestimo) {
        this.emprestimo = emprestimo;
    }

    public Emprestimo getEmprestimo() {
        return emprestimo;
    }

    public String getNome() { return nome; }
    public int getCPF() { return CPF; }
    public String getTelefone() { return telefone; }
    public String getMatricula() { return matricula; }
}
