class Circunferencia {
    //constructor
    constructor(radio) {
        this.radio = radio;
    }
    //método para calcular el área de la circunferencia
    calculoArea() {
        alert("El área de la circunferencia de radio " + this.radio 
        + " es " + Math.PI * this.radio * this.radio);
    }
    //método para calcular longitud de la circunferencia
    calculoLongitud() {
        alert("La longitud de la circunferencia de radio "
        + this.radio +" es " + 2 * Math.PI * this.radio);
    }
}
radio = parseInt(prompt("Introduzca radio de la circunferencia"));
circunferencia = new Circunferencia(radio);
circunferencia.calculoArea();
circunferencia.calculoLongitud();