import java.util.Scanner;
public class P49603{
  public static void main(String[] args){
    Scanner input = new Scanner(System.in);
    while (input.hasNextInt()){
      int numeros = input.nextInt();
      int count = 0;
      public static int numfinal = 0;
      String primera = input.next();
      for (int total = numeros;total != 0;total--){
        String next = input.next();
        if (primera.compareTo(next)>0){
          numfinal = count;
        }
        primera = next;
        count++;
      }
    }
    System.out.println(numfinal);
  }
}
