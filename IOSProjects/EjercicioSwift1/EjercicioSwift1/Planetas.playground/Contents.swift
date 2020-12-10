import UIKit

class Planeta {
    var redondo: Bool
    var grande: Bool
    var desierto: Bool
    
    //Tenemos que crear siempre un inicializador
    init(redondo: Bool, grande: Bool, desierto: Bool) {
        self.redondo = redondo
        self.grande = grande
        self.desierto = desierto
    }
}

class Marte: Planeta {
    var hielo: Bool
    var rojo: Bool
    
    init(redondo: Bool, grande: Bool, desierto: Bool, hielo: Bool, rojo: Bool) {
        self.hielo = hielo
        self.rojo = rojo
        super.init(redondo: redondo, grande: grande, desierto: desierto)
    }
}

class Jupiter: Planeta {
    var montañas: Bool
    var marron: Bool
    
    init(redondo: Bool, grande: Bool, desierto: Bool, montañas: Bool, marron: Bool) {
        self.montañas = montañas
        self.marron = marron
        super.init(redondo: redondo, grande: grande, desierto: desierto)
    }
}

var marte = Marte(redondo: true, grande: false, desierto: true, hielo: true, rojo: true)

var jupiter = Jupiter(redondo: true, grande: true, desierto: true, montañas: true, marron: true)

print("MARTE: Redondo: \(marte.redondo), grande: \(marte.grande), desierto: \(marte.desierto), hielo: \(marte.hielo), rojo: \(marte.rojo)")

print("UPITER: Redondo: \(jupiter.redondo), grande: \(jupiter.grande), desierto: \(jupiter.desierto), montañas: \(jupiter.montañas), marron: \(jupiter.marron)")
