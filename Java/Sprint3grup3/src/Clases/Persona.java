package Clases;

/**
 * Grup 3 Sprint 2 2020 - Alberto Dos Santos, Cristian Diac, Isaac Brull, Carlos Masana -
 * <p>
 * Clase Clases.Persona
 */
public abstract class Persona {
    protected String nom;
    protected String dni;
    protected String nss;

    /**
     * Constructor vacío de la clase Clases.Persona
     */
    public Persona() {
        this.nom = "";
        this.dni = "";
        this.nss = "";
    }

    /**
     * Constructor sobrecargado de la clase Clases.Persona
     *
     * @param nom nombre de la Clases.Persona
     * @param dni documento nacional de identificación de la Clases.Persona
     * @param nss número de la seguridad social de la Clases.Persona
     */
    public Persona(String nom, String dni, String nss) {
        this.nom = nom;
        this.dni = dni;
        this.nss = nss;
    }

    /**
     * Getters & Setters
     */

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNss() {
        return nss;
    }

    public void setNss(String nss) {
        this.nss = nss;
    }

    @Override
    public String toString() {
        return "Nom: " + nom + " | " +
                "DNI: " + dni + " | " +
                "NSS: " + nss + " | ";
    }

    /**
     * Método que permite modificar un usuario
     */
    public void editUsuari() {
        boolean sortir = false;
        while (!sortir) {
            InputOutput.imprimirText("Sel·lecciona quin valor vols editar");
            String[] opcionsEditarUsuari = {"Editar nom", "Editar DNI", "Editar NSS", "Enrere"};
            InputOutput.imprimirLlistaNumerada(opcionsEditarUsuari);
            switch (InputOutput.entrarEnter("")) {
                case 1:
                    this.nom = InputOutput.entrarText("Introduex un nom per al usuari");
                    break;
                case 2:
                    this.dni = InputOutput.entrarText("Introduex un DNI per al usuari");
                    break;
                case 3:
                    this.nss = InputOutput.entrarText("Introduex un NSS per al usuari");
                    break;
                case 4:
                    sortir = true;
                    break;
                default:
                    InputOutput.imprimirText("Opció incorrecta");
                    break;
            }
        }
    }
}