//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.awt.Graphics;
import java.awt.image.ImageObserver;
import javax.swing.ImageIcon;

public class Obstacle extends ObjectOfGame {
    boolean super2 = false;

    Obstacle(int x, int y, double speed) {
        super(x, y, speed);
        this.Image = (new ImageIcon("E:\\BSE-3A\\oop\\FlappyBirdGame\\asset For project\\TubeBody0.jpg")).getImage();
        this.width = this.Image.getWidth((ImageObserver)null);
        this.height = this.Image.getHeight((ImageObserver)null);
    }

    public void superPower() {
        if (this.getDimY() < 250) {
            this.dimY -= 5;
        } else if (this.dimY > 250) {
            this.dimY += 5;
        }

    }

    public void fall() {
        if (this.super2) {
            --this.dimX;
        } else {
            this.dimX = (int)((double)this.dimX - this.speedX);
        }

    }

    public void render(Graphics graphics, ImageObserver imageObserver) {
        graphics.drawImage(this.Image, this.dimX, this.dimY, imageObserver);
    }
}
