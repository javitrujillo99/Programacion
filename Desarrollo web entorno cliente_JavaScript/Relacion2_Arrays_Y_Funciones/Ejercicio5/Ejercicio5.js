var letras = ['T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J',
 'Z', 'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E', 'T']; 
var dni = parseInt(prompt("Introduce DNI sin la letra"));
resto = dni % 23;
alert("La letra de ese DNI es la " + letras[resto]);
var dni2 = prompt("Introduce DNI con la letra");
letra = dni2.substring(8, 9);
if (letra == letras[resto]) {
    alert("El DNI es correcto");
}
else {
    alert("El DNI es incorrecto");
}