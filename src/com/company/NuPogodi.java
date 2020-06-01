package com.company;

import java.awt.*;
import java.awt.event.KeyEvent;

public class NuPogodi {

    private int posX;
    private int posY;
    private String texturePath;
    private int position;
    private Textures texture;

    public NuPogodi(int position) {
        KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(keyEventDispatcher);
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

    public void updateTexture() {
        this.texture.setX(this.posX);
        this.texture.setY(this.posY);
        this.texture.setPath(this.texturePath);
        this.texture.render();
    }

    public void setCoordinatesAndTextureByNumberOfChicken(int numberOfChicken) {
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

    KeyEventDispatcher keyEventDispatcher = new KeyEventDispatcher() {
        @Override
        public boolean dispatchKeyEvent(KeyEvent e) {
            if (e.getID() == KeyEvent.KEY_PRESSED) {
                if (e.getKeyCode() == KeyEvent.VK_A) {
                    position -= position==1?0: 1;
                    setCoordinatesAndTextureByNumberOfChicken(position);
                    updateTexture();
                }
                if (e.getKeyCode() == KeyEvent.VK_D) {
                    position += position==4?0: 1;
                    setCoordinatesAndTextureByNumberOfChicken(position);
                    updateTexture();
                }
            }
            return false;
        }
    };
}
