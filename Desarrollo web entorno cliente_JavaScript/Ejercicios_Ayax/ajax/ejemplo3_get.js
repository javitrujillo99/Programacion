$(function() {
    $("#boton").click(function (e) { 
        $.get("datos2.json",function(datos,status,objetorespuesta){
                if ($("#info").is(":empty")){
                    $.each(datos,function(indice,objeto){
                        $("#info").append("nombre "+objeto.nombre+ " telefono "+objeto.telefono+"<br>");
                });
                }
            });
        e.preventDefault();
    });
});