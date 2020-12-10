import Foundation

//Ejercicio 1

func mostrarMayor(num1: Int, num2: Int) -> Int {
    if num1 > num2 {
        return num1
    } else if num2 > num1 {
        return num2
    } else {
        print("Los números son iguales")
        return num1
    }
}

var num = mostrarMayor(num1: 1, num2: 1)
print("El mayor es \(num)")


//Ejercicio 2

func hacerMedia(nota1: Float, nota2: Float, nota3: Float, nota4: Float, nota5: Float) -> Float {
    return (nota1 + nota2 + nota3 + nota4 + nota5) / 5
}

var media = hacerMedia(nota1: 10, nota2: 8, nota3: 8, nota4: 9, nota5: 10)
print("La media es \(media)")


//Ejercicio 3

func tablaMultiplicar(numero: Int) {
    for i in 0...10 {
        print("\(numero) x \(i) = \(numero * i)")
    }
}

tablaMultiplicar(numero: 5)


//Ejercicio 4

func recorrerArray(numeros: [Int]) {
    for numero in numeros {
        print("\(numero)")
    }
}

recorrerArray(numeros: [1, 2, 3, 4, 5])
