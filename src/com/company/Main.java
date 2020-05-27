package com.company;

public class Main {

    public static void main(String[] args) {

        Display.initInstance(600, 600, "Nancy");

        Textures egg = new Textures(75, 30, 20, 20, "Resources\\images.png");
        Textures nuPogodi = new Textures(20, 200, 180, 180, "Resources\\Untitled-2.png");
        Textures chickenFirst = new Textures(30, -1,100, 80, "Resources\\Untitled-1.png");
        Textures chickenSecond = new Textures(95, -1,100, 80, "Resources\\Untitled-1.png");
        Textures chickenThird = new Textures(160, -1,100, 80, "Resources\\Untitled-1.png");
        Textures chickenForth = new Textures(225, -1,100, 80, "Resources\\Untitled-1.png");

        Display.getInstance().addGraphic(egg);
        Display.getInstance().addGraphic(nuPogodi);
        Display.getInstance().addGraphic(chickenFirst);
        Display.getInstance().addGraphic(chickenForth);
        Display.getInstance().addGraphic(chickenSecond);
        Display.getInstance().addGraphic(chickenThird);

        int x = 1;
        int y = 1;

        while (true) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }

            egg.setY(egg.y + y);

            egg.render();
            if (egg.y < 0 || egg.y > 280) {
                y *= -1;
            }

//            System.out.println(x + " " + texture.y + " " + texture.width);

        }
    }
}
