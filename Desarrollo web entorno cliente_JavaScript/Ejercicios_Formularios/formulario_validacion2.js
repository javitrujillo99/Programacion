//poner en blanco el valor por defecto del input que tenga el focus (nombre o apellido)
var apellido=document.getElementById("apellido1");
apellido.addEventListener("focus",limpiarCampo);
var nombre=document.getElementById("nombre1");
nombre.addEventListener("focus",limpiarCampo);
var hermanos=document.getElementById("hermanos1");
var fechanac=document.getElementById("fechanac1");
fechanac.addEventListener("change",rellenaredad);

function rellenaredad(){
  
}


function limpiarCampo(){
  var nombrecampo=document.activeElement.name;
  var valor=document.getElementById(nombrecampo);
  var valor1=valor.value;
  var valor2=valor.getAttribute("value");
  console.log(valor1);
  console.log(valor2);
   //comparamos si el valor de campoactual coincide con el atributo value del campo recogido en la variable 
  if (valor1==valor2)
    {
    valor.value="";
    } 
}

//validar todos los elementos del formulario
function validacion(){
    if (!comprobarletranombre1()){
      alert("Nombre obligatorio");
      return false;
    }
    else  
      if (!comprobarletrapellido1()){
        alert("apellido obligatorio");
        return false;
      }
      else 
        if (document.getElementById("fechanac").value=="" || document.getElementById("fechanac").value=="dd/mm/aaaa")
				  {
				  alert("Fecha obligatoria en formato dd/mm/aaaa");
				  document.getElementById("fechanac").focus();
				  return false;
				  } 
          else
            return true;
            
  }

//comprobar el máximo de caracteres 
function maximocaracteres(elEvento, maximoCaracteres) {
    var elemento = document.getElementById("observaciones1");
  
    // Obtener la tecla pulsada para iexplorer y otros navegadores
    var evento = elEvento || window.event;
    var codigoCaracter = evento.charCode || evento.keyCode;
    
    // Permitir utilizar las teclas del cursor  izquierda y derecha
    if(codigoCaracter == 37 || codigoCaracter == 39) {
      return true;
    }
  
    // Permitir borrar con la tecla retroceso y con la tecla Supr.
    if(codigoCaracter == 8 || codigoCaracter == 46) {
      return true;
    }
    else if(elemento.value.length >= maximoCaracteres ) {
      return false;
    }
    else {
      return true;
    }
  }
  // actualizar el texto indicando el número de caracteres que quedan
  function actualizaInfo(maximoCaracteres) {
   var elemento = document.getElementById("observaciones1");
   var info = document.getElementById("info");
  
    if(elemento.value.length >= maximoCaracteres ) {
      info.innerHTML = "Máximo "+maximoCaracteres+" caracteres";
    }
    else {
      info.innerHTML = "Puedes escribir hasta "+(maximoCaracteres-elemento.value.length)+" caracteres adicionales";
    }
  }


//nombre obligatorio borrándose el contenido por defecto "Escriba aquí su Nombre"
function comprobarletranombre1(){
valornombre = document.getElementById("nombre1").value; 
if( valornombre == null || valornombre.length == 0 ||  /^\s+$/.test(valornombre) ) { 
	return false; 
  } 
else return true;
  }
//apellido obligatorio borrándose el contenido por defecto "Escriba aquí sus apellidos"
function comprobarletrapellido1(){
    valorapell = document.getElementById("apellido1").value; 
    if( valorapell == null || valorapell.length == 0 ||  /^\s+$/.test(valorapell) ) { 
      return false; 
      } 
    else return true;
  }