<?php
if (isset($_POST['nombre']) && isset($_POST['telefono'])){
    echo "Nombre: " . $_POST['nombre'] .  "Teléfono: " . $_POST['telefono'];
}

?>