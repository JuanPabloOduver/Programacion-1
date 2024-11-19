package co.edu.uniquindio.poo.controller;

import java.util.LinkedList;

import co.edu.uniquindio.poo.model.Administrador;
import co.edu.uniquindio.poo.model.Cliente;
import co.edu.uniquindio.poo.model.Concesionario;
import co.edu.uniquindio.poo.model.Empleado;

public class IniciarSesionController {
    

    //------------------------------------------------------------------//

    //Atributos de la clase

    private Concesionario concesionario;

    //------------------------------------------------------------------//

    //Métodos de la clase
    
    //Métodos Getters and Setters

    public void setConcesionario(Concesionario concesionario) {
        this.concesionario = concesionario;
    }
    
    public LinkedList<Empleado> obtenerListaEmpleados(){
            return concesionario.getEmpleados();
    }

    public LinkedList<Cliente> obtenerListaClientes(){
        return concesionario.getClientes();
    }

    public  Administrador obtenerAdministrador(){
        return concesionario.getAdministrador();
    }

    //------------------------------------------------------------------//


    
}
