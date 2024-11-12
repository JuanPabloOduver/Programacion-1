package proyectofinaljavafx.Model;

public class Sedan extends VehiculoCargaPasajeros {
    
    //----------------------------------------------------------------------------------------------//
    //----------------------------------------------------------------------------------------------//
    
    //Atributos de la clase

    private boolean velocidadCrucero,sensorColision,sensorTraficoCruzado,asistentePermanenciaCarril;
    private int numBolsasAire;

    //----------------------------------------------------------------------------------------------//
    //----------------------------------------------------------------------------------------------//
    
    //Métodos de la clase
    
    /**
     * Método constructor de la clase
     * @param velocidadCrucero
     * @param sensorColision
     * @param sensorTraficoCruzado
     * @param asistentePermanenciaCarril
     * @param numBolsasAire
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
    public Sedan(boolean velocidadCrucero, boolean sensorColision, boolean sensorTraficoCruzado, boolean asistentePermanenciaCarril, int numBolsasAire, String placa, String marca, String modelo, Estado estado, double velocidadMaxima, double cilindraje, Transmision transmision, Combustible combustible, boolean abs, boolean aireAcondicionado, boolean camaraReversa, int numPasajeros, double capacidad) {
        super(placa, marca, modelo, estado, velocidadMaxima, cilindraje, transmision, combustible, abs, aireAcondicionado, camaraReversa, numPasajeros, capacidad);
        this.velocidadCrucero = velocidadCrucero;
        this.sensorColision = sensorColision;
        this.sensorTraficoCruzado = sensorTraficoCruzado;
        this.asistentePermanenciaCarril = asistentePermanenciaCarril;
        this.numBolsasAire = numBolsasAire;
    }
    
    /**
     * Método que muestra el valor de cada dato
     * @return 
     */
    @Override
    public String toString() {
        return  super.toString() +", tiene velocidad crucero = " + velocidadCrucero + ", tiene sensor de colision = " + sensorColision + ", tiene sensor de trafico cruzado = " + sensorTraficoCruzado + ", tiene asistente de permanencia en el carril = " + asistentePermanenciaCarril + ", numero de bolsas de aire = " + numBolsasAire;
    }
    
    //----------------------------------------------------------------------------------------------//
    //----------------------------------------------------------------------------------------------//
    
    //Métodos Getters and Setters
    
    public boolean getVelocidadCrucero() {
        return velocidadCrucero;
    }

    public void setVelocidadCrucero(boolean velocidadCrucero) {
        this.velocidadCrucero = velocidadCrucero;
    }

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

    public int getNumBolsasAire() {
        return numBolsasAire;
    }

    public void setNumBolsasAire(int numBolsasAire) {
        this.numBolsasAire = numBolsasAire;
    }

    //----------------------------------------------------------------------------------------------// 
    //----------------------------------------------------------------------------------------------// 
    
}
