function enviar() {
  var usuario = document.getElementById("usuario").value;
  var pass = document.getElementById("pass").value;
  if (usuario == "admin" && pass == "1234") {
    alert("Bienvenido al sistema");
  }
  else if (usuario.length == 0 || pass.length == 0 || /^\s+$/.test(usuario) || /^\s+$/.test(pass)) {
    alert("No puede haber campos en blanco");
  }
  else {
    alert("Usuario y/o contraseña incorrectos");
  }
}

function limpiar() {
  document.getElementById("usuario").value="";
  document.getElementById("pass").value="";
}