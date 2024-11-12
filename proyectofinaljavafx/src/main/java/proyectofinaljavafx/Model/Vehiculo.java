package proyectofinaljavafx.Model;

import java.util.Scanner;

public abstract class Vehiculo {

    //----------------------------------------------------------------------------------------------//
    //----------------------------------------------------------------------------------------------//
    
    //Atributos de la clase
    
    private String marca,modelo,placa;
    private Estado estado;
    private char [] cambios;
    private double velocidadMaxima,cilindraje;
    private Transmision transmision;
    private Combustible combustible;
    
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
     */
    public Vehiculo(String placa,String marca,String modelo, Estado estado, double velocidadMaxima , double cilindraje, Transmision transmision, Combustible combustible){
        this.marca=marca;
        this.modelo=modelo;
        this.estado=estado;
        this.velocidadMaxima=velocidadMaxima;
        this.cilindraje=cilindraje;
        this.transmision=transmision;
        this.combustible=combustible;
        this.placa=placa;
        if (transmision.equals( Transmision.MANUAL)) {
            Scanner s=new Scanner(System.in);
            System.out.print("Ingrese el número máximo de cambios: ");
            int MaxCambio=s.nextInt();
            
            cambios= new char[MaxCambio+1];
    
            cambios[0]= 'R';
            for (int i = 1; i <= MaxCambio; i++) {
                cambios[i]= (char) i;
            }
        }
        
    }

    /**
     * Método que muestra el valor de cada dato
     * @return 
     */
    @Override
    public String toString() {
        return getClass()+ "= Placa ="+placa+", marca = " + marca + ", modelo = " + modelo  + ", estado del vehículo = " + estado + ", velocidad maxima = " + velocidadMaxima +", cilindraje =  "+ cilindraje + ", trasmision = " + transmision +", tipo de combustible = " + combustible;
    }
    
    //----------------------------------------------------------------------------------------------//
    //----------------------------------------------------------------------------------------------//
    
    //Métodos Getters and Setters
    
    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public char[] getCambios() {
        return cambios;
    }

    public void setCambios(char[] cambios) {
        this.cambios = cambios;
    }

    public Combustible getCombustible() {
        return combustible;
    }

    public void setCombustible(Combustible combustible) {
        this.combustible = combustible;
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
    
    //----------------------------------------------------------------------------------------------//
    //----------------------------------------------------------------------------------------------//
    
}
