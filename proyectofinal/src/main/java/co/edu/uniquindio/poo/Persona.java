package co.edu.uniquindio.poo;

public class Persona {
    
    //----------------------------------------------------------------------------------------------//
    //----------------------------------------------------------------------------------------------//
    
    //Atributos de la clase
    
    private String nombre,apellidos,email,cedula,contraseña;
    private int edad;

    //----------------------------------------------------------------------------------------------//
    //----------------------------------------------------------------------------------------------//
    
    //Métodos de la clase
    
    /**
     * Método constructor de la clase
     * @param nombre
     * @param apellidos
     * @param email
     * @param cedula
     * @param contraseña
     * @param edad 
     */
    public Persona(String nombre, String apellidos, String email, String cedula ,String contraseña,int edad) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.email = email;
        this.cedula = cedula;
        this.edad=edad;
        this.contraseña=contraseña;
    }
    
    /**
     * Método que muestra el valor de cada dato
     * @return 
     */
    @Override
    public String toString() {
        return getClass().getSimpleName() + " = nombre = " + nombre + ", apellidos = " + apellidos + ", email = " + email + ", cedula = " + cedula + ", edad = " + edad ;
    }

    //----------------------------------------------------------------------------------------------//
    //----------------------------------------------------------------------------------------------//
    
    //Métodos Getters and Setters
    
    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    //----------------------------------------------------------------------------------------------//
    //----------------------------------------------------------------------------------------------//
    
}
