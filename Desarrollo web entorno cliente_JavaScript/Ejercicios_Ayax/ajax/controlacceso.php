<?php
$usuario=isset($_GET['usuario']) ? $_GET['usuario'] : $_POST['usuario'];
$password=isset($_GET['password']) ? $_GET['password'] : $_POST['password'];

if ($usuario=='admin' && $password=='admin') 
	{
	echo 'correcto';	
	}
else 
	{
	 echo 'incorrecto';
	}
 ?>