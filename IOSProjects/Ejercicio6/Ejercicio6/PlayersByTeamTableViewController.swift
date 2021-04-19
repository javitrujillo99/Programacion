//
//  PlayersByTeamTableViewController.swift
//  Ejercicio6
//
//  Created by Javi Trujillo on 5/4/21.
//

import UIKit

class PlayersByTeamTableViewController: UITableViewController {
    
    //Creo un array que contenga todos los jugadores del equipo recuperadas del api
    var playersArray: [Player] = []
    var team = ""

    override func viewDidLoad() {
        super.viewDidLoad()
        
        loadData()

        //LA URL usada para esto es: https://fly.sportsdata.io/v3/nba/stats/json/Players/BKN?key=b52544ea304746c78679aab147b715da
        
        //Como vamos a hacer una petición para recuperar los datos de Internet, tenemos que añadir a. Info.plis el parámetro allow arbitrary loads, y ponerlo a YES
    }
    
    // MARK: - Private methods
    
    private func loadData() {
        //Creamos una constante con la key de la api
        let apiKey = "b52544ea304746c78679aab147b715da"
        
        //Creamos una constante con la URL
        let apiUrl = "https://fly.sportsdata.io/v3/nba/stats/json/Players/\(team)?key=\(apiKey)"
        
         //Inicializamos la url, pero con un if porque puede darse el caso de que no encuentre la url
        if let url = URL(string: apiUrl) {
            URLSession.shared.dataTask(with: url) { (data, response, error) in
                guard let data = data else { return }
                
               //Descomprimimos el json para mostrarlo por consola y poder comprobar que va bien
                if let jsonString = String(data: data, encoding: .utf8) {
                    print(jsonString)
                }
                
                //Recuperamos los datos para añadirlos a nuestro array
                do {
                    let player = try JSONDecoder().decode([Player].self, from: data)
                    self.playersArray = player
                } catch {
                    print("Error al recuperar los datos")
                }
                
                //Para actualizar la tabla con los datos:
                DispatchQueue.main.async {
                    self.tableView.reloadData()
                }
                
            }.resume() //Esto hace que si la URLSession está suspensa, se inicialice otra vez
        }
    }

    // MARK: - Table view data source

    override func numberOfSections(in tableView: UITableView) -> Int {
        return 1
    }

    override func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        // Esto devuelve el número de celdas
        return playersArray.count
    }

    
    override func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        //Convertimos la celda en tipo PlayerTableViewCell
        let cell = tableView.dequeueReusableCell(withIdentifier: "PlayerCellId", for: indexPath) as! PlayerTableViewCell

        //Le pasamos a cada celda el array para que se completen todas. IndexPath.row es la celda actual
        cell.loadPlayer(player: playersArray[indexPath.row])

        return cell
    }
}