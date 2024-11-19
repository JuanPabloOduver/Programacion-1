package co.edu.uniquindio.poo.model;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

public class Empleado extends Persona {

    //----------------------------------------------------------------------------------------------//
    //----------------------------------------------------------------------------------------------//
    //Atributos de la clase
    private int numVehiculosVendidos, numVehiculosAlquilados, numVehiculosComprados, numClientesCreados;
    private LinkedList<Cliente> clientesCreados;
    private Map<String, Tramite> historialTransaccionesVehiculos = new HashMap<>();
    private Set<Tramite> alquileresActivos = new HashSet<>();

    //----------------------------------------------------------------------------------------------//
    //----------------------------------------------------------------------------------------------//
    //Metodos de la clase
    /**
     * Método constructor de la clase
     *
     * @param nombre
     * @param apellidos
     * @param cedula
     * @param contraseña
     * @param edad
     */
    public Empleado(String nombre, String apellidos, String cedula, String contraseña, int edad) {
        super(nombre, apellidos, cedula, cedula, contraseña, edad);

        numVehiculosAlquilados = 0;
        numVehiculosComprados = 0;
        numVehiculosVendidos = 0;
        numClientesCreados = 0;
        
        Cliente cliente= new Cliente("hol", "nom", "ape", "qw", "12", "manzana2", 12);
        Vehiculo vehiculo=new Vehiculo("h", "20", Estado.USADO, "11", 4,2 , Transmision.AUTOMATICA, Combustible.DIESEL);
        Tramite tramite=new Tramite(vehiculo, this, cliente);

        clientesCreados = new LinkedList<>();
        historialTransaccionesVehiculos.put("g", tramite);
    }

    /**
     * Método que modifica el estado de el tramite almacenado en los datos para
     * referenciar que se devolvió el alquiler
     *
     * @param codigoTramite
     */
    public void devolverAlquiler(String codigoTramite) {
        Tramite tramite = historialTransaccionesVehiculos.get(codigoTramite);
        if (tramite == null) {
            System.out.println("No se encontró el trámite con el código: " + codigoTramite);
        }

        tramite.setEstadoTramite(EstadoTramite.ALQUILER_REGRESADO);
        alquileresActivos.remove(codigoTramite); // Elimina el trámite del conjunto de alquileres activos
    }
    
    /**
     * Método que registra la transacción y aumenta el contador dependiendo de
     * que tipo de transacción se realiza.
     *
     * @param transaccion
     */
    public void registrarTransaccion(Tramite transaccion) {
        if (historialTransaccionesVehiculos.containsKey(transaccion.getCodigoTramite())) {
            throw new IllegalArgumentException("Ya existe una transacción con ese código");
        }

        historialTransaccionesVehiculos.put(transaccion.getCodigoTramite(), transaccion);

        switch (transaccion.getEstadoTramite()) {
            case VEHICULO_VENDIDO:
                numVehiculosVendidos++;
                break;
            case VEHICULO_ALQUILADO:
                alquileresActivos.add(transaccion);
                numVehiculosAlquilados++;
                break;
            case VEHICULO_COMPRADO:
                numVehiculosComprados++;
                break;
            default:
                throw new IllegalArgumentException("Estado de trámite inválido");
        }
    }

    /**
     * Método que añade los clientes en la lista del empleado y aumenta su
     * contador
     *
     * @param cliente
     */
    public void añadirClientes(Cliente cliente) {
        clientesCreados.add(cliente);
        numClientesCreados++;
    }


    
    /**
     * Método que muestra el valor de cada dato
     *
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

    public Map<String, Tramite> getHistorialTransaccionesVehiculos() {
        return historialTransaccionesVehiculos;
    }

    public void setHistorialTransaccionesVehiculos(Map<String, Tramite> historialTransaccionesVehiculos) {
        this.historialTransaccionesVehiculos = historialTransaccionesVehiculos;
    }

    public Set<Tramite> getAlquileresActivos() {
        return alquileresActivos;
    }

    public void setAlquileresActivos(Set<Tramite> alquileresActivos) {
        this.alquileresActivos = alquileresActivos;
    }

    //----------------------------------------------------------------------------------------------//
    //----------------------------------------------------------------------------------------------//

}
