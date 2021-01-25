<?php
require_once("classempleat.php");
session_start();
if(!empty($_GET["nom"])){
    $empleat = new ClasseEmpleat($_GET["nom"],$_GET["rol"],$_GET["dni"],$_GET["nss"]);
}
    foreach ($_SESSION["empleats"] as $id => $empleats) {
        echo "ID:".$id." ";
        $empleats->mostra();
        echo "<br>";
    }

 ?>
 Formulari per eliminar un empleat
 <form action="eliminar-editar-empleats.php" method="get">
   Introduieix el nom d'un element per eliminar-lo:
   <input name="nomAEliminar" type="text" />
   <input name="delete" type="submit" value="delete"/>
 </form>
 Formulari per a editar un empleat
 <form action="eliminar-editar-empleats.php" method="get">
   <input type="text" id="idEmpleat" name="idEmpleat" placeholder="Indica el ID del empleat a editar"/>
   <input type="text" id="nomEmpleat" name="nomEmpleat" placeholder="Nou nom per al empleat"/>
   <input type="text" id="rolEmpleat" name="rolEmpleat" placeholder="Nou rol per al empleat"/>
   <input type="text" id="nssEmpleat" name="nssEmpleat" placeholder="Nou nss per al empleat"/>
   <input type="text" id="dniEmpleat" name="dniEmpleat" placeholder="Nou dni per al empleat"/>
   <input type="submit" name="edit" value="Editar"/>
</form>


 <a href="alta-empleats.php">Crear nou</a>

