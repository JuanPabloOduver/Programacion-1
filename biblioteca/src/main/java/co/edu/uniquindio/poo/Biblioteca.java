package co.edu.uniquindio.poo;
import java.util.LinkedList;
import java.util.Scanner;

public class Biblioteca {

    public String telefono, direccion, nombre;
    private LinkedList<Estudiante> estudiantes;
    private LinkedList<Bibliotecario> bibliotecarios;
    private LinkedList<Libro> libros;
    private double ganancias;
    private int capacidadLibros;
    private int cantidadLibros;
    private LinkedList<Prestamo> prestamos;

    public Biblioteca(String telefono, String direccion, String nombre) {
        this.telefono = telefono;
        this.direccion = direccion;
        this.nombre = nombre;
        this.ganancias = 0;
        estudiantes = new LinkedList<Estudiante>();
        bibliotecarios = new LinkedList<Bibliotecario>();
        libros = new LinkedList<>();
        prestamos = new LinkedList<>();
    }

    public LinkedList<Estudiante> AlumnoConMasPrestamos(){
        LinkedList<Estudiante> estudiantesMayorPrestamos=new LinkedList<>();
        int mayorPrestamo=0;
        for (Estudiante estudiante : estudiantes) {
            if(estudiante.getCantidadPrestamos()>mayorPrestamo){
                mayorPrestamo=estudiante.getCantidadPrestamos();
                estudiantesMayorPrestamos.clear();
                estudiantesMayorPrestamos.add(estudiante);
            } else if(estudiante.getCantidadPrestamos()==mayorPrestamo){
                estudiantesMayorPrestamos.add(estudiante);
            }
        }
        
        return estudiantesMayorPrestamos;
    }
    
    public double calcularGanancia() {
        double Ganancia = 0;
        if (prestamos != null) {
            for (Prestamo prestamo : prestamos) {
                Ganancia += prestamo.calcularCosteTotal(); 
            }
        }
        return Ganancia;
    }
    
    
    public void pagarEmpleado(){
        
    }
    /**
     * Metodo que almacena cada prestamo en las clases biblioteca ,estudiante,
     * bibliotecario
     *
     * @param prestamo
     */
    public void crearPrestamo(Prestamo prestamo) {
        prestamos.add(prestamo);
        ganancias = calcularGanancia();
        if (verificarBibliotecario(prestamo.getBibliotecario().getCedula())) {
            prestamo.getBibliotecario().añadirPrestamo(prestamo);
        }
    }

    public void getPrestamosBibliotecario(Bibliotecario bibliotecario) {
        if (verificarBibliotecario(bibliotecario.getCedula())) {
            System.out.println(bibliotecario.getPrestamos());
        }
    }

    /**
     * Metodo que consulta los datos de un libro segun su codigo ISBN
     *
     * @param ISBN
     * @return libro
     */
    public void consultarLibro(String ISBN) {
        if (verificarLibro(ISBN)) {
            for (Libro libro : libros) {

                if (libro.getISBN().equals(ISBN)) {
                    System.out.println("El libro que buscas con el ISBN /" + ISBN + "/ quizas sea: " + libro.toString());
                    break;

                }
            }
        } else {
            System.out.println("No hay libros con el isbn: " + ISBN);
        }
    }

    /**
     * Verifica si un bibliotecario esta almacenado segun su cedula
     *
     * @param cedula
     * @return centinela
     */
    public boolean verificarBibliotecario(String cedula) {
        boolean c = false;
        for (Bibliotecario bibliotecario : bibliotecarios) {
            if (bibliotecario.getCedula().equals(cedula)) {
                c = true;
            }
        }
        return c;
    }

    /**
     * Agrega a un bibliotecario con su cedula en caso de no estar almacenado
     *
     * @param bibliotecario
     */
    public void agregarBibliotecario(Bibliotecario bibliotecario) {
        if (!verificarBibliotecario(bibliotecario.getCedula())) {
            bibliotecarios.add(bibliotecario);
        }
    }

    /**
     * Elimina a un bibliotecario con su cedula en caso que este almacenado
     *
     * @param bibliotecario
     */
    public void eliminarBibliotecario(Bibliotecario bibliotecario) {
        if (!verificarBibliotecario(bibliotecario.getCedula())) {
            bibliotecarios.remove(bibliotecario);
        }
    }

    /**
     * verifica si el estudiante esta almacenado con su cedula
     *
     * @param cedula
     * @return
     */
    public boolean verificarEstudiante(String cedula) {
        boolean c = false;
        for (Estudiante estudiante : estudiantes) {
            if (estudiante.getCedula().equals(cedula)) {
                c = true;
            }
        }
        return c;
    }

    /**
     * Elimina a un estudiante con su cedula en caso que este almacenado
     *
     * @param estudiante
     */
    public void agregarEstudiante(Estudiante estudiante) {
        if (!verificarBibliotecario(estudiante.getCedula())) {
            estudiantes.add(estudiante);
        }
    }

    /**
     * Elimina a un estudiante con su cedula en caso que este almacenado
     *
     * @param estudiante
     */
    public void eliminarEstudiante(Estudiante estudiante) {
        if (!verificarEstudiante(estudiante.getCedula())) {
            estudiantes.remove(estudiante);
        }
    }

