<html>
<LINK REL=StyleSheet HREF="gestiopropostes.css" TYPE="text/css" MEDIA=screen>
<div class="capsalera">
    <h1>CRUD PROPOSTES</h1>
</div>
<body class="crudpropostes">
<?php


require_once("Propostes.php");
session_start();
$proposta = new Propostes($_GET["nombreProposta"],$_GET["email"],$_GET["descProp"]);

echo '<pre>' , var_dump($_SESSION) , '</pre>';
//$nomProposta = ;
//$email = ;
//$descProp = ;

//$obj = (Object)['propostes' => [$nomProposta,$email,$descProp]];


?>
</body>
<a href="gestiopropostes.html">Torna al menú.</a>
</html>
