import java.util.Scanner;
public class P97969{//P97969
  public static void main(String[] args){
    Scanner scanner = new Scanner(System.in);
    String inputtext = scanner.nextLine();
    int total_a = 0;
    for (int count = 0;count<inputtext.length();count++) {
      if (inputtext.charAt(count) == 'a') {
        total_a++;
      }
      else if (inputtext.charAt(count) == '.') {
        break;
      }
    }
    System.out.println(total_a);
  }
}
