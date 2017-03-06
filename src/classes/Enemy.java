package classes;

import javax.swing.*;
import java.awt.*;

public class Enemy {

    private int v;
    private int x;
    private int y;
    Image img = new ImageIcon("src/resources/BotCar.png").getImage();
    Road road;

    public Rectangle getRectangle () {
        return new Rectangle(x, y, 45, 105);
    }

    public Enemy(int x, int y, int v, Road road) {
        this.x = x;
        this.y = y;
        this.v = v;
        this.road = road;
    }

    public void move() {
        y = y + road.p.getV() - v;

    }

    public int getV() {
        return v;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
