import java.util.Scanner;
public class P84735{//P84735
  public static void main(String[] args){
    Scanner input = new Scanner(System.in);
    int pair_num = 1;
    while(input.hasNext()){
      int num1 = input.nextInt();
      int num2 = input.nextInt();
      if ( (num1 % num2) == 0){
        System.out.println("#"+pair_num+" : "+num2* (num1 / num2));
      } else{
        System.out.println("#"+pair_num+" : "+num2* ((num1 / num2)+1));
      }
      pair_num++;

    }
  }
}
