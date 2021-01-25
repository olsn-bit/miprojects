import java.util.Scanner;
public class P34080a{
  public static void main(String[] args){
    Scanner input = new Scanner(System.in);
    int side = input.nextInt();
    int index = 0;
    int numbers[] = {0,1,2,3,4,5,6,7,8,9};
    for (int line = 0;line<side;line++){
      for (int row = 0;row<side;row++){
        System.out.print(numbers[index]);
        index++;
        if (index == 10){
          index = 0;
        }
      }
      System.out.println();
    }
  }
}
