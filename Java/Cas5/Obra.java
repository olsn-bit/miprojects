public class Obra {
    /**
     *
     * Aquesta classe la utilitzarem per a guardar informacio de les obres i utilitzar-les com a objectes.
     * @author grup4
     */
    String titol;
    int durada;
    String autor;
    boolean adults;

    /**
     * @param durada temps de durada en (int) de la Obra
	 * @param titol Titol de l'obra	(string)
	 * @param autor Autor de l'obra (string)
	 * @param adults Boolea que marca si l'obra es per a majors de 18 anys.
     */
    public Obra(String titol, int durada, String autor, boolean adults) {
        this.titol = titol;
        this.durada = durada;
        this.autor = autor;
        this.adults = adults;
    }

    public Obra(String titol) {
        this.titol = titol;
        this.durada = 60;
        this.autor = "Anonim";
        this.adults = false;
    }

    public Obra(String titol, int durada) {
        this.titol = titol;
        this.durada = durada;
        this.autor = "Anonim";
        this.adults = false;
    }

    public Obra(String titol, int durada, String autor) {
        this.titol = titol;
        this.durada = durada;
        this.autor = autor;
        this.adults = false;
    }

    public void setTitol(String titol) {
        this.titol = titol;
    }

    public void setDurada(int durada) {
        this.durada = durada;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setAdults(boolean adults) {
        this.adults = adults;
    }

    public String getTitol() {
        return (this.titol);
    }

    public int getDurada() {
        return (this.durada);
    }

    public String getAutor() {
        return (this.autor);
    }

    public boolean getAdults() {
        return (this.adults);
    }
	/**
	 * @return Mostra breu dels atributs d'aquest objecte
	 */
    public String toString() {
        return ("Titol: " + this.titol + ", Durada: " + this.durada + ", Autor: " + this.autor + " Adults: " + this.adults);
    }

    public static void main(String[] args) {
    }
}
