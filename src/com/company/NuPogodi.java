package com.company;

public class NuPogodi {

    private int posX;
    private int posY;
    private String texturePath;
    private int position;
    private Textures texture;

    public NuPogodi(int position) {
        this.position = position;
        setCoordinatesAndTextureByNumberOfChicken(position);
        this.texture = new Textures(this.posX, this.posY, 200, 200, this.texturePath);
    }

    public Textures getTexture() {
        return texture;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    private void setCoordinatesAndTextureByNumberOfChicken(int numberOfChicken) {
        switch (numberOfChicken) {
            case 1:
                this.posY = 190;
                this.posX = 16;
                this.texturePath = "Resources\\NuPogodiFlipped.png";
                break;
            case 2:
                this.posX = 82;
                this.posY = 190;
                this.texturePath = "Resources\\NuPogodiFlipped.png";
                break;
            case 3:
                this.posX = 111;
                this.posY = 190;
                this.texturePath = "Resources\\NuPogodi.png";
                break;
            case 4:
                this.posX = 176;
                this.posY = 190;
                this.texturePath = "Resources\\NuPogodi.png";
                break;
        }
    }
}
