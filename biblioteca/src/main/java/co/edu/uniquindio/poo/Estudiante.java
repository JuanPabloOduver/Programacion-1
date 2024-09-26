package co.edu.uniquindio.poo;

public class Estudiante extends Persona {
    private int edad;
    public Estudiante (String nombre, String cedula, String correo, int telefono, int edad){
        super(nombre, cedula, correo, telefono);
        this.edad = edad;
    }

    public int getEdad() {
        return edad;
    }
    public void setEdad(int edad) {
        this.edad = edad;
    }

    @Override
    public String toString() {
        return "Estudiante [nombre=" + nombre + ", edad=" + edad + ", cedula=" + cedula + ", correo=" + correo
                + ", telefono=" + telefono + "]";
    }
    
}
