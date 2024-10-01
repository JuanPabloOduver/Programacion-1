package co.edu.uniquindio.poo;
import java.time.LocalDate;
import java.util.LinkedList;

public class Prestamo {

    private LocalDate fechaPrestamo, fechaEntrega;
    private Bibliotecario bibliotecario;
    private Estudiante estudiante;
    private double costoTotal;
    private String codigo;
    private LinkedList<DetallePrestamo> detallesprestamo;
    private int cantidadLibros;

    public Prestamo(LocalDate fechaPrestamo, LocalDate fechaEntrega, Bibliotecario bibliotecario, Estudiante estudiante, String codigo) {
        this.fechaPrestamo = fechaPrestamo;
        this.fechaEntrega = fechaEntrega;
        this.cantidadLibros=0;
        this.bibliotecario = bibliotecario;
        this.estudiante = estudiante;
        this.costoTotal = 0;
        this.codigo = codigo;
        detallesprestamo = new LinkedList<>();
    }
    
    /**
     * Metodo para agregar detalles al prestamo
     * @param detalleprestamo
     */
    public void agregarDetallePrestamo(DetallePrestamo detalleprestamo) {
        detallesprestamo.add(detalleprestamo);
        costoTotal = calcularCosteTotal();
        cantidadLibros+=detalleprestamo.getCantidad();
    }

    /**
     * Metodo para calcular el coste total de los libros
     * @return
     */
    public double calcularCosteTotal() {
        double costeTotal = 0;
        if (detallesprestamo != null) {
            for (DetallePrestamo detallePrestamo : detallesprestamo) {
                costeTotal += detallePrestamo.calcularSubtotal(); // Llama al método para obtener el subtotal
            }
        }
        return costeTotal;
    }

    public int getCantidadLibros() {
        return cantidadLibros;
    }

    public void setCantidadLibros(int cantidadLibros) {
        this.cantidadLibros = cantidadLibros;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public LinkedList<DetallePrestamo> getDetallesprestamo() {
        return detallesprestamo;
    }

    public void setDetallesprestamo(LinkedList<DetallePrestamo> detallesprestamo) {
        this.detallesprestamo = detallesprestamo;
    }

    public double getCostoTotal() {
        return costoTotal;
    }

    public LocalDate getFechaPrestamo() {
        return fechaPrestamo;
    }

    public LocalDate getFechaEntrega() {
        return fechaEntrega;
    }

    public Bibliotecario getBibliotecario() {
        return bibliotecario;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setFechaPrestamo(LocalDate fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    public void setFechaEntrega(LocalDate fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public void setBibliotecario(Bibliotecario bibliotecario) {
        this.bibliotecario = bibliotecario;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    public void setCosto(double costoTotal) {
        this.costoTotal = costoTotal;
    }

    @Override
    public String toString() {
        return "Prestamo{" + "fechaPrestamo=" + fechaPrestamo + ", fechaEntrega=" + fechaEntrega + ", bibliotecario=" + bibliotecario + ", estudiante=" + estudiante + ", costoTotal=" + costoTotal + ", codigo=" + codigo + ", detallesprestamo=" + detallesprestamo + '}';
    }

}