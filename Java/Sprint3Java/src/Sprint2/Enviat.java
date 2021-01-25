package Sprint3Java.Old;

public class Enviat extends Correu { //SUBCLASSE

    // Atribut en privat per a que només hi pugui accedir aquesta mateixa classe
    private String de;

    //Constructor per defecte
    public Enviat(){

    }

    //Constructor amb els atributs de la SUPERCLASSE I l'atribut que diferencia aquesta SUBCLASSE de l'altra (nom)
    public Enviat(String assumpte, String cos, String de) {

        super(assumpte, cos); //Override | Cridem al constructor de la SUPERCLASSE
        de = de;

    }

    // Mètode Getter
    public String getDe(){
        return de;
    }
    
    public void setDe(String de) {
        this.de = de;
    }

    //Sobreescribim el toString, ja que el cridem des de la SUPERCLASSE
    @Override
    public String toString() {
        return super.toString() + "Nom: " + de + "\n";
    }


}

