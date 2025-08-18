package com.mycompany.tp2;
import java.util.Scanner;

public class Ejercicio9 {
    public static double calcularCostoEnvio(double peso, String zona) {
        if (zona.equalsIgnoreCase("Nacional")) return peso * 5;
        else return peso * 10;
    }

    public static double calcularTotalCompra(double precioProducto, double costoEnvio) {
        return precioProducto + costoEnvio;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese el precio del producto: ");
        double precio = sc.nextDouble();
        System.out.print("Ingrese el peso del paquete en kg: ");
        double peso = sc.nextDouble();
        sc.nextLine();
        System.out.print("Ingrese la zona de envío (Nacional/Internacional): ");
        String zona = sc.nextLine();

        double envio = calcularCostoEnvio(peso, zona);
        double total = calcularTotalCompra(precio, envio);

        System.out.println("El costo de envío es: " + envio);
        System.out.println("El total a pagar es: " + total);
    }
}
