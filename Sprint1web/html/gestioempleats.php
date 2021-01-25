<!DOCTYPE html>
<html lang="en">
   <head>
      <link rel="stylesheet" type="text/css" href="gestioempleats.css">
      <meta charset="UTF-8">
      <meta name="viewport" content="width=device-width, initial-scale=1.0">
      <title>PagSplit1</title>
   </head>
   <body>
      <div id="head">
         <h1 id="h1">Gestió empresarial Montsià</h1>
         <h2 id="h2">Gestió de empleats</h2>
      </div>
      <div id="borde">
         <div id="cajon1">
            <h2 id="pEmpleats">Empleats</h2>
            <p id="plinea"></p>
            
            <ol id="ulC">
                <?php
                function eliminarempleat(){
                foreach($_SESSION["empleats"] as $listkey => $empleats){
                    if ($listkey == $_GET["idEmpleat"]) {
                        
                        unset($_SESSION["empleats"][$listkey]);
                        
                    }
                
                }
                return $_SESSION;
                }
                function editarempleat(){
                        if (!empty($_SESSION['empleats'][$_GET["idEmpleat"]])) {
                            if(!empty($_GET["nomEmpleat"])){
                                $_SESSION['empleats'][$_GET["idEmpleat"]]->setNom($_GET["nomEmpleat"]);
                                
                            }
                            if(!empty($_GET["dniEmpleat"])){
                                $_SESSION['empleats'][$_GET["idEmpleat"]]->setDni($_GET["dniEmpleat"]);
                                
                            }
                            if(!empty($_GET["nssEmpleat"])){
                                $_SESSION['empleats'][$_GET["idEmpleat"]]->setNss($_GET["nssEmpleat"]);
                               
                            }
                            if(!empty($_GET["rolEmpleat"])){
                                $_SESSION['empleats'][$_GET["idEmpleat"]]->setRol($_GET["rolEmpleat"]);
                               
                            }
                        }
                        return $_SESSION;
                }
                    require_once("php-classes/classempleat.php");
                    session_start();
                    if(!empty($_GET["nom"])){
                        $empleat = new ClasseEmpleat($_GET["nom"],$_GET["rol"],$_GET["dni"],$_GET["nss"]);
                    }elseif(!empty($_GET["nomEmpleat"]) || !empty($_GET["nssEmpleat"]) || !empty($_GET["dniEmpleat"]) || !empty($_GET["rolEmpleat"])  ){
                        $_SESSION = editarempleat();
                    }elseif(!is_null($_GET["idEmpleat"])){
                         $_SESSION = eliminarempleat();  
                    }
                        foreach ($_SESSION["empleats"] as $id => $empleats) {
                            echo "<li> ID: ".$id.". Nom: ".$empleats->getNom().". Rol: ".$empleats->getRol()."</li>";
                        }

                ?>
            </ol>
         </div>
         <div id="cajon2">
            <form id="formulari" action="crearempleats.php">
               <input type="submit" value="Crear nou empleat">
            </form>
            <form id="formulari" action="gestioempleats.php" method="get">
               <p>ID:<input type="text" id="idEmpleat" name="idEmpleat" placeholder="Indica el ID del empleat a editar"/></p>
   <p>Nom:<input type="text" id="nomEmpleat" name="nomEmpleat" placeholder="Nou nom per al empleat"/></p>
 
<div id ="imagfons">
                  <img id="img"src="images/imagEmpleat.png" alt="empleatimag">
               </div>
      <p>Rol:<input type="text" id="rolEmpleat" name="rolEmpleat" placeholder="Nou rol per al empleat"/></p>
   <p>Nss:<input type="text" id="nssEmpleat" name="nssEmpleat" placeholder="Nou nss per al empleat"/></p>
   <p>Dni:<input type="text" id="dniEmpleat" name="dniEmpleat" placeholder="Nou dni per al empleat"/></p>
               <p id="botons">
                  <input type="submit" value="Editar">
                  <input type="submit" value="El·liminar (Només cal emplenar el camp d'ID)">
               </p>
            </form>
         </div>
      </div>
        
   </body>
    <footer id="footer">
        <div id="containerfooter">
            <a href="https://agora.xtec.cat/insmontsia/">Ies Montsià</a>
            <a href="https://www.iesebre.com">Ies de l'Ebre</a>
            <a href="https://agora.xtec.cat/iesdeltebre/">Institut de Deltebre</a>
        </div>
    </footer>

</html>