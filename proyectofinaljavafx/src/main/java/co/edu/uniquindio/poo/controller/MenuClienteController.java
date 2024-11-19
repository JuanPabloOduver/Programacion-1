package co.edu.uniquindio.poo.controller;

import java.util.Collection;

import co.edu.uniquindio.poo.model.Concesionario;
import co.edu.uniquindio.poo.model.Vehiculo;

public class MenuClienteController {

    Concesionario concesionario;

    public MenuClienteController(Concesionario concesionario) {
        this.concesionario = concesionario;
    }

    public Collection<Vehiculo> obtenerListaVehiculos() {
        return concesionario.getVehiculos();
    }
    
}
