import java.util.Scanner;
public class Main{
  public static void main(String[] args){
    Scanner input = new Scanner(System.in);
    int num_seq = input.nextInt();
    for(int e = 0;e != num_seq;e++){
      int total = 0;
      int num1 = input.nextInt();
      int num2 = num1;
      while ( num2 != 0 ){
        num2 = input.nextInt();
        if (num2 > num1){
          total++;
        }
        num1 = num2;
      }
      System.out.println(total);
    }
  }
}
