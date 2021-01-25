import java.util.Arrays;
// Terminal Graphs of Data
// By Alberto Dos Santos

public class Tgraphs {
		public static String ResetColor = "\u001B[0m";
		public static String Roig = "\u001B[31m";
		public static String Groc = "\u001B[33m";
		public static String Cyan = "\u001B[36m";
		public static String Verd = "\u001B[32m";

		String[][] graph;
		int[] values;
		int height;
		int width;
		String color;
		//Constructor del graph
		public Tgraphs(int[] values) {
				this.height = 10;       // Default number, till resizing
				this.width = values.length;
				this.graph = new String[this.height][this.width];
				this.buildArray();
				this.values = values;
				this.color = Verd;      // Default code, but you can pick later.
				this.drawTemplate();
		}
		public static void main(String[] args) {
				int[] values = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14};

				Tgraphs testgraph = new Tgraphs(values);
				testgraph.createGraph();
				testgraph.printGraph();
				// System.out.println("Resize Terminal to see this template for better experience.");
				// testgraph.drawTemplate();
				// testgraph.drawGraph();
		}
		public void buildArray(){
				for(String[] e : this.graph) {
						Arrays.fill(e, " ");
				}
		}
		//Dibuixa una columna
		// public String drawColumn(int value,int column) {
		//      for (int e = 0; e < this.height; e++) {
		//              if (e == (maxArray(this.values) / value * 10)) {
		//                      this.graph[column] += "-\n";
		//              } else {
		//                      this.graph[column] += "\n";
		//              }
		//      }
		//      return (this.graph[column]);x == (this.values[value] / maxArray(this.values) * this.height)
		// }
		public void createGraph(){
				// System.out.println("prova:"+(int)((5.0/14)*10));
				for(int value = 0; value<this.values.length; value++   ) {

						// System.out.println(this.values[value]+"percentage out of 10:"+ (int)((this.values[value] / (double)maxArray(this.values)) * this.height));
						for (int y = this.height-1; y>-1; y--) {
								for(int x = 0; x<this.width; x++) {
										// for (int x = 0; x<this.height; x++) {
										// System.out.print((this.values[value] / maxArray(this.values) * this.height));
										if(x == (int)((this.values[value] / (double)maxArray(this.values)) * this.height)) {
												this.graph[y][x] = Integer.toString(this.values[value]);

										}
								}

						}
				}
		}
		public void printGraph(){
				for (int rowy = this.height-1; rowy>-1; rowy--) {
						for(int rowx = 0; rowx<this.width; rowx++) {
								// this.graph[rowy][rowx] = "."+Integer.toString(rowx)+","+Integer.toString(rowy)+".";
								System.out.print(this.graph[rowy][rowx]);
								// if(this.graph[rowx][rowy] = "
								// cell!=" ") System.out.print(i);
								// else System.out.print("-");
						}
						System.out.println();
				}
		}

		// if ( o == (maxArray(this.values) / value * 10))
		//              if (o == )
		//          fila = 1 2 3 4 5 6 7 8 9
		//                       1 2 3 4 5 6 7 8 9
		//              System.out.println(this.drawColumn(this.values[e],e));
		//      }
		//      return this.graph;
		// }
		public void drawTemplate(){
				System.out.println("Resize Terminal to see this template for better experience.");

				for (int e = 0; e<this.height; e++) {
						System.out.println();
						for (int o = 0; o < this.width; o++) {
								System.out.print("█");
						}
				}
				System.out.println();
		}
		public static int minArray(int[] list){
				int minValue = list[0];
				for(int i=1; i<list.length; i++) {
						if(list[i] < minValue) {
								minValue = list[i];
						}
				}
				return minValue;
		}
		public static int maxArray(int[] list){
				int maxValue = list[0];
				for(int i=1; i<list.length; i++) {
						if(list[i] > maxValue) {
								maxValue = list[i];
						}
				}
				return maxValue;
		}
}
