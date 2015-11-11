package model;

/**
 * Created by Katie on 11/3/2015.
 */
public class GameDifficulty {

    private int difficulty;

    public GameDifficulty() {
        difficulty = 1;  // default easy mode
    }

    public GameDifficulty(int level) {
        this.difficulty = level;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }
}
