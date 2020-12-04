import UIKit

//Una enumeración define un grupo de valores relacionados de un tipo común y permite trabajar con los valores de una manera segura dentro del código.

enum AnimalesVertebrados {
    case mamiferos
    case peces
    case reptiles
    case aves
    case anfibios
}

var animalVertebrado: AnimalesVertebrados = .peces

switch animalVertebrado {
case .mamiferos:
    print("Es un mamifero")
case .peces:
    print("Es un pez")
case .reptiles:
    print("Es un reptil")
case .aves:
    print("Es un ave")
case.anfibios:
    print("Es un anfibio")
}
