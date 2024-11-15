package co.edu.uniquindio.poo.model;

public class Motocicleta extends Vehiculo{
    
    //----------------------------------------------------------------------------------------------//
    //----------------------------------------------------------------------------------------------//
    
    //Atributos de la clase
    
    private String Color;

    //----------------------------------------------------------------------------------------------//
    //----------------------------------------------------------------------------------------------//
    
    //Métodos de la clase

    /**
     * Método constructor de la clase
     * @param Color
     * @param placa
     * @param marca
     * @param estado
     * @param modelo
     * @param disponibilidad
     * @param velocidadMaxima
     * @param cilindraje
     * @param transmision
     * @param combustible 
     */
    public Motocicleta(String Color, String placa, String marca, Estado estado, String modelo, double velocidadMaxima, double cilindraje, Transmision transmision, Combustible combustible) {
        super(placa, marca, estado, modelo, velocidadMaxima, cilindraje, transmision, combustible);
        this.Color = Color;
    }

    /**
     * Método que muestra el valor de cada dato
     * @return 
     */
    @Override
    public String toString() {
        return super.toString() + ", color = " + Color ;
    }
    
    //----------------------------------------------------------------------------------------------//
    //----------------------------------------------------------------------------------------------//
    
    //Métodos Getters and Setters
    
    public String getColor() {
        return Color;
    }

    public void setColor(String Color) {
        this.Color = Color;
    }
 
    //----------------------------------------------------------------------------------------------//
    //----------------------------------------------------------------------------------------------//
    
}
