<!DOCTYPE html>
<html lang="en">
<LINK REL=StyleSheet HREF="../css/gestioprojectes.css" TYPE="text/css" MEDIA=screen>
<script src="../js/gestioprojectes.js"></script>

<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta charset="UTF-8">
<title>Gestió emp. Monstià</title>

</head>

<body>

<div class="flex-container">
<div class="capsalera">
    <h1>Gestió empresarial Montsià</h1>
    <h2>Gestió de projectes</h2>

</div>

<div id="sidebar">
    <header>
    <a href="#">Projectes Creats</a>
    </header>
    <ul class="nav">
    <?php
    require_once("classProjectes.php");
    session_start();

    if (!is_null($_GET["idProjecte"]) && empty($_GET["nomPºrojecte"]) && empty($_GET["capProjecte"]) && empty($_GET["descriptioProjecte"]) ){
        foreach ($_SESSION["Projectes"] as $ID => $Projecte) {
            if ($ID == $_GET["idProjecte"]){
                unset($_SESSION["Projectes"][$ID]);
            }
        }
    }

    if(!empty($_GET["nomProjecte"]) || !empty($_GET["capProjecte"])  || !empty($_GET["descripcioProjecte"]) ) {
        if (!empty($_SESSION["Projectes"][$_GET["idProjecte"]])) {
            if(!empty($_GET["nomProjecte"])){
                $_SESSION["Projectes"][$_GET["idProjecte"]]->nomProjecte = $_GET["nomProjecte"];
            }
            if(!empty($_GET["capProjecte"])){
                $_SESSION["Projectes"][$_GET["idProjecte"]]->capProjecte = $_GET["capProjecte"];
            }
                if(!empty($_GET["descripcioProjecte"])){
                $_SESSION["Projectes"][$_GET["idProjecte"]]->descripcioProjecte = $_GET["descripcioProjecte"];
            }

        }
    }

    foreach ($_SESSION["Projectes"] as $ID => $Projecte) {
        echo '<li>'.$ID. ' '.$Projecte->nomProjecte.' / '.$Projecte->capProjecte.' / '.$Projecte->descripcioProjecte.'</li>';
        }

    ?>

    </ul>
</div>
<!-- Content -->
<div id="content">
    <nav class="navbar navbar-default">
    <div class="container-fluid">

</div>
</nav>
    <div class="container-fluid">

    <form action="gestioprojectes-editar-eliminar.php" method="get" >

        <h1 id="projectnametitol">Edita o Elimina un Projecte </h1>

        <!-- NAME FIELD -->
        <div class="form-field">
        <label for="id" class="label--required">ID del projecte</label>

        <input id="projectid"  type="text" placeholder="2" name ="idProjecte">

        </div>
        <div class="form-field">
        <label for="projectname" class="label--required">Nom del projecte</label>

        <input id="projectname"  type="text" placeholder="Projecte 23" name ="nomProjecte">

        </div>


        <div class="form-field">
        <label for="responsable" class="label--required">Responsable del Projecte</label>

        <input id="responsable"  type="text" placeholder="Federico Jolderqués" name ="capProjecte" />

        </div>

        <div class="form-field">
        <label for="description" class="label--required">Descripció del projecte</label>

        <input id="description"  type="text" placeholder="......" name ="descripcioProjecte"/>

        </div>

        <!-- BUTTONS -->
        <div>
        <button type="submit" class="boto">Editar</button>
        <button type="submit" class="boto">Eliminar</button>



        </div>

    </form>
    <form action="gestioprojectes.php">
            <button type="submit"class="boto" >Tornar atras</button>
        </form>
    </p>
    </div>
</div>


</div>







</body>
<footer class="footer">

  <div class="containerfooter">
    <a href="https://agora.xtec.cat/insmontsia/">Ies Montsià</a>
    <a href="https://www.iesebre.com">Ies de l'Ebre</a>
    <a href="https://agora.xtec.cat/iesdeltebre/">Institut de Deltebre</a>


  </div>

</footer>
<script src="menu.js"></script>
</html>
