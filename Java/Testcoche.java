import java.awt.*;
import java.awt.event.KeyEvent;

public class Testcoche {
		public static int thread_pos;
		int len;
		int hidden;
		int shown;
		String line;
		int time;
		public Testcoche(int speed,int difficulty){
				this.time = speed*10;
				this.line = null;
				this.len = difficulty;
				this.shown = 3*(difficulty/4);
				this.hidden = difficulty/4;

				System.out.println("Difficulty set to: "+this.len   );
		}
		public void createLine(){
				String linea = "";
				for(int e = 0; e<=this.len; e++) {
						if (e <= this.shown) {
								linea+="-";
						}else if (e>this.shown&&e<=this.shown+this.hidden) {
								linea+="#";

						}
				}
				this.line = linea;
				System.out.println(this.line);
		}
		public void start(String line){
				System.out.println(line.length());
				for(int e = 0;; e++) {
						String editedline = line;
						thread_pos = e;
						if( e<this.len) {
								if (line.charAt(e)!='#') {
										editedline = editedline.substring(0,e)+"X"+editedline.substring(e+1);
								}
						}
						Runtime.getRuntime().addShutdownHook(new Thread() {
								public void run() {
								        System.out.println(thread_pos);
								}
						});
						try{Thread.sleep(this.time);}
						catch(InterruptedException i) {}
						System.out.println(editedline);
				}
		}
		// public void showResult(String action,String editedline,int pos){
		//      String linea;
		//      int position;
		//      switch(action) {
		//      case "save":
		//              String linea = editedline;
		//              int position = pos;
		//              break;
		//          case "show";
		//              System.out.println()
		//      }
		// }
		public static void main(String[] args) {
				String mode = "hardcore";
				int speed = 0;
				int length = 0;
				switch(mode) {
				case "ez":
						speed = 40;
						length = 40;
						break;
				case "hardcore":
						speed = 10;
						length = 60;
						break;
				case "normal":
						speed = 20;
						length = 40;
						break;
				}
				Testcoche prova1 = new Testcoche(speed,length);
				prova1.createLine();
				prova1.start(prova1.line);
		}
}
