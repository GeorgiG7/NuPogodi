package com.company;

import javax.swing.*;
import java.awt.*;
import java.util.concurrent.ThreadLocalRandom;

public class Main {

    public static void main(String[] args) {

        Display.initInstance(600, 600, "Nancy");

        JLayeredPane background = new JLayeredPane();
        background.setPreferredSize(new Dimension(600, 600));

        Egg[] eggs = new Egg[100];

        //Textures egg = new Textures(75, 30, 20, 20, "Resources\\egg.png");
        //Textures nuPogodi = new Textures(20, 190, 200, 200, "Resources\\NuPogodi.png");
        Textures chickenFirst = new Textures(30, -1, 100, 80, "Resources\\chickenAnimated.png");
        Textures chickenSecond = new Textures(95, -1, 100, 80, "Resources\\chickenAnimated.png");
        Textures chickenThird = new Textures(160, -1, 100, 80, "Resources\\chickenAnimated.png");
        Textures chickenForth = new Textures(225, -1, 100, 80, "Resources\\chickenAnimated.png");
        Textures grass = new Textures(0, 220, 600, 150, "Resources\\grass.png");
        Textures wood = new Textures(0, 30, 600, 150, "Resources\\wood.png");

        Egg egg = new Egg(4);
        eggs[0] = egg;
        NuPogodi nuPogodi1 = new NuPogodi(4);

//        Display.getInstance().addGraphic(grass);
//        Display.getInstance().addGraphic(wood);
//        Display.getInstance().addGraphic(egg.getTexture());
//        Display.getInstance().addGraphic(nuPogodi1.getTexture());
//        Display.getInstance().addGraphic(chickenFirst);
//        Display.getInstance().addGraphic(chickenForth);
//        Display.getInstance().addGraphic(chickenSecond);
//        Display.getInstance().addGraphic(chickenThird);
//        Display.getInstance().addGraphic(wood);
//        Display.getInstance().addGraphic(grass);

        int y = 5;

        int iterationsCounter = 0;

        Display.getInstance().addGraphic(wood);
        Display.getInstance().addGraphic(egg.getTexture());
        Display.getInstance().addGraphic(nuPogodi1.getTexture());
        Display.getInstance().addGraphic(chickenFirst);
        Display.getInstance().addGraphic(chickenForth);
        Display.getInstance().addGraphic(chickenSecond);
        Display.getInstance().addGraphic(chickenThird);
        Display.getInstance().addGraphic(wood);
        Display.getInstance().addGraphic(grass);

        int score = 0;

        while (true) {
            iterationsCounter++;

            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }

            for (int i = 0; i < eggs.length; i++) {
                if (eggs[i] != null){
                    eggs[i].setPosY(eggs[i].getPosY() + y);
                    eggs[i].getTexture().render();
                    if (eggs[i].getPosY() == 225 && eggs[i].getChickenNumber() == nuPogodi1.getPosition()) {
                        score++;
                        Display.getInstance().removeGraphic(getComponentIndex(eggs[i].getTexture()));
                        eggs[i] = null;
                    } else if (eggs[i].getPosY() > 280){
                        Display.getInstance().removeGraphic(getComponentIndex(eggs[i].getTexture()));
                        eggs[i] = null;
                    }
                }
            }

            //egg.setPosY(egg.getPosY() + y);

            //egg.getTexture().render();
//            if (egg.getPosY() < 25 || egg.getPosY() > 225) {
//                y *= -1;
//            }

            if (iterationsCounter == 20) {
                eggs = addEggsByRandomPosition(eggs);
                iterationsCounter = 0;
                nuPogodi1.setPosition(ThreadLocalRandom.current().nextInt(1, 5));
                nuPogodi1.getTexture().render();
            }
//            System.out.print(egg.getPosY());
//            System.out.println("   " + getLastNotEmptyIndexOfArray(eggs) + "   " + score);

        }

    }

    public static int getFirstEmptyIndexOfArray(Egg[] eggs) {

        int openArray = 0;

        for (int i = 0; i < eggs.length; i++) {
            if (eggs[i] == null) {
                openArray = i;
                break;
            }
        }
        return openArray;
    }

    public static Egg[] addEggsByRandomPosition(Egg[] eggs) {
        int firstEmptyIndex = getFirstEmptyIndexOfArray(eggs) + 1;

        int randomNum = ThreadLocalRandom.current().nextInt(1, 5);
        eggs[firstEmptyIndex] = new Egg(randomNum);
        Display.getInstance().addGraphic(eggs[firstEmptyIndex].getTexture());

        return eggs;
    }

    public static int getComponentIndex(Component component) {
        if (component != null && component.getParent() != null) {
            Container c = component.getParent();
            for (int i = 0; i < c.getComponentCount(); i++) {
                if (c.getComponent(i) == component)
                    return i;
            }
        }

        return -1;
    }
}
