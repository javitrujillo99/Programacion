import UIKit

//If else
var compareString1 = "String 1"
var compareString2 = "String 2"

if compareString1 == compareString2 {
    print("Los String son iguales")
} else {
    print("Los String no son iguales")
}

if compareString1 != compareString2 {
    print("Los String son diferentes")
}

var edad = 18

if edad > 18 {
    print("Somos mayores de edad")
} else if edad == 18 {
    print("Tengo 18 años")
} else {
    print("Somos menores de edad")
}

var heJugado = true
if heJugado {
    print("He jugado")
} else {
    print("No he jugado")
}
if heJugado && edad == 18 {
    print("hola")
}


//SWITCH

var numeroIntentos = 2

switch numeroIntentos {
case 0:
    print("Aun no has empezado")
case 1:
    print("Te quedan 2 intentos")
case 2:
    print("Te queda 1 intento")
default:
    print("Ya no te quedan intentos")
}

var mascota = "perro"

switch mascota {
case "gato":
    print("La mascota es un gato")
case "perro":
    print("La mascota es un perro")
default:
    print("No sabemos qué mascota es")
}


//BUCLES

//FOR IN
let coches = ["Ford Fiesta", "Citroen C1", "Ford Focus", "Citroen C3", "Ford Kuga"]

var cochesFord = 0
var cochesCitroen = 0

//Es como el foreach de PHP
for coche in coches {
    if coche.hasPrefix("Ford") {
        cochesFord += 1
    } else if coche.hasPrefix("Citroen") {
        cochesCitroen += 1
    }
}

cochesFord
cochesCitroen


//FOR NORMAL

for i in 0...3 {
    print("Valor de i = \(i)")
}


//WHILE

var entrar = true
var i = 0

while entrar {
    i += 1
    
    if i == 5 {
        entrar = false
    }
}

//REPEAT WHILE (DO WHILE)

i = 0
repeat {
    i += 1
} while i < 10

