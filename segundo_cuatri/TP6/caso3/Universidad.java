import java.util.ArrayList;
import java.util.List;

public class Universidad {
    private String nombre;
    private List<Profesor> profesores;
    private List<Curso> cursos;
    
    // Constructor
    public Universidad(String nombre) {
        this.nombre = nombre;
        this.profesores = new ArrayList<>();
        this.cursos = new ArrayList<>();
    }
    
    // Getters
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    // Agregar profesor
    public void agregarProfesor(Profesor profesor) {
        if (profesor == null) {
            System.out.println("Error: El profesor no puede ser nulo");
            return;
        }
        
        if (buscarProfesorPorId(profesor.getId()) != null) {
            System.out.println("Error: Ya existe un profesor con ID " + profesor.getId());
            return;
        }
        
        profesores.add(profesor);
        System.out.println("Profesor agregado: " + profesor.getNombre());
    }
    
    // Agregar curso
    public void agregarCurso(Curso curso) {
        if (curso == null) {
            System.out.println("Error: El curso no puede ser nulo");
            return;
        }
        
        if (buscarCursoPorCodigo(curso.getCodigo()) != null) {
            System.out.println("Error: Ya existe un curso con código " + curso.getCodigo());
            return;
        }
        
        cursos.add(curso);
        System.out.println("Curso agregado: " + curso.getNombre());
    }
    
    // Asignar profesor a curso
    public boolean asignarProfesorACurso(String codigoCurso, String idProfesor) {
        Curso curso = buscarCursoPorCodigo(codigoCurso);
        Profesor profesor = buscarProfesorPorId(idProfesor);
        
        if (curso == null) {
            System.out.println("Error: No se encontró el curso con código " + codigoCurso);
            return false;
        }
        
        if (profesor == null) {
            System.out.println("Error: No se encontró el profesor con ID " + idProfesor);
            return false;
        }
        
        // Usar el setter del curso que mantiene la bidireccionalidad
        curso.setProfesor(profesor);
        System.out.println("Profesor " + profesor.getNombre() + " asignado al curso " + curso.getNombre());
        return true;
    }
    
    // Listar profesores
    public void listarProfesores() {
        if (profesores.isEmpty()) {
            System.out.println("No hay profesores en la universidad");
            return;
        }
        
        System.out.println("=== PROFESORES DE " + nombre.toUpperCase() + " ===");
        for (int i = 0; i < profesores.size(); i++) {
            Profesor profesor = profesores.get(i);
            System.out.println((i + 1) + ". " + profesor.getNombre() + 
                             " (" + profesor.getEspecialidad() + ") - Cursos: " + profesor.getCantidadCursos());
        }
    }
    
    // Listar cursos
    public void listarCursos() {
        if (cursos.isEmpty()) {
            System.out.println("No hay cursos en la universidad");
            return;
        }
        
        System.out.println("=== CURSOS DE " + nombre.toUpperCase() + " ===");
        for (int i = 0; i < cursos.size(); i++) {
            Curso curso = cursos.get(i);
            String profesorInfo = (curso.getProfesor() != null) ? 
                                curso.getProfesor().getNombre() : "Sin asignar";
            System.out.println((i + 1) + ". " + curso.getCodigo() + " - " + 
                             curso.getNombre() + " → " + profesorInfo);
        }
    }
    
    // Buscar profesor por ID
    public Profesor buscarProfesorPorId(String id) {
        for (Profesor profesor : profesores) {
            if (profesor.getId().equals(id)) {
                return profesor;
            }
        }
        return null;
    }
    
    // Buscar curso por código
    public Curso buscarCursoPorCodigo(String codigo) {
        for (Curso curso : cursos) {
            if (curso.getCodigo().equals(codigo)) {
                return curso;
            }
        }
        return null;
    }
    
    // Eliminar curso
    public boolean eliminarCurso(String codigo) {
        Curso curso = buscarCursoPorCodigo(codigo);
        if (curso != null) {
            // Romper relación con el profesor antes de eliminar
            if (curso.getProfesor() != null) {
                curso.desasignarProfesor();
            }
            cursos.remove(curso);
            System.out.println("Curso eliminado: " + curso.getNombre());
            return true;
        } else {
            System.out.println("Error: No se encontró el curso con código " + codigo);
            return false;
        }
    }
    
    // Eliminar profesor
    public boolean eliminarProfesor(String id) {
        Profesor profesor = buscarProfesorPorId(id);
        if (profesor != null) {
            // Desasignar todos los cursos del profesor antes de eliminar
            List<Curso> cursosDelProfesor = new ArrayList<>(profesor.getCursos());
            for (Curso curso : cursosDelProfesor) {
                curso.desasignarProfesor();
            }
            profesores.remove(profesor);
            System.out.println("Profesor eliminado: " + profesor.getNombre());
            return true;
        } else {
            System.out.println("Error: No se encontró el profesor con ID " + id);
            return false;
        }
    }
    
    // Mostrar reporte de cursos por profesor
    public void mostrarReporteCursosPorProfesor() {
        System.out.println("=== REPORTE: CURSOS POR PROFESOR ===");
        for (Profesor profesor : profesores) {
            System.out.println(profesor.getNombre() + ": " + 
                             profesor.getCantidadCursos() + " cursos");
            profesor.listarCursos();
            System.out.println();
        }
    }
    
    // Método toString
    @Override
    public String toString() {
        return nombre + " - Profesores: " + profesores.size() + ", Cursos: " + cursos.size();
    }
}