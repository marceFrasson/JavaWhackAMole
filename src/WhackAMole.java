import java.util.Random;

public class WhackAMole {
    int score;
    int molesLeft;
    int attemptsLeft;
    int gridDimensions;
    char moleGrid[][];
    char userGrid[][];

    public WhackAMole(int numAttempts, int gridDimension) {
        moleGrid = new char[gridDimension][gridDimension];
        userGrid = new char[gridDimension][gridDimension];
        attemptsLeft = numAttempts;
        gridDimensions = gridDimension;
        shuffleMoles(gridDimensions);
        initializeUserGrid(gridDimensions);
    }

    private void initializeUserGrid(int gridDimension) {
        for(int i = 0; i < gridDimension; i++) {
            for(int j = 0; j < gridDimension; j++) {
                userGrid[i][j] = 'O';
            }
        }
    }

    private void shuffleMoles(int gridDimension) {
        Random random = new Random();
        for(int i = 0; i < gridDimension; i++) {
            moleGrid[random.nextInt(gridDimension)][random.nextInt(gridDimension)] = 'M';
        }
    }

    public boolean place(int x, int y) {
        if(moleGrid[x][y] == 'M') {
            molesLeft--;
            return true;
        } else {
            return false;
        }
    }

    public void whack(int x, int y) {
        if(place(x, y)) {
            score++;
            attemptsLeft--;
            molesLeft--;
            whacked(x,y, true);
        } else {
            attemptsLeft--;
            whacked(x,y, false);
        }

    }

    public void whacked(int x, int y, boolean whackedMole) {
        if(whackedMole) {
            userGrid[x][y] = 'W';
        } else {
            userGrid[x][y] = '*';
        }
    }

    public void printGridToUser() {
        for(int i = 0; i < gridDimensions; i++) {
            for(int j = 0; j < gridDimensions; j++) {
                System.out.print(userGrid[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    public void printGrid() {
        for(int i = 0; i < gridDimensions; i++) {
            for(int j = 0; j < gridDimensions; j++) {
                if(moleGrid[i][j] == 'M' && userGrid[i][j] != 'W') {
                    System.out.print(moleGrid[i][j]);
                    System.out.print(" ");
                } else {
                    System.out.print(userGrid[i][j]);
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}