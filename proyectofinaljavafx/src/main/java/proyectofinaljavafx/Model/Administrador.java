package proyectofinaljavafx.Model;

public class Administrador extends Persona{
    
    //----------------------------------------------------------------------------------------------//
    //----------------------------------------------------------------------------------------------//
    
    //Atributos de la clase
    
    private double salario;

    //----------------------------------------------------------------------------------------------//
    //----------------------------------------------------------------------------------------------//
    
    //Métodos de la clase
    
    /**
     * Método constructor de la clase
     * @param nombre
     * @param apellidos
     * @param email
     * @param cedula
     * @param edad 
     */
    public Administrador(String nombre, String apellidos, String email, String cedula, int edad) {
        super(nombre, apellidos, email, cedula, edad);
        this.salario = 0;
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
    
    //----------------------------------------------------------------------------------------------//
    //----------------------------------------------------------------------------------------------//
    
}
