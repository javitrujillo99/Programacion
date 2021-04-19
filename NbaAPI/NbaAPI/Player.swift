//
//  Player.swift
//  NbaAPI
//
//  Created by Javi Trujillo on 25/3/21.
//

import Foundation

//Creamos el objeto

struct Player: Decodable {
    var id: Int
    var firstName: String
    var heightFeet: Int
    var heightInches: Int
    var lastName: String
    var position: String
    var team: Team
    var weightPounds: Int

    
    //En el caso de que en la api los parametros tengan unos nombres y nosotros queramos cambiarlo a uno mas comodo, y el Decodable no nos de problemas, podemos hacerlo de la siguiente manera:
    enum CodingKeys: String, CodingKey {
        case id = "id"
        case firstName = "firstName"
        case heightFeet = "heightFeet"
        case heightInches = "heightInches"
        case lastName = "lastName"
        case position = "position"
        case team = "team"
        case weightPounds = "weightPounds"
     }
}
