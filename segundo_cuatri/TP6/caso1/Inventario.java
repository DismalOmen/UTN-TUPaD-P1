import java.util.ArrayList;
import java.util.List;

public class Inventario {
    private ArrayList<Producto> productos;
    private static int totalInventariosCreados = 0; // Atributo estático
    
    // Constructor
    public Inventario() {
        this.productos = new ArrayList<>();
        totalInventariosCreados++; // Incrementar contador estático
    }
    
    // Método estático para obtener el total de inventarios creados
    public static int getTotalInventariosCreados() {
        return totalInventariosCreados;
    }
    
    // Método estático para mostrar información general del sistema
    public static void mostrarInfoSistema() {
        System.out.println("=== SISTEMA DE GESTIÓN DE INVENTARIOS ===");
        System.out.println("Total de inventarios creados: " + totalInventariosCreados);
        System.out.println("Desarrollado en Java con POO");
        System.out.println("========================================");
    }
    
    // Agregar producto al inventario
    public void agregarProducto(Producto p) {
        if (buscarProductoPorId(p.getId()) != null) {
            System.out.println("Error: Ya existe un producto con el ID " + p.getId());
            return;
        }
        productos.add(p);
        System.out.println("Producto agregado: " + p.getNombre());
    }
    
    // Método sobrecargado para agregar producto con parámetros individuales
    public void agregarProducto(String id, String nombre, double precio, int cantidad, CategoriaProducto categoria) {
        Producto nuevoProducto = new Producto(id, nombre, precio, cantidad, categoria);
        agregarProducto(nuevoProducto);
    }
    
    // Listar todos los productos
    public void listarProductos() {
        if (productos.isEmpty()) {
            System.out.println("No hay productos en el inventario.");
            return;
        }
        
        System.out.println("=== LISTA DE PRODUCTOS EN INVENTARIO ===");
        for (int i = 0; i < productos.size(); i++) {
            Producto p = productos.get(i);
            System.out.printf("%d. %s (ID: %s) - Stock: %d - Precio: $%.2f - Categoría: %s%n", 
                            (i + 1), p.getNombre(), p.getId(), p.getCantidad(), p.getPrecio(), p.getCategoria());
        }
        System.out.println("=======================================");
    }
    
    // Método sobrecargado para listar productos de forma resumida
    public void listarProductos(boolean resumido) {
        if (resumido) {
            System.out.println("=== LISTA RESUMIDA DE PRODUCTOS ===");
            for (Producto p : productos) {
                p.mostrarInfo(true);
            }
        } else {
            listarProductos();
        }
    }
    
    // Buscar producto por ID
    public Producto buscarProductoPorId(String id) {
        for (Producto producto : productos) {
            if (producto.getId().equals(id)) {
                return producto;
            }
        }
        return null;
    }
    
    // Eliminar producto por ID
    public boolean eliminarProducto(String id) {
        Producto producto = buscarProductoPorId(id);
        if (producto != null) {
            productos.remove(producto);
            System.out.println("Producto eliminado: " + producto.getNombre());
            return true;
        } else {
            System.out.println("Error: No se encontró un producto con ID " + id);
            return false;
        }
    }
    
    // Actualizar stock de un producto
    public boolean actualizarStock(String id, int nuevaCantidad) {
        Producto producto = buscarProductoPorId(id);
        if (producto != null) {
            if (nuevaCantidad >= 0) {
                producto.setCantidad(nuevaCantidad);
                System.out.printf("Stock actualizado para %s: %d unidades%n", 
                                producto.getNombre(), nuevaCantidad);
                return true;
            } else {
                System.out.println("Error: La cantidad no puede ser negativa");
                return false;
            }
        } else {
            System.out.println("Error: No se encontró un producto con ID " + id);
            return false;
        }
    }
    
    // Filtrar productos por categoría
    public List<Producto> filtrarPorCategoria(CategoriaProducto categoria) {
        List<Producto> productosFiltrados = new ArrayList<>();
        for (Producto producto : productos) {
            if (producto.getCategoria() == categoria) {
                productosFiltrados.add(producto);
            }
        }
        return productosFiltrados;
    }
    
    // Obtener el total de productos en stock
    public int obtenerTotalStock() {
        int total = 0;
        for (Producto producto : productos) {
            total += producto.getCantidad();
        }
        return total;
    }
    
    // Obtener el producto con mayor stock
    public Producto obtenerProductoConMayorStock() {
        if (productos.isEmpty()) {
            return null;
        }
        
        Producto productoMayorStock = productos.get(0);
        for (Producto producto : productos) {
            if (producto.getCantidad() > productoMayorStock.getCantidad()) {
                productoMayorStock = producto;
            }
        }
        return productoMayorStock;
    }
    
    // Filtrar productos por rango de precio
    public List<Producto> filtrarProductosPorPrecio(double min, double max) {
        List<Producto> productosFiltrados = new ArrayList<>();
        for (Producto producto : productos) {
            if (producto.getPrecio() >= min && producto.getPrecio() <= max) {
                productosFiltrados.add(producto);
            }
        }
        return productosFiltrados;
    }
    
    // Mostrar categorías disponibles
    public void mostrarCategoriasDisponibles() {
        System.out.println("=== CATEGORIAS DISPONIBLES ===");
        for (CategoriaProducto categoria : CategoriaProducto.values()) {
            System.out.printf("- %s: %s%n", categoria, categoria.getDescripcion());
        }
        System.out.println("==============================");
    }
    
    // Método toString para representación del inventario
    @Override
    public String toString() {
        return String.format("Inventario[Total productos: %d, Stock total: %d]", 
                           productos.size(), obtenerTotalStock());
    }
}