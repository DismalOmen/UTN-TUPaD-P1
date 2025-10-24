import java.io.*;
import java.util.*;

// PARTE 1: INTERFACES EN SISTEMA E-COMMERCE

// Interfaz principal para elementos que tienen un total calculable
interface Pagable {
    double calcularTotal();
}

// Interfaz para medios de pago
interface Pago {
    boolean procesarPago(double monto);
    String obtenerNombreMedioPago();
}

// Interfaz para pagos con descuento
interface PagoConDescuento extends Pago {
    double aplicarDescuento(double monto);
    double obtenerPorcentajeDescuento();
}

// Interfaz para notificaciones
interface Notificable {
    void notificar(String mensaje);
}

// CLASES DEL SISTEMA E-COMMERCE

class Producto implements Pagable {
    private String nombre;
    private double precio;
    
    public Producto(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }
    
    @Override
    public double calcularTotal() {
        return precio;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public double getPrecio() {
        return precio;
    }
    
    @Override
    public String toString() {
        return nombre + " - $" + precio;
    }
}

class Pedido implements Pagable {
    private List<Producto> productos;
    private String estado;
    private List<Notificable> observadores;
    
    public Pedido() {
        this.productos = new ArrayList<>();
        this.estado = "PENDIENTE";
        this.observadores = new ArrayList<>();
    }
    
    public void agregarProducto(Producto producto) {
        productos.add(producto);
    }
    
    @Override
    public double calcularTotal() {
        double total = 0;
        for (Producto p : productos) {
            total += p.calcularTotal();
        }
        return total;
    }
    
    public void registrarObservador(Notificable observador) {
        observadores.add(observador);
    }
    
    public void cambiarEstado(String nuevoEstado) {
        this.estado = nuevoEstado;
        notificarObservadores("El pedido ha cambiado a estado: " + nuevoEstado);
    }
    
    private void notificarObservadores(String mensaje) {
        for (Notificable observador : observadores) {
            observador.notificar(mensaje);
        }
    }
    
    public String getEstado() {
        return estado;
    }
    
    public List<Producto> getProductos() {
        return new ArrayList<>(productos);
    }
}

class Cliente implements Notificable {
    private String nombre;
    private String email;
    
    public Cliente(String nombre, String email) {
        this.nombre = nombre;
        this.email = email;
    }
    
    @Override
    public void notificar(String mensaje) {
        System.out.println(" Notificación para " + nombre + " (" + email + "):");
        System.out.println("   " + mensaje);
    }
    
    public String getNombre() {
        return nombre;
    }
}

// Medios de pago
class TarjetaCredito implements PagoConDescuento {
    private String numeroTarjeta;
    private double porcentajeDescuento;
    
    public TarjetaCredito(String numeroTarjeta, double porcentajeDescuento) {
        this.numeroTarjeta = numeroTarjeta;
        this.porcentajeDescuento = porcentajeDescuento;
    }
    
    @Override
    public boolean procesarPago(double monto) {
        double montoFinal = aplicarDescuento(monto);
        System.out.println("Procesando pago con Tarjeta de Crédito: $" + montoFinal);
        System.out.println("   Número: ****" + numeroTarjeta.substring(Math.max(0, numeroTarjeta.length() - 4)));
        System.out.println("   Descuento aplicado: " + porcentajeDescuento + "%");
        return true;
    }
    
    @Override
    public double aplicarDescuento(double monto) {
        return monto * (1 - porcentajeDescuento / 100);
    }
    
    @Override
    public double obtenerPorcentajeDescuento() {
        return porcentajeDescuento;
    }
    
    @Override
    public String obtenerNombreMedioPago() {
        return "Tarjeta de Crédito";
    }
}

class PayPal implements Pago {
    private String email;
    
    public PayPal(String email) {
        this.email = email;
    }
    
    @Override
    public boolean procesarPago(double monto) {
        System.out.println("🔵 Procesando pago con PayPal: $" + monto);
        System.out.println("   Cuenta: " + email);
        return true;
    }
    
    @Override
    public String obtenerNombreMedioPago() {
        return "PayPal";
    }
}

// PARTE 2: EXCEPCIONES

// Excepción personalizada
class EdadInvalidaException extends Exception {
    public EdadInvalidaException(String mensaje) {
        super(mensaje);
    }
}

class SaldoInsuficienteException extends Exception {
    private double saldoActual;
    private double montoRequerido;
    
