//
//  TeamsViewController.swift
//  Ejercicio6
//
//  Created by Javi Trujillo on 15/4/21.
//

import UIKit

class TeamsViewController: UIViewController {

    @IBOutlet weak var bknButton: UIButton!
    @IBOutlet weak var lalButton: UIButton!
    
//    var nameATL: String = ""
//    var nameBKN: String = ""
//    var nameBOS: String = ""
//    var nameCHA: String = ""
//    var nameCHI: String = ""
//    var nameCLE: String = ""
//    var nameDAL: String = ""
//    var nameDEN: String = ""
//    var nameDET: String = ""
//    var nameGS: String = ""
//    var nameHOU: String = ""
//    var nameIND: String = ""
//    var nameLAC: String = ""
//    var nameLAL: String = ""
//    var nameMEM: String = ""
//    var nameMIA: String = ""
//    var nameMIL: String = ""
//    var nameMIN: String = ""
//    var nameNO: String = ""
//    var nameNY: String = ""
//    var nameOKC: String = ""
//    var nameORL: String = ""
//    var namePHI: String = ""
//    var namePHO: String = ""
//    var namePOR: String = ""
//    var nameSA: String = ""
//    var nameSAC: String = ""
//    var nameTOR: String = ""
//    var nameUTA: String = ""
//    var nameWAS: String = ""
    var name: String = ""
    override func viewDidLoad() {
        super.viewDidLoad()

        // Do any additional setup after loading the view.
    }
    
    @IBAction func pulsarBKN(_ sender: Any) {
        performSegue(withIdentifier: "OpenPlayersVC", sender: self)
    }
    
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        let playersByTeamTableViewController: PlayersByTeamTableViewController = segue.destination as! PlayersByTeamTableViewController
        
        if let name = bknButton.currentTitle {
            playersByTeamTableViewController.team = name
        }
    }
}
