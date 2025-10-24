// Ejercicio 11: Dependencia de USO
class Artista {
    private String nombre;
    private String genero;
    
    public Artista(String nombre, String genero) {
        this.nombre = nombre;
        this.genero = genero;
    }
    
    public String getNombre() { return nombre; }
    public String getGenero() { return genero; }
}

class Cancion {
    private String titulo;
    private Artista artista; // Asociación unidireccional
    
    public Cancion(String titulo, Artista artista) {
        this.titulo = titulo;
        this.artista = artista;
    }
    
    public String getTitulo() { return titulo; }
    public Artista getArtista() { return artista; }
}

class Reproductor {
    // DEPENDENCIA DE USO: Recibe Canción como parámetro pero no la guarda
    public void reproducir(Cancion cancion) {
        System.out.println("Reproduciendo: " + cancion.getTitulo());
        System.out.println("Artista: " + cancion.getArtista().getNombre());
        System.out.println("Género: " + cancion.getArtista().getGenero());
    }
    
    // Otro método con dependencia de uso
    public void pausar(Cancion cancion) {
        System.out.println("Pausando: " + cancion.getTitulo());
    }
}

// Ejercicio 12: Dependencia de USO
class Contribuyente {
    private String nombre;
    private String cuil;
    
    public Contribuyente(String nombre, String cuil) {
        this.nombre = nombre;
        this.cuil = cuil;
    }
    
    public String getNombre() { return nombre; }
    public String getCuil() { return cuil; }
}

class Impuesto {
    private double monto;
    private Contribuyente contribuyente; // Asociación unidireccional
    
    public Impuesto(double monto, Contribuyente contribuyente) {
        this.monto = monto;
        this.contribuyente = contribuyente;
    }
    
    public double getMonto() { return monto; }
    public Contribuyente getContribuyente() { return contribuyente; }
}

class Calculadora {
    // DEPENDENCIA DE USO: Recibe Impuesto como parámetro pero no lo guarda
    public void calcular(Impuesto impuesto) {
        double iva = impuesto.getMonto() * 0.21;
        double total = impuesto.getMonto() + iva;
        
        System.out.println("Calculando impuesto para: " + impuesto.getContribuyente().getNombre());
        System.out.println("Monto base: $" + impuesto.getMonto());
        System.out.println("IVA (21%): $" + iva);
        System.out.println("Total: $" + total);
    }
    
    // Otro método con dependencia de uso
    public void mostrarInfoContribuyente(Impuesto impuesto) {
        System.out.println("Contribuyente: " + impuesto.getContribuyente().getNombre());
        System.out.println("CUIL: " + impuesto.getContribuyente().getCuil());
    }
}

// Ejercicio 13: Dependencia de CREACIÓN
class UsuarioQR {
    private String nombre;
    private String email;
    
    public UsuarioQR(String nombre, String email) {
        this.nombre = nombre;
        this.email = email;
    }
    
    public String getNombre() { return nombre; }
    public String getEmail() { return email; }
}

class CodigoQR {
    private String valor;
    private UsuarioQR usuario; // Asociación unidireccional
    
    public CodigoQR(String valor, UsuarioQR usuario) {
        this.valor = valor;
        this.usuario = usuario;
    }
    
    public String getValor() { return valor; }
    public UsuarioQR getUsuario() { return usuario; }
    
    public void mostrarInfo() {
        System.out.println("Código QR: " + valor);
        System.out.println("Generado para: " + usuario.getNombre());
    }
}

class GeneradorQR {
    // DEPENDENCIA DE CREACIÓN: Crea CodigoQR dentro del método pero no lo guarda
    public void generar(String valor, UsuarioQR usuario) {
        // Creación temporal dentro del método
        CodigoQR qr = new CodigoQR(valor, usuario);
        System.out.println("Generando código QR...");
        qr.mostrarInfo();
        // El objeto qr se destruye cuando termina el método
    }
    
    // Otro método con dependencia de creación
    public void generarConFecha(String valor, UsuarioQR usuario) {
        String valorConFecha = valor + "_" + java.time.LocalDate.now();
        CodigoQR qr = new CodigoQR(valorConFecha, usuario);
        System.out.println("Código QR con fecha generado:");
        qr.mostrarInfo();
    }
}

// Ejercicio 14: Dependencia de CREACIÓN
class Proyecto {
    private String nombre;
    private int duracionMin;
    
    public Proyecto(String nombre, int duracionMin) {
        this.nombre = nombre;
        this.duracionMin = duracionMin;
    }
    
    public String getNombre() { return nombre; }
    public int getDuracionMin() { return duracionMin; }
}

class Render {
    private String formato;
    private Proyecto proyecto; // Asociación unidireccional
    
    public Render(String formato, Proyecto proyecto) {
        this.formato = formato;
        this.proyecto = proyecto;
    }
    
    public String getFormato() { return formato; }
    public Proyecto getProyecto() { return proyecto; }
    
    public void ejecutarRender() {
        System.out.println("Renderizando proyecto: " + proyecto.getNombre());
        System.out.println("Formato: " + formato);
        System.out.println("Duración: " + proyecto.getDuracionMin() + " minutos");
        System.out.println("Render completado!");
    }
}

class EditorVideo {
    // DEPENDENCIA DE CREACIÓN: Crea Render dentro del método pero no lo guarda
    public void exportar(String formato, Proyecto proyecto) {
        // Creación temporal del objeto Render
        Render render = new Render(formato, proyecto);
        System.out.println("Iniciando exportación...");
        render.ejecutarRender();
        // El objeto render se destruye cuando termina el método
    }
    
    // Otro método con dependencia de creación
    public void exportarMultiplesFormatos(Proyecto proyecto) {
        String[] formatos = {"MP4", "AVI", "MOV"};
        
        for (String formato : formatos) {
            Render render = new Render(formato, proyecto);
            System.out.println("--- Exportando en formato: " + formato + " ---");
            render.ejecutarRender();
        }
    }
}

public class UMBbasico {
    public static void main(String[] args) {
        System.out.println("\n=== DEPENDENCIAS DE USO (11-12) ===");
        
        // Ejercicio 11: Dependencia de USO
        Artista artista1 = new Artista("Shakira", "Pop");
        Cancion cancion1 = new Cancion("Waka Waka", artista1);
        Reproductor reproductor = new Reproductor();
        reproductor.reproducir(cancion1); // DEPENDENCIA DE USO
        
        // Ejercicio 12: Dependencia de USO
        Contribuyente contribuyente1 = new Contribuyente("Empresa XYZ", "30-12345678-9");
        Impuesto impuesto1 = new Impuesto(10000, contribuyente1);
        Calculadora calculadora = new Calculadora();
        calculadora.calcular(impuesto1); // DEPENDENCIA DE USO
        
        System.out.println("\n=== DEPENDENCIAS DE CREACIÓN (13-14) ===");
        
        // Ejercicio 13: Dependencia de CREACIÓN
        UsuarioQR usuarioQR1 = new UsuarioQR("Carlos López", "carlos@email.com");
        GeneradorQR generadorQR = new GeneradorQR();
        generadorQR.generar("https://www.ejemplo.com", usuarioQR1); // DEPENDENCIA DE CREACIÓN
        
        // Ejercicio 14: Dependencia de CREACIÓN
        Proyecto proyecto1 = new Proyecto("Documental Naturaleza", 120);
        EditorVideo editor = new EditorVideo();
        editor.exportar("MP4", proyecto1); // DEPENDENCIA DE CREACIÓN
        
    }
}