package proyectofinaljavafx.Model;

public class VehiculoExtra extends Vehiculo{
    
    private int cambios;
    
    public VehiculoExtra(String marca,String modelo, Estado estado, double velocidadMaxima , double cilindraje, Transmision transmision,int cambios){
        super(marca, modelo, estado, velocidadMaxima, cilindraje, transmision);
        this.cambios=cambios;
        
    }

    public int getCambios() {
        return cambios;
    }

    public void setCambios(int cambios) {
        this.cambios = cambios;
    }

    @Override
    public String toString() {
        return super.toString() + "cambios = " + cambios;
    }
    
    
    
}
