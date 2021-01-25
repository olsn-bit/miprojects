package Clases;

/**
 * Grup 3 Sprint 2 2020-2021 - Alberto Dos Santos, Cristian Diac, Isaac Brull, Carlos Masana -
 * Clase Clases.Empleat: Hereda de la clase Clases.Persona
 */
public class Empleat extends Persona {
    private String codiEmpleat;

    /**
     * Constructor sobrecargado de la clase Clases.Empleat
     *
     * @param nom         nombre del empleado
     * @param dni         documento nacional de identidad del empleado
     * @param nss         número de la seguridad social del empleado
     * @param codiEmpleat número de identificación de cada empleado
     */
    public Empleat(String nom, String dni, String nss, String codiEmpleat) {
        super(nom, dni, nss);
        this.codiEmpleat = codiEmpleat;
    }

    public String getCodiEmpleat() {
        return codiEmpleat;
    }

    public void setCodiEmpleat(String codiEmpleat) {
        this.codiEmpleat = codiEmpleat;
    }

    /**
     * Método que muestra por pantalla el menú para la gestión de Empleados
     * @param repoPersones Objeto de la clase LlistatEmpleat
     */
    public static void crudEmpleat(RepositoriPersones repoPersones) {
        boolean sortir = false;
        while (!sortir) {
            InputOutput.imprimirText("--------Empleats--------");
            String[] opcions = {"Llistar Empleats", "Crear Empleats", "Esborrar Empleats", "Editar Empleats", "Enrere"};
            InputOutput.imprimirLlistaNumerada(opcions);
            switch (InputOutput.entrarEnter("")) {
                case 1://llistar
                    repoPersones.llistarEmpleats();
                    break;
                case 2://crear
                    //Empleat user = new Empleat();
                    //user.crearEmpleat();
                    //repoPersones.afegirPersona(user);
                    break;
                case 3://esborrar
                    if (repoPersones.contadorPersones == 0) {
                        InputOutput.imprimirText("No es pot editar ningun empleat, perque no hi ha ningun empleat creat.");
                    } else {
                        repoPersones.llistarEmpleats();
                        repoPersones.eliminarPersona(InputOutput.entrarEnter("Sel·lecciona un empleat per eliminar-lo"));
                    }
                    break;
                case 4://editar
                    if (repoPersones.contadorPersones == 0) {
                        InputOutput.imprimirText("No es pot editar ningun empleat, perque no hi ha ningun empleat creat.");
                    } else {
                        repoPersones.llistarEmpleats();
                        Empleat user2 = (Empleat) repoPersones.arrayPersones[(InputOutput.entrarEnter("Sel·lecciona un empleat per editar-lo") - 1)];
                        user2.editEmpleat();//-1 perque es llista amb +1
                    }
                    break;
                case 5: // Atrás
                    sortir = true;
                    break;
                default:
                    break;
            }
        }
    }

    /**
     * Método que permite modificar un empleado
     */
    public void editEmpleat() {
        boolean sortir = false;
        while (!sortir) {
            InputOutput.imprimirText("Sel·lecciona quin valor vols editar");
            String[] opcionsEditarEmpleat = {"Editar nom", "Editar DNI", "Editar NSS", "Editar codi d'empleat", "Enrere"};
            InputOutput.imprimirLlistaNumerada(opcionsEditarEmpleat);
            switch (InputOutput.entrarEnter("")) {
                case 1:
                    this.nom = InputOutput.entrarText("Introdueix el nom per al empleat");
                    break;
                case 2:
                    this.dni = InputOutput.entrarText("Introdueix el DNI per al empleat");
                    break;
                case 3:
                    this.nss = InputOutput.entrarText("Introdueix el NSS per al empleat");
                    break;
                case 4:
                    this.codiEmpleat = InputOutput.entrarText("Introdueix el codi d'empleat");
                    break;
                case 5: //atrás
                    sortir = true;
                    break;
                default:
                    InputOutput.imprimirText("Opció incorrecta");
                    break;
            }
        }
    }

    /**
     * Método que permite transformar un objeto en un String
     *
     * @return String con los datos de un empleado
     */
    public String toString() {
        return  super.toString() +
                "Codi Empleat: " +
                this.codiEmpleat;
    }
}
