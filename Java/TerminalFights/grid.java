/*
   PROG NOTES:
   0 = "empty"
   1 = "p";
   2 = "o";
   3 = P spawn
   4 = O spawn
   5 = D dead


 */
public class grid {
		public static boolean spawn_red = true;
		public static boolean spawn_blue = true;

		public static void main(String[] args) {
		}

		public static int[][] createGrid(int size) {
				int[][] grid = new int[size][size];
				for (int row = 0; row < size; row++) {
						for (int cell = 0; cell < size; cell++) {
								grid[row][cell] = 0;
						}
				}
				return grid;
		}

		public static void printarr(int[][] array, int size) {
				String ANSI_RESET = "\u001B[0m";
				String ANSI_BLUE = "\u001B[34m";
				for (int a = 0; a < size; a++) {
						String line = "";
						for (int b = 0; b < size; b++) {
								if (array[a][b] == 0) {
										line += " . ";
								}
								else if (array[a][b] == 1) {
										line += (ANSI_BLUE+" p "+ANSI_RESET);
								} else if (array[a][b] == 2) {
										line += " o ";
								} else if (array[a][b] == 3) {
										line += " P ";
								} else if (array[a][b] == 4) {
										line += " O ";
								} else if (array[a][b] == 5) {
										line += " D ";
								}
						}
						System.out.println(line);
				}
		}

		public static void update(int[][] array, int size) {
				resetnormallist(main.tmp_data, 0);
				for (int row = 0; row < size; row++) {
						for (int cell = 0; cell < size; cell++) {
								switch (array[row][cell]) {
								case 1:
										main.tmp_data[0]++;
										bluep.moveSelected(row, cell, array);
										break;
								case 2:
										main.tmp_data[1]++;
										redo.moveSelected(row, cell, array);
										break;
								case 4:
										if (main.tmp_data[1] > 20 && spawn_red == true) {
												spawn_red = false;
										}
										else if (spawn_red == true) {
												redo.spawn(row, cell, array);
										}
										break;
								case 3:
										if (main.tmp_data[0] > 20 && spawn_blue == true) {
												spawn_blue = false;
										}
										else if (spawn_blue == true) {
												bluep.spawn(row, cell, array);
										}
										break;
								case 5:
										main.tmp_data[3]++;
										break;
								}
						}
				}
		}

		public static void resetnormallist(int[] list, int value) {
				for (int e = list.length - 1; e >= 0; e--) {
						list[e] = value;
				}
		}
}
