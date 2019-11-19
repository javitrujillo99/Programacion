function convertirDis() {
    var km = document.getElementById("km").value;
    var m = document.getElementById("m").value;
    if (km != "" ) {
        document.getElementById("m").value = km * 1000;
    }
    else if (m != "") {
        document.getElementById("km").value = m / 1000;
    }
    else {
        alert("No has rellenado ningun valor");
    }
}

function convertirPes() {
    var kg = document.getElementById("kg").value;
    var g = document.getElementById("g").value;
    if (kg != "") {
        document.getElementById("g").value = kg * 1000;
    }
    else if (g != "") {
        document.getElementById("kg").value = g / 1000;
    }
    else {
        alert("No has rellenado ningun valor");
    }
}
function borrarMetros() {
    document.getElementById("m").value = "";
}
function borrarKilometros() {
    document.getElementById("km").value = "";
}
function borrarGramos() {
    document.getElementById("g").value = "";
}
function borrarKilogramos() {
    document.getElementById("kg").value = "";
}