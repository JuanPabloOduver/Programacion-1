package co.edu.uniquindio.poo;
import java.util.Collection;
import java.util.LinkedList;

public class Estudiante extends Persona {

    private int edad;
    private Collection<Prestamo> historialPrestamos;
    private int cantidadPrestamos;

    public Estudiante(String nombre, String cedula, String correo, int telefono, int edad) {
        super(nombre, cedula, correo, telefono);
        this.edad = edad;
        cantidadPrestamos=0;
        historialPrestamos = new LinkedList<>();
    }

    public void añadirPrestamo(Prestamo prestamo) {
        historialPrestamos.add(prestamo);
        cantidadPrestamos++;
    }

    
    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getCantidadPrestamos() {
        return cantidadPrestamos;
    }

    public void setCantidadPrestamos(int cantidadPrestamos) {
        this.cantidadPrestamos = cantidadPrestamos;
    }
    
    

    @Override
    public String toString() {
        return "Estudiante{" + "edad=" + edad + ", cantidadPrestamos=" + cantidadPrestamos + '}';
    }

}