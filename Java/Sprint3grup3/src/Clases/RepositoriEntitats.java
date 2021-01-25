package Clases;

/**
 * Grup 3 Sprint 2 2020 - Alberto Dos Santos, Cristian Diac, Isaac Brull, Carlos Masana -
 *
 * Clase Clases.RepositoriEntitats
 */
public class RepositoriEntitats {
    public Entitat[] arrayEntitats;
    public Integer contadorEntitats;

    /**
     * Crea un objecte de tipus LlistatEmpleat
     *
     * @param maxEntitats: Quantitat de Entitats que hi cabran al array
     */
    public RepositoriEntitats(int maxEntitats) {
        this.arrayEntitats = new Entitat[maxEntitats];
        this.contadorEntitats = 0;
    }

    /**
     * Crea un objecte de tipus Clases.Entitat getEntitatDelArray
     *
     * @param index: numero d'element de l'array en el que t'estas referin
     * @return: array de tipus arrayEntitat en la longitut de index
     */
    public Entitat getEntitatDelArray(int index) {
        return this.arrayEntitats[index];
    }

    /**
     * Crea un objecte del tipus afegirEmpleat
     *
     * @param entitat: Clases.Entitat de classe Clases.Entitat per a crear un Clases.Entitat
     */
    public void afegirEntitat(Entitat entitat) {
        this.arrayEntitats[contadorEntitats] = entitat;
        this.contadorEntitats++;
    }

}




