package co.edu.uniquindio.poo.controller;

import java.util.Collection;

import co.edu.uniquindio.poo.model.Concesionario;
import co.edu.uniquindio.poo.model.EstadoTramite;
import co.edu.uniquindio.poo.model.Tramite;
import co.edu.uniquindio.poo.model.Vehiculo;

public class MarketplaceController {
    Concesionario concesionario;

    public MarketplaceController(Concesionario concesionario) {
        this.concesionario = concesionario;
    }

    public Collection<Vehiculo> obtenerListaVehiculos() {
        return concesionario.getVehiculos();
    }

    public void alquilarVehiculo(Tramite tramite, EstadoTramite estadoTramite) {
        concesionario.registrarTransaccion(tramite, estadoTramite);
     }

    public void comprarVehiculo(Tramite tramite, EstadoTramite estadoTramite) {
       concesionario.registrarTransaccion(tramite, estadoTramite);
    }
    
}
