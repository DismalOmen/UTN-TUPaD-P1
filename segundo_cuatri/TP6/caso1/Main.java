import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("INICIO DEL SISTEMA DE GESTION DE INVENTARIOS\n");
        
        // Mostrar información estática del sistema
        Inventario.mostrarInfoSistema();
        
        // Crear instancia del inventario
        Inventario inventario = new Inventario();
        
        // TAREA 10: Mostrar las categorías disponibles con sus descripciones
        System.out.println("TAREA 10: Mostrar categorias disponibles");
        inventario.mostrarCategoriasDisponibles();
        
        // TAREA 1: Crear al menos cinco productos con diferentes categorías
        System.out.println("TAREA 1: Crear y agregar productos al inventario");
        
        // Usando diferentes constructores (sobrecarga)
        Producto p1 = new Producto("A001", "Arroz Integral", 2.50, 100, CategoriaProducto.ALIMENTOS);
        Producto p2 = new Producto("E001", "Laptop Gaming", 2500.00, 15, CategoriaProducto.ELECTRONICA);
        Producto p3 = new Producto("R001", "Jeans Clasicos", 45.99, 50, CategoriaProducto.ROPA);
        Producto p4 = new Producto("H001", "Aspiradora Robot", 899.99, 8, CategoriaProducto.HOGAR);
        Producto p5 = new Producto("A002", "Aceite de Oliva", 12.75, 80, CategoriaProducto.ALIMENTOS);
        Producto p6 = new Producto("E002", "Smartphone", 1500.00, 25, CategoriaProducto.ELECTRONICA);
        
        // Agregar productos al inventario
        inventario.agregarProducto(p1);
        inventario.agregarProducto(p2);
        inventario.agregarProducto(p3);
        inventario.agregarProducto(p4);
        inventario.agregarProducto(p5);
        inventario.agregarProducto(p6);
        
        // Agregar producto usando método sobrecargado
        inventario.agregarProducto("R002", "Camiseta Basica", 15.99, 30, CategoriaProducto.ROPA);
        
        System.out.println();
        
        // TAREA 2: Listar todos los productos mostrando su información y categoría
        System.out.println("TAREA 2: Listar todos los productos");
        inventario.listarProductos();
        
        System.out.println();
        
        // TAREA 3: Buscar un producto por ID y mostrar su información
        System.out.println("TAREA 3: Buscar producto por ID (E001)");
        Producto productoEncontrado = inventario.buscarProductoPorId("E001");
        if (productoEncontrado != null) {
            productoEncontrado.mostrarInfo();
        } else {
            System.out.println("Producto no encontrado");
        }
        
        System.out.println();
        
        // TAREA 4: Filtrar y mostrar productos de una categoría específica
        System.out.println("TAREA 4: Filtrar productos de ALIMENTOS");
        List<Producto> alimentos = inventario.filtrarPorCategoria(CategoriaProducto.ALIMENTOS);
        System.out.println("=== PRODUCTOS DE ALIMENTOS ===");
        for (Producto alimento : alimentos) {
            alimento.mostrarInfo(true); // Usando método sobrecargado
        }
        
        System.out.println();
        
        // TAREA 5: Eliminar un producto por su ID y listar los restantes
        System.out.println("TAREA 5: Eliminar producto (R001) y listar restantes");
        inventario.eliminarProducto("R001");
        System.out.println("\nProductos después de la eliminación:");
        inventario.listarProductos(true); // Lista resumida
        
        System.out.println();
        
        // TAREA 6: Actualizar el stock de un producto existente
        System.out.println("TAREA 6: Actualizar stock del producto A001");
        inventario.actualizarStock("A001", 200);
        
        System.out.println();
        
        // TAREA 7: Mostrar el total de stock disponible
        System.out.println("TAREA 7: Mostrar total de stock disponible");
        int totalStock = inventario.obtenerTotalStock();
        System.out.println("Total de unidades en stock: " + totalStock);
        
        System.out.println();
        
        // TAREA 8: Obtener y mostrar el producto con mayor stock
        System.out.println("TAREA 8: Producto con mayor stock");
        Producto mayorStock = inventario.obtenerProductoConMayorStock();
        if (mayorStock != null) {
            System.out.println("Producto con mayor stock:");
            mayorStock.mostrarInfo();
        }
        
        System.out.println();
        
        // TAREA 9: Filtrar productos con precios entre $1000 y $3000
        System.out.println("TAREA 9: Filtrar productos entre $1000 y $3000");
        List<Producto> productosFiltrados = inventario.filtrarProductosPorPrecio(1000.0, 3000.0);
        System.out.println("=== PRODUCTOS ENTRE $1000 Y $3000 ===");
        if (productosFiltrados.isEmpty()) {
            System.out.println("No hay productos en este rango de precio");
        } else {
            for (Producto producto : productosFiltrados) {
                producto.mostrarInfo(true);
            }
        }
        
        System.out.println();
        
        // Demostración del uso de toString()
        System.out.println("DEMOSTRACION DEL METODO toString()");
        System.out.println("Información del inventario: " + inventario.toString());
        System.out.println("Información de un producto: " + p2.toString());
        
        System.out.println();
        
        // Mostrar información estática final
        System.out.println("=== ESTADISTICAS FINALES ===");
        System.out.println("Total de inventarios creados: " + Inventario.getTotalInventariosCreados());
        System.out.println("Total de productos en inventario: " + inventario.obtenerTotalStock());
        
        System.out.println("\nSISTEMA EJECUTADO EXITOSAMENTE");
    }
}