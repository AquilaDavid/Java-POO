import java.util.Date;

public class Emprestimo {
    private Date dataDeEmprestimo;
    private Date dataPrevistaDeDevolucao;
    private Date dataDeEntregaReal;
    private int situacao;
    private Exemplar exemplar;
    private Usuario usuario;

    public Emprestimo(Date dataDeEmprestimo, Date dataPrevistaDeDevolucao, Exemplar exemplar, Usuario usuario) {
        this.dataDeEmprestimo = dataDeEmprestimo;
        this.dataPrevistaDeDevolucao = dataPrevistaDeDevolucao;
        this.exemplar = exemplar;
        this.usuario = usuario;
        this.situacao = 1;
    }

    public void devolverLivro(Date dataDeEntregaReal) {
        this.dataDeEntregaReal = dataDeEntregaReal;
        this.situacao = 0;
        exemplar.setEmprestada(false);
    }

    public Date getDataDeEmprestimo() { return dataDeEmprestimo; }
    public Date getDataPrevistaDeDevolucao() { return dataPrevistaDeDevolucao; }
    public Date getDataDeEntregaReal() { return dataDeEntregaReal; }
    public int getSituacao() { return situacao; }
    public Exemplar getExemplar() { return exemplar; }
    public Usuario getUsuario() { return usuario; }
}
