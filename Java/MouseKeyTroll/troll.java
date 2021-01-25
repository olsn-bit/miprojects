import java.awt.Robot;
import java.awt.AWTException;
import java.awt.event.InputEvent;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
public class troll {
		public static Robot robot;
		public static void main(String[] args) {
				// Thread.sleep(4000);
				System.out.println("Starting..");
				// Robot robot;
				try{
						robot = new Robot();
						Thread.sleep(2000);
				}catch (Exception e)
				{}
				// int contador = 0;
				for(int e = 0; e<500; e++) {
						try{
								// Thread.sleep(1000);

								type("F");
								robot.keyPress(KeyEvent.VK_ENTER);
								robot.keyRelease(KeyEvent.VK_ENTER);
						}catch (Exception o)
						{}
						// type("kloko maremeva");
						// robot.keyPress(KeyEvent.VK_ENTER);
						// robot.keyRelease(KeyEvent.VK_ENTER);
				}
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


		public static void type(String text) {
				for (int i = 0; i < text.length(); ++i) {
						typeChar(text.charAt(i));
				}
		}


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
						keyCode = (int) '+';
						break;
				case '=':
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
