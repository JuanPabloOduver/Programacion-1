package co.edu.uniquindio.poo.model;

public class Main {

    public static void main(String[] args) {

        Concesionario concesionario= new Concesionario("Hola", "sally");

        
        // Crear un objeto de tipo Motocicleta
        Vehiculo miMotocicleta = new Motocicleta("Rojo", "ABC123", "Honda", Estado.NUEVO, "CBR500",180.0, 0.5,Transmision.MANUAL, Combustible.GASOLINA);
        concesionario.registrarVehiculo(miMotocicleta);
        
        System.out.println(concesionario.getVehiculos());
        
//        String codigo = consecionario.(4) ;

//        System.out.println(codigo);
    }
}
