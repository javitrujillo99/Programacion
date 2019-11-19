$(function() {
    $("#boton").click(function (e) { 
        $.getJSON("datos_getJSON.json",function(datos,status,objetorespuesta){
                if ($("#info").is(":empty")){
                    //ahora en el bucle recorremos el array contatos que está dentro de datos
                    $.each(datos.contactos,function(indice,objeto){
                        $("#info").append("nombre "+objeto.nombre+ " telefono "+objeto.telefono+"<br>");
                });
                }
            });
        e.preventDefault();
    });
});