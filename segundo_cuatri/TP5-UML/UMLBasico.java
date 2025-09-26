// EJERCICIO 1: Pasaporte - Foto - Titular
class Foto {
    private String imagen;
    private String formato;

    public Foto(String imagen, String formato) {
        this.imagen = imagen;
        this.formato = formato;
    }
    
    // GETTERS
    public String getImagen() { return imagen; }
    public String getFormato() { return formato; }
}

class Titular {
    private String nombre;
    private String dni;
    private Pasaporte pasaporte;

    public Titular(String nombre, String dni) {
        this.nombre = nombre;
        this.dni = dni;
    }

    public void setPasaporte(Pasaporte pasaporte) {
        this.pasaporte = pasaporte;
    }

    // GETTERS
    public String getNombre() { return nombre; }
    public String getDni() { return dni; }
    public Pasaporte getPasaporte() { return pasaporte; }
}

class Pasaporte {
    private String numero;
    private String fechaEmision;
    private Foto foto;        
    private Titular titular;  

    public Pasaporte(String numero, String fechaEmision, String imagenFoto, String formatoFoto, Titular titular) {
        this.numero = numero;
        this.fechaEmision = fechaEmision;
        this.foto = new Foto(imagenFoto, formatoFoto);
        this.titular = titular;                         
        titular.setPasaporte(this);
    }
    
    // GETTERS
    public String getNumero() { return numero; }
    public String getFechaEmision() { return fechaEmision; }
    public Foto getFoto() { return foto; }
    public Titular getTitular() { return titular; }
}

// EJERCICIO 2: Celular - Batería - Usuario
class Bateria {
    private String modelo;
    private int capacidad;

    public Bateria(String modelo, int capacidad) {
        this.modelo = modelo;
        this.capacidad = capacidad;
    }
    
    // GETTERS
    public String getModelo() { return modelo; }
    public int getCapacidad() { return capacidad; }
}

class Usuario {
    private String nombre;
    private String dni;
    private Celular celular;

    public Usuario(String nombre, String dni) {
        this.nombre = nombre;
        this.dni = dni;
    }

    public void setCelular(Celular celular) { this.celular = celular; }
    
    // GETTERS
    public String getNombre() { return nombre; }
    public String getDni() { return dni; }
    public Celular getCelular() { return celular; }
}

class Celular {
    private String imei;
    private String marca;
    private String modelo;
    private Bateria bateria;
    private Usuario usuario;

    public Celular(String imei, String marca, String modelo, Bateria bateria, Usuario usuario) {
        this.imei = imei;
        this.marca = marca;
        this.modelo = modelo;
        this.bateria = bateria;
        this.usuario = usuario;
        usuario.setCelular(this);
    }
    
    // GETTERS
    public String getImei() { return imei; }
    public String getMarca() { return marca; }
    public String getModelo() { return modelo; }
    public Bateria getBateria() { return bateria; }
    public Usuario getUsuario() { return usuario; }
}

// EJERCICIO 3: Libro - Autor - Editorial
class Autor {
    private String nombre;
    private String nacionalidad;

    public Autor(String nombre, String nacionalidad) {
        this.nombre = nombre;
        this.nacionalidad = nacionalidad;
    }
    
    // GETTERS
    public String getNombre() { return nombre; }
    public String getNacionalidad() { return nacionalidad; }
}

class Editorial {
    private String nombre;
    private String direccion;

    public Editorial(String nombre, String direccion) {
        this.nombre = nombre;
        this.direccion = direccion;
    }
    
    // GETTERS
    public String getNombre() { return nombre; }
    public String getDireccion() { return direccion; }
}

class Libro {
    private String titulo;
    private String isbn;
    private Autor autor;
    private Editorial editorial;

    public Libro(String titulo, String isbn, Autor autor, Editorial editorial) {
        this.titulo = titulo;
        this.isbn = isbn;
        this.autor = autor;
        this.editorial = editorial;
    }
    
    // GETTERS
    public String getTitulo() { return titulo; }
    public String getIsbn() { return isbn; }
    public Autor getAutor() { return autor; }
    public Editorial getEditorial() { return editorial; }
}

