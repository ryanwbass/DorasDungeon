package model;

/**
 * Created by Katie on 11/3/2015.
 */
public class GameDifficulty {

    private int difficulty;
    private int time;

    public GameDifficulty() {
        difficulty = 1;  // default easy mode
        time = 60;
    }

    public GameDifficulty(int level) {
        this.difficulty = level;
        time = 75 - (difficulty * 15);
    }

    public int getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
        
    }
   
    public int getTime()
    {
        return time;
    }
    
    public void countdown()
    {
        time--;
    } 
}
