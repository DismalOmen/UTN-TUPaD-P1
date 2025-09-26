import java.util.ArrayList;
import java.util.List;

public class Profesor {
    private String id;
    private String nombre;
    private String especialidad;
    private List<Curso> cursos;
    
    // Constructor
    public Profesor(String id, String nombre, String especialidad) {
        this.id = id;
        this.nombre = nombre;
        this.especialidad = especialidad;
        this.cursos = new ArrayList<>();
    }
    
    // Getters y Setters
    public String getId() {
        return id;
    }
    
    public void setId(String id) {
        this.id = id;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getEspecialidad() {
        return especialidad;
    }
    
    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }
    
    public List<Curso> getCursos() {
        return new ArrayList<>(cursos); // Devolver copia para evitar modificaciones externas
    }
    
    // Agregar curso manteniendo la bidireccionalidad
    public void agregarCurso(Curso curso) {
        if (curso == null) {
            System.out.println("Error: El curso no puede ser nulo");
            return;
        }
        
        // Verificar si el curso ya está en la lista
        if (!cursos.contains(curso)) {
            cursos.add(curso);
            // Sincronizar el lado del curso
            if (curso.getProfesor() != this) {
                curso.setProfesor(this);
            }
            System.out.println("Curso '" + curso.getNombre() + "' agregado al profesor " + nombre);
        }
    }
    
    // Eliminar curso manteniendo la bidireccionalidad
    public void eliminarCurso(Curso curso) {
        if (curso == null) {
            System.out.println("Error: El curso no puede ser nulo");
            return;
        }
        
        if (cursos.contains(curso)) {
            cursos.remove(curso);
            // Sincronizar el lado del curso
            if (curso.getProfesor() == this) {
                curso.setProfesor(null);
            }
            System.out.println("Curso '" + curso.getNombre() + "' eliminado del profesor " + nombre);
        } else {
            System.out.println("El profesor " + nombre + " no dicta el curso '" + curso.getNombre() + "'");
        }
    }
    
    // Listar cursos del profesor
    public void listarCursos() {
        if (cursos.isEmpty()) {
            System.out.println("El profesor " + nombre + " no dicta ningún curso");
            return;
        }
        
        System.out.println("=== CURSOS DEL PROFESOR " + nombre.toUpperCase() + " ===");
        for (int i = 0; i < cursos.size(); i++) {
            Curso curso = cursos.get(i);
            System.out.println((i + 1) + ". " + curso.getCodigo() + " - " + curso.getNombre());
        }
    }
    
    // Mostrar información del profesor
    public void mostrarInfo() {
        System.out.println("=== INFORMACION DEL PROFESOR ===");
        System.out.println("ID: " + id);
        System.out.println("Nombre: " + nombre);
        System.out.println("Especialidad: " + especialidad);
        System.out.println("Cursos que dicta: " + cursos.size());
        System.out.println("================================");
    }
    
    // Obtener cantidad de cursos
    public int getCantidadCursos() {
        return cursos.size();
    }
    
    // Método toString
    @Override
    public String toString() {
        return nombre + " (" + especialidad + ") - Cursos: " + cursos.size();
    }
}