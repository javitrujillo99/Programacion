import Foundation

func notaMedia(nota1: Float, nota2: Float, nota3: Float, nota4: Float, nota5: Float) -> Float {
    return (nota1 + nota2 + nota3 + nota4 + nota5) / 5
}

var media = notaMedia(nota1: 10, nota2: 9, nota3: 8, nota4: 10, nota5: 9)

print("La media es \(media)")
