import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Ellipse2D;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class game extends JPanel {
		public static final int width = 600;
		public static final int height = 480;
		public static void main(String[] args){
				JFrame frame= new JFrame();
				frame.add(new main());
				frame.setTitle("MyGame");
				frame.pack();
				frame.setSize(width, height);
				frame.setLocationRelativeTo(null);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
				while (true) {
						game.moveBall();
						game.repaint();
						Thread.sleep(10);
				}
		}
		public void paint(Graphics g) {
				Graphics2D g2d = (Graphics2D) g;
				g2d.setColor(Color.RED);
				g2d.fillOval(0, 0, 30, 30);
				g2d.drawOval(0, 50, 30, 30);
				g2d.fillRect(50, 0, 30, 30);
				g2d.drawRect(50, 50, 30, 30);

				g2d.draw(new Ellipse2D.Double(0, 100, 30, 30));
		}
}
