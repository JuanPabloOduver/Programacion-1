package co.edu.uniquindio.poo.model;

import java.util.LinkedList;
import java.util.Scanner;

public class Concesionario {

    //----------------------------------------------------------------------------------------------//
    //----------------------------------------------------------------------------------------------//

    //Atributos de la clase

    private String nombre, direccion;
    private LinkedList<Tramite> alquilerActivo;
    private LinkedList<Empleado> empleadosContratados;
    private LinkedList<Cliente> clientes;
    private LinkedList<Vehiculo> vehiculos;
    private Administrador administrador;
    private LinkedList<Tramite> tramites ;

    //----------------------------------------------------------------------------------------------//
    //----------------------------------------------------------------------------------------------//

    //Métodos de la clase

    /**
     * Método constructor de la clase
     *
     * @param nombre
     * @param direccion
     */
    public Concesionario(String nombre, String direccion) {
        this.nombre = nombre;
        this.direccion = direccion;

        administrador = new Administrador("Johan Sebastian", "Echeverry Ibarra", "johans.echeverrii@uqvirtual.edu.co", "1097722436" ,"manzana1", 18);
        empleadosContratados = new LinkedList<>();
        clientes = new LinkedList<>();
        vehiculos = new LinkedList<>();
        tramites = new LinkedList<>();

    }

    //----------------------------------------------------------------------------------------------//

    /**
     * Método que busca un alquiler en el listado de la empresa con una codigo de tramite
     * @param codigoTramite
     * @return mensaje
     */
    public Tramite buscarAlquiler(String codigoTramite){
            Tramite tramite= null;
            for (Tramite tramite1 : alquilerActivo) {
                if(tramite1.getCodigoTramite().equals(codigoTramite)){
                    tramite=tramite1;
                }
            }
        return tramite;
    }

    /**
     * Método que verifica si un empleado está registrado en la empresa
     *
     * @param cedula
     * @return c
     */
    public boolean verificarEmpleado(String cedula) {
        boolean c = false;

        for (Empleado empleado : empleadosContratados) {
            if (empleado.getCedula().equals(cedula)) {
                c = true;
            }
        }
        return c;
    }

    /**
     * Método que verifica si un vehículo está registrado en la empresa
     *
     * @param placa
     * @return c
     */
    public boolean verificarVehiculo(String placa) {
        boolean c = false;

        for (Vehiculo vehiculo : vehiculos) {
            if (vehiculo.getPlaca().equals(placa)) {
                c = true;
            }
        }
        return c;
    }

    /**
     * Método que verifica si un administrador está registrado en la empresa
     *
     * @param cedula
     * @return c
     */
    public boolean verificarAdministrador(String cedula) {
        boolean c = false;
        
        if (administrador.getCedula().equals(cedula)) {
            c = true;
        }
        return c;
    }

    /**
     * Método que verifica si un cliente está registrado en la empresa
     *
     * @param email
     * @return c
     */
    public boolean verificarCliente(String email) {
        boolean c = false;

        for (Cliente cliente : clientes) {
            if (cliente.getEmail().equals(email)) {
                c = true;
            }
        }
        return c;
    }

    /**
     * Método que verifica si un tràmite está registrado en la lista de tramites de la empresa
     *
     * @param codigoTramite
     * @return c
     */
    public boolean verificarTramite(String codigoTramite) {
        boolean c = false;

        for (Tramite accion : tramites) {
            if (accion.getCodigoTramite().equals(codigoTramite)) {
                c = true;
            }
        }
        return c;
    }

    //----------------------------------------------------------------------------------------------//

    //Métodos de registro/Bloqueo

    /**
     * Método que genera un código de recuperacion de contraseña
     *
     * @param
     */
    public String generarRecuperaciónContraseña(){
        return GeneradorCodigos.generarHexaCode(6);
    }

    /**
     * Método que registra un empleado en los datos de la empresa
     *
     * @param empleado
     */
    public void registrarEmpleado(Empleado empleado) {
        if (!verificarEmpleado(empleado.getCedula())) {
            empleadosContratados.add(empleado);
        }
    }

