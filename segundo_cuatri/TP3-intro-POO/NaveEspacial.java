public class NaveEspacial {
    String nombre;
    int combustible;
    final int MAX_COMBUSTIBLE = 100;

    public void despegar() {
        if(combustible >= 10) {
            combustible -= 10;
            System.out.println(nombre + " ha despegado");
        } else {
            System.out.println("No hay suficiente combustible para despegar");
        }
    }

    public void avanzar(int distancia) {
        if(combustible >= distancia) {
            combustible -= distancia;
            System.out.println(nombre + " avanzo " + distancia + " unidades");
        } else {
            System.out.println("Combustible insuficiente para avanzar " + distancia + " unidades");
        }
    }

    public void recargarCombustible(int cantidad) {
        if(combustible + cantidad <= MAX_COMBUSTIBLE) {
            combustible += cantidad;
        } else {
            combustible = MAX_COMBUSTIBLE;
        }
    }

    public void mostrarEstado() {
        System.out.println(nombre + " - Combustible: " + combustible);
    }

    public static void main(String[] args) {
        NaveEspacial nave = new NaveEspacial();
        nave.nombre = "Enterprise";
        nave.combustible = 50;

        nave.avanzar(20);   // insuficiente
        nave.recargarCombustible(30);
        nave.avanzar(20);
        nave.mostrarEstado();
    }
}
