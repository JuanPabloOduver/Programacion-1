package proyectofinaljavafx.Model;

public class VehiculoCargaPasajeros extends Vehiculo{
    
    private boolean abs,aireAcondicionado,camaraReversa;
    private int numPasajeros;
    private double capacidad;
    
    
    public VehiculoCargaPasajeros(String marca,String modelo, Estado estado, double velocidadMaxima , double cilindraje, Transmision transmision,boolean abs, boolean aireAcondicionado,boolean camaraReversa,int numPasajeros,double capacidad){
        super(marca, modelo, estado, velocidadMaxima, cilindraje, transmision);
        
        this.abs=abs;
        this.aireAcondicionado=aireAcondicionado;
        this.camaraReversa=camaraReversa;
        this.numPasajeros=numPasajeros;
        this.capacidad=capacidad;
        
    }

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

    @Override
    public String toString() {
        return super.toString() + ", tiene abs = " + abs + ", tiene aire acondicionado = " + aireAcondicionado + ", tiene camara reversa = " + camaraReversa + ", numero de pasajeros = " + numPasajeros + ", capacidad de carga= " + capacidad;
    }
    
    
    
}
