public class Seient {
	/**
	 * Aquesta classe serveix com a support per a altres classes per emmagatzemar dades dels seients
	 * @author grup4
	 */
		int fila;
		int numero;
		Client ocupant;

	/**
	 *
	 * @param fila fila que es troba aquest seient
	 * @param numero numero de sient que es troba
	 * @param ocupant Persona que ocupa aquest seient.
	 */
		public Seient(int fila, int numero, Client ocupant) {
				this.fila = fila;
				this.numero = numero;
				this.ocupant = ocupant;
		}
		public void setFila(int fila) {
				this.fila = fila;
		}
		public void setNumero(int numero) {
				this.numero = numero;
		}
		public void setOcupant(Client ocupant) {
				this.ocupant = ocupant;
		}
		public int getFila() {
				return (this.fila);
		}
		public int getNumero() {
				return (this.numero);
		}
		public Client getOcupant() {
				return (this.ocupant);
		}

	/**
	 *
	 * @return String, breu explicacio del seient actual.
	 */
		public String toString() {
				return ("Fila: " + this.fila + ", Numero: " + this.numero + ", Ocupant( " + this.ocupant + " )");
		}
		public static void main(String[] args) {}
}
