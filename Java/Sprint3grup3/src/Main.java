/**
 * Grup 3 Sprint 2 2020 - Alberto Dos Santos, Cristian Diac, Isaac Brull, Carlos Masana -
 * <p>
 * Clase Principal
 */
import Clases.*;
import Finestres.FinestraPrincipal;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Main programa = new Main();
        programa.inici();

    }

    /**
     * Método que ejecuta las sentencias necesarias para iniciar el programa
     */

    public void inici() {

        RepositoriProjectes baseProjectes = new RepositoriProjectes(10);
        RepositoriPersones repoPersones = new RepositoriPersones(10);
        RepositoriPropostes basePropostes = new RepositoriPropostes(10);
        RepositoriEntitats baseEntitats = new RepositoriEntitats(10);


        FinestraPrincipal finestraPrincipal = new FinestraPrincipal(baseEntitats, repoPersones, baseProjectes, basePropostes);
        finestraPrincipal.crearFramePrincipal();


        // Dades de prova per les entitats
        baseEntitats.afegirEntitat(new Empresa("Oracle Corporation", "Redwood City", "123132132", "123"));
        baseEntitats.afegirEntitat(new Empresa("Microsoft Corporation", "Redmond", "123132132", "122"));
        baseEntitats.afegirEntitat(new Empresa("miHoYo Co., Ltd.", "Shangai", "123132132", "124"));
        baseEntitats.afegirEntitat(new Institut("INS Montsià", "Amposta", "123132132", "123"));
        baseEntitats.afegirEntitat(new Institut("INS Berenguer", "Amposta", "123132132", "124"));
        baseEntitats.afegirEntitat(new Institut("INS Els Alfacs", "Sant Carles de la Ràpita", "123132132", "125"));


    }
}
