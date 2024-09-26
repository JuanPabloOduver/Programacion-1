package co.edu.uniquindio.poo;

public class Bibliotecario extends Persona{
    private double salario;
    private int antiguedad;

    public Bibliotecario (String nombre, String cedula, String correo, int telefono, double salario, int antiguedad){
            super(nombre, cedula, correo, telefono);
            this.salario = salario; 
            this.antiguedad = antiguedad; 
        }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public int getAntiguedad() {
        return antiguedad;
    }

    public void setAntiguedad(int antiguedad) {
        this.antiguedad = antiguedad;
    }

    @Override
    public String toString() {
        return "Bibliotecario [nombre=" + nombre + ", salario=" + salario + ", cedula=" + cedula + ", antiguedad="
                + antiguedad + ", correo=" + correo + ", telefono=" + telefono + "]";
    }

}

