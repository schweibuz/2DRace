package classes;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        JFrame f = new JFrame("Carsick 2D");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(600, 1000);
        f.add(new Road());
        f.setVisible(true);
        f.setResizable(false);
    }
}
