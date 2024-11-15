package co.edu.uniquindio.poo.model;

import java.util.LinkedList;

public class Empleado extends Persona{
    
    //----------------------------------------------------------------------------------------------//
    //----------------------------------------------------------------------------------------------//

    //Atributos de la clase
    
    private int numVehiculosVendidos,numVehiculosAlquilados,numVehiculosComprados,numClientesCreados;
    private LinkedList<Cliente> clientesCreados;  
    private LinkedList<AccionesVehiculo> historialTransaccionesVehiculos;
    
    //----------------------------------------------------------------------------------------------//
    //----------------------------------------------------------------------------------------------//
    
    //Metodos de la clase
    
    /**
     * Método constructor de la clase
     * @param nombre
     * @param apellidos
     * @param cedula
     * @param contraseña
     * @param edad 
     */
    public Empleado(String nombre, String apellidos, String cedula,String contraseña,int edad){
        super(nombre, apellidos, cedula, cedula,contraseña, edad);
        
        numVehiculosAlquilados=0;
        numVehiculosComprados=0;
        numVehiculosVendidos=0;
        numClientesCreados=0;
        
        clientesCreados=new LinkedList<>();
    }

    /**
     * Método que modifica el estado de el tramite almacenado en los datos para referenciar que se devolvió el alquiler
     * @param codigoTramite 
     */
    public void devolverAlquiler(String codigoTramite){
        for (AccionesVehiculo tramite : historialTransaccionesVehiculos) {
            if(tramite.getCodigoTramite().equals(codigoTramite)){
                
                tramite.setEstadoTramite(EstadoTramite.ALQUILER_REGRESADO);
                
            }
        }
    }
    
    
    /**
     * Método que añade un vehículo vendido en las listas del empleado y aumenta su contador.
     * @param vehiculoVendido 
     */
    public void VehiculoVendido(Venta vehiculoVendido){
        historialTransaccionesVehiculos.add(vehiculoVendido);
        numVehiculosVendidos++;
        
    }
    
    /**
     * Método que añade un vehículo alquilado en las listas del empleado y aumenta su contador.
     * @param vehiculoAlquilado 
     */
    public void VehiculoAlquilado(Alquiler vehiculoAlquilado){
        vehiculoAlquilado.getVehiculo().setDisponibilidad(Disponibilidad.VEHICULO_ALQUILADO);
        historialTransaccionesVehiculos.add(vehiculoAlquilado);        
        numVehiculosAlquilados++;
        
    }
    
    /**
     * Método que añade un vehículo comprado en las listas del empleado y aumenta su contador.
     * @param vehiculoComprado 
     */
    public void VehiculoComprado(Compra vehiculoComprado){
        historialTransaccionesVehiculos.add(vehiculoComprado);        
        numVehiculosComprados++;     
    }
    
    /**
     * Método que añade los clientes en la lista del empleado y aumenta su contador
     * @param cliente 
     */
    public void añadirClientes(Cliente cliente){
        clientesCreados.add(cliente);
        numClientesCreados++;
    }

    /**
     * Método que muestra el valor de cada dato
     * @return 
     */
    @Override
    public String toString() {
        return super.toString();
    }
    
    //----------------------------------------------------------------------------------------------//
    //----------------------------------------------------------------------------------------------//
   
    //Métodos Getters and Setters

    public LinkedList<Cliente> getClientesCreados() {
        return clientesCreados;
    }

    public void setClientesCreados(LinkedList<Cliente> clientesCreados) {
        this.clientesCreados = clientesCreados;
    }

    public int getNumVehiculosVendidos() {
        return numVehiculosVendidos;
    }

    public void setNumVehiculosVendidos(int numVehiculosVendidos) {
        this.numVehiculosVendidos = numVehiculosVendidos;
    }

    public int getNumVehiculosAlquilados() {
        return numVehiculosAlquilados;
    }

    public void setNumVehiculosAlquilados(int numVehiculosAlquilados) {
        this.numVehiculosAlquilados = numVehiculosAlquilados;
    }

    public int getNumVehiculosComprados() {
        return numVehiculosComprados;
    }

    public void setNumVehiculosComprados(int numVehiculosComprados) {
        this.numVehiculosComprados = numVehiculosComprados;
    }

    public int getNumClientesCreados() {
        return numClientesCreados;
    }

    public void setNumClientesCreados(int numClientesCreados) {
        this.numClientesCreados = numClientesCreados;
    }

    public LinkedList<AccionesVehiculo> getHistorialTransaccionesVehiculos() {
        return historialTransaccionesVehiculos;
    }

    public void setHistorialTransaccionesVehiculos(LinkedList<AccionesVehiculo> historialTransaccionesVehiculos) {
        this.historialTransaccionesVehiculos = historialTransaccionesVehiculos;
    }

    //----------------------------------------------------------------------------------------------//
    //----------------------------------------------------------------------------------------------//
    
}
