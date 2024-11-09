public class Exemplar {
    private int codigo;
    private boolean ativa;
    private boolean emprestada;

    public Exemplar(int codigo, boolean ativa, boolean emprestada) {
        this.codigo = codigo;
        this.ativa = ativa;
        this.emprestada = emprestada;
    }

    public int getCodigo() { return codigo; }
    public boolean isAtiva() { return ativa; }
    public boolean isEmprestada() { return emprestada; }
    public void setEmprestada(boolean emprestada) { this.emprestada = emprestada; }
}
