import java.awt.Robot;
import java.awt.AWTException;
import java.awt.event.InputEvent;
import java.io.BufferedReader;
import java.io.*;
import java.awt.datatransfer.StringSelection;
import java.awt.Toolkit;
import java.nio.file.*;
import java.nio.file.Paths;
import java.awt.datatransfer.Clipboard;
import java.awt.event.KeyEvent;
public class filetogui {

		public static Robot robot;

		public static void main(String[] args) {
				System.out.println("working");
				try{
						robot = new Robot();
						Thread.sleep(2000);
				}catch (Exception e)
				{
						System.err.format("Exception occurred trying to read "+e);
						e.printStackTrace();
				}
				try
				{
						BufferedReader reader = new BufferedReader(new FileReader("dadesfiletogui.txt"));
						BufferedReader reader2 = new BufferedReader(new FileReader("aux.txt"));
						String line; String linedos;

						while ((line = reader.readLine()) != null)
						{
								type(line);
								robot.keyPress(KeyEvent.VK_ENTER);
								robot.keyRelease(KeyEvent.VK_ENTER);

						}
						reader.close();
				}
				catch (Exception e)
				{
						System.out.println("Exception occurred trying to read "+e);
						e.printStackTrace();
				}
				// String text = "Hello World";
				// StringSelection stringSelection = new StringSelection(text);
				// Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
				// clipboard.setContents(stringSelection, stringSelection);
				//
				// // Robot robot = new Robot();
				// robot.keyPress(KeyEvent.VK_CONTROL);
				// robot.keyPress(KeyEvent.VK_V);
				// robot.keyRelease(KeyEvent.VK_V);
				// robot.keyRelease(KeyEvent.VK_CONTROL);

		}
		public static void typeKey(int keyCode) {
				robot.keyPress(keyCode);
				robot.delay(100);
				robot.keyRelease(keyCode);
		}

		public static void typeKey(int keyCode, int keyCodeModifier) {
				robot.keyPress(keyCodeModifier);
				robot.keyPress(keyCode);
				robot.delay(100);
				robot.keyRelease(keyCode);
				robot.keyRelease(keyCodeModifier);
		}

		/**
		 * Type the text
		 * @param text value to type
		 */
		public static void type(String text) {
				for (int i = 0; i < text.length(); ++i) {
						typeChar(text.charAt(i));
				}
		}

		/**
		 * This will handle finding the keyCode of a special characters and
		 * decide whether pressing Shift Key to simulate that, and call the correct keyType function
		 * @param c character
		 */
		private static void typeChar(char c) {
				boolean shift = true;
				int keyCode;

				switch (c) {
				case '~':
						keyCode = (int) '`';
						break;
				case '!':
						keyCode = (int) '1';
						break;
				case '@':
						keyCode = (int) '2';
						break;
				case '#':
						keyCode = (int) '3';
						break;
				case '$':
						keyCode = (int) '4';
						break;
				case '%':
						keyCode = (int) '5';
						break;
				case '^':
						keyCode = (int) '6';
						break;
				case '&':
						keyCode = (int) '7';
						break;
				case '*':
						keyCode = (int) '8';
						break;
				case '(':
						keyCode = (int) '9';
						break;
				case ')':
						keyCode = (int) '0';
						break;
				case ':':
						keyCode = (int) ';';
						break;
				case '_':
						keyCode = (int) '-';
						break;
				case '+':
						keyCode = (int) '=';
						break;
				case '|':
						keyCode = (int) '\\';
						break;
				case '"':
						keyCode = KeyEvent.VK_QUOTE;
						break;
				case '?':
						keyCode = (int) '/';
						break;
				case '{':
						keyCode = (int) '[';
						break;
				case '}':
						keyCode = (int) ']';
						break;
				case '<':
						keyCode = (int) ',';
						break;
				case '>':
						keyCode = (int) '.';
						break;
				default:
						keyCode = (int) Character.toUpperCase(c);
						shift = Character.isUpperCase(c);
						break;
				}
				if (shift)
						typeKey(keyCode, KeyEvent.VK_SHIFT);
				else
						typeKey(keyCode);
		}
}
