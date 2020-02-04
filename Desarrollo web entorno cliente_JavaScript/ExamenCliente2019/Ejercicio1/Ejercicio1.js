$(function () {
    // uso de jquery validate con nuestro formulario html
    $("#formulario").validate({
        /*reglas de validaciones
            nombre y apellido obligatorios
        */
        rules: {         
            'usuario': 'required',
            'password': { required: true, minlength: 8, maxlength: 10 }
            
        },
        // mensajes asociados a las reglas
        messages: {
            'usuario': 'Usuario obligatorio',
            'password': 'Contraseñan obligatoria, debe tener entre 8 y 10 caracteres',
        },
        debug: true,
        //código a ejecutar cuando el formulario está ya correctamente validado
        submitHandler: function (form) {
            console.log("Enviado");
            alert('Formulario rellenado correctamente');
        }
    });
});
function puedeEnviar() {
    var nombre = document.getElementById("name").value;
    var nombreConfirmado = false;
    if (nombre.length == 0 || /^\s+$/.test(nombre)) {
        alert("El nombre no puede estar en blanco");
    }
    else {
        alert("Nombre bien");
        nombreConfirmado = true;
    }
}