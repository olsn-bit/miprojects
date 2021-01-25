/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sprint3Java.Old;
import java.util.Scanner;

public class Mail {

    public static void apartatMail() {
        BibliotecaIO.hola();
        //Creem i inicialitzem les variables necessàries per a dur a terme el programa.
        BibliotecaIO.imprimirText(" al servei de Mail.");
        String[] opcions = {" Redacta correu", " Elimina correu", " Safata d'entrada", " Torna"};
        String remitent;
        String destinatari;
        String motiu;
        String contingut;
        int numero2 = 0;

        int contador = 0;
        Correu correuNou[] = new Correu[10];
        //Demanem un nombre per a decidir quina acció realitzarà l'usuari.
        Scanner opcio1 = new Scanner(System.in);
        Correu mail = new Correu();
        Enviat mail1 = new Enviat();
        Rebut mail2 = new Rebut();

        int opcio;
        //Imprimim les opcions del menú.
        do {
            for (int i = 0; i < opcions.length; i++) {
                System.out.print(i + 1 + " .- ");
                BibliotecaIO.imprimirText(opcions[i]);
            }
            opcio = opcio1.nextInt();
            switch (opcio) {
                //Redactem un nou correu.
                case 1:
                    Scanner tit = new Scanner(System.in);
                    //Creem un objecte mail de tipus Correu.
                    
                    //Agafem el valor de l'escàner i li assignem a la variable remitent.
                    BibliotecaIO.imprimirText("Escriu el remitent del correu:");
                    remitent = tit.nextLine();
                    //Guardem el valor de la variable remitent i l'assignem a l'atribut "de" de la classe Correu.
                    mail1.setDe(remitent);

                    BibliotecaIO.imprimirText("Escriu el destinatari del correu:");
                    destinatari = tit.nextLine();
                    mail2.setPara(destinatari);

                    BibliotecaIO.imprimirText("Escriu l'assumpte del correu:");
                    motiu = tit.nextLine();
                    mail.setAssumpte(motiu);

                    BibliotecaIO.imprimirText("Escriu el contingut del correu:");
                    contingut = tit.nextLine();
                    mail.setCos(contingut);
                    //Guarda el correu creat a l'array mail i el comptador augmenta.
                    correuNou[contador] = mail;

                    contador++;

                    break;
                //Esborrem un correu.	        
                case 2:
                    Scanner titl = new Scanner(System.in);
                    //Imprimim el text i mostrem els correus actuals.
                    BibliotecaIO.imprimirText("Escriu la id que té el correu que vols esborrar:" + "\n");
                    for (int i = 0; i < contador; i++) {
                        BibliotecaIO.imprimirText("ID:" + correuNou[i].getNumero() + " De:" + ( mail1.getDe()) + " " + "Para:" + (mail2.getPara()) + " " + "Assumpte:" + correuNou[i].getAssumpte() + " " + "Cos:" + correuNou[i].getCos() + "\n");
                    }
                    numero2 = titl.nextInt();
                    //Agafem la variable numero2 inicialitzada en la capçalera, i li donem el valor "numero" corresponent per a mantindre les ID.
                    for (int i = 0; i < contador; i++) {
                        if (numero2 == correuNou[i].getNumero()) {
                            for (int j = i; j < contador - 1; j++) {
                                correuNou[j] = correuNou[j + 1];
                            }
                            correuNou[contador - 1] = null;
                            contador--;

                            BibliotecaIO.imprimirText("L'article s'ha eliminat correctament.");
                            break;
                        } else if (i == contador - 1) {
                            BibliotecaIO.imprimirText("No s'ha trobat l'article que vols eliminar.");
                        }
                    }
                    break;
                //Consultem la safata d'entrada.
                case 3:
                    //Imprimim els correus actuals en la safata d'entrada.
                    for (int i = 0; i < contador; i++) {

                        BibliotecaIO.imprimirText("ID:" + correuNou[i].getNumero() + " De:" + ( mail1.getDe()) + " " + "Para:" + ( mail2.getPara()) + " " + "Assumpte:" + correuNou[i].getAssumpte() + " " + "Cos:" + correuNou[i].getCos() + "\n");
                    }

                    break;

            }
            //Si seleccionem l'opció 4 del menú, sortirem del programa.
        } while (opcio != 4);
        BibliotecaIO.adeu();
        BibliotecaIO.imprimirText(" heu sortit del servei Mail");

    }

}
