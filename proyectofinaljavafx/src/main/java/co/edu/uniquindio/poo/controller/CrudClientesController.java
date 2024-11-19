package co.edu.uniquindio.poo.controller;

import java.util.Collection;

import co.edu.uniquindio.poo.model.Cliente;
import co.edu.uniquindio.poo.model.Concesionario;

public class CrudClientesController {

    Concesionario concesionario;

    public CrudClientesController(Concesionario concesionario) {
        this.concesionario = concesionario;
    }

    public void crearCliente(Cliente cliente) {
        concesionario.registrarCliente(cliente);
    }

    public Collection<Cliente> obtenerListaClientes() {
        return concesionario.getClientes();
    }

    public void eliminarCliente(String cedula) {
       concesionario.eliminarCliente(cedula);
    }

    /** 
    public boolean actualizarCliente(String cedula, Cliente cliente) {
       return concesionario.actualizarCliente(cedula, cliente);
    }
     */
}
    

