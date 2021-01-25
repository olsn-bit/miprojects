public class Gos {
		int edat;
		int distPassejada;
		public Gos(int edatGos){
				edat = edatGos;
				distPassejada = 0;
		}
		public static void main(String[] args) {
				Gos sam = new Gos(10);
				sam.lladrar();
				sam.passeig(30);
				int edatSam = sam.getEdat();
				System.out.println(edatSam);

		}
		public void lladrar(){
				System.out.println("GUAU");
		}
		public void passeig(int metres){
				distPassejada += metres;
				System.out.println("El teu gos ha caminat "+metres+"m avui, en total "+distPassejada+"m.");
		}
		public int getEdat(){
				return edat;
		}
}
