/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sprint3Java.Old;

/**
 * @author
 * @date 27/10/2020
 * @funcionalitats: Triar una de les opcions del menu per accedir als diferents
 * ...
 * @Descripció ..
 *
 */
public class App {

    public static void main(String[] args){
        boolean loop = true;
        String[] opcions = {" Wiki", " Blog", " Mail", " Xat-no funciona", " Sortir"};
        //Fem el bucle do while i el for per a realitzar el menu(switch)
        do {
            BibliotecaIO.imprimirLlistaNumerada(opcions);
            switch (BibliotecaIO.entrarEnter("Hola, On vols accedir? \n")) {
                case 1:// Per accedir a la Wiki
                    Wiki.apartatWiki();
                    break;
                case 2:// Per accedir al Blog
                    Blog.apartatBlog();
                    break;
                case 3:// Per accedir al Mail
                    Mail.apartatMail();
                    break;
                case 4:// Per accedir al Xat
                    //Server.main(args);
                    break;
                case 5:
                    loop = false;
                    break;


            }
        } while (loop);// Per sortir del programa
    }

}
