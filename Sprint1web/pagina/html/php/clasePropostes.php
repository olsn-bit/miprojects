<?php

class clasePropostes
{
    public $idDepartament;
    public $idGrup;
    public $idCategoria;
    public $Nom;
    public $Descripcio;
    public $Estat; //enum('Realitzat','Acceptat','No acceptat')
    public $DataPublicació;
    public $DataAcceptacio;

    public function __construct()
    {
    }
    public function alta($idDepartament, $idGrup, $idCategoria, $Nom, $Descripcio, $Estat, $DataPublicació, $DataAcceptacio)
    {
        $this->idDepartament = $idDepartament;
        $this->idGrup = $idGrup;
        $this->idCategoria = $idCategoria;
        $this->Nom = $Nom;
        $this->Descripcio = $Descripcio;
        $this->Estat = $Estat;
        $this->DataPublicació = $DataPublicació;
        $this->DataAcceptacio = $DataAcceptacio;

        require_once("claseConnexio.php");
        $connexio = new claseConnexio('cristian', "Cristian1@", '192.168.224.222', 'Sprint2');
        $connexio->insert(" INTO Proposta (idDepartament,idGrup,idCategoria,Nom,Descripcio,Estat,DataPublicació,DataAcceptacio) VALUES('$idDepartament','$idGrup','$idCategoria','$Nom','$Descripcio','$Estat','$DataPublicació','$DataAcceptacio')");
    }
    public static function baixa($idProposta)
    {//Aquest mètode elimina una proposta apartir de la id que li proporciona per parametre
        require_once("claseConnexio.php");
        $connexio = new claseConnexio();
        $connexio->delete(" * FROM Proposta WHERE idProposta = ".$idProposta);
    }
    public function editar($campAEditar, $valorNou)
    {//Aquest mètode canvia el valor d'un atribut, introduir valor nou entre comilles!!!!!!!
        require_once("claseConnexio.php");
        $connexio = new claseConnexio('cristian', "Cristian1@", '192.168.224.222', 'Sprint2');
        $connexio->update(" Propostes SET ".$campAEditar." = ".$valorNou." Where Nom = ".$this->Nom);
    }
    public static function llistar()
    {
        require_once("claseConnexio.php");
        $connexio = new claseConnexio('cristian', "Cristian1@", '192.168.224.222', 'Sprint2');
        return $connexio->select(" * FROM Proposta;");
    }
}
