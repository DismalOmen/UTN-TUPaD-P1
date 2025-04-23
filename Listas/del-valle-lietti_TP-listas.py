#1
multiplos_de_4 = list(range(4, 101, 4))
print("Ejercicio 1 - Múltiplos de 4:", multiplos_de_4)

#2
lista_favoritos = ["libros", "música", "viajar", "programar", "café"]
print("\nEjercicio 2 - Penúltimo elemento:", lista_favoritos[-2])

#3
lista_vacia = []
lista_vacia.append("Python")
lista_vacia.append("UTN")
lista_vacia.append("Listas")
print("\nEjercicio 3 - Lista con append:", lista_vacia)

#4
animales = ["perro", "gato", "conejo", "pez"]
animales[1] = "loro"
animales[-1] = "oso"
print("\nEjercicio 4 - Lista modificada:", animales)

#5
# el programa número 5 remueve el mayor número de la lista y luego lo imprime

#6
numeros = list(range(10, 31, 5))
print("\nEjercicio 6 - Dos primeros elementos:", numeros[:2])


#7
autos = ["sedan", "polo", "suran", "gol"]
autos[1:3] = ["camioneta", "pickup"]
print("\nEjercicio 7 - Autos modificados:", autos)


#8
dobles = []
dobles.append(5 * 2)
dobles.append(10 * 2)
dobles.append(15 * 2)
print("\nEjercicio 8 - Lista de dobles:", dobles)


#9
compras = [["pan", "leche"], ["arroz", "fideos", "salsa"], ["agua"]]
compras[2].append("jugo")
compras[1][1] = "tallarines"
compras[0].remove("pan")
print("\nEjercicio 9 - Compras modificadas:", compras)


#10
lista_anidada = [
    15,
    True,
    [25.5, 57.9, 30.6],
    False
]
print("\nEjercicio 10 - Lista anidada:", lista_anidada)