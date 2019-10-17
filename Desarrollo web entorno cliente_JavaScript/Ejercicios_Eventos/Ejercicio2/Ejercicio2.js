function ocultar(parrafo, enlace1, enlace2) {
    document.getElementById(parrafo).style.display="none";
    document.getElementById(enlace2).style.visibility="visible";
    document.getElementById(enlace1).style.visibility="hidden";
}
function mostrar(parrafo, enlace1, enlace2) {
    document.getElementById(parrafo).style.display="block";
    document.getElementById(enlace1).style.visibility="visible";
    document.getElementById(enlace2).style.visibility="hidden";
}

function aumentar(parrafo) {
    var tamaño = parseInt(document.getElementById(parrafo).style.fontSize);
    document.getElementById(parrafo).style.fontSize = tamaño + 1;
}
function disminuir(parrafo) {
    var tamaño = parseInt(document.getElementById(parrafo).style.fontSize);
    document.getElementById(parrafo).style.fontSize = tamaño - 1;
}

function defecto(parrafo) {
    document.getElementById(parrafo).style.fontSize = 16;
}