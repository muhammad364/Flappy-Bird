//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.image.ImageObserver;

public abstract class ObjectOfGame {
    protected int dimX;
    protected int dimY;
    protected int height;
    protected int width;
    protected double speedX;
    protected int speedY;
    protected Image Image;

    public ObjectOfGame(int x, int y) {
        this.dimX = x;
        this.dimY = y;
    }

    public ObjectOfGame(int x, int y, double speed) {
        this.dimX = x;
        this.dimY = y;
        this.speedX = speed;
    }

    public void setDimX(int x) {
        this.dimX = x;
    }

    public int getDimX() {
        return this.dimX;
    }

    public void setDimY(int y) {
        this.dimY = y;
    }

    public int getDimY() {
        return this.dimY;
    }

    public void setSpeedX(double speedX1) {
        this.speedX = speedX1;
    }

    public double getSpeedX() {
        return this.speedX;
    }

    public void setSpeedY(int speedY1) {
        this.speedY = speedY1;
    }

    public int getSpeedY() {
        return this.speedY;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getHeight() {
        return this.height;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getWidth() {
        return this.width;
    }

    public void setImage(Image image) {
        this.Image = image;
    }

    public Image getImage() {
        return this.Image;
    }

    public void fall() {
    }

    public void render(Graphics g, ImageObserver a) {
    }

    public Rectangle getBounds() {
        return new Rectangle(this.dimX, this.dimY, this.width, this.height);
    }
}
