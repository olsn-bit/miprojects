<html>
<LINK REL=StyleSheet HREF="gestiopropostes.css" TYPE="text/css" MEDIA=screen>
<body class="crudpropostes">
<form action="eliminarPropostes.php" method="get">
    Introduieix el nom de la proposta per a eliminar-la:
    <input name="nomAEliminar" type="text" />
    <input name="delete" type="submit" value="Esborra"/>
    <?php
    function eliminarproposta(){
        require_once("Propostes.php");
        session_start();
        foreach($_SESSION["propostes"] as $listkey => $propostes){
            if ($propostes->getnomProposta() == $_GET["nomAEliminar"]) {
                echo "<br> Hem borrat a ".$propostes->getnomProposta()."<br>";
                unset($_SESSION["propostes"][$listkey]);

            }

        }
        return $_SESSION;
    }
    $_SESSION = eliminarproposta();

    ?>
</form>
<a href="gestiopropostes.html">Tornar a la Llista</a>
</body>
</html>



