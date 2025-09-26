public class Main {
    public static void main(String[] args) {
        // Crear empleados usando diferentes constructores
        Empleado emp1 = new Empleado(1, "joaco dvl", "Desarrollador", 3000.0);
        Empleado emp2 = new Empleado("j. del valle lietti", "Diseñador");
        Empleado emp3 = new Empleado("jdvl", "Gerente");
        
        // Mostrar información inicial
        System.out.println("=== EMPLEADOS CREADOS ===");
        System.out.println(emp1.toString());
        System.out.println(emp2.toString());
        System.out.println(emp3.toString());
        
        // Aplicar aumentos de salario (métodos sobrecargados)
        emp1.actualizarSalario(10.0); // 10% de aumento
        emp2.actualizarSalario(500);  // $500 de aumento
        emp3.actualizarSalario(15.0); // 15% de aumento
        
        // Mostrar información después de los aumentos
        System.out.println("\n=== DESPUÉS DE AUMENTOS ===");
        System.out.println(emp1.toString());
        System.out.println(emp2.toString());
        System.out.println(emp3.toString());
        
        // Mostrar total de empleados
        System.out.println("\n=== TOTAL DE EMPLEADOS ===");
        System.out.println("Total: " + Empleado.mostrarTotalEmpleados());
        
        // Probar setters y getters
        System.out.println("\n=== PRUEBA DE ENCAPSULAMIENTO ===");
        emp1.setPuesto("Senior Developer");
        System.out.println("Nuevo puesto de " + emp1.getNombre() + ": " + emp1.getPuesto());
    }
}

public class Empleado {
    // Atributos
    private int id;
    private String nombre;
    private String puesto;
    private double salario;
    private static int totalEmpleados = 0;

    public Empleado(int id, String nombre, String puesto, double salario) {
        this.id = id;
        this.nombre = nombre;
        this.puesto = puesto;
        this.salario = salario;
        totalEmpleados++;
    }

    public Empleado(String nombre, String puesto) {
        this(0, nombre, puesto, 1000.0);
        this.id = totalEmpleados;
    }

    // Métodos Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    // Métodos sobrecargados actualizarSalario
    public void actualizarSalario(double porcentajeAumento) {
        this.salario += this.salario * (porcentajeAumento / 100);
    }

    public void actualizarSalario(int aumentoFijo) {
        this.salario += aumentoFijo;
    }

    // Método toString
    @Override
    public String toString() {
        return "ID: " + id + 
               " | Nombre: " + nombre + 
               " | Puesto: " + puesto + 
               " | Salario: $" + String.format("%.2f", salario);
    }

    // Método estático
    public static int mostrarTotalEmpleados() {
        return totalEmpleados;
    }
}