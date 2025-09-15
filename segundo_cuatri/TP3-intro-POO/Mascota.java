public class Mascota {
    String nombre;
    String especie;
    int edad;

    public void mostrarInfo() {
        System.out.println(nombre + ", Especie: " + especie + ", Edad: " + edad);
    }

    public void cumplirAnios() {
        edad++;
    }

    public static void main(String[] args) {
        Mascota mascota = new Mascota();
        mascota.nombre = "Firulais";
        mascota.especie = "Perro";
        mascota.edad = 3;

        mascota.mostrarInfo();
        mascota.cumplirAnios();
        mascota.mostrarInfo();
    }
}
