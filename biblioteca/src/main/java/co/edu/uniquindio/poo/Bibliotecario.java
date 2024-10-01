package co.edu.uniquindio.poo;
import java.util.LinkedList;

public class Bibliotecario extends Persona {

    private double salario;
    private int antiguedad;
    private LinkedList<Prestamo> historialPrestamos;
    private int cantidadPrestamos;

    public Bibliotecario(String nombre, String cedula, String correo, int telefono, double salario, int antiguedad) {
        super(nombre, cedula, correo, telefono);
        this.salario = salario;
        this.antiguedad = antiguedad;
        cantidadPrestamos=0;
        historialPrestamos= new LinkedList<>();
    }
    /**
     * Metodo que añade un prestamo
     * @param prestamo
     */
    public void añadirPrestamo(Prestamo prestamo){
        historialPrestamos.add(prestamo);
        cantidadPrestamos++;
    }
    
    public String getPrestamos(){
        String mensaje= "Prestamos: ";
        for (Prestamo historialPrestamo : historialPrestamos) {
            mensaje += historialPrestamo + "\n";
        }
        return mensaje;
    }
    
    
    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public int getAntiguedad() {
        return antiguedad;
    }

    public void setAntiguedad(int antiguedad) {
        this.antiguedad = antiguedad;
    }

    public int getCantidadPrestamos() {
        return cantidadPrestamos;
    }

    public void setCantidadPrestamos(int cantidadPrestamos) {
        this.cantidadPrestamos = cantidadPrestamos;
    }

    @Override
    public String toString() {
        return "Bibliotecario{" + "salario=" + salario + ", antiguedad=" + antiguedad + ", historialPrestamos=" + historialPrestamos + ", cantidadPrestamos=" + cantidadPrestamos + '}';
    }

}