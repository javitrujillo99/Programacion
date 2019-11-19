function analiza() {
    var texto = document.getElementById("texto").value;
    document.write("<h1>Información sobre el texto introducido:</h1>");
    var letras = texto.length;
    var textoAreaDividido = texto.split(" ");
    var numeroPalabras = textoAreaDividido.length;
    var primeraPalabra = textoAreaDividido[0];
    var ultimaPalabra = textoAreaDividido[numeroPalabras - 1];
    document.write("Número de palabras: " + numeroPalabras + "<br>");
    document.write("<br>Primera palabra: " + primeraPalabra + "<br>");
    document.write("<br>Última palabra: " + ultimaPalabra + "<br>");
    document.write("<br>Colocado al revés:<br>");
    document.write(textoAreaDividido.reverse() + "<br>");
    document.write("<br>Ordenados de la 'a' a la 'z':<br>");
    document.write(textoAreaDividido.sort() + "<br>");
    document.write("<br>Ordenados de la 'z' a la 'a':<br>");
    document.write(textoAreaDividido.sort().reverse());
}