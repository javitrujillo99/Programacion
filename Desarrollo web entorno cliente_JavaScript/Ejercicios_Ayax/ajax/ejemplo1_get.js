$(function() {
  $("#boton").click(function (e) { 
        /* parámetro texto: el archivo de texto 
           parámetro status: indica si hay éxito (success)
           parámetro objetorespuesta: objeto devuelto con varias propiedades   */
        $.get("datos.txt",function(texto,status,objetorespuesta){
                console.log("Mensaje "+texto+"\nstatus "+status+ " "+ objetorespuesta.status);
                console.log(objetorespuesta);
                $("#info").html("Mensaje "+texto+"<br> status "+status+ " "+ objetorespuesta.status);
            });
            
        e.preventDefault();
        
    });
    
});