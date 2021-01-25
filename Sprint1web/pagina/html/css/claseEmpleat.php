<?php
class ClasseEmpleat
{

    //     public $nom;
    //     public $rol;
    //     public $dni;
    //     public $nss;
    //
    // public function __construct($nom,$rol,$dni,$nss) {
    //
    //   $this->nom=$nom;
    //   $this->rol=$rol;
    //   $this->dni=$dni;
    //   $this->nss=$nss;
    //   $_SESSION['empleats'][] = $this;
    // }

    // $usuario = "cristian";
    // $contrasenya = "Cristian1@";
    // $servidor = "localhost";
    // $basededatos = "Sprint2";
    // $connexio = new mysqli($servidor, $usuario, $contrasenya, $basededatos);

  public  $idUsuari=$_GET["id"];
  public  $idRol=$_GET["rol"];
  public  $Nom=$_GET["nom"];
  public  $Cognom=$_GET["cognom"];
  public  $SegonCognom=$_GET["segonCognom"];
  public  $DNI=$_GET["dni"];
  public  $UserName=$_GET["usuari"];
  public  $Password=$_GET["contrasenya"];
  public  $Tipus=$_GET["tipus"];
  public  $Email=$_GET["correu"];
  public  $Telefon=$_GET["telefon"];




    function crearEmpleat(){
       require_once("classeConnexio.php");
       $connexio = new classeConnexio('cristian', 'Cristian1@', '192.168.224.222', 'Sprint2');
       $connexio->insert("INTO Usuari (idRol,Nom,Cognom,SegonCognom,DNI,UserName,Password,Tipus,Email,Telefon) VALUES('$idRol','$Nom','$Cognom','$SegonCognom','$DNI','$UserName','$Password','$Tipus','$Email','$Telefon')");

      }

      function llistarEmpleat(){
        require_once("classeConnexio.php");
        $connexio = new classeConnexio('cristian', 'Cristian1@', '192.168.224.222', 'Sprint2');
        $connexio->SELECT('* FROM Usuari');
        $resultatConsulta = mysqli_query($connexio,$consultaUsuaris) or die(mysqli_error());
        echo "<table borde='2'>";
        echo "<tr>";
        echo "<th>Nom</th>";
        echo "<th>Cognom</th>";
        echo "<th>Tipus</th>";
        echo "</tr>";
        while ($columna = mysqli_fetch_array( $resultatConsulta ))
        {
          echo "<tr>";
          echo "<td>" . $columna['Nom'] . "</td><td>" . $columna['Cognom'] . "</td><td>". $columna['Tipus'] . "</td>";
          echo "</tr>";
        }
        echo "</table>";
        }

        function baixaEmpleat(){
          require_once("classeConnexio.php");
          $connexio = new classeConnexio('cristian', 'Cristian1@', '192.168.224.222', 'Sprint2');
          $connexio->DELETE("* FROM Usuari WHERE idUsuari='$idUsuari'");
        }

        function editarEmpleat(){
          require_once("classeConnexio.php");
          $connexio = new classeConnexio('cristian', 'Cristian1@', '192.168.224.222', 'Sprint2');

        }

}
?>
