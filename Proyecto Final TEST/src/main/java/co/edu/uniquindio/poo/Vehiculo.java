package co.edu.uniquindio.poo;

import java.util.Arrays;
import java.util.Scanner;

public class Vehiculo {

    //----------------------------------------------------------------------------------------------//
    //----------------------------------------------------------------------------------------------//
    
    //Atributos de la clase
    
    private String marca, modelo, placa;
    private Disponibilidad disponibilidad;
    private char [] cambios;
    private double velocidadMaxima, cilindraje;
    private Transmision transmision;
    private Combustible combustible;
    private Estado estado;
    
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
    public Vehiculo(String placa,String marca,Estado estado,String modelo, double velocidadMaxima , double cilindraje, Transmision transmision, Combustible combustible){
        this.marca=marca;
        this.modelo=modelo;
        this.estado=estado;
        this.disponibilidad=Disponibilidad.VEHICULO_DISPONIBLE;
        this.velocidadMaxima=velocidadMaxima;
        this.cilindraje=cilindraje;
        this.transmision=transmision;
        this.combustible=combustible;
        this.placa=placa;
        if (transmision == Transmision.MANUAL){
            solicitarCambiosManual();
            
        }
    }

    /**
     * Método que crea un array de cambios del vehiculo
     */
    private void solicitarCambiosManual() {
        try (Scanner s = new Scanner(System.in) // Cerramos el Scanner
        ) {
            System.out.print("Ingrese el número máximo de cambios: ");
            int MaxCambio = s.nextInt();
            cambios = new char[MaxCambio + 1];
            
            // Asignamos 'R' para reversa y números para los cambios
            cambios[0] = 'R'; // Reversa
            for (int i = 1; i <= MaxCambio; i++) {
                cambios[i] = (char) ('0' + i); // Asignamos '1', '2', '3'...
            }
        } catch (Exception e) {
            System.out.println("Error al ingresar los cambios. Por favor, intente de nuevo.");
        }
    }
    
    /**
     * Método que muestra el valor de cada dato
     * @return 
     */
    @Override
    public String toString() {
        return getClass().getSimpleName()+ "= Placa ="+placa+", estado de uso = "+estado+", marca = " + marca + ", modelo = " + modelo  + ", disponibilidad del vehículo = " + disponibilidad + ", velocidad maxima = " + velocidadMaxima +", cilindraje =  "+ cilindraje + ", trasmision = " + transmision +", tipo de combustible = " + combustible+ ", cambios = " + Arrays.toString(cambios);
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

    public void setCambios(int cambioMax) {
        Scanner s = new Scanner(System.in);
        
        char [] cambio = new char[cambioMax+1];
        
        try {            
            // Asignamos 'R' para reversa y números para los cambios
            cambio[0] = 'R'; // Reversa
            for (int i = 1; i <= cambioMax; i++) {
                cambio[i] = (char) ('0' + i); // Asignamos '1', '2', '3'...
            }
        } finally {
            s.close(); // Cerramos el Scanner
        }
        this.cambios=cambio;
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

    public Disponibilidad getDisponibilidad() {
        return disponibilidad;
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

    public void setDisponibilidad(Disponibilidad disponibilidad) {
        this.disponibilidad = disponibilidad;
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

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }
    
    //----------------------------------------------------------------------------------------------//
    //----------------------------------------------------------------------------------------------//
    
}
