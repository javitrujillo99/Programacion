import UIKit

class Mamifero {
    var orejas: Int
    var patas: Int
    
    init() {
        orejas = 0
        patas = 0
    }
    
    func descripcion() -> String {
        return "El mamifero tiene \(orejas) orejas y \(patas) patas"
    }
}

//La clase Perro extiende de Mamifero
class Perro: Mamifero {
    var color: String
    var pelaje: String
    
    override init() {
        color = "Canela"
        pelaje = "Corto"
        
        //Super es llamar a la clase padre
        super.init()
    }
}

var perro = Perro()

perro.descripcion()
perro.orejas = 2
perro.patas = 4

perro.descripcion()



//SOBRECARGA DE OPERADORES

//La sobrecarga de operadores posibilita la modificación del comportamiento de un operador (+, -, *, /, <, >, =, %, ¡,&, ^, ). Los operadores personalizados se declaran con la palabra reservada reservator,
//  y son declarados como prefix(++¡), infix(a+b), postfix(¡++).


prefix operator +-+

prefix func +-+(num: Int) -> Int {
        var resultado = num
        resultado += resultado
        return resultado
}

var entero = 5

entero
+-+entero

