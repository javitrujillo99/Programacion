//
//  ViewController.swift
//  HolaMundo
//
//  Created by Angela Velilla on 15/12/2020.
//

import UIKit

class ViewController: UIViewController {
    
    @IBOutlet weak var principalLabel: UILabel!
    
    @IBOutlet weak var nameTextField: UITextField!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view.
    }
    
    //SI PONGO 0 LINEAS, EL TEXTO ME OCUPARA LO QUE OCUPE. SI PONGO X LINEAS ME OCUPARA LAS LINEAS QUE LE PONGA
    
    //Pulsando Ctrl sobre un botón o cualquier layout, y arrastrando hasta "View", podemos alinear el botón por ejemplo al centro con respecto al parent
    
    //Para pasar un layout personalizado gráficamente a código, pulsamos Ctrl en el layout y lo arrastramos hasta esta vista con el ratón

    
    //Funcion del boton
    @IBAction func sayHelloButtonAction(_ sender: Any) {
        //Si la variable existe
        //if let nombre: String = nameTextField.text {
            //Cambiamos el nombre del label al nombre introducido
            //principalLabel.text = nombre
        //}
        
        //Creamos el segue para pasar de esta pantalla a otra
        performSegue(withIdentifier: "OpenSayHelloVC", sender: self)
    }
    
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        //Le decimos que lo que se cargara en la pantalla a la que vamos tenga el controlador que hemos creado, sayHelloVC. Por lo tanto, cargara todo lo que hay programado ahi
        let sayHelloVC: SayHelloViewController = segue.destination as! SayHelloViewController
        
        //Cambiamos el nombre del label de la pantalla 2 al de la pantalla 1 introducido si este existe
        if let name = nameTextField.text {
            sayHelloVC.name = name
        }
    }
    
    //Arrastrando el boton, te pone directamente para ponerle una accion al boton
}

