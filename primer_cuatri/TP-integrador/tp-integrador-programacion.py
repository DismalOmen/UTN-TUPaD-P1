def bubble_sort(contactos):
    n = len(contactos)
    for i in range(n):
        for j in range(0, n - i - 1):
            nombre1 = contactos[j].split(',')[0].lower()
            nombre2 = contactos[j + 1].split(',')[0].lower()
            if nombre1 > nombre2:
                contactos[j], contactos[j + 1] = contactos[j + 1], contactos[j]
    return contactos

def agregar_contacto(nombre, telefono):
    with open("contactos.txt", "a") as archivo:
        archivo.write(f"{nombre},{telefono}\n")
    print("Contacto agregado.\n")

def buscar_contacto(nombre):
    encontrado = False
    with open("contactos.txt", "r") as archivo:
        for linea in archivo:
            if linea.lower().startswith(nombre.lower() + ","):
                print("Contacto encontrado:", linea.strip())
                encontrado = True
                break
    if not encontrado:
        print("Contacto no encontrado.\n")

def mostrar_contactos():
    try:
        with open("contactos.txt", "r") as archivo:
            contactos = archivo.readlines()
            contactos = bubble_sort(contactos)
            print("\nContactos ordenados alfabéticamente:")
            for contacto in contactos:
                print(contacto.strip())
            print()
    except FileNotFoundError:
        print("No hay contactos aún.\n")

def menu():
    while True:
        print("1. Agregar contacto")
        print("2. Buscar contacto")
        print("3. Mostrar todos los contactos")
        print("4. Salir")
        opcion = input("Seleccione una opción: ")

        if opcion == "1":
            nombre = input("Nombre: ")
            telefono = input("Teléfono: ")
            agregar_contacto(nombre, telefono)
        elif opcion == "2":
            nombre = input("Nombre a buscar: ")
            buscar_contacto(nombre)
        elif opcion == "3":
            mostrar_contactos()
        elif opcion == "4":
            print("Programa finalizado.")
            break
        else:
            print("Opción no válida.\n")

menu()
