import java.util.Scanner;

public class p2pme
{
	public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    while(sc.hasNextInt()){
      int cal_entrenament = sc.nextInt();
      if(cal_entrenament != 0){
      int n_menj = sc.nextInt();
      int total_cal = 0;
			double total_train = 0;
      for (int e = 0;e<n_menj;e++){
        total_cal += sc.nextInt();
      }
			total_train = Math.ceil((double)total_cal/cal_entrenament);
      System.out.println((int)total_train);
    }else{
			break;
    }}


	}
}
