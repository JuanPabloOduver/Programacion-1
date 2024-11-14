package co.edu.uniquindio.poo;

import java.util.LinkedList;

public class Concesionario {

    //----------------------------------------------------------------------------------------------//
    //----------------------------------------------------------------------------------------------//
    
    //Atributos de la clase
    
    private String nombre, direccion;
    private LinkedList<Empleado> empleadosContratados;
    private LinkedList<Cliente> clientes;
    private LinkedList<Vehiculo> vehiculos;
    private Administrador administrador;
    private LinkedList<AccionesVehiculo> tramites ;
    
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
    
    //Métodos de verificación/Busqueda
    
//     public static List<Vehiculo> filtrarVehiculos(List<Vehiculo> vehiculos, String modeloBuscado, Boolean tieneAireAcondicionado) {
//        List<Vehiculo> vehiculosFiltrados = new ArrayList<>();
//        for (Vehiculo v : vehiculos) {
//            // Filtra por el modelo, si se proporciona
//            boolean coincideModelo = modeloBuscado == null || v.getModelo().equalsIgnoreCase(modeloBuscado);
//            // Si tieneAireAcondicionado es null, no filtra por aire acondicionado
//            boolean coincideAireAcondicionado = (tieneAireAcondicionado == null) || (v.getA() == tieneAireAcondicionado);
//            // Solo agregar el vehículo si cumple con ambos filtros
//            if (coincideModelo && coincideAireAcondicionado) {
//                vehiculosFiltrados.add(v);
//            }
//        }
//        return vehiculosFiltrados;
//    }
    
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

        for (AccionesVehiculo accion : tramites) {
            if (accion.getCodigoTramite().equals(codigoTramite)) {
                c = true;
            }
        }
        return c;
    }

    //----------------------------------------------------------------------------------------------//
    
    //Métodos de registro/Bloqueo
    
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
        if(verificarTramite(codigoTramite)){
            for (AccionesVehiculo tramite : tramites) {
                if(tramite.getCodigoTramite().equals(codigoTramite)){
                    
                    tramite.getEmpleado().devolverAlquiler(codigoTramite);
                    administrador.devolverAlquiler(codigoTramite);
                    tramite.setEstadoTramite(EstadoTramite.ALQUILER_REGRESADO);
                }
            }
        }
    }

    /**
     * Método que registra un vehiculo comprado en los datos de la empresa en caso de que no haya un vehiculo con placa similar ni un tramite con còdigo similar
     *
     * @param vehiculoComprado
     */
    public void registrarVehiculoComprado(Compra vehiculoComprado) {
        Vehiculo vehiculo= vehiculoComprado.getVehiculo();
        String placavehiculo= vehiculo.getPlaca();
        Empleado empleado= vehiculoComprado.getEmpleado();

        if (!verificarVehiculo(placavehiculo) &&  !verificarTramite(vehiculoComprado.getCodigoTramite())) {
            vehiculos.add(vehiculo);
            
            vehiculoComprado.setEstadoTramite(EstadoTramite.VEHICULO_COMPRADO);
            
            empleado.VehiculoComprado(vehiculoComprado);
            tramites.add(vehiculoComprado);
            administrador.añadirTramites(vehiculoComprado);
        }else{
            System.out.println("No se puede crear el tramite por que ya hay uno con el mismo còdigo o un coche con la misma placa.");
        }
    }

    /**
     * Método que registra un vehiculo alquilado en los datos de la empresa en caso de que  haya un vehiculo con placa similar y con un tramite con còdigo ùnico.
     *
     * @param vehiculoAlquilado
     */
    public void registrarVehiculoAlquilado(Alquiler vehiculoAlquilado) {
        Vehiculo vehiculo= vehiculoAlquilado.getVehiculo();
        String placavehiculo= vehiculo.getPlaca();
        Empleado empleado= vehiculoAlquilado.getEmpleado();

        if (verificarVehiculo(placavehiculo) && !verificarTramite(vehiculoAlquilado.getCodigoTramite())) {
            
            vehiculo.setDisponibilidad(Disponibilidad.VEHICULO_ALQUILADO);
            
            vehiculoAlquilado.setEstadoTramite(EstadoTramite.VEHICULO_ALQUILADO);
            
            empleado.VehiculoAlquilado(vehiculoAlquilado);
            tramites.add(vehiculoAlquilado);
            administrador.añadirTramites(vehiculoAlquilado);
        }else{
            System.out.println("No se puede crear el tramite por que ya hay uno con el mismo còdigo o no se encuentra la placa del coche.");
        }
    }

    /**
     * Método que registra un vehiculo comprado en los datos de la empresa en caso de que no haya un vehiculo con placa similar ni un tramite con còdigo similar
     *
     * @param vehiculoVendido
     */
    public void registrarVehiculoVendido(Venta vehiculoVendido) {
        Vehiculo vehiculo= vehiculoVendido.getVehiculo();
        String placavehiculo= vehiculo.getPlaca();
        Empleado empleado= vehiculoVendido.getEmpleado();

        if (verificarVehiculo(placavehiculo) &&  !verificarTramite(vehiculoVendido.getCodigoTramite())) {
            vehiculos.remove(vehiculo);
            
            vehiculoVendido.setEstadoTramite(EstadoTramite.VEHICULO_VENDIDO);
            
            empleado.VehiculoVendido(vehiculoVendido);
            tramites.add(vehiculoVendido);
            administrador.añadirTramites(vehiculoVendido);           
        }else{
            System.out.println("No se puede crear el tramite por que ya hay uno con el mismo còdigo o no hay un coche con la placa ingresada.");
        }
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
        if (verificarEmpleado(cedula)) {
            for (Empleado empleado : empleadosContratados) {
                if (empleado.getCedula().equals(cedula)) {
                    empleadosContratados.remove(empleado);
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
        if (verificarVehiculo(placa)) {
            for (Vehiculo vehiculo : vehiculos) {
                if (vehiculo.getPlaca().equals(placa)) {
                    vehiculos.remove(vehiculo);
                }
            }
        }
    }

    /**
     * Método que elimina un cliente en los datos de la empresa
     *
     * @param cedula
     */
    public void eliminarCliente(String cedula) {
        if (verificarCliente(cedula)) {
            for (Cliente cliente : clientes) {
                if (cliente.getCedula().equals(cedula)) {
                    clientes.remove(cliente);
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

    //----------------------------------------------------------------------------------------------//
    //----------------------------------------------------------------------------------------------//
    
}
