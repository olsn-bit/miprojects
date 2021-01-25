package Clases; /**
 * Grup 3 Sprint 2 2020 - Alberto Dos Santos, Cristian Diac, Isaac Brull, Carlos Masana -
 * <p>
 * Clase LlistatPersona: Simula una base de datos con los empleados
 */

/**
 * Serveix per emmagatzemar objectes tipus Clases.Persona, Simulació de base de dades
 * arrayPersones = array per als objectes de tipus Clases.Persona
 * contadorPersones = contador d'Persones creats al array
 */
public  class RepositoriPersones {
    public Persona[] arrayPersones;
    public Integer contadorPersones;

    /**
     * Crea un objecte de tipus LlistatPersona
     *
     * @param maxPersones: Quantitat de Persones que hi cabran al array
     */
    public RepositoriPersones(int maxPersones) {
        this.arrayPersones = new Persona[maxPersones];
        this.contadorPersones = 0;
    }

    /**
     * Método que permite seleccionar un empleado de la lista
     *
     * @return un objeto de tipo Clases.Empleat
     */
    public Persona[] llistarEmpleats(){
        return arrayPersones;
    }

    /**
     * Crea un objecte de tipus getPersonaInArray
     * @param indexdesde0: numero d'element de l'array en el que t'estas referin, mirar que el index sigui una referencia que començi amb 0
     *
     * @return: array de tipus arrayPersona en la longitut de index
     */
    public Persona getPersonaInArray(int indexdesde0) {
        return this.arrayPersones[indexdesde0];
    }

    /**
     * Crea un objecte del tipus afegirPersona
     *
     * @param Persona : Clases.Persona de classe Clases.Persona per a crear un Clases.Persona
     */
    public void afegirPersona(Persona Persona) {
        this.arrayPersones[contadorPersones] = Persona;
        this.contadorPersones++;
        System.out.println("Sa afegit");
    }

    /**
     * Funció eliminarPersona 
     *
     * @param indexElementAEliminar : numero de l'element de l'array que vols eliminar
     * Es fa un bucle per a comprovar que l'element seleccionat existeix
     * o no
     */

    public void eliminarPersona(int indexElementAEliminar) {

        if (indexElementAEliminar >= 0 && indexElementAEliminar <= (this.contadorPersones)) {
            String nomPersonaBorrat = this.arrayPersones[indexElementAEliminar].getNom();

            for (int e = indexElementAEliminar; e < this.contadorPersones; e++) {
                this.arrayPersones[e] = this.arrayPersones[e + 1];
            }
            this.arrayPersones[this.contadorPersones - 1] = null;
            this.contadorPersones--;
        } else {
        }

    }



}


