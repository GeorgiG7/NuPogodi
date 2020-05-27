package com.company;

import javax.swing.*;
import java.awt.*;

public class Textures extends JComponent {

    int x;
    int y;
    int width;
    int height;
    private String path;

    public Textures() {
    }

    public Textures(int x, int y, int width, int height, String path) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.path = path;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public void paintComponent(Graphics g) {
        Graphics2D graph = (Graphics2D) g;

        ImageIcon imageIcon = new ImageIcon(this.path);
        Image image = imageIcon.getImage();

        graph.drawImage(image, this.x, this.y, this.width, this.height, null);
    }

    public void render() {
        Thread animationThread = new Thread(new Runnable() {
            public void run() {
                repaint();
            }
        });

        animationThread.start();
    }

}
