package Clases;

/**
 * Grup 3 Sprint 2 2020 - Alberto Dos Santos, Cristian Diac, Isaac Brull, Carlos Masana -
 * <p>
 * Clase LlistatProjecte: Simula una bbdd con Proyectos, también se implementan algunos métodos que permiten utilizarla
 */
public class RepositoriProjectes {
    public Projecte[] arrayProjectes;
    public Integer contadorProjectes;

    public RepositoriProjectes(int maxProjectes) {
        this.arrayProjectes = new Projecte[maxProjectes];
        this.contadorProjectes = 0;
    }

    public Boolean pressupostosPerFer() {
        int pressupostosFets = 0;
        for (int e = 0; e < this.contadorProjectes; e++) {
            if (this.arrayProjectes[e].getPressupostDelProjecte() == null) {
                return true;
            }
        }
        return false;
    }


    /**
     * Crea un objecte de tipus Clases.Projecte
     *
     * @param index: numero d'element de l'array en el que t'estas referin
     * @return array de tipus arrayEmpleat en la longitut de index
     */
    public Projecte getProjecteInArray(int index) {
        return this.arrayProjectes[index];
    }

    /**
     * Funció afegirProposta
     *
     * @param proj: Objecte de tipus Clases.Projecte
     */
    public void afegirProjecte(Projecte proj) {
        this.arrayProjectes[contadorProjectes] = proj;
        this.contadorProjectes++;
    }


    /**
     * Funció eliminarProjecte
     *
     * @param indexElementAEliminar : numero de l'element de l'array que vols eliminar
     *                              Es fa un bucle per a comprovar que l'element seleccionat existeix
     *                              o no
     */

    public void eliminarProjecte(int indexElementAEliminar) {
        indexElementAEliminar -= 1;//per a igualar el +1 que posem al llistat per a que la llista començe en 1
        if (indexElementAEliminar >= 0 && indexElementAEliminar <= (this.contadorProjectes)) {
            String nomEmpleatBorrat = this.arrayProjectes[indexElementAEliminar].getNom();

            for (int e = indexElementAEliminar; e < this.contadorProjectes; e++) {
                this.arrayProjectes[e] = this.arrayProjectes[e + 1];
            }
            this.arrayProjectes[this.contadorProjectes - 1] = null;
            InputOutput.imprimirText("S'ha eliminat correctament l'empleat " + nomEmpleatBorrat);
            this.contadorProjectes--;
        } else {
            InputOutput.imprimirText("No existeix aquest empleat");
        }
    }
}