    /**
     * Método que registra un vehiculo en los datos de la empresa
     *
     * @param vehiculo
     */
    public void registrarVehiculo(Vehiculo vehiculo) {
        if (!verificarVehiculo(vehiculo.getPlaca())) {
            vehiculos.add(vehiculo);
        }
    }
    
    /**
     * Método que registra un empleado en la lista de bloqueos de la empresa
     *
     * @param cedula
     */
    public void bloquearEmpleado(String cedula) {
        if (verificarEmpleado(cedula)) {
            for (Empleado empleado : empleadosContratados) {
                if (empleado.getCedula().equals(cedula)) {
                    empleadosContratados.remove(empleado);
                }
            }
        }
    }
    
    /**
     * Método que devuelve el vehiculo alquilado modificando el estado en las listas de admin, empleado, y de la empresa
     * @param codigoTramite
     */
    public void devolverAlquiler(String codigoTramite){
        // Buscar el alquiler en la base de datos o en una estructura de datos
        Tramite alquiler = buscarAlquiler(codigoTramite);

        if (alquiler == null) {
            System.out.print("No se encontró el alquiler con el código: " + codigoTramite);
        }

        // Actualizar el estado del alquiler en la base de datos
        alquiler.setEstadoTramite(EstadoTramite.ALQUILER_REGRESADO);
        // ... ejecutar la consulta SQL para actualizar la base de datos

        // Notificar al empleado (si es necesario)
        Empleado empleado = alquiler.getEmpleado();
        if (empleado != null) {
            empleado.devolverAlquiler(codigoTramite);
        }
    }

    /**
     * Método que registra una transaccion en los datos de la empresa en caso de que no haya un vehiculo con placa similar ni un tramite con còdigo similar
     *
     * @param vehiculoComprado
     */
    public boolean registrarTransaccion(Tramite tramite, EstadoTramite tipo) {
    if (tramite == null) {
        System.err.println("El trámite no puede ser nulo");
        return false;
    }

    Vehiculo vehiculo = tramite.getVehiculo();
    if (vehiculo == null || vehiculo.getDisponibilidad() != Disponibilidad.VEHICULO_DISPONIBLE) {
        System.err.println("El vehículo no está disponible");
        return false;
    }

    if (verificarTramite(tramite.getCodigoTramite())) {
        System.err.println("Ya existe un trámite con ese código");
        return false;
    }

    switch (tipo) {
        case VEHICULO_COMPRADO:
            eliminarVehiculo(vehiculo.getPlaca());
            tramite.setEstadoTramite(EstadoTramite.VEHICULO_VENDIDO);
            break;
        case VEHICULO_ALQUILADO:
            vehiculo.setDisponibilidad(Disponibilidad.VEHICULO_ALQUILADO);
            tramite.setEstadoTramite(EstadoTramite.VEHICULO_ALQUILADO);
            break;
        case VEHICULO_VENDIDO:
            // Lógica similar a la compra
            break;
        default:
            System.err.println("Tipo de transacción inválido");
            return false;
    }

    tramite.getEmpleado().registrarTransaccion(tramite);
    registrarTransaccion(tramite, tipo); // Registrar la transacción en el historial general
    System.out.println("La transacción se ha registrado correctamente.");
    return true;
}

    /**
     * Método que registra un cliente en los datos de la empresa
     *
     * @param cliente
     */
    public void registrarCliente(Cliente cliente) {
        if (!verificarCliente(cliente.getEmail())) {
            clientes.add(cliente);
        }
    }

    //----------------------------------------------------------------------------------------------//
    
    //Métodos de eliminación/Desbloqueo
    
