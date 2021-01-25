<?php

class Propostes
{

    public $nomProposta;
    public $email;
    public $descProp;
    //Setters and getters


    /**
     * @return mixed
     */
    public function getNomProposta()
    {
        return $this->nomProposta;
    }

    /**
     * @param mixed $nomProposta
     */
    public function setNomProposta($nomProposta)
    {
        $this->nomProposta = $nomProposta;
    }

    /**
     * @return mixed
     */
    public function getEmail()
    {
        return $this->email;
    }

    /**
     * @param mixed $email
     */
    public function setEmail($email)
    {
        $this->email = $email;
    }

    /**
     * @return mixed
     */
    public function getDescProp()
    {
        return $this->descProp;
    }

    /**
     * @param mixed $descProp
     */
    public function setDescProp($descProp)
    {
        $this->descProp = $descProp;
    }

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