function fondo() {
    var texto = document.getElementById("observaciones1");
    texto.style.backgroundColor = "black";
    texto.style.color = "white";
}

$(function () {
    // uso de jquery validate con nuestro formulario html
    $("#formulario1").validate({
        /*reglas de validaciones
            nombre y apellido obligatorios
        */
        rules: {
            'nombre1': { required: true, lettersonly: true },
            'apellido1': { required: true, lettersonly: true },
            'telefono': { required: true, digits: true, minlength: 9, maxlength: 9},
            'numserie': { required: true, digits: true },
            'clasereparacion': 'required',
            'sintomas': { required: true, minlength: 1 }
        },
        // mensajes asociados a las reglas
        messages: {
            'nombre1': 'Nombre obligatorio',
            'apellido1': 'Apellidos obligatorios',
            'telefono': 'Telefono obligatorio, tienen que ser 9 digitos',
            'numserie': 'Nº serie obligatorio, solo se permiten numeros',
            'clasereparacion': 'Tipo reparacion obligatorio',
            'sintomas': 'Elegir al menos 1'
        },
        debug: true,
        //código a ejecutar cuando el formulario está ya correctamente validado
        submitHandler: function (form) {
            console.log("Enviado");
            alert('Formulario rellenado correctamente');
        }
    });
});
function activarTypes() {
    document.getElementById("marcaPortatil").className = "visible";
    document.getElementById("modeloPortatil").className = "visible";
    document.getElementById("marca").className = "visible";
    document.getElementById("modelo").className = "visible";
}