    /**
     * Método que elimina un empleado en los datos de la empresa
     *
     * @param cedula
     */
    public void eliminarEmpleado(String cedula) {
        
        Scanner d=new Scanner(System.in);
        
        if (verificarEmpleado(cedula)) {
            for (Empleado empleado : empleadosContratados) {
                if (empleado.getCedula().equals(cedula)) {
                    System.out.print("¿Quieres eliminar el empleado " + empleado.toString()+ "? Y/N : ");
                    char respuesta= d.nextLine().charAt(0);
                    if(Character.toUpperCase(respuesta) =='Y'){
                        empleadosContratados.remove(empleado);
                        
                        System.out.println("El empleado se ha eliminado con éxito.");
                    }else{
                        System.out.println("El empleado no se ha eliminado.");
                    }
                }
            }
        }
    }

    /**
     * Método que elimina un vehiculo en los datos de la empresa
     *
     * @param placa
     */
    public void eliminarVehiculo(String placa) {
        Scanner d= new Scanner(System.in);
        
        if (verificarVehiculo(placa)) {
            for (Vehiculo vehiculo : vehiculos) {
                if (vehiculo.getPlaca().equals(placa)) {
                    System.out.print("¿Quieres eliminar el vehículo " + vehiculo.toString()+ "? Y/N : ");
                    char respuesta= d.nextLine().charAt(0);
                    if(Character.toUpperCase(respuesta) =='Y'){
                            vehiculos.remove(vehiculo);   
                            System.out.println("El vehículo se ha eliminado con éxito.");
                    }else{
                        System.out.println("El vehículo no se ha eliminado.");
                    }
                }
            }
        }
        d.close();
    }

    /**
     * Método que elimina un cliente en los datos de la empresa
     *
     * @param cedula
     */
    public void eliminarCliente(String cedula) {
        
        Scanner d=new Scanner(System.in);
        
        if (verificarCliente(cedula)) {
            for (Cliente cliente : clientes) {
                if (cliente.getCedula().equals(cedula)) {
                    System.out.print("¿Quieres eliminar el cliente " + cliente.toString()+ "? Y/N : ");
                    char respuesta= d.nextLine().charAt(0);
                    if(Character.toUpperCase(respuesta) =='Y'){
                        clientes.remove(cliente);
                        
                        System.out.println("El cliente se ha eliminado con éxito.");
                    }else{
                        System.out.println("El cliente no se ha eliminado.");
                    }
                }
            }
        }
    }
    
    //----------------------------------------------------------------------------------------------//
    
    /**
     * Método que muestra el valor de cada dato
     *
     * @return
     */
    @Override
    public String toString() {
        return "Concesionario = " + " Nombre = " + nombre + ", dirección = " + direccion + ", empleados = " + empleadosContratados + ", clientes = " + clientes + ", vehiculos = " + vehiculos;
    }

    //----------------------------------------------------------------------------------------------//
    //----------------------------------------------------------------------------------------------//
    
    //Métodos Getters and Setters
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public LinkedList<Empleado> getEmpleados() {
        return empleadosContratados;
    }

    public void setEmpleados(LinkedList<Empleado> empleados) {
        this.empleadosContratados = empleados;
    }

    public LinkedList<Cliente> getUsuarios() {
        return clientes;
    }

    public void setUsuarios(LinkedList<Cliente> clientes) {
        this.clientes = clientes;
    }

    public LinkedList<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(LinkedList<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }

    public LinkedList<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(LinkedList<Cliente> clientes) {
        this.clientes = clientes;
    }

    public Administrador getAdministrador() {
        return administrador;
    }

    public void setAdministrador(Administrador administrador) {
        this.administrador = administrador;
    }

    public LinkedList<Tramite> getAlquilerActivo() {
        return alquilerActivo;
    }

    public void setAlquilerActivo(LinkedList<Tramite> alquilerActivo) {
        this.alquilerActivo = alquilerActivo;
    }

    public LinkedList<Empleado> getEmpleadosContratados() {
        return empleadosContratados;
    }

    public void setEmpleadosContratados(LinkedList<Empleado> empleadosContratados) {
        this.empleadosContratados = empleadosContratados;
    }

    public LinkedList<Tramite> getTramites() {
        return tramites;
    }

    public void setTramites(LinkedList<Tramite> tramites) {
        this.tramites = tramites;
    }

    

    //----------------------------------------------------------------------------------------------//
    //----------------------------------------------------------------------------------------------//
    
}