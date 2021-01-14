//
//  ViewController.swift
//  EjercicioSwift3Calculadora
//
//  Created by Angela Velilla on 14/01/2021.
//

import UIKit

class ViewController: UIViewController {
    
    //Un stack view es una vista en la que todo lo que hay dentro guarda una relación. En este caso vamos a guardar dentro del stack view todos los botones, ya que todos comparten características muy similares.
    
    //Para hacer el botón cuadrado, en las constraints, he activado el aspect ratio para que se vean las proporciones del botón del largo con respecto del ancho. Y he puesto el multiplicador en 1:1
    
    
    
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view.
    }
    
    
    @IBOutlet weak var lblResultado: UILabel!
    
    //Creamos una enumeracion con todas las operaciones
    enum Operation: Int {
        case add
        case substract
        case multiply
        case divide
        case equal
        case none
    }
    
    var numberOnScreen: Double = 0
    var previousNumber: Double = 0
    var performingMath = false
    var actualOperation: Operation = .none
    
    
    // MARK: -Button Actions
    
    //Esa marca sirve para identificar rapido. Ahora en el buscador rapido de arriba para localizar cada metodo, en el que pone "ViewController", que es morado, ahora aparece la marca y es mas facil de identificar y encontrar
    
    @IBAction func addNumber(_ sender: UIButton) {
        if performingMath {
            lblResultado.text = String(sender.tag)
            numberOnScreen = Double(lblResultado.text!)!
            performingMath = false
        } else {
            //Ese String delante del tag es un casteo, porque entero no me deja
            lblResultado.text = lblResultado.text! + String(sender.tag)
            numberOnScreen = Double(lblResultado.text!)!
        }
    }
    
    @IBAction func addOperation(_ sender: UIButton) {
        let currentOperation = Operation(rawValue: sender.tag)!
        
        if currentOperation != .equal {
            previousNumber = Double(lblResultado.text!)!
            
            switch currentOperation {
            case .add:
                lblResultado.text = "+"
            case .substract:
                lblResultado.text = "-"
            case .multiply:
                lblResultado.text = "x"
            case .divide:
                lblResultado.text = "/"
            case .equal:
                print("Resultado")
            case .none:
                print("Ninguna operacion")
            }
            
            actualOperation = currentOperation
            performingMath = true
            
        } else {
            switch actualOperation {
            case .add:
                lblResultado.text = String(previousNumber + numberOnScreen)
            case .substract:
                lblResultado.text = String(previousNumber - numberOnScreen)
            case .multiply:
                lblResultado.text = String(previousNumber * numberOnScreen)
            case .divide:
                lblResultado.text = String(previousNumber / numberOnScreen)
            case .equal:
                print("Resultado")
            case .none:
                print("Ninguna operacion")
            }
        }
    }
    
    @IBAction func deleteOperation(_ sender: UIButton) {
        previousNumber = 0
        numberOnScreen = 0
        actualOperation = .none
        lblResultado.text = ""
    }
}

