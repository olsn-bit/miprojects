import javax.swing.JPanel;

public class game extends JPanel {
		//
		// private void loadImages() {
		// ImageIcon ii = new ImageIcon("files/images/ModelGame.png");
		//
		// star = ii.getImage();
		// }
		private void initBoard() {
					setBackground(Color.BLACK);
				setPreferredSize(new Dimension(B_WIDTH, B_HEIGHT));

				loadImage();

				x = INITIAL_X;
				y = INITIAL_Y;

				timer = new Timer(DELAY, this);
				timer.start();
		}
		@Override public void paintComponent(Graphics g) {
				super.paintComponent(g);

				drawStar(g);

		}
		private void drawStar(Graphics g) {
				g.drawImage(star, x, y, this);
				Toolkit.getDefaultToolkit().sync();
		}
		@Override public void actionPerformed(ActionEvent e) {
				x += 1;
				y += 1;
				if (y > B_HEIGHT) {
						y = INITIAL_Y;
						x = INITIAL_X;
				}
				repaint();
		}
		public static void main(String[] args) {}
}
