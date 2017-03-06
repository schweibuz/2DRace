package classes;

import javax.swing.*;
import javax.swing.Timer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.*;
import java.util.List;

public class Road extends JPanel implements ActionListener, Runnable {

    Timer timer = new Timer(15, this);

    Image img = new ImageIcon("src/resources/road.png").getImage();

    Player p = new Player();

    Thread enemiesFactory = new Thread(this);

    List<Enemy> enemies = new ArrayList<Enemy>();

    public Road() {
        timer.start();
        enemiesFactory.start();
        addKeyListener(new MyKeyAdapter());
        setFocusable(true);
    }

    private class MyKeyAdapter extends KeyAdapter {
        public void keyPressed(KeyEvent e) {
            p.keyPressed(e);
        }

        public void keyReleased(KeyEvent e) {
            p.keyReleased(e);
        }
    }

    public void paint(Graphics g) {
        g = (Graphics2D) g;
        g.drawImage(img, 0, p.getLayer1(), null);
        g.drawImage(img, 0, p.getLayer2(), null);
        g.drawImage(img, 0, p.getLayer3(), null);
        g.drawImage(p.img, p.getX(), p.getY(), null);

        Iterator<Enemy> i = enemies.iterator();
        while (i.hasNext()) {
            Enemy e = i.next();
            if (e.getY() >= 2400 || e.getY() <= -2400) {
                i.remove();
            } else {
                g.drawImage(e.img, e.getX(), e.getY(), null);
            }
        }
    }

    public void enemyMove() {
        Iterator<Enemy> i = enemies.iterator();
        while (i.hasNext()) {
            Enemy e = i.next();
            e.move();
        }
    }

    public void crashTest() {
        Iterator<Enemy> i = enemies.iterator();
        while (i.hasNext()) {
            Enemy e = i.next();
            if (p.getRectangle().intersects(e.getRectangle())) {
                JOptionPane.showMessageDialog(null, "Вы проиграли!");
                System.exit(1);
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        p.move();
        repaint();
        enemyMove();
        crashTest();
        System.out.println(enemies.size());
    }

    @Override
    public void run() {
        while (true) {
            Random rnd = new Random();
            try {
                Thread.sleep(rnd.nextInt(2000));
                enemies.add(new Enemy(rnd.nextInt(450), -1200, rnd.nextInt(60), this));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
