package proyectofinaljavafx.Model;

public class Van extends VehiculoCargaPasajeros{
    
    //----------------------------------------------------------------------------------------------//
    //----------------------------------------------------------------------------------------------//
    
    //Atributos de la clase
    
    private int numPuertas,numBolsasAire;

    //----------------------------------------------------------------------------------------------//
    //----------------------------------------------------------------------------------------------//
    
    //Métodos de la clase

    /**
     * Método constructor de la clase
     * @param numPuertas
     * @param numBolsasAire
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
    public Van(int numPuertas, int numBolsasAire, boolean abs, boolean aireAcondicionado, boolean camaraReversa, int numPasajeros, double capacidad, String placa, String marca, Estado estado, String modelo, double velocidadMaxima, double cilindraje, Transmision transmision, Combustible combustible) {
        super(abs, aireAcondicionado, camaraReversa, numPasajeros, capacidad, placa, marca, estado, modelo, velocidadMaxima, cilindraje, transmision, combustible);
        this.numPuertas = numPuertas;
        this.numBolsasAire = numBolsasAire;
    }

    /**
     * Método que muestra el valor de cada dato
     * @return 
     */
    @Override
    public String toString() {
        return super.toString() + ", numero de puertas=" + numPuertas + ", numero de bolsas de aire = " + numBolsasAire;
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
    
    //----------------------------------------------------------------------------------------------//
    //----------------------------------------------------------------------------------------------//
    
}
