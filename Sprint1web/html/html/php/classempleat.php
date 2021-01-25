<?php
class ClasseEmpleat
{

        public $nom;
        public $rol;
        public $dni;
        public $nss;

    public function __construct($nom,$rol,$dni,$nss) {

      $this->nom=$nom;
      $this->rol=$rol;
      $this->dni=$dni;
      $this->nss=$nss;
      $_SESSION['empleats'][] = $this;
    }
    
    public function delete(){
        session_start();
        var_dump($_SESSION);
      foreach ($_SESSION["empleats"] as $empleats) {
        if ($empleats == $this) {
            echo "actually done <br>";
            unset($_SESSION['empleats'][$empleats]);
        }
        
      }
      var_dump($_SESSION);
    }
    public function getNom(){
		return $this->nom;
	}

	public function setNom($nom){
		$this->nom = $nom;
	}

	public function getRol(){
		return $this->rol;
	}

	public function setRol($rol){
		$this->rol = $rol;
	}

	public function getDni(){
		return $this->dni;
	}

	public function setDni($dni){
		$this->dni = $dni;
	}

	public function getNss(){
		return $this->nss;
	}

	public function setNss($nss){
		$this->nss = $nss;
	}
    public function mostra(){
      echo "Nom:".$this->nom;
      echo "Rol:".$this->rol;
    }

}
?>
