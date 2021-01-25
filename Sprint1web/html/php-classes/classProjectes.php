<?php
class classProjectes {
  public $nomProjecte;
  public $capProjecte;
  public $descripcioProjecte;

 public function __construct($nomProjecte,$capProjecte,$descripcioProjecte) {
      $this->nomProjecte=$nomProjecte;
      $this->capProjecte=$capProjecte;
      $this->descripcioProjecte=$descripcioProjecte;
      //guardar a la sessio
      $_SESSION["Projectes"][]=$this;
  }

public function llistar(){
    echo "<p>Nom projecte: ".$this->nomProjecte."</p>";
    echo "<p>Cap projecte: ".$this->capProjecte."</p>";
    echo "<p>Descripció: ".$this->descripcioProjecte."</p>";

}

}
/*
public funcion modificar() {
  echo "<p> nom: ".objecte
  echo "<p> cap del projecte". objecte == $this->nom."</p>";
}
//print array mostrar dades
//var_dump($arrayobject);
*/
?>
