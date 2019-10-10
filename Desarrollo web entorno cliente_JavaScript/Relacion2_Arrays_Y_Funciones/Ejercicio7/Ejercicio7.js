function comprobar() {
    var cadena = prompt("Escribe una palabra");
    var resultado = "La cadena \""+cadena+"\" ";
    if (cadena == cadena.toUpperCase()) {
        resultado += " está formada sólo por mayúsculas";
    }
    else if (cadena == cadena.toLowerCase()) {
        resultado += " está formada sólo por minúsculas";
    }
    else {
        resultado += " está formada por mayúsculas y minúsculas";
    }
    return alert(resultado);
}
comprobar();