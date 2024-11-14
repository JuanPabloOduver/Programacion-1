package proyectofinaljavafx.Model;

import java.util.LinkedList;

public class Administrador extends Persona{
    
    //----------------------------------------------------------------------------------------------//
    //----------------------------------------------------------------------------------------------//
    
    //Atributos de la clase
    
    private double salario;
    private LinkedList<Empleado> empleadosContratados;
    private LinkedList<AccionesVehiculo> tramites ;

    //----------------------------------------------------------------------------------------------//
    //----------------------------------------------------------------------------------------------//
    
    //Métodos de la clase

    /**
     * Método constructor de la clase
     * @param salario
     * @param empleadosContratados
     * @param tramites
     * @param nombre
     * @param apellidos
     * @param email
     * @param cedula
     * @param contraseña
     * @param edad 
     */
    public Administrador( String nombre, String apellidos, String email, String cedula, String contraseña, int edad) {
        super(nombre, apellidos, email, cedula, contraseña, edad);
        this.salario = 0;
        this.empleadosContratados = empleadosContratados;
        tramites= new LinkedList<>();
        empleadosContratados= new LinkedList<>();
    }
    
    /**
     * Método que modifica el estado de el tramite almacenado para referenciar que se devolvió el alquiler
     * @param codigoTramite 
     */
    public void devolverAlquiler(String codigoTramite){
        for (AccionesVehiculo tramite : tramites) {
            if(tramite.getCodigoTramite().equals(codigoTramite)){
                
                tramite.setEstadoTramite(EstadoTramite.ALQUILER_REGRESADO);
                
            }
        }
    }
    
    /**
     * Mètodo que añade a la lista de tramites del administrador la list
     * @param accionesEmpleado
     */
    public void añadirTramites(AccionesVehiculo accionesEmpleado){
        tramites.add(accionesEmpleado);
    }
    

    public void contratarEmpleado(Empleado empleado){
        empleadosContratados.add(empleado);
    }
    

    /**
     * Método que muestra el valor de cada dato
     * @return 
     */
    @Override
    public String toString() {
        return super.toString() + ", salario = " + salario;
    }
    
    //----------------------------------------------------------------------------------------------//
    //----------------------------------------------------------------------------------------------//

    //Métodos Getters and Setters
    
    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }
    
    public LinkedList<Empleado> getEmpleadosContratados() {
        return empleadosContratados;
    }

    public void setEmpleadosContratados(LinkedList<Empleado> empleadosContratados) {
        this.empleadosContratados = empleadosContratados;
    }

    public LinkedList<AccionesVehiculo> getTramites() {
        return tramites;
    }

    public void setTramites(LinkedList<AccionesVehiculo> tramites) {
        this.tramites = tramites;
    }
    
    //----------------------------------------------------------------------------------------------//
    //----------------------------------------------------------------------------------------------//
    
}
