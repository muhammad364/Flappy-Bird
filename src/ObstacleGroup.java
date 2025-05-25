//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.awt.Graphics;
import java.awt.image.ImageObserver;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ObstacleGroup {
    private List<Obstacle> obstacles = new ArrayList();
    private int base = 500;
    private Random random = new Random();
    private int point = 0;
    private double currentSpeed = 2.5;
    private boolean super1 = false;

    ObstacleGroup() {
        this.makeBunch();
    }

    public void setSuper1(boolean flag) {
        this.super1 = flag;
    }

    public void makeBunch() {
        int base1 = this.base;
        int temp = this.random.nextInt(7) + 2;

        for(int i = 0; i < 15; ++i) {
            Obstacle obstacle = new Obstacle(900, base1, this.currentSpeed);
            base1 = obstacle.getDimY() - obstacle.getHeight();
            if ((i < temp || i > temp + 4) && (!this.super1 || this.super1 && (obstacle.getDimY() <= 200 || obstacle.getDimY() >= 300))) {
                this.obstacles.add(obstacle);
            }
        }

    }

    public void moveBunch() {
        for(int i = 0; i < this.obstacles.size(); ++i) {
            ((Obstacle)this.obstacles.get(i)).fall();
            if ((this.point - 4) % 10 == 0) {
                this.super1 = false;
            }

            if (this.super1 && ((Obstacle)this.getObstacles().get(i)).dimX < 450) {
                ((Obstacle)this.obstacles.get(i)).superPower();
            }

            if (((Obstacle)this.obstacles.get(i)).getDimX() <= 0) {
                this.obstacles.remove(this.obstacles.get(i));
            }
        }

        if (this.obstacles.isEmpty()) {
            this.currentSpeed += 0.05;
            this.point += 5;
            this.makeBunch();
        }

    }

    public void render(Graphics graphics, ImageObserver imageObserver) {
        for(int i = 0; i < this.obstacles.size(); ++i) {
            ((Obstacle)this.obstacles.get(i)).render(graphics, imageObserver);
        }

    }

    public int getPoint() {
        return this.point;
    }

    public void increment() {
        ++this.point;
    }

    public List<Obstacle> getObstacles() {
        return this.obstacles;
    }
}
