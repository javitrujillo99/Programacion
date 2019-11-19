$(function() {
    $("#boton").click(function (e) { 
        /*
        método ajax con objeto configurable en formato json
        parámetros:
            - url : dirección o archivo hacia donde enviar la petición
            - type : método GET o POST (si no se especifica, se entiende que es GET)
            - data: datos a enviar al servidor (si es que se envía alguno)
            - datatype: tipo de datos esperados del archivo o servidor (en nuestro caso objeto json)
            - success: código a ejecutar si la respuesta tiene exito
            - error: código a ejecutar si la respuesta no tiene éxito
        */
        $.ajax({
            url: "datos2.json",
            type: "GET",
            datatype:"json",
            success: function(datos){
                        console.log(datos);
                        if ($("#info").is(":empty")){
                            $.each(datos,function(indice,objeto){
                                $("#info").append("nombre "+objeto.nombre+ " telefono "+objeto.telefono+"<br>");
                                });
                            }
                        },
            error: function(){
                    console.log("No se han podido obtener los datos");
                    }
    });
        
        
     
        e.preventDefault();
    });
});