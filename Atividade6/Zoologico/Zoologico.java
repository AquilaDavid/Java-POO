package Zoologico;

import java.util.ArrayList;
import java.util.List;

public class Zoologico {
    private List<Animal> animais;

    public Zoologico() {
        this.animais = new ArrayList<>();
    }

    public void adicionar(Animal animal) {
        animais.add(animal);
    }

    public void animarBicharada() {
        for (Animal animal : animais) {
            animal.andar();
            animal.emitirSom();
        }
    }
    
    public void alimentarTodos() {
        for (Animal animal : animais) {
            animal.comer();
        }
    }
    
    public void fazerDormirTodos() {
        for (Animal animal : animais) {
            animal.dormir();
        }
    }
    
    public void mostrarAnimais() {
        System.out.println("Zoológico tem " + animais.size() + " animais cadastrados.");
    }
}