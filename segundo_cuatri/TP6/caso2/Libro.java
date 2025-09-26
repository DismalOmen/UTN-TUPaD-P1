public class Libro {
    private String isbn;
    private String titulo;
    private int anioPublicacion;
    private Autor autor;
    
    // Constructor
    public Libro(String isbn, String titulo, int anioPublicacion, Autor autor) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.anioPublicacion = anioPublicacion;
        this.autor = autor;
    }
    
    // Getters y Setters
    public String getIsbn() {
        return isbn;
    }
    
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
    
    public String getTitulo() {
        return titulo;
    }
    
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    
    public int getAnioPublicacion() {
        return anioPublicacion;
    }
    
    public void setAnioPublicacion(int anioPublicacion) {
        this.anioPublicacion = anioPublicacion;
    }
    
    public Autor getAutor() {
        return autor;
    }
    
    public void setAutor(Autor autor) {
        this.autor = autor;
    }
    
    // Método para mostrar información del libro
    public void mostrarInfo() {
        System.out.println("=== INFORMACION DEL LIBRO ===");
        System.out.println("ISBN: " + isbn);
        System.out.println("Titulo: " + titulo);
        System.out.println("Año de publicacion: " + anioPublicacion);
        System.out.println("Autor: " + autor.getNombre() + " - " + autor.getNacionalidad());
        System.out.println("=============================");
    }
    
    // Método toString
    @Override
    public String toString() {
        return titulo + " (ISBN: " + isbn + ", " + anioPublicacion + ") - " + autor.getNombre();
    }
}