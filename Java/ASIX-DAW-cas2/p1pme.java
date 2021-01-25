import java.util.Scanner;
public class p1pme
{
	public static void main(String[] args) {
		String s = "2 25 12 24 11";
    Scanner sc = new Scanner(s);
		int quant = sc.nextInt();
    for(int e = 0;e<quant;e++){
      int n1 = sc.nextInt();
      int n2 = sc.nextInt();
      if((n1 == 25) && (n2 == 12)){
        System.out.println("SI");
      }else{
        System.out.println("NO");
      }
    }
	}
}
