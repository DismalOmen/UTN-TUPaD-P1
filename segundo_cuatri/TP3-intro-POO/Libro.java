public class Libro {
    private String titulo;
    private String autor;
    private int anioPublicacion;

    public Libro(String titulo, String autor, int anio) {
        this.titulo = titulo;
        this.autor = autor;
        setAnioPublicacion(anio);
    }

    public String getTitulo() { return titulo; }
    public String getAutor() { return autor; }
    public int getAnioPublicacion() { return anioPublicacion; }

    public void setAnioPublicacion(int anio) {
        if(anio > 0) this.anioPublicacion = anio;
        else System.out.println("Anio invalido");
    }

    public void mostrarInfo() {
        System.out.println(titulo + " por " + autor + ", Anioo: " + anioPublicacion);
    }

    public static void main(String[] args) {
        Libro libro = new Libro("1984", "George Orwell", 1949);
        libro.mostrarInfo();
        libro.setAnioPublicacion(-2025); // inválido
        libro.setAnioPublicacion(1950);  // válido
        libro.mostrarInfo();
    }
}
