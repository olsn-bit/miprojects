/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sprint3Java.Old;

import java.util.Scanner;

public class Blog {

    public static void apartatBlog() {

        BibliotecaIO.hola();
        BibliotecaIO.imprimirText(" al Blog");
        //Mostrem les opcions que te el blog (crear/modificar/eliminar/consultar posts i tornar al menu principal)

        String[] opcions = {" Crear Post", " Modificar Post", " Eliminar Post", " Consultar Posts", " Tornar"};
        String postText;
        String titool;
        int contador = 0;
        Blogs postNou[] = new Blogs[10];

        Scanner opcio1 = new Scanner(System.in);
        //Fem un bucle per a enumerar totes les opcions que es poden fer al Blog
        int opcio;
        do {
            for (int i = 0; i < opcions.length; i++) {
                System.out.print(i + 1 + " .- ");
                BibliotecaIO.imprimirText(opcions[i]);
            }
            opcio = opcio1.nextInt();
            switch (opcio) {

                case 1://crear post
                    Scanner tit = new Scanner(System.in);
                    //Demanem a l'usuari que afegeixigue el titol del post
                    Blogs post = new Blogs();
                    BibliotecaIO.imprimirText("Escriu el titol que voleu ficar al post:");
                    //Aqui afegeix el titol i el guarde en la variable "titool"
                    titool = tit.nextLine();
                    post.setTitol(titool);
                    //Demanem a l'usuari que afegeixigue el contingut del post

                    BibliotecaIO.imprimirText("Introdueix el contingut del post");
                    //Afegeix el contingut i es guarda en la variable "postText"
                    postText = tit.nextLine();
                    post.setContingut(postText);
                    //Aqui es guardaran els posts que es bagin creant

                    postNou[contador] = post;

                    contador++;

                    break;

                case 2:// editar
                    Scanner titu = new Scanner(System.in);
                    //Demanem a l'usuari el nom del post a editar

                    BibliotecaIO.imprimirText("Escriu el nom del post que voleu editar:");
                    for (int i = 0; i < contador; i++) {
                        //Fem un bucle per a mostrar tot el contingut de l'array aixi mostrem tots els posts creats
                        BibliotecaIO.imprimirText(postNou[i].getTitol());
                    }
                    //Aqui l'usuari afegira el nou titol
                    titool = titu.nextLine();
                    //Fem un bucle per a buscar el post
                    for (int i = 0; i < contador; i++) {
                        if (titool.equals(postNou[i].getTitol())) {
                            //Si el post es troba li demanem que canvie el contingut
                            BibliotecaIO.imprimirText("Afegeix el nou contingut del post");
                            postText = titu.nextLine();
                            postNou[i].setContingut(postText);

                            BibliotecaIO.imprimirText("S'han guardat els canvis.");
                            break;
                        } else if (i == contador - 1) {
                            //Si no es troba el post es mostra que no s'ha trobat
                            BibliotecaIO.imprimirText("No s'ha trobat el post que estas buscant");
                        }
                    }
                    break;
                case 3:// eliminar
                    Scanner titl = new Scanner(System.in);
                    //Demanem a l'usuari el post que vol eliminar

                    BibliotecaIO.imprimirText("Escriu el nom del post que voleu eliminar:");
                    //Faig un bucle per a mostrar tot el contingut del array "mostro tots els posts que estan creats"
                    for (int i = 0; i < contador; i++) {
                        BibliotecaIO.imprimirText(postNou[i].getTitol());
                    }
                    //Demano que afegeixigue el nom del post que vol borrar
                    titool = titl.nextLine();
                    //Faig un bucle per a quan l'usuari afegeix el post a borrar, aquest se borra i es desplaça el contingut de l'array un lloc
                    //Es a dir si tenim hola - adeu - buenas i esborrem el adeu, quedara de la següent manera hola - buenas, quedara tot seguit
                    for (int i = 0; i < contador; i++) {
                        if (titool.equals(postNou[i].getTitol())) {
                            for (int j = i; j < contador - 1; j++) {
                                postNou[j] = postNou[j + 1];
                            }
                            postNou[contador - 1] = null;
                            contador--;
                            //Una vegada s'esborra ens mostrara aquest missatge

                            BibliotecaIO.imprimirText("El post s'ha eliminat correctament.");
                            break;
                            //Pero si aquest afegim un post que no està en la llista ens dira el següent missatge
                        } else if (i == contador - 1) {
                            BibliotecaIO.imprimirText("No s'ha trobat el post que vols eliminar.");
                        }
                    }
                    break;
                case 4://consultar
                    for (int i = 0; i < contador; i++) {
                        //Mostrem tot el contingut de dins de l'Array

                        BibliotecaIO.imprimirText(postNou[i].getTitol() + " \n" + postNou[i].getContingut());
                    }
                    break;
            }
        } while (opcio != 5);
        //Metode de sortida, ens mostra un miassatge de sortida
        BibliotecaIO.adeu();
        BibliotecaIO.imprimirText("acaveu de sortir del Blog");
    }
}
