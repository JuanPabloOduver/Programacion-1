package co.edu.uniquindio.poo;
import java.time.LocalDate;

public class Libro {
    
    private String code, ISBN, titulo, editorial;
    private LocalDate fechaPublicacion;
    private int unidadesDisponibles;
    private EstadoLibro estado;
    private Autor autor;
    

    public Libro(String code, String ISBN, Autor autor, String titulo, String editorial, LocalDate fechaPublicacion, int unidadesDisponibles, EstadoLibro estado) {
        this.code = code;
        this.ISBN = ISBN;
        this.autor = autor;
        this.titulo = titulo;
        this.editorial = editorial;
        this.fechaPublicacion = fechaPublicacion;
        this.unidadesDisponibles = unidadesDisponibles;
        this.estado=estado;
    }
    
    public void aumentarUnidades(int num){
        this.unidadesDisponibles+=num;
    }
    
    public void disminuirUnidades(int num){
        this.unidadesDisponibles-=num;
    }
    
    

    public EstadoLibro getEstado() {
        return estado;
    }
    
    public String getCode() {
        return code;
    }

    public String getISBN() {
        return ISBN;
    }

    public Autor getAutor() {
        return autor;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getEditorial() {
        return editorial;
    }

    public LocalDate getFechaPublicacion() {
        return fechaPublicacion;
    }

    public int getUnidadesDisponibles() {
        return unidadesDisponibles;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public void setEstado(EstadoLibro estado) {
        this.estado = estado;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public void setFechaPublicacion(LocalDate fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }

    public void setUnidadesDisponibles(int unidadesDisponibles) {
        this.unidadesDisponibles=unidadesDisponibles;
    }

    @Override
    public String toString() {
        return "Libro{" + "code=" + code + ", ISBN=" + ISBN + ", autor=" + autor + ", titulo=" + titulo + ", editorial=" + editorial + ", fechaPublicacion=" + fechaPublicacion + ", unidadesDisponibles=" + unidadesDisponibles + ", estado: "+ estado+ '}';
    }
    
    
    
}