package co.edu.uniquindio.poo;
import java.util.LinkedList;

public class Autor extends Persona {
    
    private LinkedList<Libro> librosCreador;
    
    public Autor(String nombre, String cedula, String correo, int telefono){
        super(nombre, cedula, correo, 0);
        librosCreador=new LinkedList<>();
    }

    public LinkedList<Libro> getLibrosCreador() {
        return librosCreador;
    }

    public void setLibrosCreador(LinkedList<Libro> librosCreador) {
        this.librosCreador = librosCreador;
    }

    @Override
    public String toString() {
        return "Autor{" + "librosCreador=" + librosCreador + '}';
    }
    
    
}
