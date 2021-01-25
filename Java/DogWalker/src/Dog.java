import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Dog {
    final static String[] POSSIBLE_MOVES = {"f", "r", "l", "b", "fr", "fl", "br", "bl"};
    final static String[] POSSIBLE_MOODS = {"chill","nervous","sleep","crazy"};
    final static int MOVES_DIRECTION = 20;
    final static int LEASH_LENGTH = 100;
    public int speed;
    public int posX;
    public int posY;
    public Image img;
    public int size;
    public String name;
    public int weight;
    public Color color;
    public Walker owner;
    static final Color LEASH_COLOR = Color.yellow;
    private int walkCounter = 0;
    private String direction;
    public double mood;//double because on click puts 0.X so in X>1 clicks changes
    private int moodCounter;
    private int[] pullLeashData = null;
    public boolean pulling = false;

    public Dog(String imgpath, Walker owner, int speed, int posX, int posY, int size, String name, int weight, Color color) {
        this.owner = owner;
        this.speed = speed;
        this.posX = posX;
        this.posY = posY;
        this.size = size;
        this.name = name;
        this.weight = weight;
        this.color = color;
        this.mood = 0;
        this.moodCounter = 0;
        try
        {
            this.img = ImageIO.read(new File(imgpath));
        }
        catch (IOException e)
        {
            String workingDir = System.getProperty("user.dir");
            System.out.println("Current working directory : " + workingDir);
            e.printStackTrace();
        }
    }

    public boolean leashCheck(int x, int y) {//returns true if its inside the range, returns false if the leash is tight at its max
        int disAfterMove = this.leashLength(x, y);
        int disFromOwner = this.leashLength(this.posX,this.posY);

        //System.out.println("Distance from dog and owner = "+disAfterMove);

        if ((disAfterMove)< LEASH_LENGTH )  {

            return true;
        }
//        || disFromOwner > disAfterMove
        else{
            return false;
        }
        // 125 (this.posY + this.speed)+this.size)
    }
    public void pullLeash(){

        if(leashLength(this.posX,this.posY) > Dog.LEASH_LENGTH-10){//Margin between walk and pullLeash ...
            if(this.pullLeashData == null) this.pullLeashData = new int[]{this.owner.posX, this.owner.posY};
//                if (!panel.checkCoordinatesVisible(this.posX + this.owner.posX-this.pullLeashData[0], this.posY + this.owner.posY-this.pullLeashData[1])) return;
                if (!this.leashCheck(this.posX + this.owner.posX-this.pullLeashData[0], this.posY + this.owner.posY-this.pullLeashData[1]))return;
                this.posX += this.owner.posX-this.pullLeashData[0];
                this.posY += this.owner.posY-this.pullLeashData[1];
                this.pulling = true;
                 //BUG IMPORTANT AKI EH
//                System.out.println(this.posX+"+"+this.posX);

        }else{
            this.pulling = false;
            this.pullLeashData = null;
        }
    }
    public int leashLength(int x, int y) {//returns true if its inside the range, returns false if the leash is tight at its max
        return (int) (Math.sqrt((this.owner.posX - x) * (this.owner.posX - x) + (this.owner.posY - y) * (this.owner.posY - y)));
    }

    public void drawDog(Graphics g) {
//        g.setColor(this.color);
//        g.fillRect(this.posX-(this.size/2),this.posY-(this.size/2), this.size, this.size);
//        g.setColor(Color.yellow);
//        g.fillRect(this.posX, this.posY, 2,2);
        g.drawImage(this.img,this.posX-(this.size/2),this.posY-(this.size/2),this.size,this.size,null);
        this.drawLeash(g);

    }
    public void drawDogStats(int[] coord, Graphics g){
//        int[] coord = {30,100};
        g.setColor(Color.black);
        g.drawString("Dog Name: " +this.name , coord[0], coord[1]);
        g.drawString("Mood: " + Dog.POSSIBLE_MOODS[(int)this.mood] , coord[0], coord[1]+20);
        g.drawString("Dis Owner: " + (Math.sqrt((this.owner.posX - this.posX) * (this.owner.posX - this.posX) + (this.owner.posY - this.posY) * (this.owner.posY - this.posY))), coord[0], coord[1]+40);
    }

    public void drawLeash(Graphics g) {
        g.setColor(LEASH_COLOR);
        g.drawLine(this.posX, this.posY, this.owner.posX,this.owner.posY);
    }
    public void changeMood(){
        if((this.mood + 0.2) > POSSIBLE_MOODS.length-1){
            this.mood = 0;
        }else this.mood+=0.2;
    }
    public void move(String direction, GamePanel panel) {

        switch (direction) {
            case "f":
                if (!panel.checkCoordinatesVisible(0, this.posY - this.speed)) break;
                if (!this.leashCheck(this.posX, this.posY - this.speed)) {
                    //System.out.println("Dont move forward, outside the range");
                    break;
                }
                this.posY -= this.speed;
                break;
            case "r":
                if (!panel.checkCoordinatesVisible((this.posX + this.speed), 0)) break;
                if (!this.leashCheck((this.posX + this.speed), this.posY)) break;

                this.posX += this.speed;
                break;
            case "l":
                if (!panel.checkCoordinatesVisible(this.posX - this.speed, 0)) break;
                if (!this.leashCheck(this.posX - this.speed, this.posY)) break;

                this.posX -= this.speed;
                break;
            case "b":
                if (!panel.checkCoordinatesVisible(0, (this.posY + this.speed))) break;
                if (!this.leashCheck(this.posX, (this.posY + this.speed))) break;

                this.posY += this.speed;
                break;
            case "fr":
                this.move("f", panel);
                this.move("r", panel);
                break;
            case "fl":
                this.move("f", panel);
                this.move("l", panel);
                break;
            case "br":
                this.move("b", panel);
                this.move("r", panel);
                break;
            case "bl":
                this.move("b", panel);
                this.move("l", panel);
                break;

        }
    }
    public void walkAction(GamePanel panel){
        if (this.walkCounter % MOVES_DIRECTION == 0) this.changeDirection();
        this.move(this.direction, panel);
        this.walkCounter++;
    }
    public void walk(GamePanel panel) {

        switch (POSSIBLE_MOODS[(int)this.mood]) {
            case "chill":
                if ( this.moodCounter % 10 == 0 )this.walkAction(panel);

                break;
            case "nervous":
                if ( this.moodCounter % 5 == 0 )this.walkAction(panel);
                break;
            case "sleep":
                if ( this.moodCounter % 1000 == 0 )this.walkAction(panel);
//                if ( this.leashLength(this.posX,this.posY) > 99 )
                break;
            case "crazy":
                this.walkAction(panel);
                break;
        }
        this.moodCounter++;

    }

    public void changeDirection() {
        int random = (int) (Math.random() * POSSIBLE_MOVES.length);
        this.direction = POSSIBLE_MOVES[random];
    }
}
