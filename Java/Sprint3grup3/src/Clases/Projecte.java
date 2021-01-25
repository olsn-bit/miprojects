package Clases;

/**
 * Grup 3 Sprint 2 2020 - Alberto Dos Santos, Cristian Diac, Isaac Brull, Carlos Masana -
 *
 * Clase Clases.Projecte: Define atributos y métodos de la clase
 */
public class Projecte {
    
    private String nom;
    private Empleat cap;
    private Pressupost pressupostDelProjecte;
    private String descripcio;
    private Proposta proposta;
    
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Empleat getCap() {
        return cap;
    }

    public void setCap(Empleat cap) {
        this.cap = cap;
    }

    public String getDescripcio() {
        return descripcio;
    }

    public void setDescripcio(String descripcio) {
        this.descripcio = descripcio;
    }

    public Pressupost getPressupostDelProjecte() {
        return pressupostDelProjecte;
    }

    public String toString() {
        return  "Títol: " + nom + " | " +
                "Descripció: " + descripcio + " | " +
                "Clases.Pressupost: " + pressupostDelProjecte + " €" + " | " +
                "Cap projecte: " + cap;
    }

    public void setPressupostDelProjecte(Pressupost pressupostDelProjecte) {
        this.pressupostDelProjecte = pressupostDelProjecte;
    }

    public Projecte(String nom, String descripcio, Empleat cap) {
        this.nom = nom;
        this.descripcio = descripcio;
        this.cap = cap;
    }

    /**
     * Permite crear Proyectos
     * @param arrayEmpleats array con los empleados que están dados de alta
     * @param basePropostes array con datos de las propuestas que han sido creadas
     * @return objeto de la clase Proyecto o null si las condiciones no se cumplen
     */
    public static Projecte crearProjecte(Persona persona, Proposta proposta) {
        String nomProjecte = proposta.getNomProposta();
        String descProjecte = proposta.getDescProposta();

        Empleat empleat = (Empleat) persona;
        return new Projecte(nomProjecte, descProjecte, empleat);
    }



    }


        
