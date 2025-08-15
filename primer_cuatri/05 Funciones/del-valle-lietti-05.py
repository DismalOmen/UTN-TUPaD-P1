import math

def imprimir_hola_mundo():
    print("Hola Mundo!")

def saludar_usuario(nombre):
    return f"Hola {nombre}!"

def informacion_personal(nombre, apellido, edad, residencia):
    print(f"Soy {nombre} {apellido}, tengo {edad} años y vivo en {residencia}.")

def calcular_area_circulo(radio):
    return math.pi * radio ** 2

def calcular_perimetro_circulo(radio):
    return 2 * math.pi * radio

def segundos_a_horas(segundos):
    return segundos / 3600

def tabla_multiplicar(numero):
    print(f"Tabla del {numero}:")
    for i in range(1, 11):
        print(f"{numero} x {i} = {numero * i}")

def operaciones_basicas(a, b):
    suma = a + b
    resta = a - b
    multiplicacion = a * b
    division = a / b if b != 0 else "No se puede dividir por cero"
    return (suma, resta, multiplicacion, division)

def calcular_imc(peso, altura):
    return peso / (altura ** 2)

def celsius_a_fahrenheit(celsius):
    return (celsius * 9/5) + 32

def calcular_promedio(a, b, c):
    return (a + b + c) / 3

def main():
    # Actividad 1
    imprimir_hola_mundo()

    # Actividad 2
    nombre = input("¿Cuál es tu nombre? ")
    print(saludar_usuario(nombre))

    # Actividad 3
    nombre = input("Nombre: ")
    apellido = input("Apellido: ")
    edad = input("Edad: ")
    residencia = input("Residencia: ")
    informacion_personal(nombre, apellido, edad, residencia)

    # Actividad 4
    radio = float(input("Ingrese el radio del círculo: "))
    print(f"Área del círculo: {calcular_area_circulo(radio):.2f}")
    print(f"Perímetro del círculo: {calcular_perimetro_circulo(radio):.2f}")

    # Actividad 5
    segundos = int(input("Ingrese cantidad de segundos: "))
    print(f"Equivale a {segundos_a_horas(segundos):.2f} horas.")

    # Actividad 6
    numero = int(input("Ingrese un número para la tabla de multiplicar: "))
    tabla_multiplicar(numero)

    # Actividad 7
    a = float(input("Ingrese el primer número: "))
    b = float(input("Ingrese el segundo número: "))
    suma, resta, mult, div = operaciones_basicas(a, b)
    print(f"Suma: {suma}")
    print(f"Resta: {resta}")
    print(f"Multiplicación: {mult}")
    print(f"División: {div}")

    # Actividad 8
    peso = float(input("Ingrese su peso en kg: "))
    altura = float(input("Ingrese su altura en metros: "))
    imc = calcular_imc(peso, altura)
    print(f"Su IMC es: {imc:.2f}")

    # Actividad 9
    celsius = float(input("Ingrese temperatura en grados Celsius: "))
    fahrenheit = celsius_a_fahrenheit(celsius)
    print(f"{celsius}°C equivale a {fahrenheit:.2f}°F")

    # Actividad 10
    n1 = float(input("Ingrese el primer número: "))
    n2 = float(input("Ingrese el segundo número: "))
    n3 = float(input("Ingrese el tercer número: "))
    promedio = calcular_promedio(n1, n2, n3)
    print(f"El promedio es: {promedio:.2f}")

if __name__ == "__main__":
    main()
