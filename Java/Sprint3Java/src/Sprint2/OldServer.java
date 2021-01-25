/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sprint3Java.Old;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class OldServer {

    /**
     * @author Joel Pascual
     * @date 27/10/2020
     * @funcionalitats: - Llegir i enviar inputs/outputs d'un client a un altre
     * - Redirigir missatges - Obrir sockets - Actuar de server per als clients.
     * @Descripció Aquest programa actua de servidor per a dos clients, un cop
     * engegat, esperarà que es connectin, llavors es quan poden executar els
     * altres dos programes clients. Per a llegir un input un client te que
     * enviar un altre input.
     */
    //banner
    public static void banner() {
        System.out.println("                  __            .__                 .__             __                   \n"
                + "___  ________   _/  |_    ______|__|  _____   __ __ |  |  _____   _/  |_   ____  _______ \n"
                + "\\  \\/  /\\__  \\  \\   __\\  /  ___/|  | /     \\ |  |  \\|  |  \\__  \\  \\   __\\ /  _ \\ \\_  __ \\\n"
                + " >    <  / __ \\_ |  |    \\___ \\ |  ||  Y Y  \\|  |  /|  |__ / __ \\_ |  |  (  <_> ) |  | \\/\n"
                + "/__/\\_ \\(____  / |__|   /____  >|__||__|_|  /|____/ |____/(____  / |__|   \\____/  |__|   \n"
                + "      \\/     \\/              \\/           \\/                   \\/                        ");
    }
//Metode visual per a que el vegi l'usuari

    public static void welcome() throws InterruptedException {
        System.out.println("Benvingut! Connectant amb el servidor...");
        TimeUnit.SECONDS.sleep(1);
        System.out.print("                                  \n"
                + "|                  |o             \n"
                + "|    ,---.,---.,---|.,---.,---.   \n"
                + "|    |   |,---||   |||   ||   |   \n"
                + "`---'`---'`---^`---'``   '`---|   \n"
                + "                          `---'");
        TimeUnit.SECONDS.sleep(3);
        System.out.print("o");
        TimeUnit.SECONDS.sleep(3);
        System.out.print("o");
        TimeUnit.SECONDS.sleep(3);
        System.out.println("o");
    }

    //Metode visual per a anunciar que s'espera resposta dels clients
    public static void obreclients(String[] args) throws IOException, InterruptedException {
        System.out.print("Esperant resposta dels clients");
        TimeUnit.SECONDS.sleep(2);
        System.out.print(".");
        TimeUnit.SECONDS.sleep(2);
        System.out.print(".");
        TimeUnit.SECONDS.sleep(2);
        System.out.println(".");
        //  client.main(args);
        //client2.main(args);
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        banner();
        welcome();
        int ports[] = new int[]{4999, 5000, 5001, 5002};//array de ports
        //connectem els sockets del client2 i client1 respectivament
        ServerSocket s3 = new ServerSocket(5000);
        ServerSocket s2 = new ServerSocket(4999);
        //Comuniquem que s'han connectat els sockets
        System.out.println("Connectat amb exit!\nSockets connectats a ports: " + ports[0] + "," + ports[1]);
        TimeUnit.SECONDS.sleep(1);
        //obreclients(args);
        //Esperem la petició dels clients
        Socket s4 = s3.accept();
        Socket s1 = s2.accept();
        //Un cop s'han connectat procedeix el programa, anunciem que s'han connectat
        System.out.println("client1 and client2 connected!");
        //Lectors de inputs
        InputStreamReader in = new InputStreamReader(s1.getInputStream());
        InputStreamReader in2 = new InputStreamReader(s4.getInputStream());
        //------------------------------------------------------------------
        //Carregar el missatge per a enviarlo als clients
        BufferedReader buffer = new BufferedReader(in);
        BufferedReader buffer2 = new BufferedReader(in2);
        //------------------------------------------------------
        //Enviar output dels missatges carregats
        PrintWriter pw = new PrintWriter(s1.getOutputStream());
        PrintWriter pw2 = new PrintWriter(s4.getOutputStream());
        //-------------------------------------------------------
        while (true) {
            //expectant de inputs dels lcients
            String str = buffer.readLine();
            String str2 = buffer2.readLine();
            /* if (str.isEmpty()){
                System.out.println("client:\n Està buit aixo!");
            }*/

            //un cop rebuts els inputs d'un s'envia l'output a l'altre
            pw2.println(str);
            pw.println(str2);

            pw.flush();
            pw2.flush();
            // String serverSays=input.nextLine();
            //pw.println(serverSays);

        }
    }
}
