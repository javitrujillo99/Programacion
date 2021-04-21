//
//  StatsViewController.swift
//  Ejercicio6
//
//  Created by Javi Trujillo on 21/4/21.
//

import UIKit

class StatsViewController: UIViewController {

    @IBOutlet weak var puntosLabel: UILabel!
    
    //Creo un objeto Stats para luego rellenarlo con los datos
    var stats = Stats()
    
    
    //Esta variable "playerID", es la que se recoge en el segue. Es muy importante, ya que lo que recoge es el "id" del jugador recogido, que es el id del jugador que luego se introduce en la api. Ese id no se puede tocar ya que ese es el id por que el la API tiene guardado a ese jugador, y si se modifica, no se cargarán las stats en la API y por tanto en esta aplicación.
    var playerID = 20000571

    override func viewDidLoad() {
        super.viewDidLoad()
        
        //Cargamos la función principal
        loadData()
                
        //LA URL usada para esto es: https://fly.sportsdata.io/v3/nba/stats/json/PlayerSeasonStatsByPlayer/2021/20000571?key=b52544ea304746c78679aab147b715da
        
        //Como vamos a hacer una petición para recuperar los datos de Internet, tenemos que añadir a. Info.plis el parámetro allow arbitrary loads, y ponerlo a YES
    }
    
    // MARK: - Private methods
    
    private func loadData() {
        //Creamos una constante con la key de la api
        let apiKey = "b52544ea304746c78679aab147b715da"
        
        //Creamos una constante con la URL
        let apiUrl = "https://fly.sportsdata.io/v3/nba/stats/json/PlayerSeasonStatsByPlayer/2021/\(playerID)?key=\(apiKey)"
        
        
         //Inicializamos la url, pero con un if porque puede darse el caso de que no encuentre la url
        if let url = URL(string: apiUrl) {
            URLSession.shared.dataTask(with: url) { (data, response, error) in
                guard let data = data else { return }
                
               //Descomprimimos el json para mostrarlo por consola y poder comprobar que va bien
                if let jsonString = String(data: data, encoding: .utf8) {
                    print(jsonString)
                }
                
                //Recuperamos los datos para añadirlos a nuestro objeto
                do {
                    let statsData = try JSONDecoder().decode(Stats.self, from: data)
                    self.stats = statsData
                } catch {
                    print("Error al recuperar los datos")
                }
                
                //Para actualizar la vista con datos:
                DispatchQueue.main.async {
                    self.puntosLabel.text = self.stats.points?.description
                }
            }.resume()
        }
    }
}
