package co.edu.uniquindio.poo;
public class DetallePrestamo {

    private int cantidad;
    private Libro libro;
    private double costeUnitario, costeSubtotal;

    public DetallePrestamo(int cantidad, Libro libro, double costeUnitario) {
        if (cantidad <= 0) {
            throw new IllegalArgumentException("La cantidad no puede ser menor o igual a 0.");
        }

        if (costeUnitario < 0) {
            throw new IllegalArgumentException("El coste unitario no puede ser negativo.");
        }

        this.cantidad = cantidad;
        this.costeUnitario = costeUnitario;
        this.libro = libro;
        this.costeSubtotal = calcularSubtotal(); // Calcula el subtotal basado en los valores válidos
    }

    public double calcularSubtotal() {
        return costeUnitario * this.cantidad;
    }

    public int getCantidad() {
        return cantidad;
    }

    public Libro getLibro() {
        return libro;
    }

    public double getCoste() {
        return costeUnitario;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    public void setCoste(double costeUnitario) {
        this.costeUnitario = costeUnitario;
    }

    public double getCosteSubtotal() {
        return costeSubtotal;
    }

    public void setCosteSubtotal(double costeSubtotal) {
        this.costeSubtotal = costeSubtotal;
    }

    @Override
    public String toString() {
        return "Detalle del Prestamo{" + "cantidad=" + cantidad + ", libro=" + libro + ", costeUnitario=" + costeUnitario + ", costeSubtotal=" + costeSubtotal + '}';
    }

}