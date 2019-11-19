$(function() {
    $("#boton").click(function (e) { 
        var nombreminusculas=$("#nombre").val();
        $.get("proceso.php",{nombre: nombreminusculas},function(respuesta){
        $("#nombremayusculas").val(respuesta);
        });
        e.preventDefault();
    });
});
