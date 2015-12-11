package view;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.util.List;
import java.util.Random;
import java.lang.Math;

/**
 * Work on generating random endpoint
 */
public class Gameboard extends JPanel{

    

    private JLabel[][] gameLabels;

    private int playerPositionX;
    private int playerPositionY;

    int N = 20;
    
    Random rand = new Random();
    
    private int startCoordinateX;
    private int startCoordinateY;
    
    private  int endCoordinateX;
    private  int endCoordinateY;
    
    private boolean[][] visited;
    private boolean[][] maze;

    public Gameboard() {
        setFocusable(true);
        requestFocusInWindow();
        
        createGameBoard();
           
        init();
        
        generate(startCoordinateX,startCoordinateY);
        
        generateLables();


        
        
    }
    
    private void generateLables(){
        
        ImageIcon dirt = new ImageIcon("src/images/dirt.jpg");
        ImageIcon stone = new ImageIcon("src/images/stone.jpg");
        
        for (int y = 0; y < N; ++y) {
            for (int x = 0; x < N; ++x) {
                
                JLabel n = new JLabel();
                n.setOpaque(true);
                if (y == startCoordinateY && x == startCoordinateX) {
                    n.setBackground(Color.PINK);
                    playerPositionX = x;
                    playerPositionY = y;
                } else if (maze[y][x]) {
                    //n.setBackground(Color.DARK_GRAY);
                    
                    n.setIcon(dirt);
                    
                } else if(x == endCoordinateY && y == endCoordinateX){
                    n.setBackground(Color.yellow);
                }else{
                    n.setIcon(stone);
                }

                
                gameLabels[y][x] = n;
                this.add(n);

            }
        }
    }
    
    private void createGameBoard(){
        
        this.gameLabels = new JLabel[N][N];

//        TODO: change size
        GridLayout gameGrid = new GridLayout(N, N, -1, -1);
        this.setLayout(gameGrid);
        this.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
    }
    
    private void init() {
        this.maze = new boolean[N][N];
        this.visited = new boolean[N][N];
        
        startCoordinateX  = rand.nextInt(((N-1) - 1) + 1);
        startCoordinateY = rand.nextInt(((N-1) - 1) + 1);
        
        playerPositionX = startCoordinateX;
        playerPositionY = startCoordinateY;
        
        for (int x = 0; x < N; x++) {
            for (int y = 0; y < N; y++) {
            maze[x][y] = true;
            }    
        }
        for (int x = 0; x < N; x++) {
            for (int y = 0; y < N; y++) {
            visited[x][y] = false;
            }    
        }
        
        // initialize border cells as already visited, prevents generator from working with the edges
        
        for (int x = 0; x < N; x++) {
            visited[x][0] = true;
            visited[x][N-1] = true;
        }
        for (int y = 0; y < N; y++) {
            visited[0][y] = true;
            visited[N-1][y] = true;
        }
        //Sets all cells to true 
        
        for (int x = 0; x < N; x++) {
            for (int y = 0; y < N; y++) {
            maze[x][y] = true;
            }    
        }
        

           
        
    }
    //Logic for generating the random maze
    private void generate(int x, int y){
        visited[x][y] = true;
        maze[x][y] = false;
        
        
        
        while (!visited[x][y+1] || !visited[x+1][y] || !visited[x][y-1] || !visited[x-1][y]){
            
            
            while(true){
                int r = rand.nextInt((3 - 0) + 1);
                
                //move down
                if(r == 0 && (!visited[x+1][y] ) && x+1 < N){
                    visited[x][y+1] = true;
                    visited[x][y-1] = true;
                    //visited[x][y] = true;
                    
                    if(visited[x+2][y] == true){
                        visited[x+1][y] = true;
                    }
                    
                   // maze[x][y] = false;
                    
                    generate(x + 1, y);
                    
                    break;
                }
                //move right
                else if (r == 1 && (!visited[x][y+1] ) && y+1 < N) {
                    visited[x+1][y] = true;
                    visited[x-1][y] = true;
                    //visited[x][y] = true;
                    
                    if(visited[x][y+2] == true){
                        visited[x][y+1] = true;
                    }
                    
                    //maze[x][y] = false;
                    
                    generate(x, y+1);
                    
                    break;
                }
                //move up
                else if (r == 2 && (!visited[x-1][y] ) && x-2 > -1) {
                    visited[x][y+1] = true;
                    visited[x][y-1] = true;
                    //visited[x][y] = true;
                    
                    if(visited[x-2][y] == true){
                        visited[x-1][y] = true;
                    }
                    
                    //maze[x][y] = false;
                    
                    generate(x-1, y);
                    
                    break;
                }
                //move left
                else if (r == 3 && (!visited[x][y-1] ) && y-2 > -1) {
                    visited[x+1][y] = true;
                    visited[x-1][y] = true;
                    //visited[x][y] = true;
                    
                    if(visited[x][y-2] == true){
                        visited[x][y-1] = true;
                    }
                         
                    //maze[x][y] = false;
                    
                    generate(x, y-1);
                    
                    break;
                }else{
                    break;
                }
                
            }
            
            setEndPoint(maze);
        }
        
        
        
    }
    
