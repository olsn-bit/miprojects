<?php
function eliminarempleat(){
    require_once("classempleat.php");
    session_start();
    foreach($_SESSION["empleats"] as $listkey => $empleats){
         if ($empleats->get_nom() == $_GET["nomAEliminar"]) {
            echo "<br> Hem borrat a ".$empleats->getNom()."<br>";
            unset($_SESSION["empleats"][$listkey]);
            
        }
     
    }
    return $_SESSION;
}
function editarempleat(){
    require_once("classempleat.php");
    session_start();
        if (!empty($_SESSION['empleats'][$_GET["idEmpleat"]])) {
            if(!empty($_GET["nomEmpleat"])){
                $_SESSION['empleats'][$_GET["idEmpleat"]]->setNom($_GET["nomEmpleat"]);
                echo "Nom canviat";
            }
            if(!empty($_GET["dniEmpleat"])){
                $_SESSION['empleats'][$_GET["idEmpleat"]]->setDni($_GET["dniEmpleat"]);
                echo "Dni canviat";
            }
            if(!empty($_GET["nssEmpleat"])){
                $_SESSION['empleats'][$_GET["idEmpleat"]]->setNss($_GET["nssEmpleat"]);
                echo "Nss canviat";
            }
            if(!empty($_GET["rolEmpleat"])){
                $_SESSION['empleats'][$_GET["idEmpleat"]]->setRol($_GET["rolEmpleat"]);
                echo "Rol canviat";
            }
        }
        return $_SESSION;
}
if(is_null($_GET["delete"])){
    $_SESSION = editarempleat();
}else{
    $_SESSION = eliminarempleat();    
}


?>
<a href="empleat-creat.php">Tornar a Llista</a>
