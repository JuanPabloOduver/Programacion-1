package co.edu.uniquindio.poo.controller;

import java.util.Collection;

import co.edu.uniquindio.poo.model.Concesionario;
import co.edu.uniquindio.poo.model.EstadoTramite;
import co.edu.uniquindio.poo.model.Tramite;

public class CrudTransaccionesController {
    Concesionario concesionario;

    public CrudTransaccionesController(Concesionario concesionario) {
        this.concesionario = concesionario;
    }

    public Collection<Tramite> obtenerListaTramites() {
        return concesionario.getTramites();
    }

    public void registrarTransaccion(Tramite tramite, EstadoTramite estadoTramite) {
        concesionario.registrarTransaccion(tramite, estadoTramite);
     }

    
}
