//
//  ViewController.swift
//  Ejercicio6
//
//  Created by Javi Trujillo on 26/4/21.
//

import UIKit

class ViewController: UIViewController {
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
        //Lo que hace esta aplicación es generar curiosidades sobre gatos de manera aleatoria.
        
    }
    
    
    //Al pulsar el botón, creamos el segue para ir a la siguiente pantalla
    @IBAction func getRandomFact(_ sender: Any) {
        performSegue(withIdentifier: "OpenRandomFactVC", sender: self)
    }
    
    //Preparamos el segue para pasarle un número al azar, que será el número del hecho aleatorio que se muestre
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        let randomFactViewController: RandomFactViewController = segue.destination as! RandomFactViewController
        
        //Asignamos la variable number del view controller siguiente para que se cargue en la siguiente pantalla ese número
        let number = Int.random(in: 0...4)
        randomFactViewController.number = number
        
    }

}

