package proyectofinaljavafx.Model;

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
     * @param CostoAccion 
     */
    public Compra(String codigoCompra, Vehiculo vehiculo, Empleado empleado, Cliente cliente, double CostoAccion) {   
    super(vehiculo, empleado, cliente, CostoAccion);
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