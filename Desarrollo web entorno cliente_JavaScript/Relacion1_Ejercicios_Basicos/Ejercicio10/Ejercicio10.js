numeroCorrecto = Math.round(Math.random() * 100);
contador = 0;
do {
    var numero = parseInt(prompt("Introduce un número del 1 al 100 "));
        if (numero >= 1 && numero <= 100) {
            if (numero > numeroCorrecto) {
                alert("El numero es menor");
            }
            else if (numero < numeroCorrecto) {
                alert("El numero es mayor");
            }
        }
        else {
            alert("Tiene que ser un numero entre 1 y 100");
    }
    contador++;
} while (numero != numeroCorrecto);
alert("ENHORABUENA, HAS ACERTADO!! Has necesitado " + contador + " intentos");
document.write("<h1>GRACIAS POR JUGAR AL JUEGO DE JAVI</h1>");