package co.edu.uniquindio.poo;

public class DetallePrestamo {
    private int cantidad;
    private double subTotal; 
    private Libro libro; 

    public DetallePrestamo (int cantidad, double subTotal, Libro libro){
        this.cantidad = cantidad; 
        this.libro = libro; 
        this.subTotal=0; 
    }
}