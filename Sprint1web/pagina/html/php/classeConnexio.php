<?php

class classConnexio
{
    private $usuari;
    private $contrasenya;
    private $servidor;
    private $baseDeDades;
    private $connexio;

    public function __construct($usuari, $contrasenya, $servidor, $baseDeDades)
    {
        $this->usuari = $usuari;
        $this->contraseya = $contrasenya;
        $this->servidor = $servidor;
        $this->baseDeDades = $baseDeDades;
        $this->connexio = new mysqli($this->servidor, $this->usuari, $this->contrasenya, $this->baseDeDades);
    }
    public function select($consulta)
    {//Introduir la constulta en SQL sense el SELECT;
        $consulta='SELECT '.$consulta;
        return mysqli_query($this->connexio, $consulta) or die("Problemas al hacer un select".mysqli_error($connexio));
    }
    public function insert($consulta)
    {//Introduir la constulta en SQL sense el INSERT;
        $consulta = "INSERT ".$consulta;
        mysqli_query($this->connexio, $consulta) or die("Problemas al hacer un insert".mysqli_error($connexio));
    }
    public function delete($consulta)
    {//Introduir la constulta en SQL sense el DELETE;
        $consulta = "DELETE ".$consulta;
        mysqli_query($this->connexio, $consulta) or die("Problemas al hacer un delete".mysqli_error($connexio));
    }
    public function update($consulta)
    {
        $consulta = "UPDATE ".$consulta;
        mysqli_query($this->connexio, $consulta) or die("Problemas al hacer un update".mysqli_error($connexio));
    }
}
