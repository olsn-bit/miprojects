import java.util.Scanner;
public class DosSantosAlbertoCas3 {
		public static void main(String[] args){
				int input;//Aqui he creat una variable per a guardar el valor dels numeros que introdueix l'usuari
				int num_elements = 0;//Esta variable maté la conta dels elements ocupats de la array
				int[] data = new int[20];//Creació de la array
				Scanner sc = new Scanner(System.in);//Inicialització del Scanner
				do {
						input = sc.nextInt();
						if (input>0&&input<6) {//Comprovem si l'element es correcte i l'afegim dins de la array data i anem incrementant la variable num_elements
								data[num_elements] = input;
								num_elements++;
						}

				} while(input>0&&input<6 && num_elements!=19);//En aquest do while introduim els elements introduits a la array i anem sumant num_elements
				int comparador = sc.nextInt();//Demanem a l'usuari un numero per a comparar
				int comparador_count = 0;//Aquesta variable contarà cuants elements són majors a la variable comparador
				int totalvalue = 0;//		Aquest enter l'utilitzarem per a afegir tots els valors del elements i fer la mitja d'aquest.
				for(int e : data) {
						if(e>comparador) {
								comparador_count++;
						}
						totalvalue += e;
				}//En aquest for fem dos coses: anem comparant amb el comparador i anem sumant si l'element es més gran que el comparador, i anem sumant els valors a la variable comparador_count per fer la mitja
				double mitjana = (double)totalvalue/num_elements;//He creat la mitja amb una variable tipus double
				System.out.println(mitjana+" "+comparador_count);//Per imprimir el resultat he utilitzat String.format per a visualitzar la mitja com a decimal amb dos xifres.
		}
}
