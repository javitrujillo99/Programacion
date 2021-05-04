//
//  RandomFactViewController.swift
//  Ejercicio6
//
//  Created by Javi Trujillo on 26/4/21.
//

import UIKit

class RandomFactViewController: UIViewController {
    
    //Outlets
    @IBOutlet weak var randomFactTextView: UITextView!
    
    //Creamos el array de los facts
    var factsArray:[Fact] = []
    
    //Este número es el que recoge el número aleatorio creado en la pantalla anterior, que se pasa por el segue
    var number = 0
    
    override func viewDidLoad() {
        super.viewDidLoad()

        //Cargamos la función principal
        loadData()
    }
    
    //MARK: - Private methods
        
    private func loadData() {
        
        //Creamos una constante con la URL
        let apiUrl = "https://cat-fact.herokuapp.com/facts"
                
         //Inicializamos la url, pero con un if porque puede darse el caso de que no encuentre la url
        if let url = URL(string: apiUrl) {
            URLSession.shared.dataTask(with: url) { (data, response, error) in
                guard let data = data else { return }
                
//               //Descomprimimos el json para mostrarlo por consola y poder comprobar que va bien
//                if let jsonString = String(data: data, encoding: .utf8) {
//                    print(jsonString)
//                }
                
                //Recuperamos los datos para añadirlos a nuestro array
                do {
                    let inputFact = try JSONDecoder().decode([Fact].self, from: data)
                    self.factsArray = inputFact
                } catch {
                    print("Error al recuperar los datos")
                }
                //Para actualizar la vista con los datos:
                DispatchQueue.main.async {
                    self.randomFactTextView.text = self.factsArray[self.number].text
                }
                
            }.resume() //Esto hace que si la URLSession está suspensa, se inicialice otra vez
        }
    }
    
    //Función del botón para ir a la anterior pantalla
    @IBAction func goBackButtonAction(_ sender: Any) {
        dismiss(animated: true, completion: nil)
    }
    
}
