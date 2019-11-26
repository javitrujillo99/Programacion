class Fraccion {
    //constructor
    constructor(num, den) {
        this.num = num;
        this.den = den;
    }
    imprimirFraccion() {
        document.write("<br>Fracción: " + this.getNumerador() + " / " + this.getDenominador());
    }
    mcd() {
        var x = this.num;
        var y = this.den;
        var resto = 0;
        while (x % y != 0) {
            resto = x % y;
            x = y;
            y = resto;
        }
        return y;
    }
    simplificar() {
        var mcd = this.mcd();
        this.num /= mcd;
        this.den /= mcd;
    }
    multiplicar(numDos, denDos) {
        document.write("<br>Multiplicado por " + numDos + " / " + denDos + ":");
        var numTres = this.num * numDos;
        var denTres = this.den * denDos;
        var fraccionTres = new Fraccion(numTres, denTres);
        fraccionTres.simplificar();
        fraccionTres.imprimirFraccion();
    }
    dividir(numDos, denDos) {
        document.write("<br>Dividido por " + numDos + " / " + denDos + ":");
        var numTres = this.num * denDos;
        var denTres = this.den * numDos;
        var fraccionTres = new Fraccion(numTres, denTres);
        fraccionTres.simplificar();
        fraccionTres.imprimirFraccion();
    }
    getNumerador() {
        return this.num;
    }
    getDenominador() {
        return this.den;
    }
    setNumerador(numerador) {
        this.num = numerador;
    }
    setDenominador(denominador) {
        this.den = denominador;
    }
};
var fraccion = new Fraccion(12, 8);
document.write("Numerador: " + fraccion.getNumerador() + "<br>Denominador: " + fraccion.getDenominador());
fraccion.imprimirFraccion();
fraccion.simplificar();
document.write("<br>Fracción simplificada: ");
fraccion.imprimirFraccion();
fraccion.multiplicar(4,5);
fraccion.dividir(2,3);