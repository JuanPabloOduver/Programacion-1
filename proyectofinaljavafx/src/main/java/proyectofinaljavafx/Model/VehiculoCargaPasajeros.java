package proyectofinaljavafx.Model;

public class VehiculoCargaPasajeros extends Vehiculo{
    
    //----------------------------------------------------------------------------------------------//
    //----------------------------------------------------------------------------------------------//

    //Atributos de la clase
    
    private boolean abs,aireAcondicionado,camaraReversa;
    private int numPasajeros;
    private double capacidad;
    
    //----------------------------------------------------------------------------------------------//
    //----------------------------------------------------------------------------------------------//
    
    //Métodos de la clase
    
    /**
     * Método constructor de la clase
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
    public VehiculoCargaPasajeros(String placa,String marca,String modelo, Estado estado, double velocidadMaxima , double cilindraje, Transmision transmision, Combustible combustible,boolean abs, boolean aireAcondicionado,boolean camaraReversa,int numPasajeros,double capacidad){
        super(placa,marca, modelo, estado, velocidadMaxima, cilindraje, transmision,combustible);
        
        this.abs=abs;
        this.aireAcondicionado=aireAcondicionado;
        this.camaraReversa=camaraReversa;
        this.numPasajeros=numPasajeros;
        this.capacidad=capacidad;
    }
    
    /**
     * Método que muestra el valor de cada dato
     * @return 
     */
    @Override
    public String toString() {
        return super.toString() + ", tiene abs = " + abs + ", tiene aire acondicionado = " + aireAcondicionado + ", tiene camara reversa = " + camaraReversa + ", numero de pasajeros = " + numPasajeros + ", capacidad de carga= " + capacidad;
    }
    
    //----------------------------------------------------------------------------------------------//
    //----------------------------------------------------------------------------------------------//
    
    //Métodos Getters and Setters
    
    public boolean isAbs() {
        return abs;
    }

    public void setAbs(boolean abs) {
        this.abs = abs;
    }

    public boolean isAireAcondicionado() {
        return aireAcondicionado;
    }

    public void setAireAcondicionado(boolean aireAcondicionado) {
        this.aireAcondicionado = aireAcondicionado;
    }

    public boolean isCamaraReversa() {
        return camaraReversa;
    }

    public void setCamaraReversa(boolean camaraReversa) {
        this.camaraReversa = camaraReversa;
    }

    public int getNumPasajeros() {
        return numPasajeros;
    }

    public void setNumPasajeros(int numPasajeros) {
        this.numPasajeros = numPasajeros;
    }

    public double getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(double capacidad) {
        this.capacidad = capacidad;
    }

    //----------------------------------------------------------------------------------------------//
    //----------------------------------------------------------------------------------------------//
    
}
