package folhaDePagamento;

import java.util.Scanner;

public class Funcionario {
    // Atributos
    private int codigo, idade;
    private String cpf, endereco, nome, telefone, letra;
    private float salario;

    // Construtor
    public Funcionario(int codigo, int idade, String cpf, String endereco, String letra, String telefone, String nome, float salario){
        this.codigo = codigo;
        this.nome = nome;
        this.idade = idade;
        this.cpf = cpf;
        this.endereco = endereco;
        this.telefone = telefone;
        this.salario = salario;
        this.letra = letra;
    }

    // Métodos Get e Set com correções
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        System.out.printf("Codigo atual: %d%n", this.codigo);
        this.codigo = codigo;
        System.out.printf("Codigo Atualizado: %d%n", this.codigo);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        System.out.printf("Nome atual: %s%n", this.nome);
        this.nome = nome;
        System.out.printf("Nome Atualizado: %s%n", this.nome);
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        System.out.printf("Idade atual: %d%n", this.idade);
        this.idade = idade;
        System.out.printf("Idade Atualizado: %d%n", this.idade);
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        System.out.printf("CPF atual: %s%n", this.cpf);
        this.cpf = cpf;
        System.out.printf("CPF Atualizado: %s%n", this.cpf);
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        System.out.printf("Endereço atual: %s%n", this.endereco);
        this.endereco = endereco;
        System.out.printf("Endereço Atualizado: %s%n", this.endereco);
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        System.out.printf("Telefone atual: %s%n", this.telefone);
        this.telefone = telefone;
        System.out.printf("Telefone Atualizado: %s%n", this.telefone);
    }

    public float getSalario() {
        return salario;
    }

    public void setSalario(float salario) {
        System.out.printf("Salario atual: %.2f%n", this.salario);
        this.salario = salario;  // Atualiza o salário bruto com o valor passado
        System.out.printf("Salario Bruto Atualizado: %.2f%n", this.salario);
    }

    // Método para calcular o salário líquido com desconto de 11%
    public float calculaSalarioLiquido() {
        return salario * 0.89f;
    }

    public void todasInformacoes() {
        System.out.printf("Codigo: %d \nNome: %s \nCPF: %s \nEndereço: %s \nTelefone: %s \nIdade: %d \nSalario Bruto: %.2f \nSalario Líquido: %.2f\n",
                          codigo, nome, cpf, endereco, telefone, idade, salario, calculaSalarioLiquido());
    }

    public String cont(String letra) {
        return letra.equals("S") ? "S" : "N";
    }

    public void menu() {
        Scanner scanner = new Scanner(System.in);
        int numero;

        do {
            System.out.print("Informe o que desejas fazer: \n");
            System.out.println("0- Todas as Informações \n1- Mostrar Codigo \n2- Atualizar codigo \n3- Mostrar Nome \n" +
                               "4- Atualizar Nome \n5- Mostrar CPF \n6- Atualizar CPF \n7- Mostrar Endereço \n" +
                               "8- Atualizar Endereço \n9- Mostrar Telefone \n10- Atualizar Telefone \n11- Idade \n" +
                               "12- Atualizar Idade \n13- Mostrar Salario Bruto \n14- Atualizar Salario Bruto \n15- Mostrar Salario Líquido");
            numero = scanner.nextInt();

            switch (numero) {
                case 0 -> todasInformacoes();
                case 1 -> System.out.println("Código: " + getCodigo());
                case 2 -> {
                    System.out.print("Digite o novo código: ");
                    setCodigo(scanner.nextInt());
                }
                case 3 -> System.out.println("Nome: " + getNome());
                case 4 -> {
                    System.out.print("Digite o novo nome: ");
                    setNome(scanner.next());
                }
                case 5 -> System.out.println("CPF: " + getCpf());
                case 6 -> {
                    System.out.print("Digite o novo CPF: ");
                    setCpf(scanner.next());
                }
                case 7 -> System.out.println("Endereço: " + getEndereco());
                case 8 -> {
                    System.out.print("Digite o novo Endereço: ");
                    setEndereco(scanner.next());
                }
                case 9 -> System.out.println("Telefone: " + getTelefone());
                case 10 -> {
                    System.out.print("Digite o novo Telefone: ");
                    setTelefone(scanner.next());
                }
                case 11 -> System.out.println("Idade: " + getIdade());
                case 12 -> {
                    System.out.print("Digite a nova Idade: ");
                    setIdade(scanner.nextInt());
                }
                case 13 -> System.out.println("Salario Bruto: " + getSalario());
                case 14 -> {
                    System.out.print("Digite o novo Salario Bruto: ");
                    setSalario(scanner.nextFloat());
                }
                case 15 -> System.out.println("Salario Líquido: " + calculaSalarioLiquido());
                default -> System.out.println("Opção inválida. Tente novamente.");
            }

            System.out.print("Deseja continuar? (S/N): ");
            letra = scanner.next();

        } while (cont(letra).equals("S"));

        System.out.println("Aqui estão suas informações finais:");
        todasInformacoes();
        scanner.close();
    }
}
