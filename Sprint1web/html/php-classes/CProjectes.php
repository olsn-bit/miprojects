<?php
require_once("classProjectes.php");
session_start();
$Projecte = new classProjectes($_GET["nomProjecte"],$_GET["capProjecte"],$_GET["descripcioProjecte"]);
$Projecte->llistar();
?>
