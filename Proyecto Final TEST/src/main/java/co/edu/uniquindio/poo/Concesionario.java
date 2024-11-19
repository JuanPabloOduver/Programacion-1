package co.edu.uniquindio.poo;

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
     * Método que busca un vehiculo en el listado de la empresa con una placa
     * @param placa
     * @return mensaje
     */
    public String buscarPlacaVehiculo(String placa){
        String mensaje="No hay un vehiculo con la placa: " + placa;
            for (Vehiculo vehiculo : vehiculos) {
                if(vehiculo.getPlaca().equals(placa)){
                    mensaje="El vehículo de la placa " + placa + " es: " + vehiculo;
                }
            }
        return mensaje;
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
     * Método que registra un vehiculo comprado en los datos de la empresa en caso de que no haya un vehiculo con placa similar ni un tramite con còdigo similar
     *
     * @param vehiculoComprado
     */
    public void registrarVehiculoComprado(Tramite vehiculoComprado) {
        if(vehiculoComprado.getVehiculo().getDisponibilidad() == Disponibilidad.VEHICULO_DISPONIBLE){
            Vehiculo vehiculo= vehiculoComprado.getVehiculo();
            String placavehiculo= vehiculo.getPlaca();
            Empleado empleado= vehiculoComprado.getEmpleado();

            if (!verificarVehiculo(placavehiculo) &&  !verificarTramite(vehiculoComprado.getCodigoTramite())) {
                registrarVehiculo(vehiculo);

                vehiculoComprado.setEstadoTramite(EstadoTramite.VEHICULO_COMPRADO);

                empleado.registrarTransaccion(vehiculoComprado);
                registrarTransaccion(vehiculoComprado, EstadoTramite.VEHICULO_COMPRADO);
                System.out.println("Se ha registrado la compra del vehículo correctamente.");
            }else{
                System.out.println("No se puede crear el tramite por que ya hay uno con el mismo còdigo o un coche con la misma placa.");
            }
        }
    }

    /**
     * Método que registra un vehiculo alquilado en los datos de la empresa en caso de que  haya un vehiculo con placa similar y con un tramite con còdigo ùnico.
     *
     * @param vehiculoAlquilado
     */
    public void registrarVehiculoAlquilado(Tramite vehiculoAlquilado) {
        if(vehiculoAlquilado.getVehiculo().getDisponibilidad() == Disponibilidad.VEHICULO_DISPONIBLE){
            Vehiculo vehiculo= vehiculoAlquilado.getVehiculo();
            String placavehiculo= vehiculo.getPlaca();
            Empleado empleado= vehiculoAlquilado.getEmpleado();

            if (verificarVehiculo(placavehiculo) && !verificarTramite(vehiculoAlquilado.getCodigoTramite())) {

                vehiculo.setDisponibilidad(Disponibilidad.VEHICULO_ALQUILADO);

                vehiculoAlquilado.setEstadoTramite(EstadoTramite.VEHICULO_ALQUILADO);

                empleado.registrarTransaccion(vehiculoAlquilado);            
                tramites.add(vehiculoAlquilado);
                System.out.println("Se ha registrado el alquiler del vehículo correctamente.");
            }else{
                System.out.println("No se puede crear el tramite por que ya hay uno con el mismo còdigo o no se encuentra la placa del coche.");
            }
        }else{
            System.out.println("No se puede alquilar un vehículo que no este disponible.");
        }
    }

    /**
     * Método que registra un vehiculo comprado en los datos de la empresa en caso de que no haya un vehiculo con placa similar ni un tramite con còdigo similar
     *
     * @param vehiculoVendido
     */
    public void registrarVehiculoVendido(Tramite vehiculoVendido) {
        if(vehiculoVendido.getVehiculo().getDisponibilidad() == Disponibilidad.VEHICULO_DISPONIBLE){
            Vehiculo vehiculo= vehiculoVendido.getVehiculo();
            String placavehiculo= vehiculo.getPlaca();
            Empleado empleado= vehiculoVendido.getEmpleado();

            if (verificarVehiculo(placavehiculo) &&  !verificarTramite(vehiculoVendido.getCodigoTramite())) {
                eliminarVehiculo(vehiculoVendido.getVehiculo().getPlaca());

                vehiculoVendido.setEstadoTramite(EstadoTramite.VEHICULO_VENDIDO);


                empleado.registrarTransaccion(vehiculoVendido);
                registrarTransaccion(vehiculoVendido, EstadoTramite.VEHICULO_VENDIDO);
                System.out.println("Se ha registrado la venta del vehículo correctamente.");
            }else{
                System.out.println("No se puede crear el tramite por que ya hay uno con el mismo còdigo o no hay un coche con la placa ingresada.");
            }
        }else{
            System.out.println("No se puede vender un vehículo que no este disponible.");
        }
    }
    
    /**
     * Método que registra un cliente en los datos de la empresa
     *
     * @param cliente
     */
    private void registrarTransaccion(Tramite transaccion, EstadoTramite estado) {
        transaccion.setEstadoTramite(estado);
        transaccion.getEmpleado().registrarTransaccion(transaccion);
        tramites.add(transaccion);
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

    //----------------------------------------------------------------------------------------------//
    //----------------------------------------------------------------------------------------------//
    
}