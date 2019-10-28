function puedeEnviar() {
    var nombre = document.getElementById("name").value;
    var nombreConfirmado = false;
    if (nombre.length == 0 || /^\s+$/.test(nombre)) {
        alert("El nombre no puede estar en blanco");
    }
    else {
        alert("Nombre bien");
        nombreConfirmado = true;
    }
}