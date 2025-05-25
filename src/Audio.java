//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.io.File;
import java.io.IOException;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Audio {
    private Clip clip;

    Audio(String a) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        File audioFile = new File(a);
        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(audioFile);
        this.clip = AudioSystem.getClip();
        this.clip.open(audioInputStream);
    }

    public void start() {
        this.clip.setMicrosecondPosition(0L);
        this.clip.start();
    }
}
