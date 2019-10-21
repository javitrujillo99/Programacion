function propiedades(event) {
    document.getElementById("div").style.backgroundColor="blue";
    var x = window.event.clientX;
    var y = window.event.clientY;
    document.getElementById("x").value = x;
    document.getElementById("y").value = y;
}
function tecla(event) {
    document.getElementById("div").style.backgroundColor ="red";
    var letra = String.fromCharCode(event.keyCode);
    document.getElementById("tecla").value = letra;
    document.getElementById("ascii").value = letra.charCodeAt(0);
}
