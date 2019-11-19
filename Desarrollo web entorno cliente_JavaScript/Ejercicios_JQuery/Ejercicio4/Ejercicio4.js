var cadena = prompt("Escribe un texto:");
document.write("Texto: " + cadena);
var n = Math.round(Math.random() * 5);
var letra = 0;
var nuevaLetra = 0;
var cadenaCifrada = "";
for (var i = 0; i < cadena.length; i++) {
    letra = cadena.charCodeAt(i);
    nuevaLetra = letra + n;
    if (nuevaLetra > 122) {
        var diferencia = (nuevaLetra - 1) - 122;
        nuevaLetra = 97 + diferencia;
    }
    if (letra == 32) {
        nuevaLetra = 32;
    }
    cadenaCifrada += String.fromCharCode(nuevaLetra);
}
document.write("<br>Texto cifrado " + n + " letras: " + cadenaCifrada);
