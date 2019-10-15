    function añadirElemento() {
    var lista = document.createElement("li");
    var a = prompt("Introduce diario deportivo");
    var contenido = document.createTextNode(a);
    lista.appendChild(contenido);
    var diarios = document.getElementById("diariosdeportivos");
    diarios.appendChild(lista);
}
