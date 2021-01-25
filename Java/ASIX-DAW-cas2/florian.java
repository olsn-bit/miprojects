import java.util.Scanner;
import java.lang.Object;
public class florian{
  public static void main(String[] args){
    Scanner input = new Scanner(System.in);
    while (input.hasNextInt()){
    	int numero = input.nextInt();
      int list[] = {};
      for (int listc = numero-1;listc>0;listc--){
        list.add(input.nextInt());
      }
      for (int chck = 0;chck<numero;chck++){
        if (ArrayUtils.contains(list, chck)){
	      	ArrayUtils.removeElement(list, chck);
        }
      }
      System.out.println(list[0]);
    }
  }
}
