import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        System.out.println("INICIO DEL SISTEMA DE GESTION DE BIBLIOTECA\n");
        
        // TAREA 1: Crear una biblioteca
        System.out.println("TAREA 1: Crear una biblioteca");
        Biblioteca biblioteca = new Biblioteca("Biblioteca Central");
        System.out.println("Biblioteca creada: " + biblioteca.toString());
        
        System.out.println();
        
        // TAREA 2: Crear al menos tres autores
        System.out.println("TAREA 2: Crear autores");
        Autor autor1 = new Autor("A001", "Gabriel Garcia Marquez", "Colombiana");
        Autor autor2 = new Autor("A002", "Isabel Allende", "Chilena");
        Autor autor3 = new Autor("A003", "Jorge Luis Borges", "Argentina");
        Autor autor4 = new Autor("A004", "Mario Vargas Llosa", "Peruana");
        
        System.out.println("Autores creados exitosamente:");
        autor1.mostrarInfo();
        autor2.mostrarInfo();
        autor3.mostrarInfo();
        autor4.mostrarInfo();
        
        System.out.println();
        
        // TAREA 3: Agregar 5 libros asociados a los autores
        System.out.println("TAREA 3: Agregar libros a la biblioteca");
        
        biblioteca.agregarLibro("978-8437604947", "Cien anos de soledad", 1967, autor1);
        biblioteca.agregarLibro("978-8408018506", "La casa de los espiritus", 1982, autor2);
        biblioteca.agregarLibro("978-8478884452", "Ficciones", 1944, autor3);
        biblioteca.agregarLibro("978-8466332941", "La ciudad y los perros", 1963, autor4);
        biblioteca.agregarLibro("978-0307474728", "El amor en los tiempos del colera", 1985, autor1);
        biblioteca.agregarLibro("978-0061122415", "Eva Luna", 1987, autor2);
        
        System.out.println();
        
        // TAREA 4: Listar todos los libros con su información y la del autor
        System.out.println("TAREA 4: Listar todos los libros");
        biblioteca.listarLibros();
        
        System.out.println();
        
        // TAREA 5: Buscar un libro por su ISBN y mostrar su información
        System.out.println("TAREA 5: Buscar libro por ISBN (978-8437604947)");
        Libro libroEncontrado = biblioteca.buscarLibroPorIsbn("978-8437604947");
        if (libroEncontrado != null) {
            libroEncontrado.mostrarInfo();
        } else {
            System.out.println("Libro no encontrado");
        }
        
        System.out.println();
        
        // TAREA 6: Filtrar y mostrar los libros publicados en un año específico
        System.out.println("TAREA 6: Filtrar libros del año 1985");
        List<Libro> libros1985 = biblioteca.filtrarLibrosPorAnio(1985);
        System.out.println("=== LIBROS PUBLICADOS EN 1985 ===");
        if (libros1985.isEmpty()) {
            System.out.println("No hay libros publicados en 1985");
        } else {
            for (Libro libro : libros1985) {
                libro.mostrarInfo();
            }
        }
        
        System.out.println();
        
        // TAREA 7: Eliminar un libro por su ISBN y listar los libros restantes
        System.out.println("TAREA 7: Eliminar libro (978-8478884452) y listar restantes");
        biblioteca.eliminarLibro("978-8478884452");
        System.out.println("\nLibros despues de la eliminacion:");
        biblioteca.listarLibros();
        
        System.out.println();
        
        // TAREA 8: Mostrar la cantidad total de libros en la biblioteca
        System.out.println("TAREA 8: Mostrar cantidad total de libros");
        int cantidadLibros = biblioteca.obtenerCantidadLibros();
        System.out.println("Cantidad total de libros en la biblioteca: " + cantidadLibros);
        
        System.out.println();
        
        // TAREA 9: Listar todos los autores de los libros disponibles
        System.out.println("TAREA 9: Listar autores disponibles");
        biblioteca.mostrarAutoresDisponibles();
        
        System.out.println();
        
    }
}