import java.util.Scanner;
// DEV NOTES
// case1 what happens when i add a element to a already in use slot and element moving from there.
//colors
//Menu
// 1-and add number to next empty place , notify user, have used spaces var global
// 2-Input again data
// 3-finish menu

public class sandbox {
		public static Scanner sc = new Scanner(System.in);
		public static int num_elements = 0;
		public static String[] cognoms = {"Alguero","Ferre","Bayo","Falco","Ferandez","Didouh","Garcia","El Khattabi","Aloy","Brull"};//Elements:10
		public static boolean running = true;
		public static final String ResetColor = "\u001B[0m";
		public static final String Roig = "\u001B[31m";
		public static final String Groc = "\u001B[33m";
		public static final String Cyan = "\u001B[36m";
		public static String askElement(){
				System.out.println("Introdueix un element: (Sense Comilles)");
				return sc.nextLine();
		}
		public static int askPosicio(){
				System.out.println("Introdueix una posició: ");
				int pos = sc.nextInt();
				sc.nextLine();
				if (pos > num_elements+1) {
						System.out.println("Posició Incorrecta/Posicións anteriors buides");
						askPosicio();
				}else{
						return pos;
				}
				return num_elements+1;
		}
		public static void printList(String[] list){
				String printline = "";
				for(int e = 0; e<list.length-1; e++) {
						printline += list[e]+",";
				}
				System.out.println("\n"+printline+list[list.length-1]);
		}
		public static String askList(){
				System.out.println("Introdueix una llista: ");
				return sc.nextLine();
		}
		public static String[] checkList(String liststr){
				if (liststr.contains("cognoms")) {
						return cognoms;
				}else{

						return null;
				}
		}
		public static void Menu(){
				System.out.println("\n\nAccions :"+
				                   "\n \"1\":Insert (element,pos,list)"+
				                   "\n \"2\":Localitzar (element,list)"+
				                   "\n \"3\":Reocuperar (pos,list)"+
				                   "\n \"4\":Suprimir (pos,list)"+
				                   "\n \"5\":SuprimirDada (element,list)"+
				                   "\n \"6\":Anul·lar (list)"+
				                   "\n \"7\":PrimerDarrer (list,primer/darrer)"+
				                   "\n \"8\":Imprimir (list)"+
				                   "\n \"9\":LocalitzarEnOrdenada (element,list)"+
				                   "\n \"10\":SuprimirDadaEnOrdenada (element,list)"
				                   );
		}
		public static void main(String[] args){
				String element; int pos; String Strlist; String[] list;
				while (sandbox.running) {
						Menu();
						for (String e : cognoms) {
								if(e!=null) {
										num_elements++;
								}
						}
						int function = sc.nextInt();
						sc.nextLine();
						switch(function) {
						// case 1:
						//      element = askElement();
						//      pos = askPosicio();
						//      Strlist = askList();
						//      list = checkList(Strlist);
						//      if ( list == null ) {System.out.println("No existeix la llista"); break;}
						//      list[pos] = element;
						//      printList(list);
						//      break;
						case 2:
								element = askElement();
								Strlist = askList();
								list = checkList(Strlist);
								if ( list == null ) {System.out.println("No existeix la llista"); break;}
								for(int i = 0; i<list.length; i++) {
										if ( list[i].equals(element)) {System.out.println("L'element "+element+" es troba a la posició "+i);}
								}
								break;
						case 3:
								pos = askPosicio();
								Strlist = askList();
								list = checkList(Strlist);
								if ( list == null ) {System.out.println("No existeix la llista"); break;}
								System.out.println("L'element a la posició " +pos+" es troba l'element: "+list[pos]);
								break;
						case 8:
								Strlist = askList();
								list = checkList(Strlist);
								printList(list);
								break;
						default:
								System.out.println("Function not working yet.");
								break;
						}
				}
		}
}
