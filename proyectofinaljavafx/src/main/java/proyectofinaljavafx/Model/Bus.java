package proyectofinaljavafx.Model;

public class Bus extends VehiculoCargaPasajeros{
 
    //----------------------------------------------------------------------------------------------//
    //----------------------------------------------------------------------------------------------//
    
    //Atributos de la clase

    private int numPuertas, numBolsasAire,numEjes,numSalidasEmergencia;

    //----------------------------------------------------------------------------------------------//
    //----------------------------------------------------------------------------------------------//
    
    //Métodos de la clase
    
    /**
     * Método constructor de la clase
     * @param numPuertas
     * @param numBolsasAire
     * @param numEjes
     * @param numSalidasEmergencia
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
    public Bus(int numPuertas, int numBolsasAire, int numEjes, int numSalidasEmergencia, String placa, String marca, String modelo, Estado estado, double velocidadMaxima, double cilindraje, Transmision transmision, Combustible combustible, boolean abs, boolean aireAcondicionado, boolean camaraReversa, int numPasajeros, double capacidad) {
        super(placa, marca, modelo, estado, velocidadMaxima, cilindraje, transmision, combustible, abs, aireAcondicionado, camaraReversa, numPasajeros, capacidad);
        this.numPuertas = numPuertas;
        this.numBolsasAire = numBolsasAire;
        this.numEjes = numEjes;
        this.numSalidasEmergencia = numSalidasEmergencia;
    }

    /**
     * Método que muestra el valor de cada dato
     * @return 
     */
    @Override
    public String toString() {
        return super.toString()  + ", numero de puertas = " + numPuertas + ", numero de bolsas de aire = " + numBolsasAire + ", numero de ejes = " + numEjes + ", numero de salidas de emergencia = " + numSalidasEmergencia;
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

    public int getNumEjes() {
        return numEjes;
    }

    public void setNumEjes(int numEjes) {
        this.numEjes = numEjes;
    }

    public int getNumSalidasEmergencia() {
        return numSalidasEmergencia;
    }

    public void setNumSalidasEmergencia(int numSalidasEmergencia) {
        this.numSalidasEmergencia = numSalidasEmergencia;
    }
    
    //----------------------------------------------------------------------------------------------//
    //----------------------------------------------------------------------------------------------//
    
}
