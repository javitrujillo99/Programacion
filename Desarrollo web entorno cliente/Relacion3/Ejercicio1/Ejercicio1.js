var fecha = new Date;
var mes=fecha.getMonth();
var cuatrimestre;
if (mes < 4) {
    cuatrimestre = 1;
}
else {
    if (mes < 8) {
        cuatrimestre = 2;
    }
    else {
        cuatrimestre = 3;
    }
}
document.write('Fecha actual:<br>' + (fecha.getDay() - 1) + ' - ' +  
(fecha.getMonth() + 1) + ' - ' + 'Cuatrimestre numero ' + cuatrimestre);