import java.util.Scanner;
public class P81629{//P81629
  public static void main(String[] args){
    Scanner scanner = new Scanner(System.in);
    int euros = scanner.nextInt();
    int centims = scanner.nextInt();
    int billetsfinals[] = {0,0,0,0,0,0,0,0,0};
    final int billets[] = {500,200,100,50,20,10,5,2,1};
    final int monedes[] = {50,20,10,5,2,1};
    int monedesfinals[] = {0,0,0,0,0,0};
    while (euros > 0){
      for (int e = 0;e != 9;e++){
        if ((euros % billets[e]) >= 0){
          billetsfinals[e] = euros / billets[e];
          euros -= billets[e]*(euros / billets[e]);
        }
      }
    }
    while (centims > 0){
      for (int e = 0;e != 6;e++){
        if ((centims % monedes[e]) >= 0){
          monedesfinals[e] = centims / monedes[e];
          centims -= monedes[e]*(centims / monedes[e]);
        }
      }
    }
    for (int count = 0;count != 9;count++){
      if ( count == 7 ){
        System.out.println("Coins of "+billets[count]+" euros: "+billetsfinals[count]);
      }
      else if( count > 7 ){
        System.out.println("Coins of "+billets[count]+" euro: "+billetsfinals[count]);
      }
      else{
        System.out.println("Banknotes of "+billets[count]+" euros: "+billetsfinals[count]);
      }
    }
    for (int count = 0;count != 6;count++){
      if (count > 4){
        System.out.println("Coins of "+monedes[count]+" cent: "+monedesfinals[count]);
      }
      else{
        System.out.println("Coins of "+monedes[count]+" cents: "+monedesfinals[count]);
      }
    }
  }
}
