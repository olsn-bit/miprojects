import java.util.Scanner;
class Main {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int f = sc.nextInt();
		int c = sc.nextInt();
		int blanca = 0;
		String quadre = "";
    boolean select = true;
		for (int j = 0; j <= f; j++) {
			quadre = sc.nextLine();
      if (select){
        select = false;
     	}else{
      	select = true;
      }
			for (int i = 0; i < quadre.length(); i++) {
        if (select){
          if ((i % 2) == 0) {
          	blanca += Integer.parseInt(quadre.substring(i, i + 1));
          }
        }
        else if(select == false){
        	if ((i % 2) == 0) {}
          else{blanca += Integer.parseInt(quadre.substring(i, i + 1));
          }
        }
			}
		}
		System.out.println(blanca);
	}
}
