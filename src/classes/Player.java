package classes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class Player {

    public static final int MAX_V = 100;
    public static final int MAX_LEFT = 55;
    public static final int MAX_RIGHT = 452;

    private int v = 0;
    private double dv = 0;
    private int s = 0;

    private int x = 100;
    private int y = 780;
    private int dx = 0;

    private int layer1 = 0;
    private int layer2 = -1000;
    private int layer3 = -2000;

    Image img = new ImageIcon("src/resources/PlayerCar.png").getImage();

    public Rectangle getRectangle () {
        return new Rectangle(x, y, 45, 105);
    }

    public void move() {
        this.s += v;
        this.v += dv;
        if (v <= 0) v = 0;
        if (v >= MAX_V) v = MAX_V;

        this.x += dx;
        if (x <= MAX_LEFT) x = MAX_LEFT;
        if (x >= MAX_RIGHT) x = MAX_RIGHT;
        if (layer1 >= 1000) {
            layer1 = 0;
            layer2 = -1000;
            layer3 = -2000;
        } else {
            layer1 += v;
            layer2 += v;
            layer3 += v;
        }
    }

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_UP) {
            dv = 5;
        }
        if (key == KeyEvent.VK_DOWN) {
            dv = -5;
        }
        if (key == KeyEvent.VK_RIGHT) {
            dx = 10;
        }
        if (key == KeyEvent.VK_LEFT) {
            dx = -10;
        }
    }

    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_UP || key == KeyEvent.VK_DOWN) {
            dv = -0.0001;
        }
        if (key == KeyEvent.VK_RIGHT || key == KeyEvent.VK_LEFT) {
            dx = 0;
        }
    }


    public int getV() {
        return v;
    }

    public double getDv() {
        return dv;
    }

    public int getS() {
        return s;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getDx() {
        return dx;
    }

    public int getLayer1() {
        return layer1;
    }

    public int getLayer2() {
        return layer2;
    }

    public int getLayer3() {
        return layer3;
    }
}
