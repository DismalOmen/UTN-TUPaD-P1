// ============================================================
// KATA 1: VEHÍCULOS Y HERENCIA BÁSICA
// ============================================================

class Vehiculo {
    protected String marca;
    protected String modelo;
    
    public Vehiculo(String marca, String modelo) {
        this.marca = marca;
        this.modelo = modelo;
    }
    
    public void mostrarInfo() {
        System.out.println("Marca: " + marca);
        System.out.println("Modelo: " + modelo);
    }
}

class Auto extends Vehiculo {
    private int cantidadPuertas;
    
    public Auto(String marca, String modelo, int cantidadPuertas) {
        super(marca, modelo);
        this.cantidadPuertas = cantidadPuertas;
    }
    
    @Override
    public void mostrarInfo() {
        super.mostrarInfo();
        System.out.println("Cantidad de puertas: " + cantidadPuertas);
    }
}

// ============================================================
// KATA 2: FIGURAS GEOMÉTRICAS Y MÉTODOS ABSTRACTOS
// ============================================================

abstract class Figura {
    protected String nombre;
    
    public Figura(String nombre) {
        this.nombre = nombre;
    }
    
    public abstract double calcularArea();
    
    public void mostrarArea() {
        System.out.println("Área de " + nombre + ": " + calcularArea());
    }
}

class Circulo extends Figura {
    private double radio;
    
    public Circulo(double radio) {
        super("Círculo");
        this.radio = radio;
    }
    
    @Override
    public double calcularArea() {
        return Math.PI * radio * radio;
    }
}

class Rectangulo extends Figura {
    private double base;
    private double altura;
    
    public Rectangulo(double base, double altura) {
        super("Rectángulo");
        this.base = base;
        this.altura = altura;
    }
    
    @Override
    public double calcularArea() {
        return base * altura;
    }
}

// ============================================================
// KATA 3: EMPLEADOS Y POLIMORFISMO
// ============================================================

abstract class Empleado {
    protected String nombre;
    protected int horasTrabajadas;
    
    public Empleado(String nombre, int horasTrabajadas) {
        this.nombre = nombre;
        this.horasTrabajadas = horasTrabajadas;
    }
    
    public abstract double calcularSueldo();
    
    public void mostrarInfo() {
        System.out.println("Empleado: " + nombre);
        System.out.println("Horas trabajadas: " + horasTrabajadas);
        System.out.println("Sueldo: $" + calcularSueldo());
    }
}

class EmpleadoPlanta extends Empleado {
    private double sueldoBase;
    
    public EmpleadoPlanta(String nombre, int horasTrabajadas, double sueldoBase) {
        super(nombre, horasTrabajadas);
        this.sueldoBase = sueldoBase;
    }
    
    @Override
    public double calcularSueldo() {
        return sueldoBase + (horasTrabajadas * 50); // Bonus por hora extra
    }
}

class EmpleadoTemporal extends Empleado {
    private double tarifaPorHora;
    
    public EmpleadoTemporal(String nombre, int horasTrabajadas, double tarifaPorHora) {
        super(nombre, horasTrabajadas);
        this.tarifaPorHora = tarifaPorHora;
    }
    
    @Override
    public double calcularSueldo() {
        return horasTrabajadas * tarifaPorHora;
    }
}

// ============================================================
// KATA 4: ANIMALES Y COMPORTAMIENTO SOBRESCRITO
// ============================================================

class Animal {
    protected String nombre;
    protected String especie;
    
    public Animal(String nombre, String especie) {
        this.nombre = nombre;
        this.especie = especie;
    }
    
    public void hacerSonido() {
        System.out.println("El animal hace un sonido");
    }
    
    public void describirAnimal() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Especie: " + especie);
    }
}

class Perro extends Animal {
    public Perro(String nombre) {
        super(nombre, "Perro");
    }
    
    @Override
    public void hacerSonido() {
        System.out.println(nombre + " dice: ¡Guau guau!");
    }
}

class Gato extends Animal {
    public Gato(String nombre) {
        super(nombre, "Gato");
    }
    
    @Override
    public void hacerSonido() {
        System.out.println(nombre + " dice: ¡Miau miau!");
    }
}

class Vaca extends Animal {
    public Vaca(String nombre) {
        super(nombre, "Vaca");
    }
    
    @Override
    public void hacerSonido() {
        System.out.println(nombre + " dice: ¡Muuu!");
    }
}

