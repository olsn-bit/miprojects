public class Client {
    /**
	 * Aquesta classe la utilitzarem per a guardar la informacio dels clients
     * @author grup4
     */
    String nom;
    int edat;
    double diners;

    /**
     * @param nom    nom del client (string)
     * @param edat   edat de la persona, necessari en cas que l'obra sigui per a majors d'edat	(int)
     * @param diners diners que té aquesta persona (double)
     */
    public Client(String nom, int edat, double diners) {
        this.nom = nom;
        this.edat = edat;
        this.diners = diners;
    }

    public Client(int edat, double diners) {
        this.nom = "anonim";
        this.edat = edat;
        this.diners = diners;
    }

    public String getNom() {
        return (this.nom);
    }

    public int getEdat() {
        return (this.edat);
    }

    public double getDiners() {
        return (this.diners);
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setEdat(int edat) {
        this.edat = edat;
    }

    public void setDiners(int diners) {
        this.diners = diners;
    }

    /**
	 * Aquest mètode cobra a un client el preu de la entrada.
     * @param preuEntrada preu de l'entrada  (double)
     * @return boolean marca si s'ha efectuat correctament la compra, també li resta els diners al client si retorna true.
     */
    public boolean pagarEntrada(double preuEntrada) {   // Al main es deuria fer un if amb te diners del client per a cobrar-li la entrada
        if ( this.teDiners(preuEntrada) ) {
            this.diners -= preuEntrada;
            return (true);
        }
        return (false);
        // return (true);
        // }
        // return (false);
    }

    /**
	 * Aquest mètode comprova si el client te prous diners per a pagar la entrada.
     * @param preuEntrada preu de l'entrada  (double)
     * @return boolean marca si el client, té prous diners per a pagar la entrada.
     */
    public boolean teDiners(double preuEntrada) {
        if ( this.diners >= preuEntrada ) {
            return (true);
        }
        return (false);
    }

    /**
	 * Aquest mètode comprova si una persona és major de edat o no.
     * @return boolean retorna true si la persona es major de 18 anys.
     */
    public boolean majorEdat() {
        if ( this.edat >= 18 ) {
            return (true);
        }
        return (false);
    }

    /**
     * @return Mostra breu dels atributs d'aquest objecte
     */
    public String toString() {
        return ("Nom: " + this.nom + ", Edat: " + this.edat + ", Diners: " + this.diners + ", És major: " + this.majorEdat());
    }

    public static void main(String[] args) {
        // Client Alberto = new Client("Alberto", 18, 1000);

        // System.out.println(Alberto.toString());
    }
}
