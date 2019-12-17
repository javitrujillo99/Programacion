$(function () {
    // uso de jquery validate con nuestro formulario html
    $("#formulario").validate({
        /*reglas de validaciones
            nombre y apellido obligatorios
        */
        rules: {
            'apellidos': { required: true, lettersonly: true },
            'nombre': { required: true, lettersonly: true },
            'domicilio': 'required',
            'sexo': { required: true, minlength: 1 },
            'edad': { required: true, digits: true },
            'modulos': { required: true, minlength: 1 },
            'curso': 'required'
        },
        // mensajes asociados a las reglas
        messages: {
            'apellidos': 'Apellidos obligatorios',
            'nombre': 'Nombre obligatorio',
            'domicilio': 'Domicilio obligatorio',
            'sexo': 'Obligatorio elegir una opción',
            'edad': 'Obligatorio, solo se admiten números enteros',
            'modulos': 'Elegir al menos 1',
            'curso': 'Elegir el curso'
        },
        debug: true,
        //código a ejecutar cuando el formulario está ya correctamente validado
        submitHandler: function (form) {
            console.log("Enviado");
            alert('Formulario rellenado correctamente');
        }
    });
});

$(function () {
    // uso de jquery validate con nuestro formulario html
    $("#formulario2").validate({
        /*reglas de validaciones
            nombre y apellido obligatorios
        */
        rules: {
            'apellidos': { required: true, lettersonly: true },
            'nombre': { required: true, lettersonly: true },
            'domicilio': 'required',
            'sexo': { required: true, minlength: 1 },
            'edad': { required: true, digits: true },
            'modulos': { required: true, minlength: 1 },
            'curso': 'required'
        },
        // mensajes asociados a las reglas
        messages: {
            'apellidos': 'Apellidos obligatorios',
            'nombre': 'Nombre obligatorio',
            'domicilio': 'Domicilio obligatorio',
            'sexo': 'Obligatorio elegir una opción',
            'edad': 'Obligatorio, solo se admiten números enteros',
            'modulos': 'Elegir al menos 1',
            'curso': 'Elegir el curso'
        },
        debug: true,
        //código a ejecutar cuando el formulario está ya correctamente validado
        submitHandler: function (form) {
            console.log("Enviado");
            alert('Formulario rellenado correctamente');
        }
    });
});

