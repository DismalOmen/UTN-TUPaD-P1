public class Producto {
    private String id;
    private String nombre;
    private double precio;
    private int cantidad;
    private CategoriaProducto categoria;
    
    // Constructor completo
    public Producto(String id, String nombre, double precio, int cantidad, CategoriaProducto categoria) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
        this.categoria = categoria;
    }
    
    // Constructor sobrecargado - sin cantidad (por defecto 0)
    public Producto(String id, String nombre, double precio, CategoriaProducto categoria) {
        this(id, nombre, precio, 0, categoria);
    }
    
    // Constructor sobrecargado - solo id y nombre
    public Producto(String id, String nombre) {
        this(id, nombre, 0.0, 0, CategoriaProducto.ALIMENTOS);
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
    
    public double getPrecio() {
        return precio;
    }
    
    public void setPrecio(double precio) {
        this.precio = precio;
    }
    
    public int getCantidad() {
        return cantidad;
    }
    
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
    public CategoriaProducto getCategoria() {
        return categoria;
    }
    
    public void setCategoria(CategoriaProducto categoria) {
        this.categoria = categoria;
    }
    
    // Método para mostrar información del producto
    public void mostrarInfo() {
        System.out.println("=== INFORMACIÓN DEL PRODUCTO ===");
        System.out.println("ID: " + this.id);
        System.out.println("Nombre: " + this.nombre);
        System.out.println("Precio: $" + this.precio);
        System.out.println("Cantidad en stock: " + this.cantidad);
        System.out.println("Categoría: " + this.categoria + " - " + this.categoria.getDescripcion());
        System.out.println("================================");
    }
    
    // Método toString para representación en texto
    @Override
    public String toString() {
        return String.format("Producto[ID: %s, Nombre: %s, Precio: $%.2f, Stock: %d, Categoría: %s]", 
                           this.id, this.nombre, this.precio, this.cantidad, this.categoria);
    }
    
    // Método sobrecargado para mostrar información resumida
    public void mostrarInfo(boolean resumido) {
        if (resumido) {
            System.out.printf("ID: %s | %s | $%.2f | Stock: %d%n", 
                            this.id, this.nombre, this.precio, this.cantidad);
        } else {
            mostrarInfo();
        }
    }
}