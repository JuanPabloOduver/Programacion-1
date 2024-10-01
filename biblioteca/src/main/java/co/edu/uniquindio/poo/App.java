package co.edu.uniquindio.poo;
import java.time.LocalDate;
public class App {

    public static void main(String[] args) {
        Autor autor=new Autor("Dan", "222", "h", 0);
        
        Libro libro=new Libro("20", "21", autor, "hola", "j", LocalDate.EPOCH, 2, EstadoLibro.DISPONIBLE);
        
        Bibliotecario bibliotecario=new Bibliotecario("jao", "12", "g", 0, 0, 0);
        
        Estudiante estudiante= new Estudiante("aos", "a", "21", 0, 0);
        
        Biblioteca biblioteca=new Biblioteca("20", "H", "bib");
        
        biblioteca.agregarLibro(libro);
        
        biblioteca.agregarBibliotecario(bibliotecario);
        
        Prestamo prestamo= new Prestamo(LocalDate.EPOCH, LocalDate.MIN, bibliotecario, estudiante, "201");
        
        DetallePrestamo detalle= new DetallePrestamo(82, libro, 9200);
        
        prestamo.agregarDetallePrestamo(detalle);
        
        
        biblioteca.AlumnoConMasPrestamos();
        
        System.out.println(estudiante);
        
        System.out.println(prestamo);
        
        System.out.println(biblioteca.getGanancias());
        

    }
    
}
