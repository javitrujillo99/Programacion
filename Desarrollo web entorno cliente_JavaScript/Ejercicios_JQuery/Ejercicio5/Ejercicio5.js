document.write("<table border='1px solid'>");
var contador = 1;
var numPremiados = new Array();
var num = 0;
for (var i = 0; i < 7; i++) {
    var num = Math.round(Math.random() * 48 + 1);
    if (numPremiados.includes(num)) {
        i--;
    }
    else {
        numPremiados[i] = num;
    }
}
for (var i = 1; i < 8; i++) {
    document.write("<tr>");
    for (var j = 1; j < 8; j++) {
        if (numPremiados.includes(contador)) {
            document.write("<td>X</td>");
        }
        else {
            document.write("<td>" + contador + "</td>");
        }
        contador++;
    }
    document.write("</tr>");
}
document.write("</table>");