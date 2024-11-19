package co.edu.uniquindio.poo.controller;

import java.util.Collection;

import co.edu.uniquindio.poo.model.Concesionario;
import co.edu.uniquindio.poo.model.Vehiculo;

public class CrudVehiculosController {

    Concesionario concesionario;

    public CrudVehiculosController(Concesionario concesionario) {
        this.concesionario = concesionario;
    }

    public Collection<Vehiculo> obtenerListaVehiculos() {
        return concesionario.getVehiculos();
    }

    public void crearVehiculo(Vehiculo vehiculo) {
        concesionario.registrarVehiculo(vehiculo);
     }

    public void eliminarCliente(String placa) {
       concesionario.eliminarVehiculo(placa);
    }



}

