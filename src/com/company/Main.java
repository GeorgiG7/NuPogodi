package com.company;

import javax.swing.*;
import java.awt.*;
import java.util.concurrent.ThreadLocalRandom;

public class Main {

    public static void main(String[] args) {

        Display.initInstance(600, 600, "Nancy");


        //Textures egg = new Textures(75, 30, 20, 20, "Resources\\egg.png");
        //Textures nuPogodi = new Textures(20, 190, 200, 200, "Resources\\NuPogodi.png");
        Textures chickenFirst = new Textures(30, -1, 100, 80, "Resources\\chickenAnimated.png");
        Textures chickenSecond = new Textures(95, -1, 100, 80, "Resources\\chickenAnimated.png");
        Textures chickenThird = new Textures(160, -1, 100, 80, "Resources\\chickenAnimated.png");
        Textures chickenForth = new Textures(225, -1, 100, 80, "Resources\\chickenAnimated.png");
        Textures grass = new Textures(0, 220, 600, 150, "Resources\\grass.png");
        Textures wood = new Textures(0, 30, 600, 150, "Resources\\wood.png");

        NuPogodi nuPogodi1 = new NuPogodi(4);


        Display.getInstance().addGraphic(wood);
        Display.getInstance().addGraphic(nuPogodi1.getTexture());
        Display.getInstance().addGraphic(chickenFirst);
        Display.getInstance().addGraphic(chickenForth);
        Display.getInstance().addGraphic(chickenSecond);
        Display.getInstance().addGraphic(chickenThird);
        Display.getInstance().addGraphic(wood);
        Display.getInstance().addGraphic(grass);




        Egg[] eggs = new Egg[20];
        eggs = fillingEggsArray(eggs);


        while (true) {

            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }

            qq

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

    public static Egg[] fillingEggsArray(Egg[] eggs){
        for (int i = 0; i < eggs.length; i++) {
            eggs[i] = new Egg(5);
        }
        return eggs;
    }

}
