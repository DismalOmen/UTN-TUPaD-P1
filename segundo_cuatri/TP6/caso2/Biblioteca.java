import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Biblioteca {
    private String nombre;
    private ArrayList<Libro> libros;
    
    // Constructor
    public Biblioteca(String nombre) {
        this.nombre = nombre;
        this.libros = new ArrayList<>();
    }
    
    // Getters
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    // Agregar libro a la biblioteca
    public void agregarLibro(String isbn, String titulo, int anioPublicacion, Autor autor) {
        // Verificar si el ISBN ya existe
        if (buscarLibroPorIsbn(isbn) != null) {
            System.out.println("Error: Ya existe un libro con el ISBN " + isbn);
            return;
        }
        
        Libro nuevoLibro = new Libro(isbn, titulo, anioPublicacion, autor);
        libros.add(nuevoLibro);
        System.out.println("Libro agregado exitosamente: " + titulo);
    }
    
    // Método sobrecargado para agregar libro directamente con objeto Libro
    public void agregarLibro(Libro libro) {
        if (buscarLibroPorIsbn(libro.getIsbn()) != null) {
            System.out.println("Error: Ya existe un libro con el ISBN " + libro.getIsbn());
            return;
        }
        libros.add(libro);
        System.out.println("Libro agregado exitosamente: " + libro.getTitulo());
    }
    
    // Listar todos los libros
    public void listarLibros() {
        if (libros.isEmpty()) {
            System.out.println("No hay libros en la biblioteca '" + nombre + "'");
            return;
        }
        
        System.out.println("=== LIBROS EN LA BIBLIOTECA: " + nombre.toUpperCase() + " ===");
        for (int i = 0; i < libros.size(); i++) {
            Libro libro = libros.get(i);
            System.out.println((i + 1) + ". " + libro.getTitulo() + 
                             " (ISBN: " + libro.getIsbn() + 
                             ", " + libro.getAnioPublicacion() + ") - " + 
                             libro.getAutor().getNombre());
        }
        System.out.println("===================================================");
    }
    
    // Buscar libro por ISBN
    public Libro buscarLibroPorIsbn(String isbn) {
        for (Libro libro : libros) {
            if (libro.getIsbn().equals(isbn)) {
                return libro;
            }
        }
        return null; // No encontrado
    }
    
    // Eliminar libro por ISBN
    public boolean eliminarLibro(String isbn) {
        Libro libro = buscarLibroPorIsbn(isbn);
        if (libro != null) {
            libros.remove(libro);
            System.out.println("Libro eliminado: " + libro.getTitulo());
            return true;
        } else {
            System.out.println("Error: No se encontro un libro con ISBN " + isbn);
            return false;
        }
    }
    
    // Obtener cantidad de libros
    public int obtenerCantidadLibros() {
        return libros.size();
    }
    
    // Filtrar libros por año
    public List<Libro> filtrarLibrosPorAnio(int anio) {
        List<Libro> librosFiltrados = new ArrayList<>();
        for (Libro libro : libros) {
            if (libro.getAnioPublicacion() == anio) {
                librosFiltrados.add(libro);
            }
        }
        return librosFiltrados;
    }
    
    // Mostrar autores disponibles
    public void mostrarAutoresDisponibles() {
        if (libros.isEmpty()) {
            System.out.println("No hay libros en la biblioteca, por lo tanto no hay autores disponibles.");
            return;
        }
        
        // Usar Set para evitar duplicados
        Set<Autor> autoresUnicos = new HashSet<>();
        for (Libro libro : libros) {
            autoresUnicos.add(libro.getAutor());
        }
        
        System.out.println("=== AUTORES DISPONIBLES EN LA BIBLIOTECA ===");
        int contador = 1;
        for (Autor autor : autoresUnicos) {
            System.out.println(contador + ". " + autor.getNombre() + " - " + autor.getNacionalidad());
            contador++;
        }
        System.out.println("============================================");
    }
    
    // Método para obtener todos los autores (útil para otras operaciones)
    public Set<Autor> obtenerAutoresUnicos() {
        Set<Autor> autoresUnicos = new HashSet<>();
        for (Libro libro : libros) {
            autoresUnicos.add(libro.getAutor());
        }
        return autoresUnicos;
    }
    
    // Método toString
    @Override
    public String toString() {
        return "Biblioteca: " + nombre + " (Libros: " + libros.size() + ")";
    }
}