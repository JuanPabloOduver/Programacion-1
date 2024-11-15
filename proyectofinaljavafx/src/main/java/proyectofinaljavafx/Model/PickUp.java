package co.edu.uniquindio.poo.model;

public class PickUp extends VehiculoCargaPasajeros{
    
    //----------------------------------------------------------------------------------------------//
    //----------------------------------------------------------------------------------------------//
    
    //Atributos de la clase
    
    private int numPuertas,numBolsasAire;
    private boolean es4x4;

    //----------------------------------------------------------------------------------------------//
    //----------------------------------------------------------------------------------------------//
    
    //Métodos de la clase

    /**
     * Método constructor de la clase
     * @param numPuertas
     * @param numBolsasAire
     * @param es4x4
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
    public PickUp(int numPuertas, int numBolsasAire, boolean es4x4, boolean abs, boolean aireAcondicionado, boolean camaraReversa, int numPasajeros, double capacidad, String placa, String marca, Estado estado, String modelo, double velocidadMaxima, double cilindraje, Transmision transmision, Combustible combustible) {
        super(abs, aireAcondicionado, camaraReversa, numPasajeros, capacidad, placa, marca, estado, modelo, velocidadMaxima, cilindraje, transmision, combustible);
        this.numPuertas = numPuertas;
        this.numBolsasAire = numBolsasAire;
        this.es4x4 = es4x4;
    }

    /**
     * Método que muestra el valor de cada dato
     * @return 
     */
    @Override
    public String toString() {
        return super.toString() + ", número de puertas = " + numPuertas + ", número de bolsas de aire = " + numBolsasAire + ", el vehículo es 4x4 = " + es4x4 ;
    }
    
    //----------------------------------------------------------------------------------------------//
    //----------------------------------------------------------------------------------------------//
    
    //Métodos Getters and Setters
    
    public int getNumPuertas() {
        return numPuertas;
    }

    public void setNumPuertas(int numPuertas) {
        this.numPuertas = numPuertas;
    }

    public int getNumBolsasAire() {
        return numBolsasAire;
    }

    public void setNumBolsasAire(int numBolsasAire) {
        this.numBolsasAire = numBolsasAire;
    }

    public boolean isEs4x4() {
        return es4x4;
    }

    public void setEs4x4(boolean es4x4) {
        this.es4x4 = es4x4;
    }

    //----------------------------------------------------------------------------------------------//
    //----------------------------------------------------------------------------------------------//
    
}
