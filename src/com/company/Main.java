package com.company;

public class Main {

    public static void main(String[] args) {

        Display.initInstance(600, 600, "Nancy");

        //Textures egg = new Textures(75, 30, 20, 20, "Resources\\egg.png");
        Textures nuPogodi = new Textures(20, 200, 180, 180, "Resources\\NuPogodi.png");
        Textures chickenFirst = new Textures(30, -1,100, 80, "Resources\\chickenAnimated.png");
        Textures chickenSecond = new Textures(95, -1,100, 80, "Resources\\chickenAnimated.png");
        Textures chickenThird = new Textures(160, -1,100, 80, "Resources\\chickenAnimated.png");
        Textures chickenForth = new Textures(225, -1,100, 80, "Resources\\chickenAnimated.png");
        Textures grass = new Textures(0, 220,600, 150, "Resources\\grass.png");
        Textures wood = new Textures(0, 30,600, 150, "Resources\\wood.png");

        Egg egg = new Egg(75,30,25, 25,"Resources\\egg1.png");

        Display.getInstance().addGraphic(grass);
        Display.getInstance().addGraphic(wood);
        Display.getInstance().addGraphic(egg.getTexture());
        Display.getInstance().addGraphic(nuPogodi);
        Display.getInstance().addGraphic(chickenFirst);
        Display.getInstance().addGraphic(chickenForth);
        Display.getInstance().addGraphic(chickenSecond);
        Display.getInstance().addGraphic(chickenThird);
        Display.getInstance().addGraphic(wood);
        Display.getInstance().addGraphic(grass);

        int y = 1;

        while (true) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }

            egg.setPosY(egg.getPosY() + y);

            egg.getTexture().render();
            if (egg.getPosY() < 0 || egg.getPosY() > 280) {
                y *= -1;
            }

            System.out.println(egg.getPosY());
        }
    }
}
