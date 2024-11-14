package co.edu.uniquindio.poo;

public class Cliente extends Persona{

    //----------------------------------------------------------------------------------------------//
    //----------------------------------------------------------------------------------------------//
    
    //Atributos de la clase
    
    private int telefono;

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
    public Cliente(int telefono, String nombre, String apellidos, String email, String cedula, String contraseña, int edad) {
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
    
    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }
    
    //----------------------------------------------------------------------------------------------//
    //----------------------------------------------------------------------------------------------//
    
}