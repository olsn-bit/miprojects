<?php
require_once "classProjectes.php";
session_start();
$_SESSION($Projecte);
if(!empty($_GET["nomProjecte"])){
    $empleat = new ClasseEmpleat($_GET["nomProjecte"],$_GET["capProjecte"],$_GET["descripcioProjecte"]);
}
    foreach ($_SESSION["projectes"] as $id => $projecte) {
        echo "ID:".$id." ";
        $projecte->llistar();
        echo "<br>";
    }
    /*
foreach ($array as $inbox => $element){
    $element ->llistar();

}
*/
?>
