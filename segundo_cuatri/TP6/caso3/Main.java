public class Main {
    public static void main(String[] args) {
        System.out.println("INICIO DEL SISTEMA UNIVERSITARIO\n");
        
        // Crear universidad
        Universidad universidad = new Universidad("Universidad Nacional");
        System.out.println("Universidad creada: " + universidad.toString());
        
        System.out.println();
        
        // TAREA 1: Crear al menos 3 profesores y 5 cursos
        System.out.println("TAREA 1: Crear profesores y cursos");
        
        // Crear profesores
        Profesor prof1 = new Profesor("P001", "Dr. Carlos Mendoza", "Matemáticas");
        Profesor prof2 = new Profesor("P002", "Dra. Ana López", "Física");
        Profesor prof3 = new Profesor("P003", "Dr. Roberto Silva", "Programación");
        
        // Crear cursos
        Curso curso1 = new Curso("MAT101", "Cálculo I");
        Curso curso2 = new Curso("MAT102", "Cálculo II");
        Curso curso3 = new Curso("FIS101", "Física General");
        Curso curso4 = new Curso("PROG101", "Programación I");
        Curso curso5 = new Curso("PROG102", "Programación II");
        Curso curso6 = new Curso("MAT103", "Álgebra Lineal");
        
        System.out.println("Profesores y cursos creados exitosamente");
        
        System.out.println();
        
        // TAREA 2: Agregar profesores y cursos a la universidad
        System.out.println("TAREA 2: Agregar a la universidad");
        
        universidad.agregarProfesor(prof1);
        universidad.agregarProfesor(prof2);
        universidad.agregarProfesor(prof3);
        
        universidad.agregarCurso(curso1);
        universidad.agregarCurso(curso2);
        universidad.agregarCurso(curso3);
        universidad.agregarCurso(curso4);
        universidad.agregarCurso(curso5);
        universidad.agregarCurso(curso6);
        
        System.out.println();
        
        // TAREA 3: Asignar profesores a cursos
        System.out.println("TAREA 3: Asignar profesores a cursos");
        
        universidad.asignarProfesorACurso("MAT101", "P001");
        universidad.asignarProfesorACurso("MAT102", "P001");
        universidad.asignarProfesorACurso("FIS101", "P002");
        universidad.asignarProfesorACurso("PROG101", "P003");
        universidad.asignarProfesorACurso("PROG102", "P003");
        universidad.asignarProfesorACurso("MAT103", "P001");
        
        System.out.println();
        
        // TAREA 4: Listar cursos con su profesor y profesores con sus cursos
        System.out.println("TAREA 4: Listar información completa");
        
        System.out.println("\n--- Lista de Cursos ---");
        universidad.listarCursos();
        
        System.out.println("\n--- Lista de Profesores ---");
        universidad.listarProfesores();
        
        System.out.println();
        
        // TAREA 5: Cambiar el profesor de un curso y verificar sincronización
        System.out.println("TAREA 5: Cambiar profesor de un curso");
        
        System.out.println("ANTES del cambio:");
        curso2.mostrarInfo();
        prof1.listarCursos();
        prof3.listarCursos();
        
        // Cambiar profesor del curso
        universidad.asignarProfesorACurso("MAT102", "P003");
        
        System.out.println("\nDESPUES del cambio:");
        curso2.mostrarInfo();
        prof1.listarCursos();
        prof3.listarCursos();
        
        System.out.println();
        
        // TAREA 6: Remover un curso y confirmar que ya no aparece en la lista del profesor
        System.out.println("TAREA 6: Remover un curso");
        
        System.out.println("Cursos del profesor P001 antes de eliminar MAT103:");
        prof1.listarCursos();
        
        universidad.eliminarCurso("MAT103");
        
        System.out.println("\nCursos del profesor P001 después de eliminar MAT103:");
        prof1.listarCursos();
        
        System.out.println();
        
        // TAREA 7: Remover un profesor y dejar profesor = null en sus cursos
        System.out.println("TAREA 7: Remover un profesor");
        
        System.out.println("Estado de los cursos antes de eliminar al profesor P002:");
        curso3.mostrarInfo();
        
        universidad.eliminarProfesor("P002");
        
        System.out.println("\nEstado del curso FIS101 después de eliminar al profesor:");
        curso3.mostrarInfo();
        
        System.out.println();
        
        // TAREA 8: Mostrar reporte de cantidad de cursos por profesor
        System.out.println("TAREA 8: Reporte de cursos por profesor");
        universidad.mostrarReporteCursosPorProfesor();
        
        System.out.println();
        
        // DEMOSTRACION ADICIONAL: Verificación de bidireccionalidad
        System.out.println("=== VERIFICACION DE BIDIRECCIONALIDAD ===");
        
        // Verificar que las referencias son consistentes
        Curso cursoEjemplo = universidad.buscarCursoPorCodigo("PROG101");
        Profesor profesorEjemplo = universidad.buscarProfesorPorId("P003");
        
        if (cursoEjemplo != null && profesorEjemplo != null) {
            System.out.println("Desde curso hacia profesor: " + cursoEjemplo.getProfesor().getNombre());
            System.out.println("Desde profesor hacia cursos: " + profesorEjemplo.getCursos().size() + " cursos");
            
            // Verificar que la referencia es la misma
            System.out.println("¿Misma referencia? " + 
                (cursoEjemplo.getProfesor() == profesorEjemplo));
        }
        
        System.out.println("\nSISTEMA UNIVERSITARIO EJECUTADO EXITOSAMENTE");
    }
}