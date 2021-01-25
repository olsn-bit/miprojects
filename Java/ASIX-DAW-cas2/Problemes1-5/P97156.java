import java.util.Scanner;
public class P97156{//P97156
  public static void main(String[] args){
    Scanner scanner = new Scanner(System.in);
    int num1 = scanner.nextInt();
    int num2 = scanner.nextInt();
    if (num1 > num2){
      System.out.println();
    }
    else{
      for (int count = num1;count < num2;count++){
        System.out.print(count+",");}
      System.out.println(num2);
    }
  }
}
