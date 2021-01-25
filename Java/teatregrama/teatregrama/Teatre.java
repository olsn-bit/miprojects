// package teatregrama;
public class Teatre {
		Seient sessio[][];
		double preu;
		Obra obra;
		public double getPreu() {
				return (preu);
		}
		public void setPreu(double PreuT) {
				this.preu = PreuT;
		}
		public Obra getObra() {
				return (obra);
		}
		public void setObra(Obra obra) {
				this.obra = obra;
		}
		public boolean seientBuit(int fila, int columna) {
				if (this.sessio[columna][fila] == null) {
						return (true);
				}
				return (false);

				/*boolean buitSn=false;
				 *
				 * if(Seient.estaOcupat(fila,columna)==false){
				 * buitSn=true;
				 * return buitSn;
				 * }
				 * else {
				 *      return buitSn;
				 * }*/
		}
		public boolean potEntrar(Persona personaPublic) {
				if (this.obra.majors > personaPublic.edat) {
						System.out.println("Ets menor de edat, no pots pagar la entrada.");
						return (false);
				} else if (personaPublic.diners < this.preu) {
						System.out.println("No tens els diners suficients per pagar l'entrada.");
						return (false);
				} else {
						return (true);
				}
		}
		public Teatre(int files, int columnes, double preu, Obra obra) {
				sessio = new Seient[files][columnes];
				this.preu = preu;
				this.obra = obra;
				// ompliSeients(files, columnes);
		}
		// public void ompliSeients(int fila, int columna) {
		// for (int i = 0; i < sessio.length; i++) {
		// for (int j = 0; j < sessio[i].length; j++) {
		// sessio[i][j] = new Seient(fila, columna);
		// }
		// }
		// }
		// public void omplirSeient(Seient hol) {
		// sessio[hol.fila][hol.columna] = hol;
		// }
		public void seure(Seient seientActual) {
				this.sessio[seientActual.columna][seientActual.fila] = seientActual;
		}
		public Seient getSeient(int fila, int col) {
				return (sessio[fila][col]);
		}
}
