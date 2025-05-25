//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.awt.Graphics;
import java.awt.image.ImageObserver;
import javax.swing.ImageIcon;

public class Dragon extends ObjectOfGame {
    Dragon(int x, int y) {
        super(x, y);
        this.Image = (new ImageIcon("E:\\BSE-3A\\oop\\FlappyBirdGame\\asset For project\\enemy2.gif")).getImage();
        this.width = this.Image.getWidth((ImageObserver)null);
        this.height = this.Image.getHeight((ImageObserver)null);
    }

    public void moveUp() {
        this.dimX -= 3;
        this.dimY -= 2;
    }

    public void moveDown() {
        this.dimX -= 3;
        ++this.dimY;
    }

    public void fall() {
        this.dimX -= 4;
    }

    public void render(Graphics graphics, ImageObserver imageObserver) {
        graphics.drawImage(this.Image, this.dimX, this.dimY, imageObserver);
    }
}
