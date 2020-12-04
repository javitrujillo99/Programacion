import UIKit

//Creamos una estructura u objeto
struct Motor {
    var caballos: Int = 120
    var cilindros: Int = 4
}

//Creamos una clase
class Coche {
    var motor: Motor
    var color: String
    var puertas: Int
    var maxPasajeros: Int
    var numPasajeros: Int?
    
    //Tenemos que crear siempre un inicializador
    init() {
        self.motor = Motor()
        self.color = "Rojo"
        self.puertas = 5
        self.maxPasajeros = 5
    }
    
    //Creamos una funcion dentro de la clase
    func arrancar() {
        print("Pisamos el acelerador")
    }
}

