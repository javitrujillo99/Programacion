import UIKit

func saludar() {
    print("Hola")
}

//Llamar a la funcion
saludar()

//Funcion con parametros
func saludarA(nombre: String, apellido: String) {
    print("Hola \(nombre) \(apellido)")
}

saludarA(nombre: "María", apellido: "Gutiérrez")

//Funcion que devuelva parametros
func devuelveElDoble(numero: Int) -> Int {
    return numero * 2
}

devuelveElDoble(numero: 3)

var ElDoble = devuelveElDoble(numero: 2)

ElDoble