// EJERCICIO 4: TarjetaDeCrédito - Cliente - Banco
class Banco {
    private String nombre;
    private String cuit;

    public Banco(String nombre, String cuit) {
        this.nombre = nombre;
        this.cuit = cuit;
    }
    
    // GETTERS
    public String getNombre() { return nombre; }
    public String getCuit() { return cuit; }
}

class Cliente {
    private String nombre;
    private String dni;
    private TarjetaDeCredito tarjeta;

    public Cliente(String nombre, String dni) {
        this.nombre = nombre;
        this.dni = dni;
    }

    public void setTarjeta(TarjetaDeCredito tarjeta) { this.tarjeta = tarjeta; }
    
    // GETTERS
    public String getNombre() { return nombre; }
    public String getDni() { return dni; }
    public TarjetaDeCredito getTarjeta() { return tarjeta; }
}

class TarjetaDeCredito {
    private String numero;
    private String fechaVencimiento;
    private Cliente cliente;
    private Banco banco;

    public TarjetaDeCredito(String numero, String fechaVencimiento, Cliente cliente, Banco banco) {
        this.numero = numero;
        this.fechaVencimiento = fechaVencimiento;
        this.cliente = cliente;
        this.banco = banco;
        cliente.setTarjeta(this);
    }
    
    // GETTERS
    public String getNumero() { return numero; }
    public String getFechaVencimiento() { return fechaVencimiento; }
    public Cliente getCliente() { return cliente; }
    public Banco getBanco() { return banco; }
}

// EJERCICIO 5: Computadora - PlacaMadre - Propietario
class PlacaMadre {
    private String modelo;
    private String chipset;

    public PlacaMadre(String modelo, String chipset) {
        this.modelo = modelo;
        this.chipset = chipset;
    }
    
    // GETTERS
    public String getModelo() { return modelo; }
    public String getChipset() { return chipset; }
}

class Propietario {
    private String nombre;
    private String dni;
    private Computadora computadora;

    public Propietario(String nombre, String dni) {
        this.nombre = nombre;
        this.dni = dni;
    }

    public void setComputadora(Computadora computadora) { this.computadora = computadora; }
    
    // GETTERS
    public String getNombre() { return nombre; }
    public String getDni() { return dni; }
    public Computadora getComputadora() { return computadora; }
}

class Computadora {
    private String marca;
    private String numeroSerie;
    private PlacaMadre placaMadre;
    private Propietario propietario;

    public Computadora(String marca, String numeroSerie, String modeloPlaca, String chipset, Propietario propietario) {
        this.marca = marca;
        this.numeroSerie = numeroSerie;
        this.placaMadre = new PlacaMadre(modeloPlaca, chipset);
        this.propietario = propietario;
        propietario.setComputadora(this);
    }
    
    // GETTERS
    public String getMarca() { return marca; }
    public String getNumeroSerie() { return numeroSerie; }
    public PlacaMadre getPlacaMadre() { return placaMadre; }
    public Propietario getPropietario() { return propietario; }
}

// EJERCICIO 6: Reserva - Cliente - Mesa
class Mesa {
    private int numero;
    private int capacidad;

    public Mesa(int numero, int capacidad) {
        this.numero = numero;
        this.capacidad = capacidad;
    }
    
    // GETTERS
    public int getNumero() { return numero; }
    public int getCapacidad() { return capacidad; }
}

class ClienteReserva {
    private String nombre;
    private String telefono;

    public ClienteReserva(String nombre, String telefono) {
        this.nombre = nombre;
        this.telefono = telefono;
    }
    
    // GETTERS
    public String getNombre() { return nombre; }
    public String getTelefono() { return telefono; }
}

class Reserva {
    private String fecha;
    private String hora;
    private ClienteReserva cliente;
    private Mesa mesa;

    public Reserva(String fecha, String hora, ClienteReserva cliente, Mesa mesa) {
        this.fecha = fecha;
        this.hora = hora;
        this.cliente = cliente;
        this.mesa = mesa;
    }
    
    // GETTERS
    public String getFecha() { return fecha; }
    public String getHora() { return hora; }
    public ClienteReserva getCliente() { return cliente; }
    public Mesa getMesa() { return mesa; }
}

