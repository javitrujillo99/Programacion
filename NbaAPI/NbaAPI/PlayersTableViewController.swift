//
//  PlayersTableViewController.swift
//  NbaAPI
//
//  Created by Javi Trujillo on 25/3/21.
//

import UIKit

class PlayersTableViewController: UITableViewController {
    
    // Creamos el array de jugadores y lo inicializamos
    var playersArray: [Player] = []

    override func viewDidLoad() {
        super.viewDidLoad()
        
        loadData()
    }
    
    //MARK: - Private methods
    
    private func loadData() {
        //Creo una constante con la URL
        let apiUrl = "https://www.balldontlie.io/api/v1/players"
    
        if let url = URL(string: apiUrl) {
            URLSession.shared.dataTask(with: url) { (data, response, error) in
                guard let data = data else { return }
                
                //Descomprimimos el JSON y lo imprimimos en consola para comprobarlo
                if let jsonString =  String(data: data, encoding: .utf8) {
                    print(jsonString)
                }
                
                //Al recuperar datos de Internet, tenemos que añadir un parametro en el Info.plist, que es el Allow Arbitrary Loads
                do {
                    let player = try JSONDecoder().decode([Player].self, from: data)
                    self.playersArray = player
                } catch {
                    print("Error al recuperar los datos")
                }
                
            }.resume() //El resume hace que si la URL session esta suspensa, se inicialice otra vez
        }
    }

    // MARK: - Table view data source

    override func numberOfSections(in tableView: UITableView) -> Int {
        // #warning Incomplete implementation, return the number of sections
        return 0
    }

    override func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        // #warning Incomplete implementation, return the number of rows
        return 0
    }
    
    override func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        let cell = tableView.dequeueReusableCell(withIdentifier: "reuseIdentifier", for: indexPath)

        // Configure the cell...

        return cell
    }
}
