import java.awt.image.BufferedImage;
import java.awt.Color;
import java.io.*;
import java.awt.*;
import javax.imageio.ImageIO;
public class imagetoterminal {
		public static void main(String [] args){
				try{
						BufferedImage image = ImageIO.read(new File("InputMoney/files/xavi.png"));
						for ( int x = 0; x < image.getWidth(); x++ ) {
								System.out.println();
								for( int y = image.getHeight()-1; y > 0; y-- ) {
										Color pixel = new Color( image.getRGB( x, y ) );

										System.out.print("\u001b[38;2;"+pixel.getRed()+";"+pixel.getGreen()+";"+pixel.getBlue()+"m"+"█");
								}
						}
				}
				catch (IOException e) {
						e.printStackTrace();
				}
		}
}
