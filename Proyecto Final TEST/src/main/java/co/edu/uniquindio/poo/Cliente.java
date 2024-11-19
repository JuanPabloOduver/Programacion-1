package co.edu.uniquindio.poo;

public class Cliente extends Persona{

    //----------------------------------------------------------------------------------------------//
    //----------------------------------------------------------------------------------------------//
    
    //Atributos de la clase
    
    private String telefono;

    //----------------------------------------------------------------------------------------------//
    //----------------------------------------------------------------------------------------------//
    
    //Métodos de la clase

    /**
     * Método constructor de la clase
     * @param telefono
     * @param nombre
     * @param apellidos
     * @param email
     * @param cedula
     * @param contraseña
     * @param edad
     */
    public Cliente(String telefono, String nombre, String apellidos, String email, String cedula, String contraseña, int edad) {
        super(nombre, apellidos, email, cedula, contraseña, edad);
        this.telefono = telefono;
    }

    /**
     * Método que muestra el valor de cada dato
     * @return 
     */
    @Override
    public String toString() {
        return super.toString() + ", telefono = " + telefono;
    }

    //----------------------------------------------------------------------------------------------//
    //----------------------------------------------------------------------------------------------//
    
    //Métodos Getters and Setters
    
    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
    //----------------------------------------------------------------------------------------------//
    //----------------------------------------------------------------------------------------------//
    
}