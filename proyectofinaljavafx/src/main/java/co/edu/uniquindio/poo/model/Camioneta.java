package co.edu.uniquindio.poo.model;

public class Camioneta extends VehiculoCargaPasajeros {

    //----------------------------------------------------------------------------------------------//
    //----------------------------------------------------------------------------------------------//
    
    //Atributos de la clase

    private int numPuertas, numBolsasAire;
    private boolean velocidadCrucero,sensorColision,sensorTraficoCruzado,asistentePermanenciaCarril,es4x4;

    //----------------------------------------------------------------------------------------------//
    //----------------------------------------------------------------------------------------------//
    
    //Métodos de la clase

    /**
     * Método constructor de la clase
     * @param numPuertas
     * @param numBolsasAire
     * @param velocidadCrucero
     * @param sensorColision
     * @param sensorTraficoCruzado
     * @param asistentePermanenciaCarril
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
     * @param velocidadMaxima
     * @param cilindraje
     * @param transmision
     * @param combustible 
     */
    public Camioneta(int numPuertas, int numBolsasAire, boolean velocidadCrucero, boolean sensorColision, boolean sensorTraficoCruzado, boolean asistentePermanenciaCarril, boolean es4x4, boolean abs, boolean aireAcondicionado, boolean camaraReversa, int numPasajeros, double capacidad, String placa, String marca, Estado estado, String modelo, double velocidadMaxima, double cilindraje, Transmision transmision, Combustible combustible) {
        super(abs, aireAcondicionado, camaraReversa, numPasajeros, capacidad, placa, marca, estado, modelo, velocidadMaxima, cilindraje, transmision, combustible);
        this.numPuertas = numPuertas;
        this.numBolsasAire = numBolsasAire;
        this.velocidadCrucero = velocidadCrucero;
        this.sensorColision = sensorColision;
        this.sensorTraficoCruzado = sensorTraficoCruzado;
        this.asistentePermanenciaCarril = asistentePermanenciaCarril;
        this.es4x4 = es4x4;
    }
    
    /**
     * Método que muestra el valor de cada dato
     * @return 
     */
    @Override
    public String toString() {
        return super.toString() + ", numero de puertas = " + numPuertas + ", numero de bolsas de aire = " + numBolsasAire + ", tiene velocidad Crucero = " + velocidadCrucero + ", tiene sensor de colision = " + sensorColision + ", tiene sensor de trafico cruzado = " + sensorTraficoCruzado + ", tiene asistente de permanencia en el carril = " + asistentePermanenciaCarril + ", el vehiculo es 4x4 = " + es4x4 ;
    }

    //----------------------------------------------------------------------------------------------//
    //----------------------------------------------------------------------------------------------//
    
    //Métodos Getters and Setters
    
    public boolean isSensorColision() {
        return sensorColision;
    }

    public void setSensorColision(boolean sensorColision) {
        this.sensorColision = sensorColision;
    }

    public boolean isSensorTraficoCruzado() {
        return sensorTraficoCruzado;
    }

    public void setSensorTraficoCruzado(boolean sensorTraficoCruzado) {
        this.sensorTraficoCruzado = sensorTraficoCruzado;
    }

    public boolean isAsistentePermanenciaCarril() {
        return asistentePermanenciaCarril;
    }

    public void setAsistentePermanenciaCarril(boolean asistentePermanenciaCarril) {
        this.asistentePermanenciaCarril = asistentePermanenciaCarril;
    }

    public boolean isEs4x4() {
        return es4x4;
    }

    public void setEs4x4(boolean es4x4) {
        this.es4x4 = es4x4;
    }    

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

    public boolean isVelocidadCrucero() {
        return velocidadCrucero;
    }

    public void setVelocidadCrucero(boolean velocidadCrucero) {
        this.velocidadCrucero = velocidadCrucero;
    }

    //----------------------------------------------------------------------------------------------//
    //----------------------------------------------------------------------------------------------//
    
}
