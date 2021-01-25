/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sprint3Java.Old;

public class Correu {
    //Declarem els atributs de la classe Correu.

    protected String assumpte;
    protected String cos;
    static int darrerNumero;
    int numero;
//Creem un constructor Correu per a poder incrementar la variable "darrerNumero", la qual ens ajudarà a mantindre les ID quan es borri un correu.
    public Correu(String assumpte, String cos) {
            assumpte = assumpte;
            cos = cos;
    }
    
    public Correu() {
    	
        this.darrerNumero++;
        numero = this.darrerNumero;
    }

    public void setAssumpte(String assumpte) {
        this.assumpte = assumpte;
    }

    public String getAssumpte() {
        return assumpte;

    }

    public void setCos(String cos) {
        this.cos = cos;
    }

    public String getCos() {
        return cos;

    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getNumero() {
        return numero;

    }

}
