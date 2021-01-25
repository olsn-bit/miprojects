
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
    <?php
    require_once("Propostes.php");
    session_start();
    ?>
    <table id="llistarpropostes">
      <tr>
        <th>Nom Proposta</th>
        <th>Email</th>
        <th>Descripció</th>
      </tr>
    <?php foreach ($_SESSION['propostes'] as $x):?>
    <tr>
      <td><?php  echo $x->nomProposta; ?></td>
      <td><?php  echo $x->email; ?></td>
      <td><?php  echo $x->descProp; ?></td>
    </tr>
    <?php endforeach; ?>
    </table>
</body>
<a href="../gestiopropostes.html">Torna al menú.</a>
</html>