    public SaldoInsuficienteException(double saldoActual, double montoRequerido) {
        super("Saldo insuficiente. Saldo actual: $" + saldoActual + ", requerido: $" + montoRequerido);
        this.saldoActual = saldoActual;
        this.montoRequerido = montoRequerido;
    }
    
    public double getSaldoFaltante() {
        return montoRequerido - saldoActual;
    }
}

// CLASE CON EJERCICIOS DE EXCEPCIONES

class EjerciciosExcepciones {
    
    // Ejercicio 1: División segura
    public static void divisionSegura(double dividendo, double divisor) {
        try {
            if (divisor == 0) {
                throw new ArithmeticException("No se puede dividir por cero");
            }
            double resultado = dividendo / divisor;
            System.out.println("Resultado: " + dividendo + " / " + divisor + " = " + resultado);
        } catch (ArithmeticException e) {
            System.out.println(" Error: " + e.getMessage());
        }
    }
    
    // Ejercicio 2: Conversión de cadena a número
    public static void convertirCadenaANumero(String texto) {
        try {
            int numero = Integer.parseInt(texto);
            System.out.println("Conversión exitosa: '" + texto + "' = " + numero);
        } catch (NumberFormatException e) {
            System.out.println(" Error: '" + texto + "' no es un número válido");
        }
    }
    
    // Ejercicio 3: Lectura de archivo
    public static void leerArchivo(String nombreArchivo) {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(nombreArchivo));
            String linea;
            System.out.println(" Contenido del archivo:");
            while ((linea = reader.readLine()) != null) {
                System.out.println(linea);
            }
        } catch (FileNotFoundException e) {
            System.out.println(" Error: El archivo '" + nombreArchivo + "' no existe");
        } catch (IOException e) {
            System.out.println(" Error al leer el archivo: " + e.getMessage());
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                    System.out.println("Archivo cerrado correctamente");
                } catch (IOException e) {
                    System.out.println(" Error al cerrar el archivo");
                }
            }
        }
    }
    
    // Ejercicio 4: Validación de edad con excepción personalizada
    public static void validarEdad(int edad) throws EdadInvalidaException {
        if (edad < 0) {
            throw new EdadInvalidaException("La edad no puede ser negativa: " + edad);
        }
        if (edad > 120) {
            throw new EdadInvalidaException("La edad no puede ser mayor a 120: " + edad);
        }
        System.out.println("Edad válida: " + edad + " años");
    }
    
    // Ejercicio 5: Try-with-resources
    public static void leerArchivoConTryWithResources(String nombreArchivo) {
        System.out.println(" Leyendo archivo con try-with-resources:");
        try (BufferedReader reader = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                System.out.println(linea);
            }
            System.out.println("Archivo leído correctamente (se cerró automáticamente)");
        } catch (FileNotFoundException e) {
            System.out.println(" Error: El archivo '" + nombreArchivo + "' no existe");
        } catch (IOException e) {
            System.out.println(" Error al leer el archivo: " + e.getMessage());
        }
    }
}

// CLASE PRINCIPAL - PROGRAMA DE DEMOSTRACIÓN

public class SistemaEcommerceCompleto {
    
    public static void main(String[] args) {
        
        System.out.println("╔═══════════════════════════════════════════════════════════╗");
        System.out.println("║   SISTEMA E-COMMERCE CON INTERFACES Y EXCEPCIONES        ║");
        System.out.println("╚═══════════════════════════════════════════════════════════╝\n");
        
        // PARTE 1: Demostración del sistema E-commerce
        demoParte1Ecommerce();
        
        System.out.println("\n" + "=".repeat(60));
        
        // PARTE 2: Demostración de manejo de excepciones
        demoParte2Excepciones();
    }
    
    // DEMOSTRACIÓN PARTE 1: SISTEMA E-COMMERCE
    
