package com.example.clasesyfuncioneskotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

//PRUEBA COMENTARIO PARA VER SI HACE EL COMMIT

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    fun main() {
        var persona1 = Persona()
        var persona2 = Persona2("Seli", "Muñoz")
        persona1.nombre = "Juan" //Así se edita un atributo
        println("La persona 1 se llama $persona1.nombre")
        println("La persona 2 se llama $persona2.nombre")
    }

    //Creando una clase sin pasarle parámetros
    class Persona {
        var nombre = "Nombre"
        var apellido = "Apellido"
        set(value) {
            apellido = "Apellido: $value"
        }
    }

    //Creando clase pasándole parámetros directamente. El open significa que se puede heredar de esta clase
    open class Persona2(val nombre: String, val apellido: String) {

    }

    //Esto es una clase que hereda de otra clase
    class Companero (val funcion: String): Persona2("Ana", "Gonzalez") {

    }
}