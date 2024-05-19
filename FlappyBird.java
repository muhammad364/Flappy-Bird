import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

abstract class ObjectOfGame {

    ObjectOfGame(int x1, int y1) {
        this.x = x1;
        this.y = y1;
    }

    ObjectOfGame(int x1, int y1, double s) {
        this.x = x1;
        this.y = y1;
        this.speedX = s;
    }

    protected int x;
    protected int height;
    protected int width;
    protected int y;
    protected double speedX;
    protected int speedY;
    protected Image Image;

    public void setX(int x) {
        this.x = x;
    }

    public int getX() {
        return x;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getHeight() {
        return height;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getWidth() {
        return width;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getY() {
        return y;
    }

    public void setSpeedX(int speedX) {
        this.speedX = speedX;
    }

    public double getSpeedX() {
        return speedX;
    }

    public void setSpeedY(int speedY) {
        this.speedY = speedY;
    }

    public int getSpeedY() {
        return speedY;
    }

    public void setImage(Image image) {
        this.Image = image;
    }

    public Image getImage() {
        return Image;
    }

    public void tick() {
        // Implementation of the tick method
    }

    public void render(Graphics g, ImageObserver a) {
        // Implementation of the render method
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, width, height);
    }

}

public class FlappyBird extends ObjectOfGame {


    FlappyBird(int x,int y,Image I){
        super(x,y);

        Image=I;
        width=Image.getWidth(null);
        height=Image.getHeight(null);
        speedY=2;
    }
    public  void tick(){
        if(speedY<3){
            speedY+=2;
        }

        this.y=this.y+speedY;

    }
    public void jump(){
        speedY+=-20;

    }


    public void render(Graphics g, ImageObserver a){
        g.drawImage(Image,x,y,a);
    }
}

class enemy extends ObjectOfGame{

    enemy(int x1, int y1) {
        super(x1, y1);
        this.Image= new ImageIcon("E:\\ZainFlappyBird\\src\\asset For project\\enemy2.gif").getImage();
        this.height=Image.getHeight(null);
        this.width=Image.getWidth(null);
    }
    public void tickup(){
        this.x-=9;
        this.y-=5;
    }
    public void tickdown(){
        this.x-=9;
        this.y+=3;
    }
    public void tick(){
        this.x-=9;
    }
    public void render(Graphics g, ImageObserver a){
        g.drawImage(Image,x,y,a);
    }


}

class Obstacle extends ObjectOfGame{

    boolean super2=false;

    Obstacle(int x,int y,double s){
        super(x,y,s);
        Image =new ImageIcon("E:\\ZainFlappyBird\\src\\asset For project\\TubeBody0.jpg").getImage();
        this.width=Image.getWidth(null);
        this.height=Image.getHeight(null);

    }
    public void superPower(){
        if(this.getY()<250){
            this.y-=5;
        }
        if(this.getY()>250){
            this.y+=5;
        }
    }

    @Override
    public void tick() {

        if(super2){
            x-=3;
        }
        else{
            x-=speedX;
        }
    }

    @Override
    public void render(Graphics g, ImageObserver a) {
        g.drawImage(Image,x,y,a);

    }
}

class ObstacleGroup {
    private List<Obstacle> Obstacle;
    private int base=500;
    private Random random;
    private int point=0;
    private double current_Speed=7;
    private boolean super1=false;

    ObstacleGroup(){
        Obstacle=new ArrayList<>();
        random=new Random();

        MakeBunch();


    }

    public void setSuper1(Boolean flag) {
        this.super1=flag;
    }

    public List<Obstacle> getObstacle() {
        return Obstacle;
    }

    public void MakeBunch() {
        int base1=base;

        int temp = random.nextInt(7) + 2;

        for (int i = 0; i < 15; i++) {

            Obstacle o = new Obstacle(900, base1,current_Speed);


            base1 = o.getY() - o.getHeight();

            if (i < temp || i > temp + 4) {
                if(!super1  || (super1 && !(o.getY()>200 && o.getY()<300))){
                    Obstacle.add(o);
                }

            }

        }}
    public void TickBunch() {
        for (int i = 0; i < Obstacle.size(); i++) {
            Obstacle.get(i).tick();
            if((point-4)%10==0){
                super1=false;
            }
            if(super1 && getObstacles().get(i).getX()<450){

                Obstacle.get(i).superPower();
            }


            if (Obstacle.get(i).getX() <= 0) {
                Obstacle.remove(Obstacle.get(i));
            }
        }

        if (Obstacle.isEmpty()) {
            current_Speed+=0.10;

            point += 1;
            MakeBunch();
        }


    }
    public void render(Graphics g, ImageObserver a) {
        for (int i = 0; i < Obstacle.size(); i++) {
            Obstacle.get(i).render(g, a);
        }
    }

    public int getPoint() {
        return point;
    }
    public void increment(){
        this.point+=1;
    }
    // Accessor for obstacles list
    public List<Obstacle> getObstacles() {
        return Obstacle;
    }
}

class DataOfUser implements Serializable {

    int Score;

    DataOfUser(int High){

        Score=High;
    }
    public String toString(){
        return Integer.toString(Score);
    }
    public int getScore(){
        return Score;
    }



    public void setScore(int highScore) {
        Score = highScore;
    }
}
