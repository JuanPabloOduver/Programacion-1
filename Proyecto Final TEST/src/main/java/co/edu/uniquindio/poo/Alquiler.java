package co.edu.uniquindio.poo;

public class Alquiler extends AccionesVehiculo {

    // Atributo adicional
    private String codigoDevolucion;

    //----------------------------------------------------------------------------------------------//
    //----------------------------------------------------------------------------------------------//
    
    // Métodos de la clase

    /**
     * Método constructor de la clase
     * @param codigoDevolucion
     * @param vehiculo
     * @param empleado
     * @param cliente
     * @param codigoTramite
     */
    public Alquiler(String codigoDevolucion, Vehiculo vehiculo, Empleado empleado, Cliente cliente, String codigoTramite) {
        super(vehiculo, empleado, cliente);
        this.codigoDevolucion = codigoDevolucion; // Inicializar el atributo
    }

    /**
     * Método para obtener el código de devolución
     * @return código de devolución
     */
    public String getCodigoDevolucion() {
        return codigoDevolucion;
    }

    /**
     * Método que muestra el valor de cada dato
     * @return
     */
    @Override
    public String toString() {
        return super.toString() + ", Código de devolución: " + codigoDevolucion;
    }
    
    //----------------------------------------------------------------------------------------------//
    //----------------------------------------------------------------------------------------------//

}
