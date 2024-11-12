package proyectofinaljavafx.Model;

public class Alquiler extends AccionesVehiculo{
    
    //----------------------------------------------------------------------------------------------//
    //----------------------------------------------------------------------------------------------//
    
    //Atributos de la clase
    
    private int diasAlquiler;
    
    //----------------------------------------------------------------------------------------------//
    //----------------------------------------------------------------------------------------------//
    
    //Métodos de la clase
    
    /**
     * Método constructor de la clase
     * @param diasAlquiler
                                                                                                                                                                                                                                                                                         */
    public Alquiler(Empleado empleado, Cliente cliente, Vehiculo vehiculo, int diasAlquiler , double costo){
        super(vehiculo, empleado, cliente, costo);
        
        this.diasAlquiler=diasAlquiler;
    }
    
    /**
     * Método que muestra el valor de cada dato
     * @return 
     */
        @Override
    public String toString() {
        return super.toString() + ", dias que dura el alquiler = " + diasAlquiler  ;
    }
    
    //----------------------------------------------------------------------------------------------//
    //----------------------------------------------------------------------------------------------//
    
    //Métodos Getters and Setters

    public int getDiasAlquiler() {
        return diasAlquiler;
    }

    public void setDiasAlquiler(int diasAlquiler) {
        this.diasAlquiler = diasAlquiler;
    }

    //----------------------------------------------------------------------------------------------//
    //----------------------------------------------------------------------------------------------//
    
}
