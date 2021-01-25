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
import java.net.Socket;
import java.util.Scanner;

public class Client2 {

    public static void main(String[] args) throws IOException {
        //connectem en un socket diferent que el client 1, el server s'encarregara de redirigir el missatge
        Socket s4 = new Socket("localhost", 5000);
        PrintWriter pw = new PrintWriter(s4.getOutputStream());
        Scanner input = new Scanner(System.in);
        InputStreamReader in = new InputStreamReader(s4.getInputStream());
        BufferedReader buffer = new BufferedReader(in);

        while (true) {
            //agafem el que diu el client i ho enviem amb el printwritter
            String clientSays = input.nextLine();
            pw.println("client2: " + clientSays);
            pw.flush();//fem flush per a que no s'acumulin els inputs

//llegim els missatges entrants i els mostrem per pantalla
            String str = buffer.readLine();
            System.out.println(str);
        }
    }
}
