<html>
<LINK REL=StyleSheet HREF="gestiopropostes.css" TYPE="text/css" MEDIA=screen>
<div class="capsalera">
    <h1>CRUD PROPOSTES</h1>
</div>
<body class="crudpropostes">
    <?php
    require_once("Propostes.php");
    session_start();
    ?>
    <table border="1">
    <?php foreach ($_SESSION['propostes'] as $x):?>
    <tr>
      <td><?php  echo $x->mostra(); ?></td>


    </tr>
    <?php endforeach; ?>
    </table>
</body>
<a href="gestiopropostes.html">Torna al menú.</a>
</html>

