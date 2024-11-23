package helicoptero;

public class Principal {
    public static void main(String[] args) {
        Helicoptero heli = new Helicoptero(false, 0, 4);

    heli.estadoHelicoptero();  
    heli.ligarHelicoptero();   
    heli.estadoHelicoptero();  
    heli.desligarHelicoptero();
    heli.estadoHelicoptero();  
    }
}
