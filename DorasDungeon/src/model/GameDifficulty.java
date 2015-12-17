package model;

/**
 * Created by Katie on 11/3/2015.
 */
public class GameDifficulty {

    private int difficulty;
    private int turns;

    public GameDifficulty() {
        difficulty = 1;  // default easy mode
        turns = 100;
    }

    public GameDifficulty(int level) {
        this.difficulty = level;
        turns = 130 - (difficulty * 30);
    }

    public int getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
        turns = 130 - (difficulty * 30);
    }
   
    public int getTurns()
    {
        return turns;
    }
}
