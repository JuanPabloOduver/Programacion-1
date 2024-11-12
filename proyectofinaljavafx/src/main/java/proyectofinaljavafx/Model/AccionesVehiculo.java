package proyectofinaljavafx.Model;

public class AccionesVehiculo {

    //----------------------------------------------------------------------------------------------//
    //----------------------------------------------------------------------------------------------//
    
    //Atributos de la clase
    
    private Vehiculo vehiculo;
    private Empleado empleado;
    private Cliente cliente;
    private double CostoAccion;
    
    //----------------------------------------------------------------------------------------------//
    //----------------------------------------------------------------------------------------------//
    
    //Métodos de la clase

    /**
     * Método constructor de la clase
     * @param vehiculo
     * @param empleado
     * @param cliente
     * @param CostoAccion 
     */
    public AccionesVehiculo(Vehiculo vehiculo, Empleado empleado, Cliente cliente, double CostoAccion) {
        this.vehiculo = vehiculo;
        this.empleado = empleado;
        this.cliente = cliente;
        this.CostoAccion = CostoAccion;
    }
    
    /**
     * Método que muestra el valor de cada dato
     * @return 
     */
    @Override
    public String toString() {
        return getClass() + "= Vehículo = " + vehiculo + ", empleado = " + empleado + ", cliente = " + cliente + ", Costo de la accion = " + CostoAccion ;
    }
    
    //----------------------------------------------------------------------------------------------//
    //----------------------------------------------------------------------------------------------//
    
    //Métodos Getters and Setters

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public double getCostoAccion() {
        return CostoAccion;
    }

    public void setCostoAccion(double CostoAccion) {
        this.CostoAccion = CostoAccion;
    }

    //----------------------------------------------------------------------------------------------//
    //----------------------------------------------------------------------------------------------//
    
}
