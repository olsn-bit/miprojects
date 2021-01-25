
<html lang="en">
<LINK REL=StyleSheet HREF="../css/gestiopropostes.css" TYPE="text/css" MEDIA=screen>
<link href="https://fonts.googleapis.com/css2?family=Quicksand:wght@300&display=swap" rel="stylesheet">
<head>
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta charset="UTF-8">
</head>
<div class="capsalera">
  <h1>CRUD PROPOSTES</h1>
</div>
<body class="crudpropostes">
    <table id="llistarpropostes">
      <tr>
        <th>Nom Proposta</th>
        <th>Email</th>
        <th>Descripció</th>
      </tr>
      <?php

      require_once("clases/clasePropostes.php");
      echo clasePropostes::llistar();
      // $proposta->alta($_GET["nombreProposta"],$_GET["email"],$_GET["descProp"]);


    echo "</table>";

    echo "purlka";
    require_once("clases/clasePropostes.php");
    echo clasePropostes::llistar();
    echo "sulka";
    // $proposta->alta($_GET["nombreProposta"],$_GET["email"],$_GET["descProp"]);

    ?>
</body>
<a href="../gestiopropostes.html">Torna al menú.</a>
</html>
