package proyectofinaljavafx.Model;

public abstract class Vehiculo {
    private String marca;
    private String modelo;
    private Estado estado;
    private double velocidadMaxima,cilindraje;
    private Transmision transmision;
    

    public Vehiculo(String marca,String modelo, Estado estado, double velocidadMaxima , double cilindraje, Transmision transmision){
        this.marca=marca;
        this.modelo=modelo;
        this.estado=estado;
        this.velocidadMaxima=velocidadMaxima;
        this.cilindraje=cilindraje;
        this.transmision=transmision;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public Estado getEstado() {
        return estado;
    }

    public double getVelocidadMaxima() {
        return velocidadMaxima;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public void setVelocidadMaxima(double velocidadMaxima) {
        this.velocidadMaxima = velocidadMaxima;
    }

    public Transmision getTransmision() {
        return transmision;
    }

    public void setTransmision(Transmision transmision) {
        this.transmision = transmision;
    }

    public double getCilindraje() {
        return cilindraje;
    }

    public void setCilindraje(double cilindraje) {
        this.cilindraje = cilindraje;
    }
    
    @Override
    public String toString() {
        return getClass()+ "= marca = " + marca + ", modelo = " + modelo  + ", estado del vehículo = " + estado + ", velocidad maxima = " + velocidadMaxima +", cilindraje =  "+ cilindraje + ", trasmision = " + transmision ;
    }
    
}
