
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class GamePanel extends JPanel implements KeyListener {

    private boolean[] keys = new boolean[256];
    Walker player;
    Dog[] dogs;
    String name;
    Boolean running;

    int fps;
    boolean paused;

    public GamePanel(String name, Walker player, Dog[] dogs) {
        this.name = name;
        this.fps = 0;
        this.running = true;
        this.player = player;
        this.dogs = dogs;
        this.addKeyListener(this);
        this.setFocusable(true);
        this.paused = false;
    }

    //No need to call this function, it runs when updating, clicking, ... the frame
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.player.drawWalker(g);
        for (Dog gos:this.dogs){
            gos.drawDog(g);
            gos.drawDogStats(new int[]{30, 100},g);

        }
        this.player.drawLeashZone(g);

        //Draw FPS
        g.setColor(Color.black);
        g.drawString(this.fps + " FPS", 50, 20);

    }


    //drawpath is going to be draw every tick so we only draw the last phat coordinates

//    public void drawHpBar(Graphics g) {
//        Graphics2D g2 = (Graphics2D) g;
//        g2.setStroke(new BasicStroke(1));
//        g.setColor(Color.black);
//        g.drawString("HP", 30, 860);
//        g.drawRect(49, Game.FRAMEWIDTH / 2, this.player.maxHp * 2, 16);
//        g.setColor(new Color(255, 0, 0, 127));//127 = 50% transparent
//        if (this.player.hp > 0) {
//            g.fillRect(50, Game.FRAMEWIDTH / 2, this.player.hp * 2, 15);
//        }
//    }
//
//    public void drawInfected(Graphics g) {
//        for (Infected each : this.infected) {
////            System.out.println("x: "+(each.xPos+(Game.FRAMEWIDTH*bg.codeZone[0]))+"y: "+(each.yPos+(Game.FRAMEHEIGHT*bg.codeZone[1])));
//            g.drawImage(each.img, each.xPos + (Game.FRAMEWIDTH * this.bg.codeZone[0]), each.yPos + (Game.FRAMEHEIGHT * this.bg.codeZone[1]), each.width, each.height, this);
//        }
//    }
//


//    public void drawDogs(Graphics g) {
//        for (int e = 0;e<this.dogs.length){
//            g.drawImage(this.dogs[e]
//        }
//        g.drawImage(this.bg.img, this.bg.codeZone[0] * Game.FRAMEWIDTH, this.bg.codeZone[1] * Game.FRAMEHEIGHT, this);
////        g.drawImage(this.bg.img, 0, 0, Game.FRAMEWIDTH, Game.FRAMEHEIGHT-Game.SIZEBUG, null, this);
//        g.drawString(this.bg.strZone(), 10, 20);
//    }

    //Inicialize game components
    public void start() {
        this.requestFocusInWindow();//Request focus for the keyListener
        this.loop();
    }
    public Boolean checkCoordinatesVisible(int x, int y){
        return this.contains(x,y);
    }

    public void loop() {
        double MS_PER_FRAME = 16.8;
        double endTimeFps;
        int fpsIter = 0;
        int frameTimes = 0;
        while (this.running) {
            if (keys[KeyEvent.VK_P]) {
                this.paused = !this.paused;
                keys[KeyEvent.VK_P] = false;

            }
            double start = System.currentTimeMillis();
            if (!this.paused) {
                this.update();
            }
            this.render();
            try {
                if ((start + MS_PER_FRAME - System.currentTimeMillis()) > 0) {
                    Thread.sleep((long) (start + MS_PER_FRAME - System.currentTimeMillis()));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            endTimeFps = System.currentTimeMillis();
            frameTimes = frameTimes + (int) (endTimeFps - start);
            fpsIter++;
            if (frameTimes >= 500) {//1000 = 1 sec in mils
//                System.out.println("px:"+this.player.xPos+" py:"+this.player.yPos+"tpx:"+
//
//                        this.toiletPaper.X+" tpy:"+this.toiletPaper.Y);
                this.fps = fpsIter * 2;
                fpsIter = 0;
                frameTimes = 0;
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        keys[e.getKeyCode()] = true;
    }

    @Override
    public void keyReleased(KeyEvent e) {
        keys[e.getKeyCode()] = false;
    }

    //Render : updateimages on screen
    public void render() {
        this.revalidate();
        this.repaint();
    }

    //Move screeen objects and update based on time for now
    public void update() {
//        if (this.player.hp <= 0) {//end game
//            this.running = false;
//        }
        //move dogs
        for (Dog gos:this.dogs){
            gos.walk(this);
            gos.pullLeash();
            this.player.pullDog(gos.pulling);
        }

        if (keys[KeyEvent.VK_A] && keys[KeyEvent.VK_W]) {
            this.player.move("fl",this);
        } else if (keys[KeyEvent.VK_A] && keys[KeyEvent.VK_S]) {
            this.player.move("bl",this);
        } else if (keys[KeyEvent.VK_S] && keys[KeyEvent.VK_D]) {
            this.player.move("br",this);
        } else if (keys[KeyEvent.VK_D] && keys[KeyEvent.VK_W]) {
            this.player.move("fr",this);
        } else if (keys[KeyEvent.VK_W]) {
            this.player.move("f",this);
        } else if (keys[KeyEvent.VK_D]) {
            this.player.move("r",this);
        } else if (keys[KeyEvent.VK_S]) {
            this.player.move("b",this);
        } else if (keys[KeyEvent.VK_A]) {
            this.player.move("l",this);
        }else if (keys[KeyEvent.VK_M]) {
            this.dogs[0].changeMood();
        }
        //Check collisions


        //Update all objects in the game

    }
    //Main function, not used actually
}
