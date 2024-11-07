package folhaDePagamento;

public class Funcionario {
    // Atributos
    private int codigo, idade;
    private String cpf, endereco, nome, telefone;
    private float salario;

    //Construtor
    public Funcionario(int codigo, int idade, String cpf, String endereco, String telefone, String nome, float salario){
        this.codigo = codigo;
        this.nome = nome;
        this.idade = idade;
        this.cpf = cpf;
        this.endereco = endereco;
        this.telefone = telefone;
        this.salario = salario;
    }

    // Metodos
    public int getCodigo(){
        return codigo;
    }

    public void setCodigo(int codigo){
        this.codigo = codigo;
    }

    public String getNome(){
        return nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public int getIdade(){
        return idade;
    }

    public void setIdade(int idade){
        this.idade = idade;
    }

    public String getCpf(){
        return cpf;
    }

    public void setCpf( String cpf){
        this.cpf = cpf;
    }

    public String getEndereco(){
        return endereco;
    }

    public void setEndereco(String endereco){
        this.endereco = endereco;
    }

    public String getTelefone(){
        return telefone;
    }

    public void setTelefone(String telefone){
        this.telefone = telefone;
    }

    public Float getSalario(){
        return salario;
    }

    public void setSalario(Float salario){
        this.salario = salario;
    }

    public void imprimir(){
        System.out.print("Todas as suas informações");
        System.out.printf("Codigo: %d \n Nome: $s \n CPF: $s \n Endereço: $s \n Telefone: $s \n Idade: $d \n Salario: $f", codigo,nome,cpf, endereco, telefone, idade, salario);
    }

}
