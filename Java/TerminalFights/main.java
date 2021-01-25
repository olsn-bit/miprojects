/*
   PROG NOTES:
   0 = "empty"
   1 = "p";blue
   2 = "o";red
   3 = P spawn blue
   4 = O spawn red
   5 = D dead

   UPDATE REWORK!!!!!!!!!!!
 */
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class main {
		public static Scanner sc = new Scanner(System.in);
		public static int grid1size = 40;
		public static int[][] grid1 = grid.createGrid(grid1size);
//  Data Values =                   P's,O's
		public static int[] tmp_data = { 0, 0 };
		public static int gen = 0;

//                          pkills,okills,dead
		public static int[] final_data = { 0, 0, 0 };
		public static TimeUnit time = TimeUnit.MILLISECONDS;

		public static void main(String[] args) {
				int sleeptime = 500;
				redo.setSpawn(grid1, grid1size);
				bluep.setSpawn(grid1, grid1size);
				while (true) {
						if (final_data[1]>20) {
								System.out.println("O's win.");
								final_data[1]=0;
						}else if (final_data[0]>20) {
								final_data[0]=0;
								System.out.println("P's win.");

						}
						System.out.println("Generation : " + gen + " || p's :" + tmp_data[0] + " || o's :" + tmp_data[1]
						                   + " || Dead :" + final_data[2] + " || P Kills :" + final_data[0] + " || O Kills :" + final_data[1]);
						grid.printarr(grid1,grid1size);
						grid.update(grid1, grid1size);
						gen++;
						try {
								time.sleep(sleeptime);
						} catch (InterruptedException a) {
								Thread.currentThread().interrupt();
						}
				}

		}
		public static void restart(String[] args) {
				grid1 = grid.createGrid(grid1size);
				grid.resetnormallist(final_data, 0);
				grid.resetnormallist(tmp_data, 0);
				gen = 0;

		}
}
