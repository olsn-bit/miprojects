<?php

class claseConnexio
{
    private $usuari;
    private $contrasenya;
    private $servidor;
    private $baseDeDades;
    private $connexio;

    public function __construct()
    {
        $this->usuari = 'cristian';
        $this->contrasenya = "Cristian1@";
        $this->servidor = '192.168.224.222';
        $this->baseDeDades = 'Sprint2';
    }
    public function select($consulta)
    {//Introduir la constulta en SQL sense el SELECT;
        $this->connexio = new mysqli($this->servidor, $this->usuari, $this->contrasenya, $this->baseDeDades) or die("Problemas al conectarse".mysqli_error($this->connexio));
        $consulta='SELECT '.$consulta;
        return $this->connexio->query($this->connexio, $consulta) or die("Problemas al hacer un select".mysqli_error($this->connexio));
    }
    public function insert($consulta)
    {//Introduir la constulta en SQL sense el INSERT;
        $this->connexio = new mysqli($this->servidor, $this->usuari, $this->contrasenya, $this->baseDeDades) or die("Problemas al conectarse".mysqli_error($this->connexio));

        $consulta = "INSERT ".$consulta;
        return mysqli_query($this->connexio, $consulta) or die("Problemas al hacer un insert".mysqli_error($this->connexio));
    }
    public function delete($consulta)
    {//Introduir la constulta en SQL sense el DELETE;
        $this->connexio = new mysqli($this->servidor, $this->usuari, $this->contrasenya, $this->baseDeDades) or die("Problemas al conectarse".mysqli_error($this->connexio));

        $consulta = "DELETE ".$consulta;
        return mysqli_query($this->connexio, $consulta) or die("Problemas al hacer un delete".mysqli_error($this->connexio));
    }
    public function update($consulta)
    {
        $this->connexio = new mysqli($this->servidor, $this->usuari, $this->contrasenya, $this->baseDeDades) or die("Problemas al conectarse".mysqli_error($this->connexio));

        $consulta = "UPDATE ".$consulta;
        return mysqli_query($this->connexio, $consulta) or die("Problemas al hacer un update".mysqli_error($this->connexio));
    }
}
