package co.edu.uniquindio.poo.controller;

import java.util.Collection;

import co.edu.uniquindio.poo.model.Concesionario;
import co.edu.uniquindio.poo.model.Tramite;

public class ListaTramitesController {

    Concesionario concesionario;

    public ListaTramitesController(Concesionario concesionario) {
        this.concesionario = concesionario;
    }

    public Collection<Tramite> obtenerListaTramites() {
        return concesionario.getTramites();
    }
    
}
