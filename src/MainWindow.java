import java.awt.Component;
import javax.swing.JFrame;

public class MainWindow extends JFrame {
    MainWindow(int width, int height, Setup game) {
        JFrame jFrame = new JFrame();
        jFrame.setResizable(false);
        jFrame.add(game);
        jFrame.setTitle("M Haroon Khalid's Flappy bird");
        jFrame.setDefaultCloseOperation(3);
        jFrame.setSize(width, height);
        jFrame.setLocationRelativeTo((Component)null);
        jFrame.setResizable(false);
        jFrame.setVisible(true);
    }
}
