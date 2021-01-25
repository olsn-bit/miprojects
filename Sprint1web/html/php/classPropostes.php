<?php

class classPropostes
{
    private idDepartament;
    private idGrup;
    private idCategoria;
    private Nom;
    private Descripcio;
    private Estat; //enum('Realitzat','Acceptat','No acceptat')
    private DataPublicació;
    private DataAcceptacio;
    //Setters and getters

c
    public function __construct($nomProposta, $email, $descProp)
    {

        $this->nomProposta = $nomProposta;
        $this->email = $email;
        $this->descProp = $descProp;
        $_SESSION['propostes'][] = $this;
    }

    public function mostra()
    {
        echo "<p> Nom: $this->nomProposta ";
        echo "<p> email: $this->email";
        echo "<p> Descripció: $this->descProp ";
    }
}

?>
