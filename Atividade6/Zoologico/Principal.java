package Zoologico;

/*
    Modificações realizadas:
    1. Substituição do array fixo de animais por uma lista dinâmica (ArrayList<Animal>) na classe Zoologico.
    2. Adição dos métodos comer() e dormir() na interface Animal e implementação nas classes concretas.
    3. Novos métodos na classe Zoologico: alimentarTodos() e fazerDormirTodos().
    4. Separação do código em arquivos individuais para melhor organização.
*/


public class Principal {
    public static void main(String[] args) {
        Zoologico zoo = new Zoologico();

        zoo.adicionar(new Cachorro());
        zoo.adicionar(new Galinha());
        zoo.adicionar(new Gato());
        zoo.adicionar(new Papagaio());

        zoo.mostrarAnimais();
        zoo.animarBicharada();
        zoo.alimentarTodos();
        zoo.fazerDormirTodos();
    }
}