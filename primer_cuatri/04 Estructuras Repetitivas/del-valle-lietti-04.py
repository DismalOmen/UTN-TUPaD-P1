# 1) Imprimir números del 0 al 100 (uno por línea)
print("Ejercicio 1:")
for i in range(101):
    print(i)

# 2) Contar dígitos de un número
n = input("Ingresa un número entero: ")
print("Cantidad de dígitos:", len(n.strip('-')))

# 3) Sumar enteros entre dos valores (excluyendo los extremos)
a = int(input("Ingresa el primer número: "))
b = int(input("Ingresa el segundo número: "))
suma = sum(range(min(a, b) + 1, max(a, b)))
print("Suma:", suma)

# 4) Sumar números hasta que el usuario ingrese 0
total = 0
while True:
    n = int(input("Ingresa un número (0 para terminar): "))
    if n == 0:
        break
    total += n
print("Suma total:", total)

# 5) Juego de adivinar número del 0 al 9
import random
secreto = random.randint(0, 9)
intentos = 0

while True:
    intento = int(input("Adivina el número (0-9): "))
    intentos += 1
    if intento == secreto:
        break

print("¡Correcto! Lo adivinaste en", intentos, "intentos.")

# 6) Números pares del 100 al 0 en orden decreciente
for i in range(100, -1, -2):
    print(i)

# 7) Suma de 0 hasta un número dado
n = int(input("Ingresa un número entero positivo: "))
suma = sum(range(n + 1))
print("Suma:", suma)

# 8) Clasificación de 100 números ingresados
pares = impares = positivos = negativos = 0
cantidad = 100  # Podés cambiar este número para pruebas

for _ in range(cantidad):
    n = int(input("Ingresa un número: "))
    if n % 2 == 0:
        pares += 1
    else:
        impares += 1
    if n >= 0:
        positivos += 1
    else:
        negativos += 1

print("Pares:", pares)
print("Impares:", impares)
print("Positivos:", positivos)
print("Negativos:", negativos)

# 9) Media de 100 números
suma = 0
cantidad = 100  # Podés cambiar este número para pruebas

for _ in range(cantidad):
    n = int(input("Ingresa un número: "))
    suma += n

media = suma / cantidad
print("Media:", media)

# 10) Invertir los dígitos de un número)
n = input("Ingresa un número: ")
invertido = n[::-1] if n[0] != '-' else '-' + n[:0:-1]
print("Número invertido:", invertido)
