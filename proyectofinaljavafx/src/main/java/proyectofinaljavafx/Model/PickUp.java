package proyectofinaljavafx.Model;

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
     * @param placa
     * @param marca
     * @param modelo
     * @param estado
     * @param velocidadMaxima
     * @param cilindraje
     * @param transmision
     * @param combustible
     * @param abs
     * @param aireAcondicionado
     * @param camaraReversa
     * @param numPasajeros
     * @param capacidad 
     */
    public PickUp(int numPuertas, int numBolsasAire, boolean es4x4, String placa, String marca, String modelo, Estado estado, double velocidadMaxima, double cilindraje, Transmision transmision, Combustible combustible, boolean abs, boolean aireAcondicionado, boolean camaraReversa, int numPasajeros, double capacidad) {
        super(placa, marca, modelo, estado, velocidadMaxima, cilindraje, transmision, combustible, abs, aireAcondicionado, camaraReversa, numPasajeros, capacidad);
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