// EJERCICIO 7: Vehículo - Motor - Conductor
class Motor {
    private String tipo;
    private String numeroSerie;

    public Motor(String tipo, String numeroSerie) {
        this.tipo = tipo;
        this.numeroSerie = numeroSerie;
    }
    
    // GETTERS
    public String getTipo() { return tipo; }
    public String getNumeroSerie() { return numeroSerie; }
}

class Conductor {
    private String nombre;
    private String licencia;
    private Vehiculo vehiculo;

    public Conductor(String nombre, String licencia) {
        this.nombre = nombre;
        this.licencia = licencia;
    }

    public void setVehiculo(Vehiculo vehiculo) { this.vehiculo = vehiculo; }
    
    // GETTERS
    public String getNombre() { return nombre; }
    public String getLicencia() { return licencia; }
    public Vehiculo getVehiculo() { return vehiculo; }
}

class Vehiculo {
    private String patente;
    private String modelo;
    private Motor motor;
    private Conductor conductor;

    public Vehiculo(String patente, String modelo, Motor motor, Conductor conductor) {
        this.patente = patente;
        this.modelo = modelo;
        this.motor = motor;
        this.conductor = conductor;
        conductor.setVehiculo(this);
    }
    
    // GETTERS
    public String getPatente() { return patente; }
    public String getModelo() { return modelo; }
    public Motor getMotor() { return motor; }
    public Conductor getConductor() { return conductor; }
}

// EJERCICIO 8: Documento - FirmaDigital - Usuario
class UsuarioFirma {
    private String nombre;
    private String email;

    public UsuarioFirma(String nombre, String email) {
        this.nombre = nombre;
        this.email = email;
    }
    
    // GETTERS
    public String getNombre() { return nombre; }
    public String getEmail() { return email; }
}

class FirmaDigital {
    private String codigoHash;
    private String fecha;
    private UsuarioFirma usuario;

    public FirmaDigital(String codigoHash, String fecha, UsuarioFirma usuario) {
        this.codigoHash = codigoHash;
        this.fecha = fecha;
        this.usuario = usuario;
    }
    
    // GETTERS
    public String getCodigoHash() { return codigoHash; }
    public String getFecha() { return fecha; }
    public UsuarioFirma getUsuario() { return usuario; }
}

class Documento {
    private String titulo;
    private String contenido;
    private FirmaDigital firmaDigital;

    public Documento(String titulo, String contenido, String codigoHash, String fecha, UsuarioFirma usuario) {
        this.titulo = titulo;
        this.contenido = contenido;
        this.firmaDigital = new FirmaDigital(codigoHash, fecha, usuario);
    }
    
    // GETTERS
    public String getTitulo() { return titulo; }
    public String getContenido() { return contenido; }
    public FirmaDigital getFirmaDigital() { return firmaDigital; }
}

// EJERCICIO 9: CitaMédica - Paciente - Profesional
class Paciente {
    private String nombre;
    private String obraSocial;

    public Paciente(String nombre, String obraSocial) {
        this.nombre = nombre;
        this.obraSocial = obraSocial;
    }
    
    // GETTERS
    public String getNombre() { return nombre; }
    public String getObraSocial() { return obraSocial; }
}

class Profesional {
    private String nombre;
    private String especialidad;

    public Profesional(String nombre, String especialidad) {
        this.nombre = nombre;
        this.especialidad = especialidad;
    }
    
    // GETTERS
    public String getNombre() { return nombre; }
    public String getEspecialidad() { return especialidad; }
}

class CitaMedica {
    private String fecha;
    private String hora;
    private Paciente paciente;
    private Profesional profesional;

    public CitaMedica(String fecha, String hora, Paciente paciente, Profesional profesional) {
        this.fecha = fecha;
        this.hora = hora;
        this.paciente = paciente;
        this.profesional = profesional;
    }
    
    // GETTERS
    public String getFecha() { return fecha; }
    public String getHora() { return hora; }
    public Paciente getPaciente() { return paciente; }
    public Profesional getProfesional() { return profesional; }
}

// EJERCICIO 10: CuentaBancaria - ClaveSeguridad - Titular
class ClaveSeguridad {
    private String codigo;
    private String ultimaModificacion;

