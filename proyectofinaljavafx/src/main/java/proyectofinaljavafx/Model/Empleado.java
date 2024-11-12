package proyectofinaljavafx.Model;

import java.util.LinkedList;

public class Empleado extends Persona{
    
    //----------------------------------------------------------------------------------------------//
    //----------------------------------------------------------------------------------------------//

    //Atributos de la clase
    
    private int numVehiculosVendidos,numVehiculosAlquilados,numVehiculosComprados,numClientesCreados;
    private double salario;
    private LinkedList<Cliente> clientesCreados;
    private LinkedList<Alquiler> vehiculosAlquilados;
    private LinkedList<Compra> vehiculosComprados;
    private LinkedList<Venta> vehiculosVendidos;    
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
        
        salario=0;
        numVehiculosAlquilados=0;
        numVehiculosComprados=0;
        numVehiculosVendidos=0;
        
        vehiculosVendidos=new LinkedList<>();
        vehiculosAlquilados=new LinkedList<>();
        vehiculosComprados=new LinkedList<>();
        clientesCreados=new LinkedList<>();
    }

    public void VehiculoVendido(Venta vehiculoVendido){
        vehiculosVendidos.add(vehiculoVendido);
        historialTransaccionesVehiculos.add(vehiculoVendido);
        this.salario+= vehiculoVendido.getCostoAccion();
        numVehiculosVendidos++;
    }
    
    public void VehiculoAlquilado(Alquiler vehiculoAlquilado){
        vehiculosAlquilados.add(vehiculoAlquilado);
        historialTransaccionesVehiculos.add(vehiculoAlquilado);        
        this.salario+= vehiculoAlquilado.getCostoAccion();
        numVehiculosAlquilados++;
    }
    
    public void VehiculoComprado(Compra vehiculoComprado){
        vehiculosComprados.add(vehiculoComprado);
        historialTransaccionesVehiculos.add(vehiculoComprado);        
        this.salario+= vehiculoComprado.getCostoAccion();
        numVehiculosComprados++;
    }
    
    public void CrearClientes(Cliente cliente){
        clientesCreados.add(cliente);
        numClientesCreados++;
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

    public LinkedList<Cliente> getClientesCreados() {
        return clientesCreados;
    }

    public void setClientesCreados(LinkedList<Cliente> clientesCreados) {
        this.clientesCreados = clientesCreados;
    }

    public LinkedList<Alquiler> getVehiculosAlquilados() {
        return vehiculosAlquilados;
    }

    public void setVehiculosAlquilados(LinkedList<Alquiler> vehiculosAlquilados) {
        this.vehiculosAlquilados = vehiculosAlquilados;
    }

    public LinkedList<Compra> getVehiculosComprados() {
        return vehiculosComprados;
    }

    public void setVehiculosComprados(LinkedList<Compra> vehiculosComprados) {
        this.vehiculosComprados = vehiculosComprados;
    }

    public LinkedList<Venta> getVehiculosVendidos() {
        return vehiculosVendidos;
    }

    public void setVehiculosVendidos(LinkedList<Venta> vehiculosVendidos) {
        this.vehiculosVendidos = vehiculosVendidos;
    }

    public LinkedList<AccionesVehiculo> getHistorialAccionesVehiculos() {
        return historialAccionesVehiculos;
    }

    public void setHistorialAccionesVehiculos(LinkedList<AccionesVehiculo> historialAccionesVehiculos) {
        this.historialAccionesVehiculos = historialAccionesVehiculos;
    }
    
    //----------------------------------------------------------------------------------------------//
    //----------------------------------------------------------------------------------------------//
    
}
