package Clases;

/**
 * Grup 3 Sprint 2 2020-2021 - Alberto Dos Santos, Cristian Diac, Isaac Brull, Carlos Masana -
 *
 * Clase entidad: Implementa métodos comunes en clases Clases.Empresa e Instituto
 */

 abstract class Entitat {
    protected String nom;
    protected String poblacio;
    protected String telefono;

    /**
     * Constructor vacío de la clase Entidad
     */
    public Entitat() {
        this.nom = "";
        this.poblacio = "";
        this.telefono = "";
    }

    /**
     * Constructor sobrecargado de la clase Entidad
     * @param nombre nombre de la entidad
     * @param poblacion lugar dónde se encuentra ubicada la entidad
     * @param telefono número de teléfono de la entidad
     */
    public Entitat(String nombre, String poblacion, String telefono) {
        this.nom = nombre;
        this.poblacio = poblacion;
        this.telefono = telefono;
    }

    /**
     * Getters and Setters
     */

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPoblacio() {
        return poblacio;
    }

    public void setPoblacio(String poblacio) {
        this.poblacio = poblacio;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * Permite mostrar la información completa de un objeto de la clase entidad
     * @return mensaje con la información del objeto
     */
    @Override
    public String toString() {
        return  "Nom: " + this.nom + " | " +
                "Població: " + this.poblacio + " | " +
                "Telèfon: " + this.telefono + " | ";
    }
}