function multiplicar(numero) {
    if (numero >= 2 && numero <= 9) {
        document.write("<table border = 1>");
        for(i = 0; i < 11; i++) {
            document.write("<tr>");
            document.write("<td>" + numero + ' x ' + i + "</td>");
            document.write( "<td>"  + numero * i + '</td>') ;
            document.write("</tr>");
        }
        document.write("</table>")
    }
    else {
        document.write('NO ESTA ENTRE 2 Y 9');
    }
}