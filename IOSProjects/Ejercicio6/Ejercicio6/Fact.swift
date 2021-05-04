//
//  Fact.swift
//  Ejercicio6
//
//  Created by Javi Trujillo on 26/4/21.
//

import Foundation

//Creamos el objeto Fact. A cada característica del array recogida, se le asigna un objeto Fact, para después usar el texto y mostrarlo

struct Fact: Decodable {
    var status: Status
    var type: String
    var deleted: Bool
    var _id: String
    var user: String
    var text: String
    var __v: Int
    var source: String
    var updatedAt: String
    var createdAt: String
    var used: Bool
    
    //Creamos las codingKeys para que no de problemas a la hora de leer el JSON
    enum CodingKeys: String, CodingKey {
        case status = "status"
        case type = "type"
        case deleted = "deleted"
        case _id = "_id"
        case user = "user"
        case text = "text"
        case __v = "__v"
        case source = "source"
        case updatedAt = "updatedAt"
        case createdAt = "createdAt"
        case used = "used"
    }
    
    //Esto es que hay un objeto dentro de otro, hay un Status dentro de Fact, y aquí creamos el Status
    struct Status: Decodable {
        var verified: Bool
        var sentCount: Int
        var feedback: String?
        
        enum CodingKeys: String, CodingKey {
            case verified = "verified"
            case sentCount = "sentCount"
            case feedback = "feedback"
        }
    }
}
