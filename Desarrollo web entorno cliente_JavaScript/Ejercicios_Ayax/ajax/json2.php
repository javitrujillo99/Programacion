<?php

//recogemos el DNI que hemos introducido en el formulario
$dni=isset($_GET['dni'])?$_GET['dni']:$_POST['dni'];

//crear conexión a la Bd
$c=mysqli_connect('localhost','root','cfgsasir2') or die("Error en conexión");
$bd=mysqli_select_db($c,'alumnos');

// creamos la consulta a la BD
$sql='select dni,nombre,email from alumnos';
$resultado=mysqli_query($c,$sql);
$numfilas=mysqli_query($resultado);

// creamos un objeto de tipo json
$objetojson = new stdClass();


//creamos clase Alumno para luego crear un objeto json de esta clase
class Alumno {
    public $dni = "";
    public $nombre = "";
    public $email = "";
	}


//recorrer el resultado de la select
if $numfilas>0
{
while ($fila=mysqli_fetch_row($resultado)){
	if ($dni==$fila[0]) {
		$alumno = new Alumno;
		$alumno->dni=$fila[0];
		$alumno->nombre=$fila[1];
		$alumno->email=$fila[2];
		$json=json_encode($alumno);
		echo $json;
		}
	}
}
?>