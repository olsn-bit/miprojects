import java.util.Scanner;
public class P90226{
  public static void main(String[] args){
    Scanner scanner = new Scanner(System.in);
    // 1-Demanar al usuari una “string” i la guardarem com a “paraula_1”.
    String paraula_1 = scanner.next();
    // 2-Demanar al usuari una altra “string” i la guardarem com a “paraula_2”.
    String paraula_2 = scanner.next();
    // 3-Comparem quina variable de les dues te l’ordre lexografic primer:
    // 3.1-Crearem una variable per a marcar el simbol correcte i la guardarem com a “signe”
    String signe;
    // 3.2-Comparem amb l’eina compareTo la paraula 1 amb la paraula_2 i apartir de la documentació utilitzarem el resultat per saber l’ordre.(Utilitzarem diferents if per acomplir el cas)

    if (paraula_1.compareTo(paraula_2) <= 0){
      if (paraula_1.compareTo(paraula_2) == 0){
        signe = "=";}
      else{
        signe = "<";}}
    else{
        signe = ">";}
    // 4-Imprimirem la frase amb les paraules i el signe entre mitj.
    System.out.println(paraula_1+" "+signe+" "+paraula_2);
  }
}
