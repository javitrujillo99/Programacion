$(function() {
    $("#boton").click(function (e) { 
        $.getJSON("datos_getJSON2.json",function(datos,status,objetorespuesta){
                var personas= new Array;
                var menoredad=200;;

                if ($("#info").is(":empty")){
                    //ahora vamos a buscar la menor edad entre los contactos
                    $.each(datos.contactos,function(indice,objeto){
                        personas.push(objeto.edad);
                        $.each(personas,function(indice2,edad){
                                if (edad<menoredad){
                                    menoredad=edad;
                                }
                        });
                        $("#info").text("la menor edad de mis contactos es: "+menoredad);
                });
                }
            });
        e.preventDefault();
    });
});