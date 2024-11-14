package co.edu.uniquindio.poo;

public class Alquiler extends AccionesVehiculo{
    
    //----------------------------------------------------------------------------------------------//
    //----------------------------------------------------------------------------------------------//
    
    //Atributos de la clase
    
    private String codigoDevolucion;
    
    //----------------------------------------------------------------------------------------------//
    //----------------------------------------------------------------------------------------------//
    
    //Métodos de la clase

    /**
     * Método constructor de la clase
     * @param codigoDevolucion
     * @param vehiculo
     * @param empleado
     * @param cliente
     * @param codigoTramite 
     */
    public Alquiler(String codigoDevolucion, Vehiculo vehiculo, Empleado empleado, Cliente cliente, String codigoTramite) {
        super(vehiculo, empleado, cliente, codigoTramite);
        this.codigoDevolucion = codigoDevolucion;
    }
    
    /**
     * Método que muestra el valor de cada dato
     * @return 
     */
        @Override
    public String toString() {
        return super.toString() + ", código para devolver el alquiler = " + codigoDevolucion  ;
    }
    
    //----------------------------------------------------------------------------------------------//
    //----------------------------------------------------------------------------------------------//
    
    //Métodos Getters and Setters

    public String getCodigoDevolucion() {
        return codigoDevolucion;
    }

    public void setCodigoDevolucion(String codigoDevolucion) {
        this.codigoDevolucion = codigoDevolucion;
    }

    //----------------------------------------------------------------------------------------------//
    //----------------------------------------------------------------------------------------------//
    
}
