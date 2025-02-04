import java.util.ArrayList;

// Classe Cliente
class Cliente {
    String nome;
    double valorCompra;

    Cliente(String nome, double valorCompra) {
        this.nome = nome;
        this.valorCompra = valorCompra;
    }

    double calcularValorFinal() {
        return valorCompra;
    }

    void imprimirDados() {
        System.out.println("Nome: " + nome);
        System.out.println("Valor da Compra: R$ " + calcularValorFinal());
    }
}

// Classe VIP que herda de Cliente
class VIP extends Cliente {
    String numeroCartao;

    VIP(String nome, double valorCompra, String numeroCartao) {
        super(nome, valorCompra);
        this.numeroCartao = numeroCartao;
    }

    double calcularValorFinal() {
        return super.calcularValorFinal() * 0.9; // Desconto de 10%
    }

    void imprimirDados() {
        super.imprimirDados();
        System.out.println("Numero do Cartao: " + numeroCartao);
    }
}

// Classe OuroVIP que herda de VIP
class OuroVIP extends VIP {
    String endereco;

    OuroVIP(String nome, double valorCompra, String numeroCartao, String endereco) {
        super(nome, valorCompra, numeroCartao);
        this.endereco = endereco;
    }

    double calcularValorFinal() {
        return super.calcularValorFinal() * 0.85; // Desconto de 15% sobre o valor com desconto VIP
    }

    void imprimirDados() {
        super.imprimirDados();
        System.out.println("Endereco: " + endereco);
    }
}

// Classe Mercadinho
class Mercadinho {
    ArrayList<Cliente> clientes;

    Mercadinho() {
        clientes = new ArrayList<>();
    }

    void adicionarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    double calcularTotal() {
        double total = 0;
        for (Cliente cliente : clientes) {
            total += cliente.calcularValorFinal();
        }
        return total;
    }

    void imprimirClientes() {
        for (Cliente cliente : clientes) {
            cliente.imprimirDados();
            System.out.println("---------------------------");
        }
    }
}

// Classe Principal para testar
public class Principal {
    public static void main(String[] args) {
        Mercadinho mercadinho = new Mercadinho();

        Cliente cliente1 = new Cliente("Joao", 100.0);
        VIP cliente2 = new VIP("Maria", 200.0, "12345");
        OuroVIP cliente3 = new OuroVIP("Carlos", 300.0, "67890", "Rua das Flores, 123");

        mercadinho.adicionarCliente(cliente1);
        mercadinho.adicionarCliente(cliente2);
        mercadinho.adicionarCliente(cliente3);

        System.out.println("Clientes cadastrados:");
        mercadinho.imprimirClientes();

        System.out.println("Valor total das compras: R$ " + mercadinho.calcularTotal());
    }
}
