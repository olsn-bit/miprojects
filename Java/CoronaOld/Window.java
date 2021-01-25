import javax.swing.JFrame;

public class Window extends JFrame {
		int windowHeight;
		int windowWidth;
		String windowName;

		public Window(int height, int width, String name) {
				this.windowHeight = height;
				this.windowWidth = width;
				this.windowName = name;
		}
		public void initWindow() {
				add(new game());
				setSize(this.windowHeight, this.windowWidth);
				setTitle(this.windowName);
				setVisible(true);
				setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

				setLocationRelativeTo(null);
		}
		public static void main(String[] args) {
				Window frame = new Window(1600, 900, "Corona2DGame");

				frame.initWindow();
		}
}
