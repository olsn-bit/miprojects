/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sprint3Java.Old;

import java.util.Scanner;

/**
 * @author Isaac Brull Llao
 * @date 27/10/2020
 * @funcionalitats: Triar una de les opcions del menu per accedir a diferents
 * opcions de la Wiki.
 * @Descripció Aquesta classe ens permet triar una de les opcions del menu per
 * accedir a diferents opcions de la Wiki on cada opció te una funció diferent.
 *
 */
public class Wiki {

    public static void apartatWiki() {
        //Aqui he creat les variables que necessitarem en la classe + el missatge de salutació.
        BibliotecaIO.hola();
        BibliotecaIO.imprimirText(" a WIKIPOJECTE");
        //Creo un array per a guardar el nom de les opcions del menu.
        String[] opcions = {" Crear article", " Modificar Article", " Eliminar article", " Consultar", " Tornar"};
        String arti;
        String titool;
        //Aquest contador l'utilitzarem per anar suman o restan (depen la situació) els articles en l'array de tipus Article
        int contador = 0;
        Article articleNou[] = new Article[10];

        Scanner opcio1 = new Scanner(System.in);

        int opcio;
        //Fem el bucle do while i el for per a realitzar el menu(switch)
        do {
            for (int i = 0; i < opcions.length; i++) {
                System.out.print(i + 1 + " .- ");
                BibliotecaIO.imprimirText(opcions[i]);
            }
            opcio = opcio1.nextInt();
            switch (opcio) {

                case 1:// Per a crear un article.
                    Scanner tit = new Scanner(System.in);

                    Article article = new Article();
                    //Assignem el titol de l'article.
                    BibliotecaIO.imprimirText("Escriu el titol que voleu ficar a l'article:");
                    titool = tit.nextLine();
                    article.setTitol(titool);
                    //Introduïm el contingut de l'article.
                    BibliotecaIO.imprimirText("Introdueix el contingut de l'article");
                    arti = tit.nextLine();
                    article.setContingut(arti);
                    //Es guarda dintre de l'array d'objectes de "article" i el contador incrementa segons el numero d'articles que hi ha en l'array
                    articleNou[contador] = article;

                    contador++;

                    break;

                case 2:// Per a editar un article
                    Scanner titu = new Scanner(System.in);
                    //introdueïx el nom de l'article que vulguis editar
                    BibliotecaIO.imprimirText("Escriu el nom de l'article que voleu editar:");
                    for (int i = 0; i < contador; i++) {
                        BibliotecaIO.imprimirText(articleNou[i].getTitol());
                    }
                    titool = titu.nextLine();
                    /*En cas que es trobi el nom de l'article que has introduït, ens demanara que fiquesem el nou
                    contingut de l'article.               
                     */
                    for (int i = 0; i < contador; i++) {
                        if (titool.equals(articleNou[i].getTitol())) {
                            BibliotecaIO.imprimirText("Afegeix el nou contingut de l'article");
                            arti = titu.nextLine();
                            articleNou[i].setContingut(arti);
                            //una vegada fesem "Enter" es guardarà el nou contingut de l'article
                            BibliotecaIO.imprimirText("S'han guardat els canvis.");
                            break;
                            /*En cas que no es trobi el nom de l'article que has introduït, ens imprimirà un missatge
                            dient que no s'ha trobat l'article que volem editar i ens tornara al menu.               
                             */
                        } else if (i == contador - 1) {

                            BibliotecaIO.imprimirText("No s'ha trobat l'article que estas buscant");
                        }
                    }
                    break;
                case 3:// Per a eliminar un article
                    Scanner titl = new Scanner(System.in);

                    BibliotecaIO.imprimirText("Escriu el nom de l'article que voleu eliminar:");
                    for (int i = 0; i < contador; i++) {
                        BibliotecaIO.imprimirText(articleNou[i].getTitol());
                    }
                    titool = titl.nextLine();
                    for (int i = 0; i < contador; i++) {
                        if (titool.equals(articleNou[i].getTitol())) {
                            for (int j = i; j < contador - 1; j++) {
                                articleNou[j] = articleNou[j + 1];
                            }
                            articleNou[contador - 1] = null;
                            contador--;
                            /*En cas que es trobi el nom de l'article que has introduït, ens informarà de que
                            l'article s'ha eliminat correctament.               
                             */
                            BibliotecaIO.imprimirText("L'article s'ha eliminat correctament.");
                            break;
                            /*En cas que no es trobi el nom de l'article que has introduït, ens imprimirà un missatge
                            dient que no s'ha trobat l'article que volem eliminar i ens tornara al menu.               
                             */
                        } else if (i == contador - 1) {
                            BibliotecaIO.imprimirText("No s'ha trobat l'article que vols eliminar.");
                        }
                    }
                    break;
                case 4:// Per a consultar un article
                    for (int i = 0; i < contador; i++) {
                        //Ens imprimeix tots els articles que hem creat.
                        BibliotecaIO.imprimirText(articleNou[i].getTitol() + " \n" + articleNou[i].getContingut());
                    }

                    break;

            }
        } while (opcio != 5);// Per a tornar al menu principal
        //missatge de despedida
        BibliotecaIO.adeu();
        BibliotecaIO.imprimirText("acabeu de sortir de WIKIPROJECTE");

    }

}
