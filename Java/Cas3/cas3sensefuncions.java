import java.util.Scanner;
public class cas3sensefuncions {
		public static void main(String[] args){
				Scanner sc = new Scanner(System.in);
				int num_elements = 0;
				String[] cognoms = {"Aloy","Ferre","Bayo","Falco","Fernandez","Didouh","Garcia","El Khattabi","Alguero","Brull"};                //Elements:10
				boolean running = true;
				final String ResetColor = "\u001B[0m";
				final String Roig = "\u001B[31m";
				final String Groc = "\u001B[33m";
				final String Cyan = "\u001B[36m";
				final String Verd = "\u001B[32m";
				String element; int pos; String Strlist; String[] list; String siono; String printline; String[] list_aux; Boolean bool_aux; String primerDarrer;
				while (running) {
						System.out.println(Cyan+"\nAccions :"+
						                   "\n \"1\": Inserir (element,pos,list)"+
						                   "\n \"2\": Localitzar (element,list)"+
						                   "\n \"3\": Recuperar (pos,list)"+
						                   "\n \"4\": Suprimir (pos,list)"+
						                   "\n \"5\": SuprimirDada (element,list)"+
						                   "\n \"6\": Anul·lar (list)"+
						                   "\n \"7\": PrimerDarrer (list,primer/darrer)"+
						                   "\n \"8\": Imprimir (list)"+
						                   "\n \"9\": Ordenar (list)"+
						                   "\n \"10\": LocalitzarEnOrdenada (element,list)"+
						                   "\n \"11\": SuprimirDadaEnOrdenada (element,list)"+
						                   "\n \"12\": Sortir del Programa"+ResetColor
						                   );
						num_elements = 0;                                        //per a que comenci a comptar des del principi i per a que no es sumin elements de més cada vegada que es completi el bucle for.
						for (String e : cognoms) {
								if(e!=null) {
										num_elements++;
								}
						}
						int function = sc.nextInt();
						sc.nextLine();
						switch(function) {
						case 1:
								System.out.println(Groc+"Introdueix una llista: "+ResetColor);
								while(true) {
										Strlist = sc.nextLine();
										if (Strlist.contains("cognoms")) {
												list = cognoms;
												break;
										}else{
												System.out.println(Roig+"Aquesta llista no existeix, torna a introduir una altra."+Groc+" (cognoms) "+ResetColor);
										}
								}
								do {
										System.out.println(Groc+"Introdueix un element: (Sense Comilles)"+ResetColor);
										element = sc.nextLine();
								} while(element.length()<1);
								System.out.println(Groc+"Introdueix una posició: "+ResetColor);
								while (true) {
										pos = sc.nextInt();
										sc.nextLine();
										if (pos >= 0 && pos < list.length && pos <= num_elements) {
												break;
										}else{
												System.out.println(Roig+"Posició Incorrecta/Posicions anteriors buides"+ResetColor);

										}
								}
								if(num_elements==list.length) {
										do {
												System.out.println(Roig+"La llista esta plena, vols que borrem l'ultim element \" "+list[list.length-1]+" \" o no efectuar la acció ( si / no ) ?"+ResetColor);
												siono = sc.nextLine();
										} while(!(siono.equals("si") || siono.equals("no")));                                                                                        //https://softwareengineering.stackexchange.com/questions/306881/how-to-properly-reverse-the-if-statement-when-you-have-two-conditions-in-it

										if (siono.equals("no")) {
												break;
										}else{
												for (int e = num_elements-1; e>pos; e--) {
														list[e] = list[e-1];
												}
												list[pos] = element;
										}
								}else{
										for (int e = num_elements; e>pos; e--) {
												list[e] = list[e-1];
										}
										list[pos] = element;
								}
								printline = "";
								for(int e = 0; e<list.length-1; e++) {
										printline += list[e]+",";
								}
								System.out.println(Verd+"\n"+printline+list[list.length-1]+ResetColor);
								break;
						//LOCALITZAR
						case 2:
								do {
										System.out.println(Groc+"Introdueix un element: (Sense Comilles)"+ResetColor);
										element = sc.nextLine();
								} while(element.length()<1);
								System.out.println(Groc+"Introdueix una llista: "+ResetColor);
								while(true) {
										Strlist = sc.nextLine();
										if (Strlist.contains("cognoms")) {
												list = cognoms;
												break;
										}else{
												System.out.println(Roig+"Aquesta llista no existeix, torna a introduir una altra."+Groc+" (cognoms) "+ResetColor);
										}
								}
								for(int i = 0; i<num_elements; i++) {

										if (i == num_elements) {
												System.out.println(Roig+"L'element "+element+" no es troba a la llista "+Strlist+""+ResetColor);
												break;
										}
										if ( list[i] != null && list[i].equals(element)) {System.out.println(Verd+"L'element "+element+" es troba a la posició "+i+""+ResetColor); break;}
								}
								break;
						//RECUPERAR
						case 3:
								System.out.println(Groc+"Introdueix una llista: "+ResetColor);
								while(true) {
										Strlist = sc.nextLine();
										if (Strlist.contains("cognoms")) {
												list = cognoms;
												break;
										}else{
												System.out.println(Roig+"Aquesta llista no existeix, torna a introduir una altra."+Groc+" (cognoms) "+ResetColor);
										}
								}
								System.out.println(Groc+"Introdueix una posició: "+ResetColor);
								while (true) {
										pos = sc.nextInt();
										sc.nextLine();
										if (pos >= 0 && pos < list.length && pos <= num_elements) {
												break;
										}else{
												System.out.println(Roig+"Posició Incorrecta/Posicions anteriors buides"+ResetColor);
										}
								}
								if (list[pos] == null) {
										System.out.println("\u001B[32m"+"La posició " +pos+" es buida"+ResetColor);
								}else{
										System.out.println("\u001B[32m"+"A la posició " +pos+" es troba l'element: "+list[pos]+""+ResetColor);

								}
								break;
						/*Suprimir*/
						case 4:
								System.out.println(Groc+"Introdueix una llista: "+ResetColor);
								while(true) {
										Strlist = sc.nextLine();
										if (Strlist.contains("cognoms")) {
												list = cognoms;
												break;
										}else{
												System.out.println(Roig+"Aquesta llista no existeix, torna a introduir una altra."+Groc+" (cognoms) "+ResetColor);
										}
								}
								System.out.println(Groc+"Introdueix una posició: "+ResetColor);
								while (true) {
										pos = sc.nextInt();
										sc.nextLine();
										if (pos >= 0 && pos < list.length && pos <= num_elements) {
												break;
										}else{
												System.out.println(Roig+"Posició Incorrecta/Posicions anteriors buides"+ResetColor);

										}
								}
								if (list[pos]!=null) {
										System.out.println(Verd+"S'ha eliminat l'element "+list[pos]+""+ResetColor);
										//Sobreescriu les cel·les cap a l'esquerra i elimina la primera
										for (int e = pos; e<list.length-1; e++) {
												list[e] = list[e+1];
										}
										//llista = {1,2,3,null}

										list[num_elements-1] = null;
								}
								else{System.out.println(Roig+"Aquest element no es pot borrar perque no existeix. "+ResetColor);}

								break;
						case 5:
								do {
										System.out.println(Groc+"Introdueix un element: (Sense Comilles)"+ResetColor);
										element = sc.nextLine();
								} while(element.length()<1 || element.equals("null"));
								System.out.println(Groc+"Introdueix una llista: "+ResetColor);
								while(true) {
										Strlist = sc.nextLine();
										if (Strlist.contains("cognoms")) {
												list = cognoms;
												break;
										}else{
												System.out.println(Roig+"Aquesta llista no existeix, torna a introduir una altra."+Groc+" (cognoms) "+ResetColor);
										}
								}
								//utilitzo bool aux per a el bug de borrar i print arra per detectar les correlacions
								printline = "a";
								for (int i = 0; i<num_elements; i++) {
										if(list[i] != null && list[i].equals(element)) {
												System.out.println(Verd+"S'ha eliminat l'element "+list[i]+" a la posició "+i+ResetColor);
												for (int e = i; e<list.length-1; e++) {
														list[e] = list[e+1];
												}
												list[num_elements-1] = null;
												i--;
												printline = "e";
										}else if(i == num_elements-2 && printline.equals("a")) {
												System.out.println(Roig+"Aquest element no es pot borrar perque no existeix. "+ResetColor);
										}
								}
								break;
						//ANULAR
						case 6:
								System.out.println(Groc+"Introdueix una llista: "+ResetColor);
								while(true) {
										Strlist = sc.nextLine();
										if (Strlist.contains("cognoms")) {
												list = cognoms;
												Strlist = "cognoms";
												break;
										}else{
												System.out.println(Roig+"Aquesta llista no existeix, torna a introduir una altra."+Groc+" (cognoms) "+ResetColor);
										}
								}
								cognoms = null;
								cognoms = new String[10];
								System.out.println(Verd+"La llista "+Strlist+ " ha estat buidada."+ResetColor);
								break;
						/*primerDarrer*/
						case 7:
								System.out.println(Groc+"Introdueix una llista: "+ResetColor);
								while(true) {
										Strlist = sc.nextLine();
										if (Strlist.contains("cognoms")) {
												list = cognoms;
												break;
										}else{
												System.out.println(Roig+"Aquesta llista no existeix, torna a introduir una altra."+Groc+" (cognoms) "+ResetColor);
										}
								}
								do {
										System.out.println(Verd+"Opcions: \"primer\" o \"darrer\""+ResetColor);
										primerDarrer = sc.next();
								} while(!(primerDarrer.equals("primer")||primerDarrer.equals("darrer")));
								if (primerDarrer.equals("primer")) {
										System.out.println(Verd + list[0] + ResetColor);
								} else if (primerDarrer.equals("darrer")) {
										System.out.println(Verd+list[num_elements-1]+ResetColor);
								}
								break;
						//IMPIMIR LLISTA
						case 8:
								System.out.println(Groc+"Introdueix una llista: "+ResetColor);
								while(true) {
										Strlist = sc.nextLine();
										if (Strlist.contains("cognoms")) {
												list = cognoms;
												break;
										}else{
												System.out.println(Roig+"Aquesta llista no existeix, torna a introduir una altra."+Groc+" (cognoms) "+ResetColor);
										}
								}
								if(num_elements > 0) {
										printline = "";
										for(int e = 0; e<num_elements-1; e++) {

												printline += list[e]+",";

										}

										printline += list[num_elements-1];
										System.out.println(Verd+"\n"+printline+ResetColor);
								}else{
										System.out.println(Roig+"Llista buida !"+ResetColor);
								}
								break;
						case 9:
								System.out.println(Groc+"Introdueix una llista: "+ResetColor);
								while(true) {
										Strlist = sc.nextLine();
										if (Strlist.contains("cognoms")) {
												list = cognoms;
												break;
										}else{
												System.out.println(Roig+"Aquesta llista no existeix, torna a introduir una altra."+Groc+" (cognoms) "+ResetColor);
										}
								}
								if ( num_elements > 1) {
										for(int i = 0; i<num_elements; i++) {
												for(int e = i+1; e<num_elements; e++) {
														if(list[i].compareTo(list[e])<0) {
																//utilitzem printline com a variable temporal, ja que quan es torni a utilitzar es sobreescriura i no s'utilitzara.
																printline = list[i];
																list[i] = list[e];
																list[e] = printline;
														}
												}
										}
								}else{
										System.out.println(Roig+"Llista massa curta per ordenar "+ResetColor);
										break;
								}
								printline = "";
								for(int e = 0; e<list.length; e++) {
										if (list[e]!=null) {
												printline += list[e]+",";
										}
								}
								System.out.println(Verd+"\n"+printline.substring(0,printline.length()-1)+ResetColor);
								break;
						case 10:
								do {
										System.out.println(Groc+"Introdueix un element: (Sense Comilles)"+ResetColor);
										element = sc.nextLine();
								} while(element.length()<1);
								System.out.println(Groc+"Introdueix una llista: "+ResetColor);
								while(true) {
										Strlist = sc.nextLine();
										if (Strlist.contains("cognoms")) {
												list = cognoms;
												break;
										}else{
												System.out.println(Roig+"Aquesta llista no existeix, torna a introduir una altra."+Groc+" (cognoms) "+ResetColor);
										}
								}
								do {
										System.out.println(Roig+"Vols ordernar la llista "+Strlist+" permanentment ? ( si / no )"+ResetColor);
										siono = sc.nextLine();
								} while(!(siono.equals("si") || siono.equals("no")));                                                                 //https://softwareengineering.stackexchange.com/questions/306881/how-to-properly-reverse-the-if-statement-when-you-have-two-conditions-in-it
								if ( siono.equals("si")) {
										if ( num_elements > 1) {
												for(int i = 0; i<num_elements; i++) {                                                                                                                //aquest for va augmentant de valor de 0 a numelement

														for(int e = 0; e<num_elements; e++) {
																if(list[i].compareTo(list[e])<0) {
																		//utilitzo printline com a variable temporal, ja que quan es torni a utilitzar es sobreescriura i no s'utilitzara.
																		printline = list[i];
																		list[i] = list[e];
																		list[e] = printline;
																}
														}
												}


										}else{
												System.out.println(Roig+"Llista massa curta per ordenar "+ResetColor);
												break;
										}
										for(int i = 0; i<num_elements+1; i++) {

												if (i == num_elements) {
														System.out.println(Roig+"L'element "+element+" no es troba a la llista "+Strlist+""+ResetColor);
														break;
												}
												if ( list[i] != null && list[i].equals(element)) {System.out.println(Verd+"L'element "+element+" es troba a la posició "+i+" en la llista ordenada"+ResetColor); break;}
										}
								}else{
										list_aux = new String[list.length];
										for (int e = 0; e<list.length; e++) {
												list_aux[e] = list[e];
										}
										if ( num_elements > 1) {
												for(int i = 0; i<num_elements; i++) {
														for(int e = 0; e<num_elements; e++) {
																if(list_aux[i].compareTo(list_aux[e])<0) {
																		//utilitzo printline com a variable temporal, ja que quan es torni a utilitzar es sobreescriura i no s'utilitzara.
																		printline = list_aux[i];
																		list_aux[i] = list_aux[e];
																		list_aux[e] = printline;
																}
														}
												}


										}else{
												System.out.println(Roig+"Llista massa curta per ordenar "+ResetColor);
												break;
										}
										for(int i = 0; i<num_elements+1; i++) {

												if (i == num_elements) {
														System.out.println(Roig+"L'element "+element+" no es troba a la llista "+Strlist+""+ResetColor);
														break;
												}
												if ( list_aux[i].equals(element)) {System.out.println(Verd+"L'element "+element+" es troba a la posició "+i+" en la llista ordenada"+ResetColor); break;}
										}
								}
								break;
						case 11:
								do {
										System.out.println(Groc+"Introdueix un element: (Sense Comilles)"+ResetColor);
										element = sc.nextLine();
								} while(element.length()<1);
								System.out.println(Groc+"Introdueix una llista: "+ResetColor);
								while(true) {
										Strlist = sc.nextLine();
										if (Strlist.contains("cognoms")) {
												list = cognoms;
												break;
										}else{
												System.out.println(Roig+"Aquesta llista no existeix, torna a introduir una altra."+Groc+" (cognoms) "+ResetColor);
										}
								}
								do {
										System.out.println(Roig+"Vols ordernar la llista "+Strlist+" permanentment ? ( si / no )"+ResetColor);
										siono = sc.nextLine();
								} while(!(siono.equals("si") || siono.equals("no")));                                                                 //https://softwareengineering.stackexchange.com/questions/306881/how-to-properly-reverse-the-if-statement-when-you-have-two-conditions-in-it
								if ( siono.equals("si")) {
										if ( num_elements > 1) {
												for(int i = 0; i<num_elements; i++) {
														for(int e = 0; e<num_elements; e++) {
																if(list[i].compareTo(list[e])<0) {
																		//utilitzo printline com a variable temporal, ja que quan es torni a utilitzar es sobreescriura i no s'utilitzara.
																		printline = list[i];
																		list[i] = list[e];
																		list[e] = printline;
																}
														}
												}


										}else{
												System.out.println(Roig+"Llista massa curta per ordenar "+ResetColor);
												break;
										}
										for (int i = 0; i<list.length; i++) {
												if(list[i] != null && list[i].equals(element)) {
														System.out.println(Verd+"S'ha eliminat l'element "+list[i]+" a la posició "+i+ResetColor);
														for (int e = i; e<list.length-1; e++) {
																list[e] = list[e+1];
														}
														list[num_elements-1] = null;
														i--;
												}else if(i == list.length-1) {
														System.out.println(Roig+"S'han eliminat totes les coincidencies. "+ResetColor);
												}
										}
								}else{
										list_aux = list.clone();
										if ( num_elements > 1) {
												for(int i = 0; i<num_elements; i++) {
														for(int e = 0; e<num_elements; e++) {
																if(list_aux[i].compareTo(list_aux[e])<0) {
																		//utilitzo printline com a variable temporal, ja que quan es torni a utilitzar es sobreescriura i no s'utilitzara.
																		printline = list_aux[i];
																		list_aux[i] = list_aux[e];
																		list_aux[e] = printline;
																}
														}
												}


										}else{
												System.out.println(Roig+"Llista massa curta per ordenar "+ResetColor);
												break;
										}
										bool_aux = false;
										for (int i = 0; i<num_elements; i++) {
												if (bool_aux) {
														i--;
														bool_aux = false;
												}
												if(list_aux[i] != null && list_aux[i].equals(element)) {
														System.out.println(Verd+"S'ha eliminat l'element "+list_aux[i]+" a la posició "+i+ResetColor);
														for (int e = i; e<list_aux.length-1; e++) {
																list_aux[e] = list_aux[e+1];
														}
														list_aux[num_elements-1] = null;
														bool_aux = true;

												}
												if(list[i] != null && list[i].equals(element)) {
														for (int e = i; e<list.length-1; e++) {
																list[e] = list[e+1];
														}
														list[num_elements-1] = null;
														bool_aux = true;

												} if(i == list_aux.length-1) {
														System.out.println(Roig+"S'han eliminat totes les coincidencies. "+ResetColor);
												}
										}
								}
								break;
						default:
								System.out.println(Roig+"Funció no operativa o codi erroni."+ResetColor);
								break;
						case 12:
								System.out.println(Groc+"Fins la pròxima ;)"+ResetColor);
								running=false;
								break;
						}
				}
		}
}
