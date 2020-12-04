import UIKit

// Generics nos permite crearnos atajos de código para no tener que repetir ciertas operaciones y ahorrarnos tiempo.

//Inout es para que no tenga que devolver ni cambie el valor de la variable
func intercambiarEnteros(enteroA: inout Int, enteroB: inout Int) {
    let temporal = enteroA
    enteroA = enteroB
    enteroB = temporal
}

var entero1 = 3
var entero2 = 5

//intercambiarEnteros(enteroA: &entero1, enteroB: &entero2)

entero1
entero2

//Ahora queremos hacer una funcion de intercambiar Strings
func intercambiarStrings(stringA: inout String, stringB: inout String) {
    let temporal = stringA
    stringA = stringB
    stringB = temporal
}

var string1 = "hola"
var string2 = "mundo"

//intercambiarStrings(stringA: &string1, stringB: &string2)

string1
string2

//Para evitar copiar codigo muy parecido, como en este caso, usamos los genericos

func intercambiarValores<T>(a: inout T, b: inout T) {
    let temporal = a
    a = b
    b = temporal
}

intercambiarValores(a: &entero1, b: &entero2)

entero1
entero2

intercambiarValores(a: &string1, b: &string2)

string1
string2
