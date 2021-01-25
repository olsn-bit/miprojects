import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.Scanner;

public class main {
    public static void main(String[] args) throws AWTException, IOException, UnsupportedFlavorException {
        int x = 0;
        Scanner sc = new Scanner("C:\\Users\\lavvo\\Dropbox\\Programming\\JavaScript\\justvibing\\whatsappTranslatorBot.js");
        Robot robot = new Robot();
        String jscode = "";
        while(sc.hasNextLine()){
            jscode += sc.nextLine();
        }
        while(x < 1) {

            robot.delay(2000); //delay 2 second
//            robot.mouseMove(979,798);
//            robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
//            robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
//            StringSelection stringSelection = new StringSelection(jscode);
//            Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
//            clipboard.setContents(stringSelection, stringSelection);
//            paste(robot);
//            robot.keyPress(KeyEvent.VK_ENTER);
//
//
//            robot.mouseMove(1056,757);//f12 last
//            doubleclick(robot);
//            robot.delay(2000); //delay 2 second
//            String command = robotcopy(robot);
//            robot.mouseMove(517,792);//input bar
//            robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
//            robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
//            robot.delay(2000); //delay 2 second
//            stringSelection = new StringSelection(command);
//            clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
//            clipboard.setContents(stringSelection, stringSelection);
//            paste(robot);
//            robot.keyPress(KeyEvent.VK_ENTER);

            System.out.println(MouseInfo.getPointerInfo().getLocation().x + "_" + MouseInfo.getPointerInfo().getLocation().y);
            x++;
//        robot.mouseMove();
        }
    }
        public static String robotcopy(Robot robot) throws IOException, UnsupportedFlavorException {
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_C);
            robot.keyRelease(KeyEvent.VK_CONTROL);
            robot.keyRelease(KeyEvent.VK_C);Clipboard c=Toolkit.getDefaultToolkit().getSystemClipboard();
            return (String) c.getData(DataFlavor.stringFlavor);
    }
    public static void paste(Robot robot) throws IOException, UnsupportedFlavorException {
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyRelease(KeyEvent.VK_V);
    }
        public static void doubleclick(Robot robot){
            robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
            robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
            robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
            robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        }
    }



