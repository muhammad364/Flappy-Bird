//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.ImageObserver;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Random;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Setup extends JPanel implements ActionListener {
    private Bird bird;
    private ObstacleGroup obstacleGroup;
    private Image Background;
    private Timer time;
    private boolean Running = false;
    private Graphics g;
    private Image background1;
    private Image background2;
    private boolean danger = false;
    private int Highscore = 0;
    private Boolean flag = true;
    private boolean superPower = false;
    boolean ak = false;
    private DataOfUser d1;
    private Image b1 = (new ImageIcon("E:\\BSE-3A\\oop\\FlappyBirdGame\\asset For project\\bird5.gif")).getImage();
    private Image b2 = (new ImageIcon("E:\\BSE-3A\\oop\\FlappyBirdGame\\asset For project\\birdR5.gif")).getImage();
    private boolean pause = false;
    private boolean playedOnce = false;
    private Audio jump = new Audio("E:\\BSE-3A\\oop\\FlappyBirdGame\\asset For project\\jumpBird.wav");
    private Audio die = new Audio("E:\\BSE-3A\\oop\\FlappyBirdGame\\asset For project\\die1.wav");
    private Dragon dragon;
    private boolean made = false;
    private int flagE;

    Setup() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        this.d1 = new DataOfUser(this.Highscore);
        this.background1 = (new ImageIcon("E:\\BSE-3A\\oop\\FlappyBirdGame\\asset For project\\b2.jpg")).getImage();
        this.background2 = (new ImageIcon("E:\\BSE-3A\\oop\\FlappyBirdGame\\asset For project\\dangerB.jpg")).getImage();
        this.Background = (new ImageIcon("E:\\BSE-3A\\oop\\FlappyBirdGame\\asset For project\\b1.jpg")).getImage();
        this.setFocusable(true);
        this.addKeyListener(new GameKeyAdapter());
        this.time = new Timer(5, this);
        this.time.start();
    }

    public void paint(Graphics g) {
        if (this.danger) {
            g.setColor(Color.white);
            g.drawImage(this.background2, 0, 0, (ImageObserver)null);
        } else if (!this.superPower) {
            g.setColor(Color.BLACK);
            g.drawImage(this.Background, 0, 0, (ImageObserver)null);
        } else {
            g.setColor(Color.white);
            g.drawImage(this.background1, 0, 0, (ImageObserver)null);
        }

        g.setFont(new Font("Arial", 1, 14));
        if (this.Running) {
            g.drawString("Highest Score:" + this.Highscore, 550, 20);
            g.setFont(new Font("Arial", 2, 13));
            if (!this.pause) {
                g.setFont(new Font("Arial", 1, 15));
                g.drawString("Enter SHIFT to pause", 250, 20);
            } else {
                g.setFont(new Font("Arial", 2, 20));
                g.drawString("Press Enter to resume", 250, 250);
            }

            this.bird.render(g, this);
            if (this.obstacleGroup.getPoint() < 30 || this.obstacleGroup.getPoint() > 37 && this.obstacleGroup.getPoint() < 60 || this.obstacleGroup.getPoint() > 67 && this.obstacleGroup.getPoint() < 90 || this.obstacleGroup.getPoint() > 97) {
                this.obstacleGroup.render(g, (ImageObserver)null);
                if (((Obstacle)this.obstacleGroup.getObstacles().get(0)).getDimX() < 15) {
                    g.setFont(new Font("Arial", 1, 15));
                    g.drawString("+1", this.bird.getDimX(), this.bird.getDimY());
                }
            }

            if (this.obstacleGroup.getPoint() >= 30 && this.obstacleGroup.getPoint() <= 37 || this.obstacleGroup.getPoint() >= 60 && this.obstacleGroup.getPoint() <= 67 || this.obstacleGroup.getPoint() >= 90 && this.obstacleGroup.getPoint() <= 97) {
                g.setFont(new Font("Arial", 1, 20));
                this.ak = !this.ak;
                if (this.ak) {
                    g.drawString("Danger Mode ON", 250, 400);
                }

                if (this.obstacleGroup.getPoint() % 30 != 0 && this.dragon.getDimX() > 10) {
                    this.dragon.render(g, this);
                    if (this.dragon.getDimX() < 15 || this.dragon.getDimX() > 700 && this.obstacleGroup.getPoint() % 30 != 0) {
                        g.setFont(new Font("Arial", 1, 15));
                        g.drawString("+1", this.bird.getDimX(), this.bird.getDimY());
                    }
                }
            }

            g.setFont(new Font("Arial", 1, 13));
            g.drawString("Your Score:" + this.obstacleGroup.getPoint(), 5, 20);
            if (this.superPower) {
                this.obstacleGroup.setSuper1(true);
                g.setFont(new Font("Arial", 1, 20));
                g.drawString("SUPER POWER ACTIVE ", 250, 400);
            } else if (((this.obstacleGroup.getPoint() - 4) % 10 == 0 || (this.obstacleGroup.getPoint() - 5) % 10 == 0) && this.obstacleGroup.getPoint() != 4 && this.obstacleGroup.getPoint() != 5 && this.obstacleGroup.getPoint() % 10 == 0 && this.obstacleGroup.getPoint() != 0 && (this.obstacleGroup.getPoint() < 30 || this.obstacleGroup.getPoint() > 37 && this.obstacleGroup.getPoint() < 60 || this.obstacleGroup.getPoint() > 67 && this.obstacleGroup.getPoint() < 90 || this.obstacleGroup.getPoint() > 97)) {
                this.ak = !this.ak;
                if (this.ak) {
                    g.setFont(new Font("Arial", 1, 18));
                    g.drawString("SUPER POWER DE-ACTIVATING ", 200, 400);
                }
            }
        } else {
            if (this.playedOnce) {
                g.setFont(new Font("Arial", 1, 25));
                g.drawString("Your Score: " + this.obstacleGroup.getPoint(), 250, 100);
            }

            if (!this.flag) {
                g.setFont(new Font("Arial", 1, 14));
                g.drawString("Enter 1 to Select this bird", 100, 200);
                g.drawImage(this.b1, 300, 200, (ImageObserver)null);
                g.drawString("Enter 2 to Select this bird", 100, 300);
                g.drawImage(this.b2, 300, 300, (ImageObserver)null);
            } else {
                g.setFont(new Font("Arial", 1, 20));
                g.drawString("Press Enter to Start the Game", 200, 250);
            }
        }

        g.setFont(new Font("Arial", 2, 13));
        g.drawString("By: Haroon Khalid (SP23-BSE-033)", 350, 450);
    }

    public void CheckDown() throws InterruptedException, UnsupportedAudioFileException, LineUnavailableException, IOException {
        if (this.obstacleGroup.getPoint() % 10 == 0 && this.obstacleGroup.getPoint() != 0 && (this.obstacleGroup.getPoint() < 30 || this.obstacleGroup.getPoint() > 37 && this.obstacleGroup.getPoint() < 60 || this.obstacleGroup.getPoint() > 67 && this.obstacleGroup.getPoint() < 90 || this.obstacleGroup.getPoint() > 97)) {
            this.superPower = true;
        }

        if (this.bird.getDimY() < 0 || this.bird.getDimY() > 468) {
            this.GameOver();
        }

    }

    public void restart() throws IOException, ClassNotFoundException {
        this.Running = true;
        this.obstacleGroup = new ObstacleGroup();
        this.superPower = false;
        FileInputStream file = new FileInputStream("E:\\OOP_Content\\OOPSemesterProject\\src\\HighScoreData.txt");
        ObjectInputStream object = new ObjectInputStream(file);
        DataOfUser d1 = (DataOfUser)object.readObject();
        this.Highscore = d1.getScore();
    }

    public void GameOver() throws InterruptedException, UnsupportedAudioFileException, LineUnavailableException, IOException {
        this.playedOnce = true;
        this.Running = false;
        this.flag = true;
        this.made = false;
        this.die.start();
        this.d1.setScore(this.obstacleGroup.getPoint());
        if (this.obstacleGroup.getPoint() > this.Highscore) {
            try {
                FileOutputStream fileOutputStream = new FileOutputStream("E:\\OOP_Content\\OOPSemesterProject\\src\\HighScoreData.txt");
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
                objectOutputStream.writeObject(this.d1);
                objectOutputStream.close();
                fileOutputStream.close();
            } catch (IOException var3) {
                System.out.println(var3.getMessage());
                var3.printStackTrace();
            }
        }

    }

    public void actionPerformed(ActionEvent e) {
        if (!this.pause) {
            if (this.Running) {
                this.bird.fall();
                if (this.obstacleGroup.getPoint() >= 30 && (this.obstacleGroup.getPoint() <= 37 || this.obstacleGroup.getPoint() >= 60) && (this.obstacleGroup.getPoint() <= 67 || this.obstacleGroup.getPoint() >= 90) && this.obstacleGroup.getPoint() <= 97) {
                    this.danger = true;
                    if ((this.obstacleGroup.getPoint() >= 30 && this.obstacleGroup.getPoint() <= 37 || this.obstacleGroup.getPoint() >= 60 && this.obstacleGroup.getPoint() <= 67 || this.obstacleGroup.getPoint() >= 90 && this.obstacleGroup.getPoint() <= 97) && !this.made) {
                        Random r1 = new Random();
                        int p = r1.nextInt(3);
                        if (p == 0) {
                            this.dragon = new Dragon(900, -100);
                            this.flagE = 0;
                        } else if (p == 1) {
                            this.dragon = new Dragon(900, 600);
                            this.flagE = 1;
                        } else {
                            this.dragon = new Dragon(900, 200);
                            this.flagE = 2;
                        }

                        this.made = true;
                    }

                    if (this.made) {
                        if (this.flagE == 0) {
                            this.dragon.moveDown();
                            if (this.dragon.getDimX() <= 0) {
                                this.made = false;
                                this.obstacleGroup.increment();
                            }
                        } else if (this.flagE == 1) {
                            this.dragon.moveUp();
                            if (this.dragon.getDimX() <= 0) {
                                this.made = false;
                                this.obstacleGroup.increment();
                            }
                        } else {
                            this.dragon.fall();
                            if (this.dragon.getDimX() <= 0) {
                                this.made = false;
                                this.obstacleGroup.increment();
                            }
                        }

                        try {
                            if (this.obstacleGroup.getPoint() % 30 != 0) {
                                this.checkCollisionE();
                            }
                        } catch (UnsupportedAudioFileException var5) {
                            throw new RuntimeException(var5);
                        } catch (LineUnavailableException var6) {
                            throw new RuntimeException(var6);
                        } catch (IOException var7) {
                            throw new RuntimeException(var7);
                        } catch (InterruptedException var8) {
                            throw new RuntimeException(var8);
                        }
                    }
                } else {
                    this.danger = false;
                    this.obstacleGroup.moveBunch();

                    try {
                        this.checkCollision();
                    } catch (UnsupportedAudioFileException | LineUnavailableException | IOException | InterruptedException var9) {
                        throw new RuntimeException(var9);
                    }
                }

                if ((this.obstacleGroup.getPoint() - 4) % 10 == 0 && this.obstacleGroup.getPoint() != 4 && (this.obstacleGroup.getPoint() < 30 || this.obstacleGroup.getPoint() > 37 && this.obstacleGroup.getPoint() < 60 || this.obstacleGroup.getPoint() > 67 && this.obstacleGroup.getPoint() < 90 || this.obstacleGroup.getPoint() > 97)) {
                    this.superPower = false;
                }

                try {
                    this.CheckDown();
                } catch (UnsupportedAudioFileException | LineUnavailableException | IOException | InterruptedException var4) {
                    throw new RuntimeException(var4);
                }
            }

            this.repaint();
        }

    }

    public void checkCollision() throws InterruptedException, UnsupportedAudioFileException, LineUnavailableException, IOException {
        Rectangle r1 = this.bird.getBounds();

        for(int i = 0; i < this.obstacleGroup.getObstacles().size(); ++i) {
            Rectangle r2 = ((Obstacle)this.obstacleGroup.getObstacles().get(i)).getBounds();
            if (r2.intersects(r1)) {
                this.GameOver();
            }
        }

    }

    public void checkCollisionE() throws UnsupportedAudioFileException, LineUnavailableException, IOException, InterruptedException {
        Rectangle r1 = this.dragon.getBounds();
        Rectangle r2 = this.bird.getBounds();
        if (r2.intersects(r1)) {
            this.GameOver();
        }

    }

    private class GameKeyAdapter extends KeyAdapter {
        private GameKeyAdapter() {
        }

        public void keyPressed(KeyEvent e) {
            if ((!Setup.this.Running || Setup.this.pause) && e.getKeyCode() == 10) {
                Setup.this.flag = false;
                Setup.this.pause = false;
            }

            if (Setup.this.Running && e.getKeyCode() == 32) {
                Setup.this.jump.start();
                Setup.this.bird.jump();
            }

            if (e.getKeyCode() == 16) {
                Setup.this.pause = true;
            }

            if (!Setup.this.Running) {
                if (e.getKeyCode() == 49) {
                    Setup.this.bird = new Bird(200, 100, Setup.this.b1);
                    Setup.this.flag = true;

                    try {
                        Setup.this.restart();
                    } catch (IOException var5) {
                        throw new RuntimeException(var5);
                    } catch (ClassNotFoundException var6) {
                        throw new RuntimeException(var6);
                    }
                }

                if (e.getKeyCode() == 50) {
                    Setup.this.bird = new Bird(200, 100, Setup.this.b2);
                    Setup.this.flag = true;

                    try {
                        Setup.this.Running = true;
                        Setup.this.restart();
                    } catch (IOException var3) {
                        throw new RuntimeException(var3);
                    } catch (ClassNotFoundException var4) {
                        throw new RuntimeException(var4);
                    }
                }
            }

        }

        public void keyReleased(KeyEvent e) {
        }
    }
}
