import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.concurrent.*;
//
// class buttonpress implements ActionListener {
//     public void actionPerformed(ActionEvent e) {
//         // prova2finestra.GUI("rise_pb");
//         // cp.repain();
//         // prova2finestra.GUI();
//         // finestra.dispose();
//         // prova2finestra.GUI();
//         // cont.repaint();
//     }
// }
public class prova2finestra extends JFrame {

//     int num = 0;
    public static JProgressBar pbar = new JProgressBar(0, 2000);
    public static JFrame Finestra(String name){
        JFrame finestra = new JFrame(name);
        finestra.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        return finestra;
//         finestra.pack();
//         // Timer timer = new Timer (1000, new ActionListener (){
//         //     public void actionPerformed(ActionEvent e){
//         //         cp.repaint();
//         //         System.out.println("hola");
//         //     }
//         // });
//         // timer.start();
    }
    public static void FinestraComp(JFrame window) {
      // window.setPreferredSize(new Dimension(400, 300));
      Container cp = window.getContentPane();
      cp.setPreferredSize(new Dimension(400, 300));
      cp.setLayout(new FlowLayout());
      JTextField inputfield = new JTextField();
      JButton startbutt = new JButton("Start");
      // startbutt.addActionListener(new buttonpress());
      cp.add(startbutt);
      cp.add(inputfield);
      cp.add(pbar);
      // cp.setPreferredSize(new Dimension(400, 300));
    }
    public static void pbarinit(int value){
      pbar.setMinimum(0);
      pbar.setMaximum(100);
      pbar.setValue(value);
      pbar.setStringPainted(true);
      pbar.setIndeterminate(false);
    }
    // public static void pbarupdate(int value){
    //     pbar.getValue
    // }
//     //     // JProgressBar pbar;
//     //     // pbar = new JProgressBar();
//     //     pbar.setMinimum(0);
//     //     pbar.setMaximum(100);
//     //     pbar.setValue(value);
//     //     // System.out.println(value);
//     //     pbar.setStringPainted(true);
//     //     pbar.setIndeterminate(false);
//     //     // return pbar;
//     //     // cp.repaint();
//     //     // return pbar;
    //     // }
    //     public void update(){
    //        while (num < 2000) {
    //          pbar.setValue(num);
    //          try {
    //            Thread.sleep(1000);
    //          } catch (InterruptedException e) {
    //          }
//          num += 95;
//        }
//      }
//
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
              JFrame fin = Finestra("Asteroid Madness");
              FinestraComp(fin);
              fin.setVisible(true);
              pbarinit(0);
              // pbarupdate();
              // pbar();
              // update();
            }
        });
    }
}
