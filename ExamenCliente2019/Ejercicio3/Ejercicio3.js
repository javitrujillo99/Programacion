class Carta {
    //constructor
    constructor(palo, valor) {
        this.palo = palo;
        this.valor = valor;
    }

    obtenerNombre() {
        var palo = this.palo;
        var valor = this.valor;
        var nombrePalo = "";
        var valorCarta = "";
        if (palo == 1) {
            nombrePalo = "corazones";
        }
        if (palo == 2) {
            nombrePalo = "diamantes";
        }
        if (palo == 3) {
            nombrePalo = "picas";
        }
        if (palo == 4) {
            nombrePalo = "treboles";
        }

        if (valor == 1) {
            valorCarta = "Uno";
        }
        if (valor == 2) {
            valorCarta = "Dos";
        }
        if (valor == 3) {
            valorCarta = "Tres";
        }
        if (valor == 4) {
            valorCarta = "Cuatro";
        }
        if (valor == 5) {
            valorCarta = "Cinco";
        }
        if (valor == 6) {
            valorCarta = "Seis";
        }
        if (valor == 7) {
            valorCarta = "Siete";
        }
        if (valor == 8) {
            valorCarta = "Ocho";
        }
        if (valor == 9) {
            valorCarta = "Nueve";
        }
        if (valor == 10) {
            valorCarta = "Diez";
        }
        if (valor == 11) {
            valorCarta = "J";
        }
        if (valor == 12) {
            valorCarta = "Q";
        }
        if (valor == 13) {
            valorCarta = "K";
        }

        document.write("<h3>" + valorCarta + " de " + nombrePalo + "</h3>");

    }

};
var palo = prompt("Introduzca palo: [1-4] ");
if (palo >= 1 && palo <= 4) {
    var valor = prompt("Introduzca valor: [1-13] ");
    if (valor >= 1 && valor <= 13) {
        var carta = new Carta(palo, valor);
        carta.obtenerNombre();
    }
    else {
        alert("El valor debe estar entre 1 y 13");
    }
}
else {
    alert("El palo debe estar entre 1 y 4");
}
