//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MainMenu extends JFrame implements ActionListener {
    private ImageIcon background = new ImageIcon("E:\\BSE-3A\\oop\\FlappyBirdGame\\asset For project\\final2.png");
    private JPanel panel;
    private JButton startGame = new JButton();
    JButton exit = new JButton();

    MainMenu() {
        JLabel jLabel = new JLabel(this.background);
        jLabel.setBounds(0, 0, 600, 445);
        this.add(jLabel);
        this.startGame.addActionListener(this);
        this.exit.addActionListener(this);
        this.panel = new JPanel(new FlowLayout(1));
        this.startGame.setBounds(210, 250, 180, 90);
        this.startGame.setOpaque(false);
        this.exit.setBounds(205, 360, 175, 100);
        this.exit.setOpaque(false);
        this.panel.setBounds(0, 100, 600, 150);
        this.panel.add(this.startGame);
        this.panel.add(this.exit);
        this.panel.setOpaque(false);
        this.panel.setLayout((LayoutManager)null);
        this.add(this.panel);
        this.setDefaultCloseOperation(3);
        this.setTitle("Main Menu");
        this.setSize(600, 460);
        this.setVisible(true);
        this.startGame.requestFocus();
        this.setLocationRelativeTo((Component)null);
        this.exit.requestFocus();
    }

    public void actionPerformed(ActionEvent actionEvent) {
        if (actionEvent.getSource() == this.startGame) {
            Setup game = null;

            try {
                game = new Setup();
            } catch (UnsupportedAudioFileException var4) {
                throw new RuntimeException(var4);
            } catch (IOException var5) {
                throw new RuntimeException(var5);
            } catch (LineUnavailableException var6) {
                throw new RuntimeException(var6);
            }

            new MainWindow(700, 500, game);
        }

        if (actionEvent.getActionCommand().equals("Confirm")) {
            this.dispose();
        } else if (actionEvent.getSource() == this.exit) {
            this.dispose();
        }

    }
}
