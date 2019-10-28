function contarCaracteres() {
    var value = document.getElementById("area").value;
    var contador = value.trim().replace(/\s+/gi, ' ').split(' ').length;
    return document.write("Palabras restantes: " + contador);
}