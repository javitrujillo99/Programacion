var enlaces = document.getElementsByTagName("a");
document.write("Número de enlaces de la página: " + enlaces.length);
document.write("<br>Direccion a la que enlaza el penúltimo enlace: " + enlaces[enlaces.length - 2]);
var contador = 0;
for(var i = 0; i < enlaces.length; i++) {
    if (enlaces[i] == "http://www.marca.es/") {
        contador++;
    }
    
}
document.write("<br>Número de enlaces que enlazan a http://www.marca.es: " + contador);
var parrafos = document.getElementsByTagName("p");
var enlacesTercerParrafo = parrafos[2].getElementsByTagName("a");
document.write("<br>Número de enlaces del tercer párrafo: " + enlacesTercerParrafo.length);
