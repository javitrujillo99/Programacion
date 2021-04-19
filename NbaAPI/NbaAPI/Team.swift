//
//  Team.swift
//  NbaAPI
//
//  Created by Javi Trujillo on 25/3/21.
//

import Foundation

//Creamos el objeto

struct Team: Decodable {
    var id: Int
    var abbreviation: String
    var city: String
    var conference: String
    var division: String
    var fullName: String
    var name: String
    
    enum CodingKeys: String, CodingKey {
        case id = "id"
        case abbreviation = "abbreviation"
        case city = "city"
        case conference = "conference"
        case division = "division"
        case fullName = "fullName"
        case name = "name"
     }
}
