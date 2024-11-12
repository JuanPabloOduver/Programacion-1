package proyectofinaljavafx.Model;

import java.util.LinkedList;

public class Concesionario {

    //----------------------------------------------------------------------------------------------//
    //----------------------------------------------------------------------------------------------//
    
    //Atributos de la clase
    
    private String nombre, direccion;
    private LinkedList<Empleado> empleados;
    private LinkedList<Cliente> clientes;
    private LinkedList<Vehiculo> vehiculos;
    private LinkedList<Administrador> administradores;
    private double InteresXCuota=0.3;
    private double ganancias=0;

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
        empleados = new LinkedList<>();
        clientes = new LinkedList<>();
        vehiculos = new LinkedList<>();
        administradores = new LinkedList<>();
    }

    //----------------------------------------------------------------------------------------------//
    
    //Métodos de verificación/Busqueda
    
    public LinkedList<Vehiculo> buscarvehiculos;
    
    /**
     * Método que verifica si un empleado está registrado en la empresa
     *
     * @param cedula
     * @return c
     */
    public boolean verificarEmpleado(String cedula) {
        boolean c = false;

        for (Empleado empleado : empleados) {
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

        for (Administrador administrador : administradores) {
            if (administrador.getCedula().equals(cedula)) {
                c = true;
            }
        }
        return c;
    }

    /**
     * Método que verifica si un cliente está registrado en la empresa
     *
     * @param emails
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

    //----------------------------------------------------------------------------------------------//
    
    //Métodos de registro/Bloqueo
    
    /**
     * Método que registra un empleado en los datos de la empresa
     *
     * @param empleado
     */
    public void registrarEmpleado(Empleado empleado) {
        if (!verificarEmpleado(empleado.getCedula())) {
            empleados.add(empleado);
        }
    }

    /**
     * Método que registra un empleado en la lista de bloqueos de la empresa
     *
     * @param cedula
     */
    public void bloquearEmpleado(String cedula) {
        if (verificarEmpleado(cedula)) {
            for (Empleado empleado : empleados) {
                if (empleado.getCedula().equals(cedula)) {
                    empleados.remove(empleado);
                }
            }
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
     * Método que registra un administrador en los datos de la empresa
     *
     * @param administrador
     */
    public void registrarAdministrador(Administrador admin) {
        if (!verificarEmpleado(admin.getCedula())) {
            administradores.add(admin);
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
            for (Empleado empleado : empleados) {
                if (empleado.getCedula().equals(cedula)) {
                    empleados.remove(empleado);
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
     * Método que elimina un administrador en los datos de la empresa
     *
     * @param cedula
     */
    public void eliminarAdministrador(String cedula) {
        if (verificarAdministrador(cedula)) {
            for (Administrador administrador : administradores) {
                if (administrador.getCedula().equals(cedula)) {
                    administradores.remove(administrador);
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
                    clientes.remove(cedula);
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
        return "Concesionario = " + " Nombre = " + nombre + ", dirección = " + direccion + ", empleados = " + empleados + ", clientes = " + clientes + ", vehiculos = " + vehiculos;
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
        return empleados;
    }

    public void setEmpleados(LinkedList<Empleado> empleados) {
        this.empleados = empleados;
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
