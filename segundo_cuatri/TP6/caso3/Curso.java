public class Curso {
    private String codigo;
    private String nombre;
    private Profesor profesor;
    
    // Constructor
    public Curso(String codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.profesor = null; // Inicialmente sin profesor
    }
    
    // Constructor con profesor
    public Curso(String codigo, String nombre, Profesor profesor) {
        this.codigo = codigo;
        this.nombre = nombre;
        setProfesor(profesor); // Usar setter para mantener bidireccionalidad
    }
    
    // Getters y Setters
    public String getCodigo() {
        return codigo;
    }
    
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public Profesor getProfesor() {
        return profesor;
    }
    
    // Setter que mantiene la bidireccionalidad
    public void setProfesor(Profesor nuevoProfesor) {
        // Si ya tenía un profesor, eliminarse de su lista
        if (this.profesor != null && this.profesor != nuevoProfesor) {
            this.profesor.eliminarCurso(this);
        }
        
        // Asignar nuevo profesor
        this.profesor = nuevoProfesor;
        
        // Si el nuevo profesor no es nulo, agregarse a su lista
        if (nuevoProfesor != null && !nuevoProfesor.getCursos().contains(this)) {
            nuevoProfesor.agregarCurso(this);
        }
    }
    
    // Método para desasignar profesor (sin asignar nuevo)
    public void desasignarProfesor() {
        setProfesor(null);
    }
    
    // Mostrar información del curso
    public void mostrarInfo() {
        System.out.println("=== INFORMACION DEL CURSO ===");
        System.out.println("Código: " + codigo);
        System.out.println("Nombre: " + nombre);
        if (profesor != null) {
            System.out.println("Profesor: " + profesor.getNombre() + " (" + profesor.getEspecialidad() + ")");
        } else {
            System.out.println("Profesor: No asignado");
        }
        System.out.println("=============================");
    }
    
    // Método toString
    @Override
    public String toString() {
        String profesorInfo = (profesor != null) ? profesor.getNombre() : "Sin profesor";
        return codigo + " - " + nombre + " (" + profesorInfo + ")";
    }
}