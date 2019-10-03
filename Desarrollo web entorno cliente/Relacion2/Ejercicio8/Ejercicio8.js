function comprobar(cadena) {
    if (cadena.upperLower) {
        alert('Está escrito con minúsculas');
    }
    else if (regxs.upper.test(cadena)) {
        alert('Está escrito con mayúsculas');
    }
    else if(regxs.upperLower.test(cadena)) {
        alert('Está escrito con mayúsculas y minúsculas');
    }
}