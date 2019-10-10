var array1 = [];
numero = 0;
suma = 0;
for (i = 0; numero < 3000; i++) {
    array1[i] = i * 11;
    numero = array1[i];
    document.write(array1[i] + " ");
    suma += numero;
}
document.write("<br>La suma es " + suma);