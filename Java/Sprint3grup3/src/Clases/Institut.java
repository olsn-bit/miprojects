package Clases;

/**
 * Grup 3 Sprint 2 2020-2021 - Alberto Dos Santos, Cristian Diac, Isaac Brull, Carlos Masana -
 * <p>
 * Clase Clases.Institut: Permite realizar operaciones de gestión de institutos
 */
public class Institut extends Entitat {

    private String codiTerritorial;

    /**
     * Constructor vacío de la clase Clases.Institut
     */
    public Institut() {
        super(); // Llama al constructor de la clase padre
        this.codiTerritorial = "";
    }

    /**
     * Constructor sobrecargado de la clase Instituto
     *
     * @param nombre          nombre del instituto
     * @param poblacion       lugar dónde está ubicado el instituto
     * @param telefono        número de teléfono del instituto
     * @param codiTerritorial código de 6 dígitos único de cada instituto
     */
    public Institut(String nombre, String poblacion, String telefono, String codiTerritorial) {
        super(nombre, poblacion, telefono);
        this.codiTerritorial = codiTerritorial;
    }

    /**
     * Getters & Setters
     */
    public String getCodiTerritorial() {
        return codiTerritorial;
    }

    public void setCodiTerritorial(String codiTerritorial) {
        this.codiTerritorial = codiTerritorial;
    }

    /**
     * Permite mostrar la información completa de un objeto de la clase Clases.Institut
     *
     * @return mensaje con la información del objeto
     */
    @Override
    public String toString() {
        return super.toString() +
                "Codi Territorial: " + codiTerritorial;
    }

    /**
     * Mètode estatic per crear un institut, retorna el objecte de tipus institut
     * @return objeto de tipo instituto
     */
    public static Institut crearInstitut() {
        String nom = InputOutput.entrarText("Introduex el nom de l'Clases.Institut");
        String poblacio = InputOutput.entrarText("Introduex la població de l'Clases.Institut");
        String telefon = InputOutput.entrarText("Introduex el telefon de l'Intitut");
        String codiTerri = InputOutput.entrarText("Introduex el codi Territorial de l'Clases.Institut");
        Institut nouInstitut = new Institut(nom, poblacio, telefon, codiTerri);
        return nouInstitut;
    }


    /**
     * Mètode per editar un institut
     */
    public void editInstitut() {
        InputOutput.imprimirText("Sel·lecciona quin valor vols editar");
        String[] opcionsEditarInstitut = {"Editar nom", "Editar Població", "Editar Telefon", "Editar Codi del territori"};
        InputOutput.imprimirLlistaNumerada(opcionsEditarInstitut);
        switch (InputOutput.entrarEnter("")) {
            case 1:
                this.nom = InputOutput.entrarText("Introduex un nom per al Clases.Institut");
                break;
            case 2:
                this.poblacio = InputOutput.entrarText("Introduex la població de l'Clases.Institut");
                break;
            case 3:
                this.telefono = InputOutput.entrarText("Introduex el numero de telefon de l'Clases.Institut");
                break;
            case 4:
                this.codiTerritorial = InputOutput.entrarText("Introduex el codi Territorial de l'Clases.Institut");
                break;
            default:
                InputOutput.imprimirText("Opció incorrecta");
                break;
        }
    }


}