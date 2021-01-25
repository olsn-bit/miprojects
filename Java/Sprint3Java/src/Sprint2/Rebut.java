package Sprint3Java.Old;

public class Rebut extends Correu { //SUBCLASSE

    private String para;

    //Constructor per defecte
    public Rebut(){

    }

    //Constructor amb els atributs de la SUPERCLASSE I l'atribut que diferencia aquesta SUBCLASSE de l'altra (nom)
    public Rebut(String assumpte, String cos, String para) {

        super(assumpte, cos);
        para = para;

    }

    // Mètode Getter
    public String getPara(){
        return para;
    }
    
    public void setPara(String para) {
        this.para = para;
    }

    @Override
    public String toString() {
        return super.toString() + "Cognom: " + para;
    }

}
