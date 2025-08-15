## 1

def factorial(n):
    if n == 0 or n == 1:
        return 1
    else:
        return n * factorial(n - 1)

n = int(input("Ingrese un número: "))
for i in range(1, n + 1):
    print(f"Factorial de {i}: {factorial(i)}")

# 2

def fibonacci(pos):
    if pos == 0:
        return 0
    elif pos == 1:
        return 1
    else:
        return fibonacci(pos - 1) + fibonacci(pos - 2)

n = int(input("Ingrese una posición: "))
for i in range(n + 1):
    print(f"Posición {i}: {fibonacci(i)}")

# 3
def potencia(base, exponente):
    if exponente == 0:
        return 1
    else:
        return base * potencia(base, exponente - 1)

base = int(input("Base: "))
exponente = int(input("Exponente: "))
print(f"{base}^{exponente} = {potencia(base, exponente)}")

# 4

def decimal_a_binario(n):
    if n == 0:
        return "0"
    elif n == 1:
        return "1"
    else:
        return decimal_a_binario(n // 2) + str(n % 2)

n = int(input("Número decimal: "))
print(f"Binario: {decimal_a_binario(n)}")

# 5
def es_palindromo(palabra):
    if len(palabra) <= 1:
        return True
    else:
        if palabra[0] == palabra[-1]:
            return es_palindromo(palabra[1:-1])
        else:
            return False

palabra = input("Ingrese una palabra: ").lower()
print(f"¿Es palíndromo? {es_palindromo(palabra)}")

# 6

def suma_digitos(n):
    if n < 10:
        return n
    else:
        return (n % 10) + suma_digitos(n // 10)

n = int(input("Número: "))
print(f"Suma de dígitos: {suma_digitos(n)}")

# 7

def contar_bloques(n):
    if n == 1:
        return 1
    else:
        return n + contar_bloques(n - 1)

n = int(input("Bloques en la base: "))
print(f"Total de bloques: {contar_bloques(n)}")

# 8

def contar_digito(numero, digito):
    if numero == 0:
        return 0
    else:
        ultimo_digito = numero % 10
        if ultimo_digito == digito:
            return 1 + contar_digito(numero // 10, digito)
        else:
            return contar_digito(numero // 10, digito)

numero = int(input("Número: "))
digito = int(input("Dígito a buscar (0-9): "))
print(f"El dígito {digito} aparece {contar_digito(numero, digito)} veces")