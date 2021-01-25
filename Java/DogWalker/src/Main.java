import java.awt.*;

public class Main {
    static final int HEIGHT = 800;
    static final int WIDTH = 500;
    static final String NAME = "Walker 1.0";
    public static void main(String[] args) {
        Walker persona = new Walker("src/img/player.png",HEIGHT/2,WIDTH/2, 5,50, "Alberto", 100);
        Dog[] giga = {new Dog("src/img/dog1.png",persona,10,HEIGHT/2,WIDTH/2, 25, "Giga",10, Color.red)};
        Window finestra = new Window(Main.WIDTH,Main.HEIGHT,Main.NAME);
        //GamePanel
        finestra.configFrame();
        GamePanel game = new GamePanel("Panel1", persona, giga);
        finestra.add(game);
        game.start();



    }
}