    public ClaveSeguridad(String codigo, String ultimaModificacion) {
        this.codigo = codigo;
        this.ultimaModificacion = ultimaModificacion;
    }
    
    // GETTERS
    public String getCodigo() { return codigo; }
    public String getUltimaModificacion() { return ultimaModificacion; }
}

class TitularCuenta {
    private String nombre;
    private String dni;
    private CuentaBancaria cuenta;

    public TitularCuenta(String nombre, String dni) {
        this.nombre = nombre;
        this.dni = dni;
    }

    public void setCuenta(CuentaBancaria cuenta) { this.cuenta = cuenta; }
    
    // GETTERS
    public String getNombre() { return nombre; }
    public String getDni() { return dni; }
    public CuentaBancaria getCuenta() { return cuenta; }
}

class CuentaBancaria {
    private String cbu;
    private double saldo;
    private ClaveSeguridad clave;
    private TitularCuenta titular;

    public CuentaBancaria(String cbu, double saldo, String codigoClave, String ultimaModificacion, TitularCuenta titular) {
        this.cbu = cbu;
        this.saldo = saldo;
        this.clave = new ClaveSeguridad(codigoClave, ultimaModificacion);
        this.titular = titular;
        titular.setCuenta(this);
    }
    
    // GETTERS
    public String getCbu() { return cbu; }
    public double getSaldo() { return saldo; }
    public ClaveSeguridad getClave() { return clave; }
    public TitularCuenta getTitular() { return titular; }
}

// ... (todo el código anterior de las clases permanece igual)

