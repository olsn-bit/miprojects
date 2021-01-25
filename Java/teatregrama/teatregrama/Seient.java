// package teatregrama;
public class Seient {
		int columna;
		int fila;
		Persona persona;
		public int getColumna() {
				return (columna);
		}
		public void setColumna(int columnaS) {
				this.columna = columnaS;
		}
		public int getFila() {
				return (fila);
		}
		public void setFila(int filaS) {
				this.fila = filaS;
		}
		public Persona getPersona() {
				return (persona);
		}
		public void setPersona(Persona persona) {
				this.persona = persona;
		}
		public String toString() {
				return ("Seient: Columna:" + this.columna + " Fila:" + this.fila + " Client:" + this.persona.nom);
		}
		public Seient(int columnaSeient, int filaSeient, Persona personaSeient) {
				this.columna = columnaSeient;
				this.fila = filaSeient;
				this.persona = personaSeient;
		}
		public Seient(int columnaSeient, int filaSeient) {
				columna = columnaSeient;
				fila = filaSeient;
		}
}
