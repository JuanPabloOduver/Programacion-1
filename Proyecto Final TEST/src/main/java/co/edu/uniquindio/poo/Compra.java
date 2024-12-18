package co.edu.uniquindio.poo;

public class Compra extends AccionesVehiculo{
    
    //----------------------------------------------------------------------------------------------//
    //----------------------------------------------------------------------------------------------//
    
    //Atributos de la clase

    private String codigoCompra;
    
    //----------------------------------------------------------------------------------------------//
    //----------------------------------------------------------------------------------------------//
    
    //Métodos de la clase

    /**
     * Método constructor de la clase
     * @param codigoCompra
     * @param vehiculo
     * @param empleado
     * @param cliente
     * @param codigoTramite 
     */
    public Compra(String codigoCompra, Vehiculo vehiculo, Empleado empleado, Cliente cliente, String codigoTramite) {
        super(vehiculo, empleado, cliente);
        this.codigoCompra = codigoCompra;
    }

    /**
     * Método que muestra el valor de cada dato
     * @return 
     */
    @Override
    public String toString() {
        return super.toString() + ", codigo de la compra = " + codigoCompra ;
    }
    
    //----------------------------------------------------------------------------------------------//
    //----------------------------------------------------------------------------------------------//
    
    //Métodos Getters and Setters

    public String getCodigoCompra() {
        return codigoCompra;
    }

    public void setCodigoCompra(String codigoCompra) {
        this.codigoCompra = codigoCompra;
    }
    
    //----------------------------------------------------------------------------------------------//
    //----------------------------------------------------------------------------------------------//
    
}