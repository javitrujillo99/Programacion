function quiniela(triples, golesL, golesV) {
    document.write("<table border='1px solid'>");
    var numPremiados = new Array();
    var num = 0;
    var numero = "";
    for (var i = 0; i < 7; i++) {
        var num = Math.round(Math.random() * 48 + 1);
        if (numPremiados.includes(num)) {
            i--;
        }
        else {
            numPremiados[i] = num;
        }
    }
    for (var i = 1; i < 15; i++) {
        document.write("<tr>");
        for (var j = 1; j < 4; j++) {
            if (j == 1) {
                document.write("<td>Partido " + i + "</td>");
            }
            if (j == 2) {
                numero = "1";
            }
            if (j == 3) {
                numero = "X";
            }
            if (j == 4) {
                numero == "2";
            }
            document.write("<td>" + numero + "</td>");
        }
        document.write("</tr>");
    }
    document.write("<tr>");
    document.write("<td>Pleno al 15</td>");
    document.write("<td>" + golesL + "</td>");
    document.write("<td>" + golesV + "</td>");
    document.write("</tr>");
    document.write("</table>");
}