package proyectofinaljavafx.Model;

public class Electrico extends Vehiculo {

    //----------------------------------------------------------------------------------------------//
    //----------------------------------------------------------------------------------------------//
    
    //Atributos de la clase
    
    private double duracionBateria,TiempoEnCargar;
    
    //----------------------------------------------------------------------------------------------//
    //----------------------------------------------------------------------------------------------//
    
    //Métodos de la clase

    /**
     * Mètodo constructor de la clase
     * @param placa
     * @param marca
     * @param estado
     * @param modelo
     * @param velocidadMaxima
     * @param cilindraje
     * @param transmision
     * @param combustible
     * @param duracionBateria
     * @param TiempoEnCargar
     */
    public Electrico(String placa,String marca,Estado estado,String modelo, double velocidadMaxima , double cilindraje, Transmision transmision, Combustible combustible, double duracionBateria, double TiempoEnCargar){
        super(placa,marca,estado,modelo,velocidadMaxima,cilindraje,transmision,combustible);
        this.TiempoEnCargar=TiempoEnCargar;
        this.duracionBateria=duracionBateria;
    }
    
    /**
     * Método que muestra el valor de cada dato
     * @return 
     */
    @Override
    public String toString() {
        return getClass() + "= duraciòn de la baterìa = " + duracionBateria  + " horas, tiempo que tarda en cargar completamente = " + TiempoEnCargar + " horas." ;
    }
    
    //----------------------------------------------------------------------------------------------//
    //----------------------------------------------------------------------------------------------//
    
    //Métodos Getters and Setters

    public double getTiempoEnCargar() {
        return TiempoEnCargar;
    }
    
    public double getDuracionBateria() {
        return duracionBateria;
    }

    public void setTiempoEnCargar(double TiempoEnCargar){
        this.TiempoEnCargar=TiempoEnCargar;
    }

    public void setDuracionBateria(double duracionBateria){
        this.duracionBateria=duracionBateria;
    }

    //----------------------------------------------------------------------------------------------//
    //----------------------------------------------------------------------------------------------//
    
}