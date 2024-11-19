package co.edu.uniquindio.poo.controller;

import java.util.Collection;

import co.edu.uniquindio.poo.model.Concesionario;
import co.edu.uniquindio.poo.model.Empleado;

public class CrudEmpleadoController {

    Concesionario concesionario;

    public CrudEmpleadoController(Concesionario concesionario) {
        this.concesionario = concesionario;
    }

    public void crearEmpleado(Empleado empleado) {
        concesionario.registrarEmpleado(empleado);
    }

    public Collection<Empleado> obtenerListaEmpleados() {
        return concesionario.getEmpleados();
    }

    public void eliminarCliente(String cedula) {
       concesionario.eliminarEmpleado(cedula);
    }
    
}
