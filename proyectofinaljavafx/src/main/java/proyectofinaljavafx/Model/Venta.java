package proyectofinaljavafx.Model;

public class Venta extends AccionesVehiculo{
        
    //----------------------------------------------------------------------------------------------//
    //----------------------------------------------------------------------------------------------//
    
    //Atributos de la clase

    private int cuotaIntereses;
    
    //----------------------------------------------------------------------------------------------//
    //----------------------------------------------------------------------------------------------//
    
    //Métodos de la clase

    /**
     * Método constructor de la clase
     * @param cuotaIntereses
     * @param vehiculo
     * @param empleado
     * @param cliente
     * @param codigoTramite 
     */
    public Venta(int cuotaIntereses, Vehiculo vehiculo, Empleado empleado, Cliente cliente, String codigoTramite) {
        super(vehiculo, empleado, cliente, codigoTramite);
        this.cuotaIntereses = cuotaIntereses;
    }

    /**
     * Método que muestra el valor de cada dato
     * @return 
     */
    @Override
    public String toString() {
        return super.toString() + ", pagos en "+cuotaIntereses+" cuota(s) con interes. ";
    }
    
    //----------------------------------------------------------------------------------------------//
    //----------------------------------------------------------------------------------------------//
    
    //Métodos Getters and Setters
    
    public int getCuotaIntereses() {
        return cuotaIntereses;
    }

    public void setCuotaIntereses(int cuotaIntereses) {
        this.cuotaIntereses = cuotaIntereses;
    }
    
    
    //----------------------------------------------------------------------------------------------//
    //----------------------------------------------------------------------------------------------//

}
