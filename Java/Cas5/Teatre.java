public class Teatre {
    Obra obra;
    double preu;
    int files;
    int seients;

    Seient[][] sessio;

    /**
     * Constructor de la classe
     * @author grup4
     * @param obra                 objecte de tipus obra per al teatre (Obra)
     * @param preu                 preu de la entrada a aquest teatre (double)
     * @param files,seientsPerFila files i seients per fila que conte aquest teatre(int)
     */
    public Teatre(Obra obra, double preu, int files, int seientsPerFila) {
        this.obra = obra;
        this.preu = preu;
        this.sessio = new Seient[files][seientsPerFila];
        this.files = files;
        this.seients = seientsPerFila;
    }

    public Obra getObra() {
        return (this.obra);
    }

    public double getPreu() {
        return (this.preu);
    }

    public Seient[][] getSessio() {
        return (this.sessio);
    }

    public void setObra(Obra obra) {
        this.obra = obra;
    }

    public void setPreu(double preu) {
        this.preu = preu;
    }

    public void setSessio(Seient seients[][]) {
        this.sessio = seients;
    }

    // public boolean seientOcupat()
    public Seient getSeient(int fila, int seient) {
        return (this.sessio[fila][seient]);
    }

    public void setSeient(Seient seient) {
        this.sessio[seient.getFila()][seient.getNumero()] = seient;
    }

    /**
     * Serveix per a comprovar si un seient és buit o ple
     *
     * @param fila,seient localitzacio del seient fila i num_seient (int)
     * @return String "[0]"si es buit i "[X]" si no es.
     */
    public String seientOcupat(int fila, int seient) {
        if ( this.sessio[fila][seient] == null ) {
            return ("[O]");
        }
        return ("[X]");
    }

    /**
     * @return Mostra breu dels atributs d'aquest objecte
     */
    public String toString() {
        String returnedString = "";

        returnedString += ("Teatre------------------------------------\n");
        returnedString += ("Seient ");
        for (int i = 0; i < this.seients; i++) {//Contador de seients a la part superior del grafic
            returnedString += ("-" + i + "- ");
        }
        for (int e = 0; e < this.files; e++) {//""contador de files i contingut
            returnedString += ("\nFila-" + e + "-");
            for (int i = 0; i < seients; i++) {
                returnedString += (this.seientOcupat(e, i) + " ");
            }
        }
        returnedString += ("\n");
        return (returnedString + this.printList());
    }

    /**
     * Imprimeix la llista dels clients que tenen un seient al teatre.
     *
     * @return String: llista de clients que tenen un seient al teatre.
     */
    public String printList() {
        String returnedString = "";

        returnedString += ("Llista de clients------------------------------------\n");
        for (int i = 0; i < this.seients; i++) {
            for (int e = 0; e < this.files; e++) {
                if ( this.sessio[i][e] != null ) {
                    returnedString += (this.sessio[i][e] + "\n");
                }
            }
        }
        return (returnedString);
    }
    // public Teatre
}
