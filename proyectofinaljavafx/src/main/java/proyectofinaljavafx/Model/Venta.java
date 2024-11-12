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
     * @param CostoAccion 
     */
    public Venta(int cuotaIntereses, Vehiculo vehiculo, Empleado empleado, Cliente cliente, double CostoAccion) {
        super(vehiculo, empleado, cliente, CostoAccion);
        
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
    
    public int getcuotaIntereses() {
        return cuotaIntereses;
    }

    public void setcuotaIntereses(int cuotaIntereses) {
        this.cuotaIntereses = cuotaIntereses;
    }
    
    //----------------------------------------------------------------------------------------------//
    //----------------------------------------------------------------------------------------------//

}
