suma = 0;
document.write("Los numeros son: ");
for (i = 0; i < 10; i++) {
    var numero = parseInt(prompt("Introduce un número "));
    document.write(numero + ", ");
    suma += numero;
}
document.write("<br>La suma de los numeros es " + suma);
