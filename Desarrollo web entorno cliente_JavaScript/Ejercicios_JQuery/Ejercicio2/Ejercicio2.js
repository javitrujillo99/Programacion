var rojo = Math.round(Math.random()*255);
var verde = Math.round(Math.random()*255);
var azul = Math.round(Math.random()*255);
document.getElementById("color").style.backgroundColor="rgb(" + rojo + "," + verde + "," + azul + ")";
var num = prompt("Introduce un número");
if (isNaN(num)) {
    alert("No es un número");
}
else {
    alert("Es un número");
}