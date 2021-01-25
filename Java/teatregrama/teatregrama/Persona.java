// package teatregrama;
public class Persona {
		String nom;
		int edat;
		double diners;
		public String getNom() {
				return (nom);
		}
		public void setNom(String nomC) {
				this.nom = nomC;
		}
		public int getEdat() {
				return (edat);
		}
		public void setEdat(int edatC) {
				this.edat = edatC;
		}
		public double getDiners() {
				return (diners);
		}
		public void setDiners(int dinersC) {
				this.diners = dinersC;
		}
		public boolean pagarEntrada(double preuEntrada) {
				diners = diners - preuEntrada;
				System.out.println("Entrada pagada \nLi queden " + diners + " euros");
				return (false);
		}
		public boolean majorEdat() {
				boolean major = false;

				if (edat < 18) {
						major = false;
						return (major);
				} else {
						major = true;
						return (major);
				}
		}
		public boolean teDiners(Teatre tr) {
				boolean dineros = false;

				if (diners < tr.getPreu()) {
						dineros = false;
						return (dineros);
				} else {
						dineros = true;
						return (dineros);
				}
		}
		public String toString() {
				String dades = "El senyor " + nom + " té " + edat + " anys i té " + diners + " euros.";

				return (dades);
		}
		public Persona(String nomClient, int edatClient, int dinersClient) {
				nom = nomClient;
				edat = edatClient;
				diners = dinersClient;
		}
		public Persona(int edatClient, int dinersClient) {
				nom = "anonim";
				edat = edatClient;
				diners = dinersClient;
		}
		public Persona(int dinersClient) {
				nom = "anonim";
				edat = 99;
				diners = dinersClient;
		}
}
