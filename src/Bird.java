//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.ImageObserver;

public class Bird extends ObjectOfGame {
    Bird(int x, int y, Image I) {
        super(x, y);
        this.Image = I;
        this.width = this.Image.getWidth((ImageObserver)null);
        this.height = this.Image.getHeight((ImageObserver)null);
        this.speedY = 2;
    }

    public void fall() {
        if (this.speedY < 3) {
            ++this.speedY;
        }

        this.dimY += this.speedY;
    }

    public void jump() {
        this.speedY += -17;
    }

    public void render(Graphics graphics, ImageObserver imageObserver) {
        graphics.drawImage(this.Image, this.dimX, this.dimY, imageObserver);
    }
}
