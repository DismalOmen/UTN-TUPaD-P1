import math
from collections import deque

# Punto 1, 2 y 3
def gestionar_frutas():
    precios_frutas = {'Banana': 1200, 'Ananá': 2500, 'Melón': 3000, 'Uva': 1450}

    # Añadir frutas
    precios_frutas.update({'Naranja': 1200, 'Manzana': 1500, 'Pera': 2300})

    # Actualizar precios
    precios_frutas.update({'Banana': 1330, 'Manzana': 1700, 'Melón': 2800})

    # Lista de frutas
    solo_frutas = list(precios_frutas.keys())
    print("Frutas:", solo_frutas)


# Punto 4
class Persona:
    def __init__(self, nombre, pais, edad):
        self.nombre = nombre
        self.pais = pais
        self.edad = edad

    def saludar(self):
        print(f"¡Hola! Soy {self.nombre}, vivo en {self.pais} y tengo {self.edad} años.")


# Punto 5
class Circulo:
    def __init__(self, radio):
        self.radio = radio

    def calcular_area(self):
        return math.pi * self.radio ** 2

    def calcular_perimetro(self):
        return 2 * math.pi * self.radio


# Punto 6
def balanceado(cadena):
    pila = []
    pares = {')': '(', '}': '{', ']': '['}
    for caracter in cadena:
        if caracter in "({[":
            pila.append(caracter)
        elif caracter in ")}]":
            if not pila or pila.pop() != pares[caracter]:
                return False
    return not pila


# Punto 7
class Banco:
    def __init__(self):
        self.cola = deque()

    def agregar_cliente(self, nombre):
        self.cola.append(nombre)

    def atender_cliente(self):
        if self.cola:
            return self.cola.popleft()
        return None

    def siguiente_cliente(self):
        return self.cola[0] if self.cola else None


# Punto 8 y 9
class Nodo:
    def __init__(self, valor):
        self.valor = valor
        self.siguiente = None

class ListaEnlazada:
    def __init__(self):
        self.cabeza = None

    def insertar_inicio(self, valor):
        nuevo = Nodo(valor)
        nuevo.siguiente = self.cabeza
        self.cabeza = nuevo

    def mostrar(self):
        actual = self.cabeza
        while actual:
            print(f"{actual.valor} -> ", end="")
            actual = actual.siguiente
        print("None")

    def invertir(self):
        anterior = None
        actual = self.cabeza
        while actual:
            siguiente = actual.siguiente
            actual.siguiente = anterior
            anterior = actual
            actual = siguiente
        self.cabeza = anterior


# MAIN
def main():
    # Punto 1-3
    gestionar_frutas()

    # Punto 4
    persona = Persona("Ana", "Argentina", 30)
    persona.saludar()

    # Punto 5
    circulo = Circulo(5)
    print("Área:", circulo.calcular_area())
    print("Perímetro:", circulo.calcular_perimetro())

    # Punto 6
    print("balanceado(\"({[()]})\") →", balanceado("({[()]})"))
    print("balanceado(\"({[}\") →", balanceado("({[}"))

    # Punto 7
    banco = Banco()
    banco.agregar_cliente("Carlos")
    banco.agregar_cliente("Lucía")
    print("Siguiente cliente:", banco.siguiente_cliente())
    print("Atendiendo:", banco.atender_cliente())
    print("Siguiente cliente:", banco.siguiente_cliente())

    # Punto 8 y 9
    lista = ListaEnlazada()
    lista.insertar_inicio(3)
    lista.insertar_inicio(2)
    lista.insertar_inicio(1)
    print("Lista original:", end=" ")
    lista.mostrar()
    lista.invertir()
    print("Lista invertida:", end=" ")
    lista.mostrar()


if __name__ == "__main__":
    main()
