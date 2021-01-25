import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

public class excelWork {
    public static void main(String[] args) throws AWTException {

        Robot robot = new Robot();
        String[] files = {"616", "646", "458", "657", "113", "615","632" ,"638" ,"651" ,"653" ,"435" ,"650" ,"640" ,"404" ,"639" ,"629" ,"661" ,"633" ,"631" ,"620" ,"654" ,"617" ,"78","649" ,"626" ,"628" ,"621" ,"623" ,"624" ,"641" ,"642" ,"20","637" ,"643" ,"630"};
        for (int e = 0; e < files.length; e++) {


            moveNclic(153, 36, robot);
            robot.delay(100);
//            System.out.println(MouseInfo.getPointerInfo().getLocation().x + "_" + MouseInfo.getPointerInfo().getLocation().y);
            moveNclic(168, 246, robot);
            robot.delay(100);
            moveNclic(980, 289, robot);
            robot.delay(100);
            robotType("G:\\Marina\\" + files[e] + "_19.pdf",robot);
            robot.delay(100);
            moveNclic(958,487, robot);
            robot.delay(100);
            robotType("PDF_"+files[e],robot);
            robot.delay(100);
            moveNclic(1195,457, robot);
            robot.delay(100);
            moveNclic(1190,487, robot);
            robot.delay(100);
            moveNclic(974,573, robot);
            robot.delay(100);
            moveNclic(1074,570, robot);
            robot.delay(100);
            robot.keyPress(KeyEvent.VK_DOWN);
            robot.keyRelease(KeyEvent.VK_DOWN);
        }
//153_36-insertarr
//168_246-hyper
//        980_289 ruta
//        958_487 textoboton
//        1195_457 form-diaply
//        1190_487 button
//        974_573- aply
//        1074_570 cerra
//        System.out.println(MouseInfo.getPointerInfo().getLocation().x + "_" + MouseInfo.getPointerInfo().getLocation().y);
    }
    public static void moveNclic(int x, int y, Robot r){
        r.mouseMove(x,y);
        r.delay(1000);
        r.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        r.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
    }
    public static void robotType(String text,Robot r){
        StringSelection stringSelection = new StringSelection(text);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(stringSelection, stringSelection);

        r.keyPress(KeyEvent.VK_CONTROL);
        r.keyPress(KeyEvent.VK_V);
        r.keyRelease(KeyEvent.VK_V);
        r.keyRelease(KeyEvent.VK_CONTROL);
    }
}//        for (int i = 0; i < 5; i++) {
//            robot.delay(3000); //delay 2 second
//            System.out.println(MouseInfo.getPointerInfo().getLocation().x + "_" + MouseInfo.getPointerInfo().getLocation().y);
//        }
//        robot.mouseMove(1056,757);//f12 last
//        robot.delay(2000); //delay 2 second
//        robot.mouseMove(517,792);//input bar
//        robotrobot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);robot.delay(2000); //delay 2 second
//
//        robot.keyPress(KeyEvent.VK_ENTER);

