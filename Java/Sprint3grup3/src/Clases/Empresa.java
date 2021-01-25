package Clases;

/**
 * Grup 3 Sprint 2 2020-2021 - Alberto Dos Santos, Cristian Diac, Isaac Brull, Carlos Masana
 *
 * Clase Clases.Empresa: Permite realizar operaciones de gestión de empresas
 */

public class Empresa extends Entitat{
    private String cif;

    /**
     * Constructor vacío de la clase Clases.Empresa
     */
    public Empresa() {
        super(); // Llama al constructor de la clase padre
        this.cif = "";
    }

    /**
     * Constructor sobrecargado de la clase Clases.Empresa
     * @param nombre nombre de la empresa
     * @param poblacion lugar dónde se encuentra ubicada la empresa
     * @param telefono número de teléfono de la empresa
     * @param cif código de identificación fiscal de la empresa
     */
    public Empresa(String nombre, String poblacion, String telefono, String cif) {
        super(nombre, poblacion, telefono);
        this.cif = cif;
    }

    /**
     * Getters & Setters
     */

    public String getCif() {
        return cif;
    }

    public void setCif(String cif) {
        this.cif = cif;
    }

    /**
     * Permite mostrar la información completa de un objeto de la clase Clases.Empresa
     * @return mensaje con la información del objeto
     */
    @Override
    public String toString() {
        return  super.toString() +
                "CIF: " + this.cif;
    }

    /**
     * Permite crear una empresa
     *
     * @return objeto de tipo Clases.Empresa
     */
    public static Empresa crearEmpresa() {
        String nom = InputOutput.entrarText("Introduex el nom de la Clases.Empresa");
        String poblacio = InputOutput.entrarText("Introduex la població de la Clases.Empresa");
        String telefono = InputOutput.entrarText("Introduex el telefon de la Clases.Empresa");
        String cif = InputOutput.entrarText("Introduex el cif de la Clases.Empresa");

        Empresa novaEmpresa = new Empresa(nom,poblacio,telefono,cif);

        return novaEmpresa;
    }

    /**
     * Mètode per editar els valors d'una Clases.Empresa
     */
    public void editarEmpresa() {
        boolean sortir = false;
        while (!sortir) {
            InputOutput.imprimirText("Sel·lecciona quin valor vols editar");
            String[] opcionsEditarEmpresa = {"1. Editar nom", "2. Editar poblacio", "3. Editar telefono", "4. Editar cif", "5. Enrere"};
            InputOutput.imprimirLlistaNumerada(opcionsEditarEmpresa);
            switch (InputOutput.entrarEnter("")) {
                case 1:
                    this.nom = InputOutput.entrarText("Introdueix el nou nom de la Clases.Empresa");
                    break;
                case 2:
                    this.poblacio = InputOutput.entrarText("Introdueix la nova població de la Clases.Empresa");
                    break;
                case 3:
                    this.telefono = InputOutput.entrarText("Introdueix el nou telefon de la Clases.Empresa");
                    break;
                case 4:
                    this.cif = InputOutput.entrarText("Introdueix el nou cif de la Clases.Empresa");
                    break;
                case 5: // atrás
                    sortir = true;
                    break;
                default:
                    InputOutput.imprimirText("Opció incorrecta");
                    break;
            }
        }
    }
}