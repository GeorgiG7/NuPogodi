package com.company;

public class Egg {

    private int posX;
    private int posY;
    private String path;
    private Textures texture;

    public Egg(int posX, int posY, int width, int height, String path) {
        this.posX = posX;
        this.posY = posY;
        this.texture = new Textures(posX, posY, width, height, path);
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public int getPosY() {
        return posY;
    }

    public Textures getTexture() {
        updateTexture();
        return texture;
    }

    public void updateTexture(){
        this.texture.setX(this.posX);
        this.texture.setY(this.posY);
    }
}
