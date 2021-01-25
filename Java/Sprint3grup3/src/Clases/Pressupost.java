package Clases;

/**
 * Grup 3 Sprint 2 2020 - Alberto Dos Santos, Cristian Diac, Isaac Brull, Carlos Masana -
 *
 * Clase Presupuesto: Permite realizar cualquier tipo de gestión presupuestos
 */
public class Pressupost {
    String nom;
    Integer preuTotal;
    Integer[] llistaPreus;
    String[] nomPreus;

    /**
     * Constructor sobrecargado
     * @param preuTotal precio total del presupuesto
     * @param llistaPreus un array con los precios de cada producto del presupuesto
     * @param nomPreus un array con el nombre de los productos del presupuesto
     * @param nom nombre del presupuesto
     */
    public Pressupost(Integer preuTotal, Integer[] llistaPreus, String[] nomPreus, String nom) {
        this.preuTotal = preuTotal;
        this.llistaPreus = llistaPreus;
        this.nomPreus = nomPreus;
        this.nom = nom;
    }


    public Integer getPreuTotal() {
        return preuTotal;
    }

    public Integer getLlistaPreus() {
        return llistaPreus[0];
    }

    public String getnomPreus() {
        return nomPreus[0];
    }

    public String getNom() {
        return nom;
    }

    public void setPreuTotal(Integer preuTotal) {
        this.preuTotal = preuTotal;
    }

    public void setLlistaPreus(Integer[] llistaPreus) {
        this.llistaPreus = llistaPreus;
    }

    public void setnomPreus(String[] nomPreus) {
        this.nomPreus = nomPreus;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * To string elaborat per mostrar els Pressupostos en forma de taula.
     * @return
     */
    public String toString() {

        String columna = "Nom pressupost : "+this.nom+"\n    Nom Preu : "+this.nomPreus[0] +"| Preu "+llistaPreus[0]+"\n";
        String linees = columna;
        for (int e = 0;e<this.llistaPreus.length;e++){
            linees += "    "+" |  €\n";
        }
        linees += "             Total: " + preuTotal;
        linees += "\n-------------------------";
        return linees;
    }
}
