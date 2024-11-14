package co.edu.uniquindio.poo;

public class Camion extends VehiculoCargaPasajeros{
    
    //----------------------------------------------------------------------------------------------//
    //----------------------------------------------------------------------------------------------//
    
    //Atributos de la clase

    private int numEjes;
    private TipoCamion tipoCamion;

    //----------------------------------------------------------------------------------------------//
    //----------------------------------------------------------------------------------------------//
    
    //Métodos de la clase
    
    /**
     * Método constructor de la clase
     * @param numEjes
     * @param tipoCamion
     * @param abs
     * @param aireAcondicionado
     * @param camaraReversa
     * @param numPasajeros
     * @param capacidad
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
    public Camion(int numEjes, TipoCamion tipoCamion, boolean abs, boolean aireAcondicionado, boolean camaraReversa, int numPasajeros, double capacidad, String placa, String marca, Estado estado, String modelo, double velocidadMaxima, double cilindraje, Transmision transmision, Combustible combustible) {
        super(abs, aireAcondicionado, camaraReversa, numPasajeros, capacidad, placa, marca, estado, modelo, velocidadMaxima, cilindraje, transmision, combustible);
        this.numEjes = numEjes;
        this.tipoCamion = tipoCamion;
    }

    /**
     * Método que muestra el valor de cada dato
     * @return 
     */
    @Override
    public String toString() {
        return super.toString() + ", numero de ejes = " + numEjes + ", tipo de camion = " + tipoCamion;
    }

    //----------------------------------------------------------------------------------------------//
    //----------------------------------------------------------------------------------------------//
    
    //Métodos Getters and Setters
    
    public int getNumEjes() {
        return numEjes;
    }

    public void setNumEjes(int numEjes) {
        this.numEjes = numEjes;
    }

    public TipoCamion getTipoCamion() {
        return tipoCamion;
    }

    public void setTipoCamion(TipoCamion tipoCamion) {
        this.tipoCamion = tipoCamion;
    }

    //----------------------------------------------------------------------------------------------//
    //----------------------------------------------------------------------------------------------//
    
}
