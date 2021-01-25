<!DOCTYPE html>
<html>
<body>

<?php
$txt = "PHP";
$array = [
    "first" => $_GET["nom"],
    "second" => "None neither",
];
echo "Empleats a la base de dades:";
$contador = 0;
foreach($array as $value) {
  echo "<br>";
  echo $contador;
  $contador++;
  echo " - ";
  echo $value;
}


?>

<form action="phpalbero.php"method="get">
  <label for="nom">Nom:</label><br>
  <input type="text" id="nom" name="nom"><br>
  <label for="carreg">Càrreg:</label><br>
  <input type="text" id="carreg" name="carreg"><br>
  <label for="dni">DNI:</label><br>
  <input type="text" id="dni" name="dni"><br>
  <label for="nss">NSS:</label><br>
  <input type="text" id="nss" name="nss"><br>
  <input type="submit" value="Submit">
</form>

</body>
</html>
