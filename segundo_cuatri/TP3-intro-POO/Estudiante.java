public class Estudiante {
    String nombre;
    String apellido;
    String curso;
    int calificacion;

    public void mostrarInfo() {
        System.out.println(nombre + " " + apellido + ", Curso: " + curso + ", Calificación: " + calificacion);
    }

    public void subirCalificacion(int puntos) {
        calificacion += puntos;
    }

    public void bajarCalificacion(int puntos) {
        calificacion -= puntos;
    }

    public static void main(String[] args) {
        Estudiante estudiante = new Estudiante();
        estudiante.nombre = "joaco";
        estudiante.apellido = "dvl";
        estudiante.curso = "programacionII";
        estudiante.calificacion = 7;

        estudiante.mostrarInfo();
        estudiante.subirCalificacion(2);
        estudiante.mostrarInfo();
        estudiante.bajarCalificacion(3);
        estudiante.mostrarInfo();
    }
}
