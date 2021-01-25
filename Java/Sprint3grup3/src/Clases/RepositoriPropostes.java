package Clases; /**
 * Grup 3 Sprint 2 2020 - Alberto Dos Santos, Cristian Diac, Isaac Brull, Carlos Masana -
 * <p>
 * Clase LlistatProposta: Simula una base de datos con las Propuestas
 */

/**
 * Serveix per emmagatzemar objectes tipus Clases.Proposta, Simulació de base de dades
 * arrayPropostas = array per als objectes de tipus Clases.Proposta
 * contadorPropostas = contador de propostes creats al array
 */
public class RepositoriPropostes {
    public Proposta[] arrayPropostes;
    public Integer contadorPropostes;

    /**
     * Crea un objecte de tipus LlistatProposta
     *
     * @param maxPropostes: Quantitat de propostes que hi cabran al array
     */
    public RepositoriPropostes(int maxPropostes) {
        this.arrayPropostes = new Proposta[maxPropostes];
        this.contadorPropostes = 0;
    }

    /**
     * Crea un objecte de tipus getPropostaInArray
     * @param index: numero d'element de l'array en el que t'estas referin
     * @return array de tipus arrayPropostes en la longitut de index
     */
    public Proposta getPropostaInArray(int index) {
        return this.arrayPropostes[index];
    }

    /**
     * Crea un objecte del tipus afegirPropostes
     *
     * @param proposta: proposta de classe Clases.Proposta per a crear una proposta
     */
    public void afegirPropostes(Proposta proposta) {
        this.arrayPropostes[contadorPropostes] = proposta;
        this.contadorPropostes++;
    }

    /**
     * Funció eliminarProposta
     *
     * @param indexElementAEliminar : numero de l'element de l'array que vols eliminar
     * Es fa un bucle per a comprovar que l'element seleccionat existeix
     * o no
     */

    public void eliminarProposta(int indexElementAEliminar) {
        indexElementAEliminar -= 1;//per a igualar el +1 que posem al llistat per a que la llista començe en 1
        if (indexElementAEliminar >= 0 && indexElementAEliminar <= (this.contadorPropostes)) {
            String nomPropostaBorrat = this.arrayPropostes[indexElementAEliminar].getNomProposta();

            for (int e = indexElementAEliminar; e < this.contadorPropostes; e++) {
                this.arrayPropostes[e] = this.arrayPropostes[e + 1];
            }
            this.arrayPropostes[this.contadorPropostes - 1] = null;
            InputOutput.imprimirText("S'ha eliminat correctament la proposta " + nomPropostaBorrat);
            this.contadorPropostes--;
        } else {
            InputOutput.imprimirText("No existeix aquesta proposta");
        }

    }

}


