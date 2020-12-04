import UIKit

//Variables y constantes
var saludo = "Hola!"
let numero = 4

saludo = "Que tal?"

//Asignando el tipo de variable
var despedida: String = String()

var maxPersonas: Int = 25

//El interrogante significa que puede ser nil (null)
var numeroEntero: Float?

numeroEntero = 40000

//Booleans
var esAmarillo: Bool = false

//Se pueden añadir emojis con cmd + ctrl + espacio

//Para añadir una variable a una cadena:
let saludoCompleto = "\(saludo) buenas"

//Podemos acceder a unas funciones de las variables y constantes
saludo.isEmpty
saludo.uppercased() //Poner en mayuscula

despedida.isEmpty



//TUPLAS:
//Las tuplas son un grupo de valores múltiples en un solo valor compuesto
var tupla = (40, "Hola", 30)

//Podemos llamarlas con el nombre y un .
tupla.0
tupla.1
tupla.2

//Podemos asignar los valores de la tupla a otras variables
let (codigo, mensaje, codigo2) = tupla

codigo
mensaje
codigo2

//Tambien se pueden hacer tuplas ingresando directamente el valor que quiero de cada elemento
var tupla2 = (codigo:50, mensaje:"Error")

tupla2.codigo
tupla2.mensaje

//Tambien podemos crear una tupla diciendole los tipos de parametros que va a tener
var tupla3: (String, String, Int)
tupla3.0 = "Hola"
tupla3.1 = "Adios"
tupla3.2 = 3




//ARAYS
var color = ["Rojo", "Amarillo", "Azul", "Verde"]

color[2]
color[3]
 
//Obtener el número de valores del array
color.count

//Añadir nu nuevo miembro al array
color += ["Blanco", "Negro"]

color.count

//Eliminar parámetros de un array
color.remove(at: 2)

//Declarar un array
var numeros1 = Array<Int>()
var numeros2 = [Int]()
var numeros3: [Int] = []

//Añadir valores a esos arrays en la ultima posicion disponible
numeros1.append(4)
numeros1.append(0)

//Añadir a un array el contenido de otro array
numeros2.append(contentsOf: numeros1)

numeros1.append(2)

numeros1
numeros2



//DICTIONARY
//Un Dictionary es una colección desordenada de objetos. Estos objetos serán almacenados en forma
//de pares “clave – valor” y accederemos a cada valor por su clave o key

var edades = ["Juan": 20, "Patricia": 34]
var edades2: [String: Int] = ["Maria": 40]

//Añadir un valor
edades["Pablo"] = 10

edades

//Actualizamos un valor del diccionario
edades.updateValue(26, forKey: "Patricia")
edades

//Eliminamos un valor
edades.removeValue(forKey: "Pablo")
edades
