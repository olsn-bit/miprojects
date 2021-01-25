import java.util.Scanner;
public class P89078{//P89078
  public static void main(String[] args){
    Scanner input = new Scanner(System.in);
    int index = 0;
    while(input.hasNext()){
      if ((input.nextInt() % 2) == 0){
        System.out.println(index+1);
        break;}
      index++;}}}
