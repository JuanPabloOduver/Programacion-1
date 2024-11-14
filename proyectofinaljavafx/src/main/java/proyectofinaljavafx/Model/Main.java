package proyectofinaljavafx.Model;

public class Main {

    public static void main(String[] args) {
        // Crear un objeto de tipo Motocicleta
        Vehiculo miMotocicleta = new Motocicleta("Rojo", "ABC123", "Honda", Estado.NUEVO, "CBR500", 
                                                   180.0, 0.5, 
                                                  Transmision.MANUAL, Combustible.GASOLINA);
        System.out.println(miMotocicleta); 
    }
}
