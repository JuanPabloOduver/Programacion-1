package co.edu.uniquindio.poo;
import java.time.LocalDate;

public class App {

    public static void main(String[] args) {

        
        
        
        //Creamos (estudiante,bibliotecario,biblioteca,autor,libro,prestamo,detalleprestamo)
        Autor autor = new Autor("Dan", "222", "h", 0);

        Libro libro = new Libro("20", "21", autor, "hola", "j", LocalDate.EPOCH, 2, EstadoLibro.DISPONIBLE);

        Bibliotecario bibliotecario = new Bibliotecario("Gabriela", "1212", "g@", 10902, 20000, 9);

        Bibliotecario bibliotecario2 = new Bibliotecario("Gabriel", "112", "ge@", 19243, 17000, 4);

        Estudiante estudiante = new Estudiante("Jose", "190", "j@", 3201, 34);

        Estudiante estudiante2 = new Estudiante("Jairo", "8912", "jo@", 4103, 26);

        Prestamo prestamo = new Prestamo(LocalDate.EPOCH, LocalDate.MIN, bibliotecario, estudiante, "201");

        DetallePrestamo detalle = new DetallePrestamo(10, libro, 9200);

        Biblioteca biblioteca = new Biblioteca("20145", "direccionficticia cra2", "Crae");
        
        Libro libro1 = libro;

        libro1.setCode("120");
        
        libro1.setUnidadesDisponibles(4);


        
        
        
        //añadimos a las listas los libros, estudiante,bibliotecario,detalleprestamo
        biblioteca.agregarLibro(libro);

        biblioteca.agregarBibliotecario(bibliotecario);

        biblioteca.agregarBibliotecario(bibliotecario2);

        biblioteca.agregarEstudiante(estudiante);

        biblioteca.agregarEstudiante(estudiante2);

        prestamo.agregarDetallePrestamo(detalle);

        bibliotecario.añadirPrestamo(prestamo);
        
        estudiante.añadirPrestamo(prestamo);
        
        
        
        // buscar estudiante, bibliotecario,libro en los datos 
        biblioteca.buscarEstudiante("a");
        
        biblioteca.buscarBibliotecario("20");
        
        biblioteca.buscarLibro(libro.getISBN());

        
        
        
        //imprime la lista de prestamos de bibliotecario
        biblioteca.prestamosBibliotecario(bibliotecario.getCedula());
        
        
        
        
        //Sobreescribir un libro
        biblioteca.sobreescribirLibro(libro1.getISBN(), libro1);

        System.out.println(libro);
        
        
        
        //costo subtotal prestamo
        System.out.println("Costo subtotal del prestamo: "+detalle.getCosteSubtotal());
        
        
        
        //costo total prestamo
        System.out.println("Costo total del prestamo: "+prestamo.getCostoTotal());
        
        //disminuir unidades libro
        System.out.println(libro.getUnidadesDisponibles());
        biblioteca.disminuirUnidadesLibro(libro, 1);
        System.out.println(libro.getUnidadesDisponibles());
        biblioteca.disminuirUnidadesLibro(libro, 5);
        System.out.println(libro.getUnidadesDisponibles());
    }

    public static void imprimir(String mensaje) {
        System.out.println(mensaje);
    }
}
