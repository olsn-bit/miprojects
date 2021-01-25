import java.util.Scanner;
public class P71753{
  public static void main(String[] args){
    Scanner input = new Scanner(System.in);
    while(input.hasNextInt()){
      int total = input.nextInt();
      int max = input.nextInt();
      for (int e = total-1 ; e>0 ; e-- ){
          int num = input.nextInt();
          if (max < num){
            max = num;
          }
      }
      System.out.println(max);
    }
  }
}
