package co.edu.uniquindio.poo.model;

public class Administrador extends Persona{

    //----------------------------------------------------------------------------------------------//
    //----------------------------------------------------------------------------------------------//
    
    //Métodos de la clase

    /**
     * Método constructor de la clase
     * @param contraseña
     * @param nombre
     * @param apellidos
     * @param email
     * @param cedula
     * @param edad 
     */
    public Administrador( String nombre, String apellidos, String email, String cedula, String contraseña, int edad) {
        super(nombre, apellidos, email, cedula, contraseña, edad);
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

}
