package co.edu.uniquindio.poo;

import java.util.Scanner;

public class Hibrido extends Vehiculo {

    //----------------------------------------------------------------------------------------------//
    //----------------------------------------------------------------------------------------------//
    
    //Atributos de la clase
    
    private boolean esEnchufable,HibridoLigero;
    
    //----------------------------------------------------------------------------------------------//
    //----------------------------------------------------------------------------------------------//
    
    //Métodos de la clase

    /**
     * Mètodo constructor de la clase
     * @param placa
     * @param marca
     * @param estado
     * @param modelo
     * @param velocidadMaxima
     * @param cilindraje
     * @param transmision
     * @param combustible
     * @param esEnchufable
     */
    public Hibrido(String placa,String marca,Estado estado,String modelo, double velocidadMaxima , double cilindraje, Transmision transmision, Combustible combustible, boolean esEnchufable){
        super(placa,marca,estado,modelo,velocidadMaxima,cilindraje,transmision,combustible);
        this.esEnchufable=esEnchufable;
        if(!esEnchufable){
            this.HibridoLigero=determinarEsHibridoLigero();
        }
    }

    /*+
     * Mètodo que pregunta al usuario si el vehìculo es de tipo ligero y lo convierte a booleano segùn su respuesta.
     * @return centinela
     */
    public boolean determinarEsHibridoLigero(){
        boolean centinela=false;
        Scanner s = new Scanner(System.in);

        System.out.print("¿Su vehìculo es hìbrido ligero? Y / N : ");
        char respuesta= s.nextLine().charAt(0);
        if( Character.toUpperCase(respuesta) == 'Y'){
            centinela=true;
        }
        
        return centinela;
    }

    
    /**
     * Método que muestra el valor de cada dato
     * @return
     */
    @Override
    public String toString() {
        return super.toString() + ", ¿es enchufable?: " + (esEnchufable ? "Sí" : "No") +
        ", ¿es hìbrido ligero?: " + (HibridoLigero ? "Sì": "No");
    }
    
    //----------------------------------------------------------------------------------------------//
    //----------------------------------------------------------------------------------------------//
    
    //Métodos Getters and Setters

    public boolean getesEnchufable() {
        return esEnchufable;
    }
    
    public boolean getHibridoLigero() {
        return HibridoLigero;
    }

    public void setEsEnchufable(boolean esEnchufable){
        this.esEnchufable=esEnchufable;
    }

    public void setHibridoLigero(boolean HibridoLigero){
        this.HibridoLigero=HibridoLigero;
    }
        
    //----------------------------------------------------------------------------------------------//
    //----------------------------------------------------------------------------------------------//
    
}