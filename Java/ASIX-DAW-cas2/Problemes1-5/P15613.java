import java.util.Scanner;
public class P15613{
  public static void main(String[] args){

    // 1-Donar un numero enter al programa
    Scanner input = new Scanner(System.in);
    int temperatura = input.nextInt();
    // 2-Si el numero enter que guardem a la variable “temperatura” compleix la condició de estar entre 10º i 30º mostrara per pantalla “S’esta be”.
    if(temperatura >= 10 && temperatura <= 30){
      System.out.println("it's ok");
    }
    // 3-Si el numero enter que guardem a la variable “temperatura” compleix la condició de ser menor de 10º mostrara per pantalla “Fa fred”.
    else if(temperatura < 10){
      System.out.println("it's cold");
    }
    // 4-Si el numero enter que guardem a la variable “temperatura” compleix la condició de ser major de 30º mostrara per pantalla “Fa calor”.
    else if(temperatura > 30){
      System.out.println("it's hot");
    }
    // 5-Si el numero enter que guardem a la variable “temperatura” compleix la condició de ser igual o major de 100 “l’aigua bulliria”
    if(temperatura >= 100){
      System.out.println("water would boil");
    }
    // 6-Si el numero enter que guardem a la variable “temperatura” compleix la condició de ser igual o menor que 0 “Aigua congelada”
    else if(temperatura <= 0){
      System.out.println("water would freeze");
    }
  }
}
