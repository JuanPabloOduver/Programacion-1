package co.edu.uniquindio.poo;

public class AccionesVehiculo {

    //----------------------------------------------------------------------------------------------//
    //----------------------------------------------------------------------------------------------//
    
    //Atributos de la clase
        
    private Vehiculo vehiculo;
    private Empleado empleado;
    private Cliente cliente;
    private String codigoTramite;
    private EstadoTramite estadoTramite;
    
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
    public AccionesVehiculo(Vehiculo vehiculo, Empleado empleado, Cliente cliente) {
        this.vehiculo = vehiculo;
        this.empleado = empleado;
        this.cliente = cliente;
        estadoTramite=EstadoTramite.SELECCIONE_ESTADO;
        this.codigoTramite=GeneradorCodigos.generarHexaCodeUnico(10);
    }
    
    /**
     * Método que muestra el valor de cada dato
     * @return 
     */
    @Override
    public String toString() {
        return getClass().getSimpleName() + "= Vehículo = " + vehiculo + ", empleado = " + empleado + ", cliente = " + cliente  +", estado del tramite = " +estadoTramite+", còdigo del tramite: " + codigoTramite;
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

    public String getCodigoTramite(){
        return codigoTramite;
    }

    public void setEstadoTramite(EstadoTramite estadoTramite) {
        this.estadoTramite = estadoTramite;
    }

    public EstadoTramite getEstadoTramite(){
        return estadoTramite;
    }

    //----------------------------------------------------------------------------------------------//
    //----------------------------------------------------------------------------------------------//
    
}
