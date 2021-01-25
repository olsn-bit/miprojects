  import java.util.Scanner;
  public class p3pme
  {
  	public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      while(sc.hasNext()){
        String linea = sc.nextLine().toLowerCase();
        if (linea.equals("fin")){
          break;
        }
        String line_pr = "";
        for (char c : linea.toCharArray()) {
          if(c == ' '){
            line_pr += " ";
        }else{
          line_pr += Character.toString((char) (((c - 'a' + 1) % 26) + 'a'));
        }}
          System.out.println(line_pr.toUpperCase());
      }



  	}
  }
