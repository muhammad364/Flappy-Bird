import java.io.Serializable;

public class DataOfUser implements Serializable {
    int gameScore;

    DataOfUser(int score) {
        this.gameScore = score;
    }

    public String toString() {
        return Integer.toString(this.gameScore);
    }

    public int getScore() {
        return this.gameScore;
    }

    public void setScore(int score) {
        this.gameScore = score;
    }
}
