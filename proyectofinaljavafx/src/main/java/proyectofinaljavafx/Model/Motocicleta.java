package proyectofinaljavafx.Model;

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
     * @param modelo
     * @param estado
     * @param velocidadMaxima
     * @param cilindraje
     * @param transmision
     * @param combustible 
     */
    public Motocicleta(String Color, String placa, String marca, String modelo, Estado estado, double velocidadMaxima, double cilindraje, Transmision transmision, Combustible combustible) {
        super(placa, marca, modelo, estado, velocidadMaxima, cilindraje, transmision, combustible);
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
