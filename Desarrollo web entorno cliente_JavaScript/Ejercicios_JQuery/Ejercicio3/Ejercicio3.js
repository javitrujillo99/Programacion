function calcularSalario() {
    var nombre=document.getElementById("nombre").value;
    var edad=document.getElementById("edad").value;
    var salario=document.getElementById("salario").value;
    var salarioFinal = 0;
    if (salario >= 1000 && salario <= 2000) {
        if (edad >= 50) {
            salarioFinal = salario * 1.1;
        }
        else {
            salarioFinal = salario * 1.05;
        }
    }
    else if (salario < 1000) {
        if (edad >= 50 && edad <= 60) {
            salarioFinal = salario * 1.15;
        }
        else if (edad < 50) {
            salarioFinal = salario * 1.075;
        }
        else {
            salarioFinal = salario * 1.2;
        }
    }
    else {
        salarioFinal = salario;        
    }
    var final = document.getElementById("final");
    final.value = salarioFinal;
    var numeroPositivo = prompt("Introduce un numero entero positivo");
    var factorial = 1;
    for (i = numeroPositivo; i > 1; i--) {
        factorial *= i;
    }
    alert("El factorial es " + factorial);
}