    /**
     * verifica si el libro esta almacenado con su ISBN
     *
     * @param ISBN
     * @return centinela
     */
    public boolean verificarLibro(String ISBN) {
        boolean c = false;
        for (Libro libro : libros) {
            if (libro.getISBN().equals(ISBN)) {
                c = true;
            }
        }
        return c;
    }

    /**
     * Elimina a un libro con su ISBN en caso que este almacenado
     *
     * @param libro
     */
    public void agregarLibro(Libro libro) {

        Scanner s = new Scanner(System.in);

        if (!verificarLibro(libro.getISBN())) {

            libros.add(libro);
        } else {
            for (Libro libro1 : libros) {
                if (libro.getISBN().equals(libro1.getISBN())) {
                    System.out.print("Ingrese la cantidad de libros a agregar: ");
                    int num = s.nextInt();

                    libro1.aumentarUnidades(num);
                }

            }
        }
        s.close();
    }

    /**
     * Metodo que disminuye las unidades disponibles de cada libro
     *
     * @param libro
     */
    public void disminuirUnidadesLibro(Libro libro, int num) {
        if (verificarLibro(libro.getISBN())) {
            if (libro.getUnidadesDisponibles() - num >= 0) {
                libro.disminuirUnidades(num);
                System.out.println("Las unidades disponibles del libro " + libro.getTitulo() + "son : " + libro.getUnidadesDisponibles());
            } else {
                System.out.println("No se puede disminuir la cantidad dicha, ya que excede el 0");
            }
        }
    }

    public void buscarEstudiante(String cedula) {
        if (verificarEstudiante(cedula)) {
            boolean encontrado = false; // Para verificar si se encontró al estudiante
            for (Estudiante estudiante : estudiantes) {
                if (estudiante.getCedula().equals(cedula)) {
                    System.out.println(estudiante);
                    encontrado = true; // Marcamos que se encontró al menos un estudiante
                }
            }
            if (!encontrado) {
                System.out.println("No se encontró un estudiante con la cédula: " + cedula);
            }
        } else {
            System.out.println("No se encontró un estudiante con la cédula: " + cedula);
        }
    }

    public void buscarBibliotecario(String cedula) {
        if (verificarBibliotecario(cedula)) {
            boolean encontrado = false; // Para verificar si se encontró al estudiante
            for (Bibliotecario bibliotecario : bibliotecarios) {
                if (bibliotecario.getCedula().equals(cedula)) {
                    System.out.println(bibliotecario);
                    encontrado = true; // Marcamos que se encontró al menos un estudiante
                }
            }
            if (!encontrado) {
                System.out.println("No se encontró un bibliotecario con la cédula: " + cedula);
            }
        } else {
            System.out.println("No se encontró un bibliotecario con la cédula: " + cedula);
        }
    }

    public void buscarLibro(String ISBN) {
        if (verificarLibro(ISBN)) {
            boolean encontrado = false; // Para verificar si se encontró al estudiante
            for (Libro libro : libros) {
                if (libro.getISBN().equals(ISBN)) {
                    System.out.println(libro);
                    encontrado = true; // Marcamos que se encontró al menos un estudiante
                }
            }
            if (!encontrado) {
                System.out.println("No se encontró un libro con el ISBN: " + ISBN);
            }
        } else {
            System.out.println("No se encontró un libro con la ISBN: " + ISBN);
        }
    }

    public void sobreescribirLibro(String isbn, Libro libro) {
        if (verificarLibro(isbn)) {
            for (Libro libro1 : libros) {
                if (libro1.getISBN().equals(isbn)) {
                    libro1 = libro;
                }
            }
        }
    }

    public void prestamosBibliotecario(String cedula) {
        int numeroPrestamos = 0;
        for (Bibliotecario bibliotecario : bibliotecarios) {
            if (bibliotecario.getCedula().equals(cedula)) {
                numeroPrestamos = bibliotecario.getHistorialPrestamos().size();
                System.out.println("El bibliotecario " + bibliotecario.getNombre() + " Tiene " + numeroPrestamos + " prestamos.");
                break;
            }
        }

    }

    /**
     * Elimina a un libro con su ISBN en caso que este almacenado
     *
     * @param libro
     */
    public void eliminarLibro(Libro libro) {
        if (!verificarLibro(libro.getISBN())) {
            libros.remove(libro);
        }
    }

    public String getTelefono() {
        return telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LinkedList<Prestamo> getPrestamos() {
        return prestamos;
    }

    public void setPrestamos(LinkedList<Prestamo> prestamos) {
        this.prestamos = prestamos;
    }

    public double getGanancias() {
        return ganancias;
    }

    public void setGanancias(double ganancias) {
        this.ganancias = ganancias;
    }

    
    
    @Override
    public String toString() {
        return "Biblioteca{" + "telefono=" + telefono + ", direccion=" + direccion + ", nombre=" + nombre + ", estudiantes=" + estudiantes + ", bibliotecarios=" + bibliotecarios + ", libros=" + libros + ", ganancias=" + ganancias + ", capacidadLibros=" + capacidadLibros + ", cantidadLibros=" + cantidadLibros + ", prestamos=" + prestamos + '}';
    }

}