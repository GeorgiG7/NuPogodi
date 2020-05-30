package com.company;

public class Egg {

    private int posX;
    private int posY;
    private int chickenNumber;
    private String path;
    private Textures texture;

    public Egg(int chickenNumber) {
        this.chickenNumber = chickenNumber;
        setCoordinatesByNumberOfChicken(chickenNumber);
        this.texture = new Textures(this.posX, this.posY, 25, 25, "Resources\\egg1.png");
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public int getPosY() {
        return posY;
    }

    public int getChickenNumber() {
        return chickenNumber;
    }

    public Textures getTexture() {
        updateTexture();
        return texture;
    }

    public void updateTexture() {
        this.texture.setX(this.posX);
        this.texture.setY(this.posY);
    }

    private void setCoordinatesByNumberOfChicken(int numberOfChicken) {
        switch (numberOfChicken) {
            case 1:
                this.posY = 25;
                this.posX = 46;
                break;
            case 2:
                this.posX = 113;
                this.posY = 25;
                break;
            case 3:
                this.posX = 177;
                this.posY = 25;
                break;
            case 4:
                this.posX = 242;
                this.posY = 25;
                break;
        }
    }
}
