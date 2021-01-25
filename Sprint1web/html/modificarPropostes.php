<html>
<LINK REL=StyleSheet HREF="gestiopropostes.css" TYPE="text/css" MEDIA=screen>
<body class="crudpropostes">
<div class="capsalera">
    <h1>CRUD PROPOSTES</h1>
</div>
<form action="modificarPropostes.php" method="get">
    <input type="text" id="index" name="index" placeholder="Indica quina proposta vols modificar"/>
    <input type="text" id="nomproposta" name="nomproposta" placeholder="Canvia el nom de la descripció"/>
    <input type="text" id="email" name="email" placeholder="Canvia el mail"/>
    <input type="text" id="desc" name="desc" placeholder="Canvia la descripció"/>
    <input type="submit" value="Enviar"/>
</form>
<?php
require_once("Propostes.php");
session_start();

if(is_null($_GET['index'])){
    echo' No es modificarà cap proposta';
}
else {
    $CampoTexto1 = $_GET['index'];
    $CampoTexto2 = $_GET['nomproposta'];
    $CampoTexto3 = $_GET['email'];
    $CampoTexto4 = $_GET['desc'];
    


        if (!empty($_SESSION['propostes'][$CampoTexto1])) {

            if(!empty($CampoTexto2)){

            $_SESSION['propostes'][$CampoTexto1]->setNomProposta($CampoTexto2);
            }
            if(!empty($CampoTexto3)){
            $_SESSION['propostes'][$CampoTexto1]->setEmail($CampoTexto3);
            }
            if(!empty($CampoTexto4)){
            $_SESSION['propostes'][$CampoTexto1]->setDesc($CampoTexto4);
            }

        }


}
?>
<a href="gestiopropostes.html">Torna al menú.</a>
</body>

</html>
