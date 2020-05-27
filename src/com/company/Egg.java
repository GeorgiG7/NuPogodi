package com.company;

public class Egg {

    private int posX;
    private int posY;
    private int width;
    private int height;
    private String path;
    private Textures texture;

    public Egg(int posX, int posY, int width, int height, String path) {
        this.posX = posX;
        this.posY = posY;
        this.width = width;
        this.height = height;
        this.path = path;
        this.texture = new Textures(posX, posY, width, height, path);
    }
}
