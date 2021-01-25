// package teatregrama;
public class Obra {
		String titol;
		String durada;
		String autor;
		int majors;
		public String getTitol() {
				return (titol);
		}
		public void setTitol(String titolC) {
				this.titol = titolC;
		}
		public String getDurada() {
				return (durada);
		}
		public void setDurada(String duradaC) {
				this.durada = duradaC;
		}
		public String getAutor() {
				return (autor);
		}
		public void setAutor(String autorC) {
				this.autor = autorC;
		}
		public int getMajors() {
				return (majors);
		}
		public void setMajors(int majorsC) {
				this.majors = majorsC;
		}
		public String toString() {
				String dades = null;

				if (majors != 12) {
						dades = "Obra: " + titol + " \nDuració: " + durada + " \nAutor: " + autor;
						return (dades);
				} else {
						dades = "Obra: " + titol + " \nDuració: " + durada + " \nAutor: " + autor + "\nEdat min: " + majors;
						return (dades);
				}
		}
		public Obra(String titolObra, String duradaObra, String autorobra) {
				titol = titolObra;
				durada = duradaObra;
				autor = autorobra;
		}
		public Obra(String titolObra, String duradaObra, String autorobra, int majoriaobra) {
				titol = titolObra;
				durada = duradaObra;
				autor = autorobra;
				majors = majoriaobra;
		}
}