    public static void demoParte1Ecommerce() {
        System.out.println("\nPARTE 1: SISTEMA E-COMMERCE\n");
        
        // Crear productos
        Producto laptop = new Producto("Laptop Dell", 45000);
        Producto mouse = new Producto("Mouse Logitech", 1500);
        Producto teclado = new Producto("Teclado Mecánico", 8000);
        
        // Crear pedido
        Pedido pedido = new Pedido();
        pedido.agregarProducto(laptop);
        pedido.agregarProducto(mouse);
        pedido.agregarProducto(teclado);
        
        // Crear cliente y registrarlo como observador
        Cliente cliente = new Cliente("Juan Pérez", "juan@email.com");
        pedido.registrarObservador(cliente);
        
        // Mostrar productos del pedido
        System.out.println(" Productos en el pedido:");
        for (Producto p : pedido.getProductos()) {
            System.out.println("   • " + p);
        }
        
        // Calcular total usando polimorfismo (Pagable)
        System.out.println("\nTotal del pedido: $" + pedido.calcularTotal());
        
        // Cambiar estados del pedido (activa notificaciones)
        System.out.println("\nCambios de estado:");
        pedido.cambiarEstado("PROCESANDO");
        pedido.cambiarEstado("ENVIADO");
        pedido.cambiarEstado("ENTREGADO");
        
        // Procesar pago con diferentes medios
        System.out.println("\n Procesando pagos:");
        
        Pago pagoTarjeta = new TarjetaCredito("1234567890123456", 10);
        pagoTarjeta.procesarPago(pedido.calcularTotal());
        
        System.out.println();
        
        Pago pagoPayPal = new PayPal("juan@email.com");
        pagoPayPal.procesarPago(pedido.calcularTotal());
    }
    
    // DEMOSTRACIÓN PARTE 2: EXCEPCIONES
    
    public static void demoParte2Excepciones() {
        System.out.println("\n PARTE 2: MANEJO DE EXCEPCIONES\n");
        
        // Ejercicio 1: División segura
        System.out.println(" DIVISIÓN SEGURA:");
        EjerciciosExcepciones.divisionSegura(10, 2);
        EjerciciosExcepciones.divisionSegura(10, 0);
        
        System.out.println("\n" + "-".repeat(60));
        
        // Ejercicio 2: Conversión de cadena a número
        System.out.println("\n CONVERSIÓN DE CADENA A NÚMERO:");
        EjerciciosExcepciones.convertirCadenaANumero("123");
        EjerciciosExcepciones.convertirCadenaANumero("abc");
        EjerciciosExcepciones.convertirCadenaANumero("45.67");
        
        System.out.println("\n" + "-".repeat(60));
        
        // Ejercicio 3: Lectura de archivo
        System.out.println("\n LECTURA DE ARCHIVO:");
        crearArchivoEjemplo("datos.txt");
        EjerciciosExcepciones.leerArchivo("datos.txt");
        EjerciciosExcepciones.leerArchivo("noexiste.txt");
        
        System.out.println("\n" + "-".repeat(60));
        
        // Ejercicio 4: Validación de edad con excepción personalizada
        System.out.println("\nVALIDACIÓN DE EDAD (EXCEPCIÓN PERSONALIZADA):");
        try {
            EjerciciosExcepciones.validarEdad(25);
            EjerciciosExcepciones.validarEdad(-5);
        } catch (EdadInvalidaException e) {
            System.out.println(e.getMessage());
        }
        
        try {
            EjerciciosExcepciones.validarEdad(150);
        } catch (EdadInvalidaException e) {
            System.out.println(e.getMessage());
        }
        
        System.out.println("\n" + "-".repeat(60));
        
        // Ejercicio 5: Try-with-resources
        System.out.println("\n TRY-WITH-RESOURCES:");
        EjerciciosExcepciones.leerArchivoConTryWithResources("datos.txt");
        EjerciciosExcepciones.leerArchivoConTryWithResources("noexiste.txt");
        
        System.out.println("\n" + "=".repeat(60));
        System.out.println("\nDEMOSTRACIÓN COMPLETADA");
    }
    
    // Método auxiliar para crear un archivo de ejemplo
    private static void crearArchivoEjemplo(String nombre) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(nombre))) {
            writer.println("Este es un archivo de ejemplo");
            writer.println("Para demostrar el manejo de excepciones");
            writer.println("En el ejercicio de Java");
        } catch (IOException e) {
            System.out.println("Error al crear archivo de ejemplo");
        }
    }
}