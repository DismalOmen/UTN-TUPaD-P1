package com.mycompany.tp1;
import java.util.Scanner;

public class ErrorEjemploCorregido {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingresa tu nombre: ");
        String nombre = scanner.nextLine(); // Corregido: nextLine() en vez de nextInt()
        System.out.println("Hola, " + nombre);
        
        /*
        Explicación del error original:
        - Se usaba scanner.nextInt() para leer un String
        - nextInt() solo lee números enteros
        - Para leer texto se debe usar nextLine()
        */
    }
}