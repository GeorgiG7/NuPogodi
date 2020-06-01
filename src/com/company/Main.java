package com.company;


import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Main {

    static int milis = 30;
    static Scanner input = new Scanner(System.in);
    static int iterationCounter = 0;
    static int score = 0;
    static int lives = 3;
    static Textures[] digitsTextures = new Textures[4];
    static Textures[] livesTextures = new Textures[4];

    public static void main(String[] args) {



        printOptions();

        int option = input.nextInt();
        chooseOption(option);

    }

    public static void chooseOption(int option) {
        switch (option) {
            case 1:
                runGame();
                break;
            case 2:
                break;
            case 3:
                System.exit(0);
                break;
        }
    }

    public static void runGame() {
        createDigitsAndLivesTexturesArray();

        Display.initInstance(600, 600, "Nancy");

        NuPogodi nuPogodi = new NuPogodi(4);
        Display.getInstance().addGraphic(nuPogodi.getTexture());

        fillAllTextures();

        Egg[] eggs = new Egg[20];
        eggs = fillingEggsArray(eggs);
        eggs = makeNewEggFallInRandomPosition(eggs);

        while (true) {

            iterationCounter++;

            delay(milis);

            oshteNeZnamIme(eggs, nuPogodi);

            if (iterationCounter == 50) {
                eggs = makeNewEggFallInRandomPosition(eggs);
                iterationCounter = 0;
                milis--;
            }

            if (lives == 0){
                break;
            }

            showScore();
            showLives();
        }

    }

    public static void printOptions() {
        System.out.println("Целта на играта НуПагади е да се съберат възможно най-много яца" +
                "без да се изпускат такива. При три изпуснати яйца, играта приключва");
        System.out.println("1.Играй \n2.Класация \n3.Изход");
    }

    public static Egg[] fillingEggsArray(Egg[] eggs) {
        for (int i = 0; i < eggs.length; i++) {
            eggs[i] = new Egg(5);
        }
        return eggs;
    }

    public static Egg[] makeNewEggFallInRandomPosition(Egg[] eggs) {
        int index = 0;

        for (int i = 0; i < eggs.length; i++) {
            if (eggs[i].getChickenNumber() == 5) {
                index = i;
                break;
            }
        }

        eggs[index].setChickenNumber(ThreadLocalRandom.current().nextInt(1, 5));

        return eggs;
    }

    public static void delay(int milis) {
        try {
            Thread.sleep(milis);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }

    public static void oshteNeZnamIme(Egg[] eggs, NuPogodi nuPogodi) {
        for (Egg egg : eggs) {
            if (egg.getChickenNumber() != 5) {
                egg.setPosY(egg.getPosY() + 1);
                egg.getTexture().render();

                if (egg.getPosY() == 225 && egg.getChickenNumber() == nuPogodi.getPosition()) {
                    score++;
                    egg.setChickenNumber(5);
                } else if (egg.getPosY() == 280) {
                    lives--;
                    egg.setChickenNumber(5);
                }
            }
        }
    }

    public static Textures[] createBackgroundTextures() {

        Textures[] textures = new Textures[6];

        textures[0] = new Textures(30, -1, 100, 80, "Resources\\chickenAnimated.png");
        textures[1] = new Textures(95, -1, 100, 80, "Resources\\chickenAnimated.png");
        textures[2] = new Textures(160, -1, 100, 80, "Resources\\chickenAnimated.png");
        textures[3] = new Textures(225, -1, 100, 80, "Resources\\chickenAnimated.png");
        textures[4] = new Textures(0, 220, 600, 150, "Resources\\grass.png");
        textures[5] = new Textures(0, 30, 600, 150, "Resources\\wood.png");

        return textures;

    }

    public static void fillTexturesInDisplay(Textures[] textures) {
        for (int i = 0; i < textures.length; i++) {
            if (textures[i] != null) {
                Display.getInstance().addGraphic(textures[i]);
            }
        }
    }

    public static void createDigitsAndLivesTexturesArray() {
        digitsTextures[0] = new Textures();
        digitsTextures[1] = new Textures();
        digitsTextures[2] = new Textures();
        digitsTextures[3] = new Textures();

        livesTextures[0] = new Textures();
        livesTextures[1] = new Textures();
        livesTextures[2] = new Textures();
        livesTextures[3] = new Textures();
    }

    public static void showScore() {
        int size = 20;

        for (int i = 0; i < digitsTextures.length; i++) {
            digitsTextures[i].setX(Display.getInstance().getWidth() / 2 - size - size * i - 20);
            digitsTextures[i].setY(120);
            digitsTextures[i].setWidth(size);
            digitsTextures[i].setHeight(size);
        }
        digitsTextures[0].setPath("Resources\\" + score % 10 + ".png");
        digitsTextures[1].setPath("Resources\\" + score / 10 % 10 + ".png");
        digitsTextures[2].setPath("Resources\\" + score / 100 % 10 + ".png");
        digitsTextures[3].setPath("Resources\\" + score / 1000 % 10 + ".png");
    }

    public static void showLives() {

        int size = 50;

        for (int i = 0; i < lives; i++) {
            livesTextures[i].setX(30 + i * 15);
            livesTextures[i].setY(120);
            livesTextures[i].setWidth(size);
            livesTextures[i].setHeight(size);
            livesTextures[i].setPath("Resources/heart.png");
        }

        for (int i = 3; i >= lives; i--) {
            livesTextures[i].setX(10000);
        }
    }

    public static void fillAllTextures() {
        createBackgroundTextures();
        fillTexturesInDisplay(createBackgroundTextures());
        fillTexturesInDisplay(digitsTextures);
        fillTexturesInDisplay(livesTextures);
    }

//    public static void showRecords() {
//        File file = new File("ScoreSheet");
//        Scanner fileReader = null;
//        try {
//            fileReader = new Scanner(file, "windows-1251");
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
//        assert fileReader != null;
//        while (fileReader.hasNextLine()) {
//            System.out.println("Line %d: %s%n");
//        }
//        fileReader.close();
//    }

//    public static void signInRecord() {
//        System.out.println("Моля запишете вашето име, за да запазим рекорда в класацията:");
//        PrintStream fileWriter = null;
//        try {
//            fileWriter = new PrintStream("ScoreSheet");
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
//        String name = input.next();
//        ArrayList<String> names = new ArrayList();
//        ArrayList<Integer>scores = new ArrayList();
//        scores.add(score);
//        names.add(name);
//        fileWriter.printf(names, scores);
//        fileWriter.close();
//    }

}
