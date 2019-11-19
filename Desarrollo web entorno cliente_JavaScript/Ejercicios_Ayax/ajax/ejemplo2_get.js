$(function() {
    $("#boton").click(function (e) { 
        /* parámetro texto: el archivo de texto 
           parámetro status: indica si hay éxito (success)
           parámetro objetorespuesta: objeto devuelto con varias propiedades   */
        $.get("datos.json",function(datos,status,objetorespuesta){
                console.log(datos);console.log(objetorespuesta);
                $("#info").text("Nombre: "+datos.nombre+ "\nTeléfono "+datos.telefono);
            });
            
        e.preventDefault();
        
    });
    
});