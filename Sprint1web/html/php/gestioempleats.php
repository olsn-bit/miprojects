<!DOCTYPE html>
<html lang="en" style="font-family:'Quicksand'!important;">
   <head>
      <link rel="stylesheet" type="text/css" href="../css/gestioempleats.css">
      <link href="https://fonts.googleapis.com/css2?family=Quicksand:wght@300&display=swap" rel="stylesheet">
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
                                  require_once("classempleat.php");
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
                  <img id="img"src="../images/imagEmpleat.png" alt="empleatimag">
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


   <footer>
    <div class="container-footer-all">
      <div class="container-body">
        <div class="column1">
          <h1>Empresag3daw2</h1>
           <p>Nosaltres ens encarreguem de gestionar les propostes, pressupostot, empleats i projectes. </p>
        </div>
        <div class="column2">
          <h1>Torna a inici</h1>
          <div class="menufooter">
            <ul class="links-nav">
                <li><a href="../menu.html">Inici</a></li><br>
            </ul>
          </div>
        </div>
        <div class="column3">
          <h1>Informació de contacte</h1>
          <div class="row2">
            <img src="">
             <label>Empresag3daw2,
                    Carrer Madrid, 35, 49,
                    43870 Amposta <br></label>
          </div>

          <div class="row2">
            <img src="">
             <label>Telf. 977700043 <br></label>
          </div>
        </div>
      </div>
  </div>
  <div class="container_footer">
    <div class="footer">
    <div class="copyright">
      © 2020 Tots els drets reservats |
    </div>
    <div class="informacio_politica">
      Informació companya | Privacio i Politica | Termins i Condicions
    </div>
  </div>
</div>
  </footer>

</html>
