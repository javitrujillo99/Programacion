<?php

//ALTA DE UN ALUMNO

//recogemos los datos del formulario
$dni=isset($_GET['dni'])?$_GET['dni']:$_POST['dni'];
$nombre=isset($_GET['nombre'])?$_GET['nombre']:$_POST['nombre'];
$email=isset($_GET['email'])?$_GET['email']:$_POST['email'];


//crear conexión a la Bd
$c=mysqli_connect('localhost','root','cfgsasir2') or die("Error en conexión");
$bd=mysqli_select_db($c,'alumnos');

// creamos inserción en la BD
$sql="insert into alumnos values('$dni','$nombre','$email')";
if ($resultado=mysqli_query($c,$sql))
	{
	mysqli_query($c,"commit");
	}
else
	echo "error en inserción";

header('Location: json2.html');
?>