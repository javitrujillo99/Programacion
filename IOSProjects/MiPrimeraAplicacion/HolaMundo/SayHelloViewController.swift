//
//  SayHelloViewController.swift
//  HolaMundo
//
//  Created by Angela Velilla on 15/12/2020.
//

import UIKit

class SayHelloViewController: UIViewController {

    @IBOutlet weak var sayHelloLabel: UILabel!
    
    var name: String = ""
    
    override func viewDidLoad() {
        super.viewDidLoad()
    }
    
    //Funcion que se ejecutara cuando aparezca la pantalla
    override func viewWillAppear(_ animated: Bool) {
        super.viewWillAppear(animated)
        
        sayHelloLabel.text = "Hola \(name), cómo estás?"
    }

    //Funcion asignada al boton, para cerrar la vista
    @IBAction func closeButtonAction(_ sender: Any) {
        dismiss(animated: true, completion: nil)
    }
}
