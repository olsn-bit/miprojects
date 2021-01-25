
<html lang="en">
<LINK REL=StyleSheet HREF="../css/gestiopropostes.css" TYPE="text/css" MEDIA=screen>
<link href="https://fonts.googleapis.com/css2?family=Quicksand:wght@300&display=swap" rel="stylesheet">
<head>
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta charset="UTF-8">
</head>
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.15.1/css/all.css" integrity="sha384-vp86vTRFVJgpjF9jiIGPEEqYqlDwgyBgEF109VFjmqGmIY/Y4HV4d3Gp2irVfcrp" crossorigin="anonymous">
<div class="capsalera">
      <h1>Creació Proposta</h1>
      <h2>Emplena tots els camps per crear una Proposta</h2>
      <div class="flex-container2">

        <div class="goback"onclick="window.history.back();">
          <i class="fas fa-chevron-circle-left fa-2x"></i>
          Go back
        </div>
        <div class="daymode">
          <i class="fas fa-moon fa-2x"></i>
          Night Mode
              </div>

        <script>
 let button = document.querySelector('.daymode');

button.addEventListener('click', ()=>{
  document.documentElement.classList.toggle('darkmode');

})
        </script>
          <div onclick="location.href='/public/menu.html';">
          <i style="color:white"  class="fas fa-home fa-2x"></i>
        </div>

        <div>
          <button class="usericon"> </button>
          <p class="user" > Admin </p>
        </div>

      </div>

    </div>
<body class="crudpropostes">

  <form action="crearProposta.php" method="get">
      <label for="Departament">Departament:</label>
      <select id="cars">
        <?php
        require_once("clases/claseConnexio.php");
        $connexio = new claseConnexio('cristian', "Cristian1@", '192.168.224.222', 'Sprint2');
        echo "crea connexio";
        $consulta = $connexio->select("* FROM Departaments;");
        echo "consulta funciona";

                   while ($columna = mysqli_fetch_array($consulta)) {
                       echo "<option value=".$contRols.">".$columna['Nom']."</option>";
                       $contRols++;
                   }
                   echo "funciona lo tt while";
                   echo "</select> <br>";

        ?>
      </select>
      Grup :<input type="text" id="Grup"><br>
      Categoria :<input type="text" id="Categoria"><br>
      Nom: <input type="text" id="Nom"><br>
      Descripcio: <input type="text" id="Descripcio"><br>
      Estat: <input type="text" id="Estat"><br>
      Data publicació:<input type="text" id="Data_publicacio"><br>
      Data acceptació:<input type="text" id="Data_acceptacio"><br>
      <input type="submit" value="Enviar">
  </div>
  </form>
  <?php
  if ($GET["Nom"] == "piolaisadfla") {
      require_once("/clases/clasePropostes.php");
      $proposta = new clasePropostes();
      $proposta->alta($GET["Departament"], $GET["Grup"], $GET["Categoria"], $GET["Nom"], $GET["Descripcio"], $GET["Estat"], $GET["Data_publicacio"], $GET["Data_acceptacio"]);
      echo "Proposta creada";
  }


  // $proposta->alta($_GET["nombreProposta"],$_GET["email"],$_GET["descProp"]);

  ?>


<footer>
  <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.15.1/css/all.css" integrity="sha384-vp86vTRFVJgpjF9jiIGPEEqYqlDwgyBgEF109VFjmqGmIY/Y4HV4d3Gp2irVfcrp" crossorigin="anonymous">
    <div class="container-footer-all">
      <div class="container-body">
            <div class="column1">
          <h1>Empresag3daw2</h1>
           <p>Pàgina per a la gestió de les  propostes, pressupostos, empleats i projectes. </p>
        </div>
        <div class="column2">
          <h1>Torna a inici</h1>
           <div onclick="location.href='/public/menu.html';">
          <i style="color:white;margin-left:35px;"  class="fas fa-home fa-2x"></i>
        </div>
          <div class="menufooter">
            <ul class="links-nav">
                <li><a href="menu.html">Inici</a></li><br>
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
      Informació
 companyia | Privacitat i Politiques | Termes i Condicions
    </div>
  </div>
</div>
  </footer>
</body>
</html>