// ============================================================
// CLASE PRINCIPAL CON EJEMPLOS DE USO
// ============================================================

public class KatasHerenciaPolimorfismo {
    
    public static void main(String[] args) {
        
        System.out.println("=== KATA 1: VEHÍCULOS ===");
        kata1Vehiculos();
        
        System.out.println("\n=== KATA 2: FIGURAS GEOMÉTRICAS ===");
        kata2Figuras();
        
        System.out.println("\n=== KATA 3: EMPLEADOS ===");
        kata3Empleados();
        
        System.out.println("\n=== KATA 4: ANIMALES ===");
        kata4Animales();
    }
    
    // ============================================================
    // KATA 1: Demostración de herencia básica
    // ============================================================
    public static void kata1Vehiculos() {
        Auto auto1 = new Auto("Toyota", "Corolla", 4);
        Auto auto2 = new Auto("Ford", "Mustang", 2);
        
        System.out.println("Auto 1:");
        auto1.mostrarInfo();
        
        System.out.println("\nAuto 2:");
        auto2.mostrarInfo();
    }
    
    // ============================================================
    // KATA 2: Polimorfismo con array de figuras
    // ============================================================
    public static void kata2Figuras() {
        Figura[] figuras = new Figura[4];
        figuras[0] = new Circulo(5.0);
        figuras[1] = new Rectangulo(4.0, 6.0);
        figuras[2] = new Circulo(3.0);
        figuras[3] = new Rectangulo(7.0, 2.5);
        
        for (Figura figura : figuras) {
            figura.mostrarArea();
        }
        
        // Calcular área total
        double areaTotal = 0;
        for (Figura figura : figuras) {
            areaTotal += figura.calcularArea();
        }
        System.out.println("\nÁrea total de todas las figuras: " + areaTotal);
    }
    
    // ============================================================
    // KATA 3: Polimorfismo y uso de instanceof
    // ============================================================
    public static void kata3Empleados() {
        Empleado[] empleados = new Empleado[4];
        empleados[0] = new EmpleadoPlanta("Juan Pérez", 160, 50000);
        empleados[1] = new EmpleadoTemporal("María González", 120, 200);
        empleados[2] = new EmpleadoPlanta("Carlos Rodríguez", 180, 55000);
        empleados[3] = new EmpleadoTemporal("Ana López", 100, 180);
        
        double sueldoTotal = 0;
        int countPlanta = 0;
        int countTemporal = 0;
        
        for (Empleado emp : empleados) {
            emp.mostrarInfo();
            System.out.println();
            
            // Uso de instanceof para clasificar
            if (emp instanceof EmpleadoPlanta) {
                System.out.println("→ Empleado de Planta");
                countPlanta++;
            } else if (emp instanceof EmpleadoTemporal) {
                System.out.println("→ Empleado Temporal");
                countTemporal++;
            }
            
            sueldoTotal += emp.calcularSueldo();
            System.out.println("-------------------");
        }
        
        System.out.println("\nRESUMEN:");
        System.out.println("Total empleados de planta: " + countPlanta);
        System.out.println("Total empleados temporales: " + countTemporal);
        System.out.println("Sueldo total a pagar: $" + sueldoTotal);
    }
    
    // ============================================================
    // KATA 4: Polimorfismo con comportamiento sobrescrito
    // ============================================================
    public static void kata4Animales() {
        Animal[] animales = new Animal[5];
        animales[0] = new Perro("Rex");
        animales[1] = new Gato("Michi");
        animales[2] = new Vaca("Lola");
        animales[3] = new Perro("Max");
        animales[4] = new Gato("Pelusa");
        
        System.out.println("Concierto de animales:");
        System.out.println("----------------------");
        for (Animal animal : animales) {
            animal.describirAnimal();
            animal.hacerSonido();
            System.out.println();
        }
        
        // Demostración de upcasting y downcasting
        System.out.println("=== DEMOSTRACIÓN DE CASTING ===");
        Animal animalGenerico = new Perro("Bobby"); // Upcasting implícito
        animalGenerico.hacerSonido();
        
        // Downcasting seguro con instanceof
        if (animalGenerico instanceof Perro) {
            Perro perro = (Perro) animalGenerico; // Downcasting explícito
            System.out.println("Confirmado: es un perro llamado " + perro.nombre);
        }
    }
}