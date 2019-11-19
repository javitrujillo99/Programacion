$(function(){
    //podemos seleccionar el botón submit con $("#nombre"), pero lo vamos a hacer de otra forma
    $("input[type=submit]").click(function(e){
        //hacemos preventDefault para que el botón submit no envíe el formulario
        e.preventDefault();
        var nombre=$("#nombre").val();
        var telefono=$("#telefono").val();
        $.post("ejemplo_post.php",
          {nombre: nombre,
           telefono: telefono},
          function(respuesta){
            $("#info").text(respuesta);
          }).done(function(){
			  $("#otrainfo").text("ejecución correcta"); //método done y fail  añadidos al método post (chained function)
		  }).fail(function(){
			  $("#otrainfo").text("ejecución fallida");
		  }).always(function(){
			  console.log("ejecución finalizada");
		  });
    });
	
})