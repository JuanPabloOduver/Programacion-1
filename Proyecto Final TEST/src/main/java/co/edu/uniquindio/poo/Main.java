package co.edu.uniquindio.poo;

public class Main {

    public static void main(String[] args) {

        Concesionario concesionario= new Concesionario("Mi Carro Uq", "quindio");

        Vehiculo miMotocicleta = new Motocicleta("Rojo", "ABC123", "Honda", Estado.NUEVO, "CBR500",180.0, 0.5,Transmision.MANUAL, Combustible.GASOLINA);
        concesionario.registrarVehiculo(miMotocicleta);

        Empleado empleado= new Empleado("Daniel", "Murcia", "1117509157","Manzanota", 17);
        concesionario.registrarEmpleado(empleado);
        
        Cliente cliente=new Cliente("f", "e", "k", "@", "j", "hole", 10);
        concesionario.registrarCliente(cliente);
        
        Tramite compra= new Tramite(miMotocicleta, empleado, cliente);
        concesionario.registrarVehiculoComprado(compra);
        
        
        
        Tramite alquiler= new Tramite(miMotocicleta, empleado, cliente);
        alquiler.getVehiculo().setDisponibilidad(Disponibilidad.VEHICULO_NO_DISPONIBLE);
        concesionario.registrarVehiculoAlquilado(alquiler);
        
        concesionario.bloquearEmpleado(empleado.getCedula());
        concesionario.eliminarCliente(cliente.getCedula());
        concesionario.buscarPlacaVehiculo(miMotocicleta.getPlaca());
        
//        
//        System.out.println(concesionario.verificarEmpleado(empleado.getCedula()));
//        System.out.println(concesionario.verificarVehiculo(miMotocicleta.getPlaca()));
//        System.out.println(concesionario.verificarCliente(cliente.getCedula()));
//        
        
        //errores buscarAlquiler
        
    }
}
