package co.edu.uniquindio.poo.model;

public class Deportivo extends Vehiculo {
    
    //----------------------------------------------------------------------------------------------//
    //----------------------------------------------------------------------------------------------//
    
    //Atributos de la clase
    
    private int numPasajeros,numPuertas,numBolsasAire,numCaballosFuerza;
    private double tiempoAlcanza100Km;

    //----------------------------------------------------------------------------------------------//
    //----------------------------------------------------------------------------------------------//
    
    //Métodos de la clase

    /**
     * Método constructor de la clase
     * @param numPasajeros
     * @param numPuertas
     * @param numBolsasAire
     * @param numCaballosFuerza
     * @param tiempoAlcanza100Km
     * @param placa
     * @param marca
     * @param estado
     * @param modelo
     * @param velocidadMaxima
     * @param cilindraje
     * @param transmision
     * @param combustible 
     */
    public Deportivo(int numPasajeros, int numPuertas, int numBolsasAire, int numCaballosFuerza, double tiempoAlcanza100Km, String placa, String marca, Estado estado, String modelo, double velocidadMaxima, double cilindraje, Transmision transmision, Combustible combustible) {
        super(placa, marca, estado, modelo, velocidadMaxima, cilindraje, transmision, combustible);
        this.numPasajeros = numPasajeros;
        this.numPuertas = numPuertas;
        this.numBolsasAire = numBolsasAire;
        this.numCaballosFuerza = numCaballosFuerza;
        this.tiempoAlcanza100Km = tiempoAlcanza100Km;
    }

    /**
     * Método que muestra el valor de cada dato
     * @return 
     */
    @Override
    public String toString() {
        return super.toString() + ", capacidad de pasajeros = " + numPasajeros + ", cantidad de puertas = " + numPuertas + ", número de bolsas de aire = " + numBolsasAire + ", numero de caballos de fuerza = " + numCaballosFuerza + ", tiempo en el que alcanza los 100Km = " + tiempoAlcanza100Km + 's';
    }
    
    //----------------------------------------------------------------------------------------------//
    //----------------------------------------------------------------------------------------------//
    
    //Métodos Getters and Setters
    
    public int getNumPasajeros() {
        return numPasajeros;
    }

    public void setNumPasajeros(int numPasajeros) {
        this.numPasajeros = numPasajeros;
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

    public int getNumCaballosFuerza() {
        return numCaballosFuerza;
    }

    public void setNumCaballosFuerza(int numCaballosFuerza) {
        this.numCaballosFuerza = numCaballosFuerza;
    }

    public double getTiempoAlcanza100Km() {
        return tiempoAlcanza100Km;
    }

    public void setTiempoAlcanza100Km(double tiempoAlcanza100Km) {
        this.tiempoAlcanza100Km = tiempoAlcanza100Km;
    }

    //----------------------------------------------------------------------------------------------//
    //----------------------------------------------------------------------------------------------//
    
}
