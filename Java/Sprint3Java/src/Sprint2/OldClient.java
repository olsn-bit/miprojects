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

public class OldClient {

    public static void main(String[] args) throws IOException {
        Socket s1 = new Socket("localhost", 4999);//connexió amb servidor per el port 4999
        //PrintWriter imprimeix els missatgesAgafa l'escrit per el Client i retornem l'output
        PrintWriter pw = new PrintWriter(s1.getOutputStream()); //GetOutputStream envia output al socket
        Scanner input = new Scanner(System.in);
        //Per agafar els missatges entrants per el socket
        InputStreamReader in = new InputStreamReader(s1.getInputStream());//rep els inputs que venen pel socket
        //crea un buffer per a carregar els missatges entrants
        BufferedReader buffer = new BufferedReader(in);

        while (true) {
            //agafem el que diu el Client i ho enviem amb el printwritter
            String clientSays = input.nextLine();
            pw.println("client1: " + clientSays);
            pw.flush();//fem flush per a que no s'acumulin els inputs

            //llegim els missatges entrants i els mostrem per pantalla
            String str = buffer.readLine();
            System.out.println(str);
        }
    }
}
