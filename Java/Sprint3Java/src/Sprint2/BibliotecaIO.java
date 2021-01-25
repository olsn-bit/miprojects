/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sprint3Java.Old;

/**
 *
 * @author alumne
 */


import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

/**
 * Grup 3 Sprint 2 2020 - Alberto Dos Santos, Cristian Diac, Isaac Brull, Carlos Masana -
 * <p>
 * Biblioteca de Entradas / Salidas de la aplicación
 */
public class BibliotecaIO {

    /**
     * Método que permite introducir una cadena de carcateres
     * y muestra por pantalla un mensaje explicativo
     *
     * @param missatgeExplicatiu El mensaje que quieres enviar por pantalla
     * @return input La cadena de caracteres introducida por el usuario
     */
    public static String entrarText(String missatgeExplicatiu) {
        imprimirText(missatgeExplicatiu);
        Scanner sc = new Scanner(System.in);
        String input;
        do {
            try {
                input = sc.nextLine();
                break;
            } catch (Exception e) {
                imprimirText("Número erroni");
                sc.next();
            }

        } while (true);

        return input;
    }

    /**
     * Método que permite introducir un número décimal
     * y muestra por pantalla un mensaje explicativo
     *
     * @param missatgeExplicatiu El mensaje que quieres enviar por pantalla
     * @return input La cadena de caracteres introducida por el usuario
     */
    public static Double entrarDecimal(String missatgeExplicatiu) {
        entrarText(missatgeExplicatiu);
        Scanner sc = new Scanner(System.in);
        Double input;
        do {
            try {
                input = sc.nextDouble();
                break;
            } catch (Exception e) {
                imprimirText("Número erroni");
                sc.next();
            }

        } while (true);
        return input;
    }

    /**
     * Método que permite introducir un número entero
     * y muestra por pantalla un mensaje explicativo
     *
     * @param missatgeExplicatiu El mensaje que quieres enviar por pantalla
     * @return input La cadena de caracteres introducida por el usuario
     */
    public static Integer entrarEnter(String missatgeExplicatiu) {
        imprimirText(missatgeExplicatiu);
        Scanner sc = new Scanner(System.in);
        Integer input = null;
        do {
            try {
                input = sc.nextInt();
                break;
            } catch (Exception e) {
                imprimirText("Número erroni");
                sc.next();
            }

        } while (true);
        return input;
    }

    /**
     * Et demana una data en strings i retorna un objecte de tipus DATE
     * @param missatgeExplicatiu missatge que s'imprmira al principi del metode per a l'usuari
     * @return
     */
    public static Date entrarData(String missatgeExplicatiu) {
        imprimirText(missatgeExplicatiu);
        Scanner sc = new Scanner(System.in);
        GregorianCalendar dataNova = new GregorianCalendar();
        dataNova.clear();
        imprimirText("Introdueix el dia, mes i any :");
        int dia = BibliotecaIO.entrarEnter("Introdueix el dia");
        int mes = BibliotecaIO.entrarEnter("Introdueix el mes");
        int any = BibliotecaIO.entrarEnter("Introdueix el any");
        dataNova.set(any, mes -= 1, dia);
        return dataNova.getTime();
    }

    /**
     * Muestra por pantalla un número decimal
     *
     * @param numeroPerImprimir el nº decimal a imprimir
     */
    public static void imprimirDouble(Double numeroPerImprimir) {
        System.out.println(numeroPerImprimir);
    }

    /**
     * Muestra por pantalla una cadena de caracteres
     *
     * @param missatgeExplicatiu el mensaje a imprimir
     */
    public static void imprimirText(String missatgeExplicatiu) {
        System.out.println(missatgeExplicatiu);
    }

    /**
     * Método que permite numerar arrays de tipo String
     * (El primer número es siempre 1)
     *
     * @param llista array de tipo String para numerar
     */
    public static void imprimirLlistaNumerada(String[] llista) {
        for (int a = 0; a < llista.length; a++) {
            System.out.println((a + 1) + ". -" + llista[a]);
        }
    }


    public static void hola() {
        System.out.print("Benvingut.");
    }
    public static void adeu() {
        System.out.print("Adeu.");
    }

}