    private void setEndPoint(boolean[][] maze){
        for(int i = N-1; i > 0; i--){
            for(int j = N-1; j > 0; j--){
                if (!maze[i][j] &&((/*down, right, up*/maze[i + 1][j ] && maze[i][j + 1] && maze[i - 1][j]) || (/*right, up, left*/maze[i][j + 1] && maze[i - 1][j] && maze[i][j - 1]) || (/*up, left, down*/maze[i - 1][j] && maze[i][j - 1] && maze[i + 1][j]) || (/*left, down, right*/maze[i][j - 1] && maze[i + 1][j] && maze[i][j + 1]))){
                    endCoordinateX = i;
                    endCoordinateY = j;
                }
            }
        }
    }
    
    private void atEnd() {

        if (playerPositionX == endCoordinateY && playerPositionY == endCoordinateX) {
            showGameOverMessage();
            restartGame();
        }

    }

    @Override
    public boolean isFocusTraversable() {
        return true;
    }

    private void restartGame() {
        this.removeAll();
        //N = N + 10;
        init();
        
        generate(startCoordinateX,startCoordinateY);
        
        generateLables();
        
        repaint();
        revalidate();
        /*
        startCoordinateX = rand.nextInt(((N-1) - 1) + 1);
        startCoordinateY = rand.nextInt(((N-1) - 1) + 1);
        N = N + 10;
        
        createGameBoard();
        init();
        
        generate(startCoordinateX,startCoordinateY);
        
        generateLables();
        
        /*
        gameLabels[playerPositionY][playerPositionX].setBackground(Color.CYAN);
        gameLabels[startCoordinateY][startCoordinateX].setBackground(Color.PINK);
        
        playerPositionY = startCoordinateY;
        playerPositionX = startCoordinateX;
*/
    }

    private void showGameOverMessage() {

        JFrame gameOver = new JFrame("Game Over!");
        JPanel panel = new JPanel();
        JLabel message = new JLabel("You won!");

        panel.setBackground(Color.DARK_GRAY);
        message.setBackground(Color.DARK_GRAY);
        message.setForeground(Color.CYAN);
        message.setFont(new Font("Arial", Font.PLAIN, 25));

        panel.add(message);

        gameOver.getContentPane().add(panel, "Center");

        gameOver.setBackground(Color.DARK_GRAY);
        gameOver.setSize(400, 100);
        gameOver.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        gameOver.setVisible(true);

    }

    public void movePlayerRight() {

        // if the point to the right is not filled
        if (playerPositionX + 1 > 0 && playerPositionX + 1 < N && !maze[playerPositionY][playerPositionX + 1]) {
            // moves player one point to the right
            gameLabels[playerPositionY][playerPositionX + 1].setBackground(Color.PINK);

            // set old position color back
            gameLabels[playerPositionY][playerPositionX].setBackground(Color.CYAN);

            // update player position
            playerPositionX = playerPositionX + 1;  // only x coor changes

            atEnd();

        }

    }

    public void movePlayerLeft() {

        // if the point to the left is not filled
        if (/*playerPositionX - 1 >= 0 && playerPositionX - 1 < N && */!maze[playerPositionY][playerPositionX - 1]) {
            // move player one point to the left
            gameLabels[playerPositionY][playerPositionX - 1].setBackground(Color.PINK);

            // set old position color back
            gameLabels[playerPositionY][playerPositionX].setBackground(Color.CYAN);

            // update player position
            playerPositionX = playerPositionX - 1;  // only x coor changes

            atEnd();

        }

    }

    public void movePlayerUp() {

        // if the point is not filled
        if (!maze[playerPositionY - 1][playerPositionX]) {

            // move player one point up
            gameLabels[playerPositionY - 1][playerPositionX].setBackground(Color.PINK);

            // set old position color back
            gameLabels[playerPositionY][playerPositionX].setBackground(Color.CYAN);

            // update player position
            playerPositionY = playerPositionY - 1;  // only y coor changes

            atEnd();

        }

    }

    public void movePlayerDown() {

        // if the point is not filled
        if (!maze[playerPositionY + 1][playerPositionX]) {

            // move player one point up
            gameLabels[playerPositionY + 1][playerPositionX].setBackground(Color.PINK);

            // set old position color back
            gameLabels[playerPositionY][playerPositionX].setBackground(Color.CYAN);

            // update player position
            playerPositionY = playerPositionY + 1;  // only y coor changes

            atEnd();

        }

    }

    public int getPlayerPositionX() {
        return playerPositionX;
    }

    public int getPlayerPositionY() {
        return playerPositionY;
    }

}
