function calculaMenor (numero1, numero2, numero3) {
    if (numero1 <= numero2 && numero1 <= numero3) {
        alert("El menor es el " + numero1);
    }
    else if (numero2 <= numero1 && numero2 <= numero3) {
        alert("El menor es el " + numero2);
    }
    else if (numero3 <= numero1 && numero3 <= numero2) {
        alert("El menor es el " + numero3);
    }
    else if (numero1 <= numero2 && numero1 >= numero3) {
        alert("El menor es el " + numero3);
    }
    else if (numero2 <= numero1 && numero3 >= numero2) {
        alert("El menor es el " + numero2);
    }
    else if (numero2 <= numero3 && numero1 <= numero2) {
        alert("El menor es el " + numero1);
    }
}