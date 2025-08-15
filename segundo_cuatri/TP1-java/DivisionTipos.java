package com.mycompany.tp1;
import java.util.Scanner;

public class DivisionTipos {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Parte a: División con enteros
        System.out.println("--- División con enteros ---");
        System.out.print("Ingrese dividendo (entero): ");
        int a = scanner.nextInt();
        System.out.print("Ingrese divisor (entero): ");
        int b = scanner.nextInt();
        System.out.println("Resultado (int): " + (a / b)); // Truncamiento
        
        // Parte b: División con doubles
        System.out.println("\n--- División con doubles ---");
        System.out.print("Ingrese dividendo (double): ");
        double x = scanner.nextDouble();
        System.out.print("Ingrese divisor (double): ");
        double y = scanner.nextDouble();
        System.out.println("Resultado (double): " + (x / y)); // Preciso
    }
}