// CLASE PRINCIPAL
public class UMLBasico {
    public static void main(String[] args) {
        System.out.println("=== DEMOSTRACIÓN DE TODAS LAS RELACIONES UML 1 A 1 ===\n");
        
        // Ejercicio 1: Pasaporte - Foto - Titular
        System.out.println("1. Pasaporte - Foto - Titular (Composición + Asociación bidireccional)");
        Titular titular1 = new Titular("Juan Pérez", "12345678");
        Pasaporte pasaporte1 = new Pasaporte("AB123456", "2024-01-15", "foto.jpg", "JPEG", titular1);
        System.out.println("Titular: " + titular1.getNombre() + " - Pasaporte: " + pasaporte1.getNumero());
        
        // Ejercicio 2: Celular - Batería - Usuario
        System.out.println("\n2. Celular - Batería - Usuario (Agregación + Asociación bidireccional)");
        Bateria bateria1 = new Bateria("Li-ion", 4000);
        Usuario usuario1 = new Usuario("María García", "87654321");
        Celular celular1 = new Celular("123456789012345", "Samsung", "Galaxy S23", bateria1, usuario1);
        System.out.println("Usuario: " + usuario1.getNombre() + " - Celular: " + celular1.getImei() + " - Batería: " + celular1.getBateria().getCapacidad() + "mAh");
        
        // Ejercicio 3: Libro - Autor - Editorial
        System.out.println("\n3. Libro - Autor - Editorial (Asociación unidireccional + Agregación)");
        Autor autor1 = new Autor("Gabriel García Márquez", "Colombiana");
        Editorial editorial1 = new Editorial("Sudamericana", "Buenos Aires");
        Libro libro1 = new Libro("Cien años de soledad", "978-0307474728", autor1, editorial1);
        System.out.println("Libro: " + libro1.getTitulo() + " - Autor: " + libro1.getAutor().getNombre() + " - Editorial: " + libro1.getEditorial().getNombre());
        
        // Ejercicio 4: TarjetaDeCrédito - Cliente - Banco
        System.out.println("\n4. TarjetaDeCrédito - Cliente - Banco (Asociación bidireccional + Agregación)");
        Banco banco1 = new Banco("Banco Nacional", "30-12345678-9");
        Cliente cliente1 = new Cliente("Carlos López", "11222333");
        TarjetaDeCredito tarjeta1 = new TarjetaDeCredito("1234-5678-9012-3456", "12/2027", cliente1, banco1);
        System.out.println("Cliente: " + cliente1.getNombre() + " - Tarjeta: " + tarjeta1.getNumero() + " - Banco: " + tarjeta1.getBanco().getNombre());
        
        // Ejercicio 5: Computadora - PlacaMadre - Propietario
        System.out.println("\n5. Computadora - PlacaMadre - Propietario (Composición + Asociación bidireccional)");
        Propietario propietario1 = new Propietario("Ana Torres", "44555666");
        Computadora compu1 = new Computadora("Dell", "SN123456", "ASUS Prime", "B550", propietario1);
        System.out.println("Propietario: " + propietario1.getNombre() + " - Computadora: " + compu1.getMarca() + " - Placa: " + compu1.getPlacaMadre().getModelo());
        
        // Ejercicio 6: Reserva - Cliente - Mesa
        System.out.println("\n6. Reserva - Cliente - Mesa (Asociación unidireccional + Agregación)");
        ClienteReserva clienteReserva1 = new ClienteReserva("Roberto Silva", "115554444");
        Mesa mesa1 = new Mesa(5, 4);
        Reserva reserva1 = new Reserva("2024-10-15", "20:30", clienteReserva1, mesa1);
        System.out.println("Reserva: " + reserva1.getFecha() + " " + reserva1.getHora() + " - Cliente: " + reserva1.getCliente().getNombre() + " - Mesa: " + reserva1.getMesa().getNumero());
        
        // Ejercicio 7: Vehículo - Motor - Conductor
        System.out.println("\n7. Vehículo - Motor - Conductor (Agregación + Asociación bidireccional)");
        Motor motor1 = new Motor("V8", "MTR123456");
        Conductor conductor1 = new Conductor("Laura Méndez", "LIC998877");
        Vehiculo vehiculo1 = new Vehiculo("ABC123", "Toyota Hilux", motor1, conductor1);
        System.out.println("Conductor: " + conductor1.getNombre() + " - Vehículo: " + vehiculo1.getPatente() + " - Motor: " + vehiculo1.getMotor().getTipo());
        
        // Ejercicio 8: Documento - FirmaDigital - Usuario
        System.out.println("\n8. Documento - FirmaDigital - Usuario (Composición + Agregación)");
        UsuarioFirma usuarioFirma1 = new UsuarioFirma("Dr. González", "dr.gonzalez@email.com");
        Documento documento1 = new Documento("Contrato", "Texto del contrato...", "a1b2c3d4e5", "2024-10-10", usuarioFirma1);
        System.out.println("Documento: " + documento1.getTitulo() + " - Firmado por: " + documento1.getFirmaDigital().getUsuario().getNombre() + " - Hash: " + documento1.getFirmaDigital().getCodigoHash());
        
        // Ejercicio 9: CitaMédica - Paciente - Profesional
        System.out.println("\n9. CitaMédica - Paciente - Profesional (Asociación unidireccional x2)");
        Paciente paciente1 = new Paciente("Sofía Ruiz", "OSDE 210");
        Profesional profesional1 = new Profesional("Dr. Martínez", "Cardiología");
        CitaMedica cita1 = new CitaMedica("2024-10-20", "10:00", paciente1, profesional1);
        System.out.println("Cita: " + cita1.getFecha() + " " + cita1.getHora() + " - Paciente: " + cita1.getPaciente().getNombre() + " - Médico: " + cita1.getProfesional().getNombre());
        
        // Ejercicio 10: CuentaBancaria - ClaveSeguridad - Titular
        System.out.println("\n10. CuentaBancaria - ClaveSeguridad - Titular (Composición + Asociación bidireccional)");
        TitularCuenta titularCuenta1 = new TitularCuenta("Miguel Ángel", "99887766");
        CuentaBancaria cuenta1 = new CuentaBancaria("1234567890123456789012", 150000.50, "claveSegura123", "2024-09-01", titularCuenta1);
        System.out.println("Titular: " + titularCuenta1.getNombre() + " - CBU: " + cuenta1.getCbu() + " - Saldo: $" + cuenta1.getSaldo() + " - Clave: " + cuenta1.getClave().getCodigo());
        
        System.out.println("Resumen de relaciones demostradas:");
        System.out.println("- 3 Composiciónes");
        System.out.println("- 4 Agregaciones"); 
        System.out.println("- 5 Asociaciones bidireccionales");
        System.out.println("- 3 Asociaciones unidireccionales");
    }
}