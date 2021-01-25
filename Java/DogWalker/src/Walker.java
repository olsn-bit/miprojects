import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Walker {
    public int posX;
    public int posY;
    public int speed;
    public int size;
    public String name;
    public Image img;
    public int maxRopeLength;
    public final int originalSpeed;

    public Walker(String imgpath, int posX, int posY, int speed, int size, String name, int maxRopeLength) {
        this.posX = posX;
        this.posY = posY;
        this.speed = speed;
        this.size = size;
        this.name = name;

        this.maxRopeLength = maxRopeLength;
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
        this.originalSpeed = speed;
    }
    public void pullDog(boolean pulling){
        if ( pulling ) this.speed = this.originalSpeed/2;
        else this.speed = this.originalSpeed;
    }
    public void drawWalker(Graphics g) {
//        g.setColor(Color.black);
//        g.fillRect(this.posX-(this.size/2),this.posY-(this.size/2),this.size,this.size);
//
//        g.setColor(Color.green);
//        g.fillRect(this.posX,this.posY,2,2);
        g.drawImage(this.img,this.posX-(this.size/2),this.posY-(this.size/2),this.size,this.size,null);
    }
    public void drawLeashZone(Graphics g){
        int radius = Dog.LEASH_LENGTH;
        g.drawOval(((this.posX-(this.size/2))-(radius))+(this.size/2),((this.posY-(this.size/2))-(radius))+(this.size/2),radius*2,radius*2);

    }
    public void move(String direction,GamePanel panel){
        switch (direction){
            case "f":
                if(!panel.checkCoordinatesVisible(0,this.posY - this.speed))break;
                this.posY -= this.speed;
                break;
            case "r":
                if(!panel.checkCoordinatesVisible((this.posX + this.speed),0))break;
                this.posX += this.speed;
                break;
            case "l":
                if(!panel.checkCoordinatesVisible(this.posX - this.speed,0))break;
                this.posX -= this.speed;
                break;
            case "b":
                if(!panel.checkCoordinatesVisible(0, (this.posY + this.speed)))break;
                this.posY += this.speed;
                break;
            case "fr":
                this.move("f",panel);
                this.move("r",panel);
                break;
            case "fl":
                this.move("f",panel);
                this.move("l",panel);
                break;
            case "br":
                this.move("b",panel);
                this.move("r",panel);
                break;
            case "bl":
                this.move("b",panel);
                this.move("l",panel);
                break;

        }
    }

}
