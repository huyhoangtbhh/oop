// TetrisGrid encapsulates a tetris board and has
// a clearRows() capability.

public class TetrisGrid {

    /**
     * Constructs a new instance with the given grid.
     * Does not make a copy.
     * @param grid
     */
    private boolean[][] tetrisGrid;

    public TetrisGrid(boolean[][] grid) {
        if(grid.length > 0 && grid[0].length > 0) {
            this.tetrisGrid = grid;
        }
        return;
    }


    /**
     * Does row-clearing on the grid (see handout).
     */
    public void clearRows() {
        for(int i = 0 ; i < tetrisGrid.length ; i++ ){
            int count = 0;

            for(int j = 0 ; j < tetrisGrid[i].length ; j++){
                if(tetrisGrid[i][j] == true){
                    count ++;
                }
            }

            if(count == tetrisGrid[i].length){
                for(int j = i ; j > 0 ; j--){
                    for(int k = 0 ; k < tetrisGrid[j].length ; k++){
                        tetrisGrid[j][k] = tetrisGrid[j-1][k];
                    }
                }

                for(int j = 0 ; j < tetrisGrid[0].length ; j++){
                    tetrisGrid[0][j] = false;
                }
            }
        }
    }

    /**
     * Returns the internal 2d grid array.
     * @return 2d grid array
     */
    boolean[][] getGrid() {
        return this.tetrisGrid; // YOUR CODE HERE
    }

    public static void main(String[] args) {
        boolean[][] arr = new boolean[][]{{true,false,false,false,false},
                {true,true,false,false,false},
                {true,true,true,true,true},
                {true,true,true,false,false}};
        TetrisGrid TG = new TetrisGrid(arr);
        TG.clearRows();
        for(int i = 0 ; i < TG.tetrisGrid.length ; i++){
            for(int j = 0 ; j < TG.tetrisGrid[0].length ; j++){
                System.out.print(TG.tetrisGrid[i][j] + " ");
            }
            System.out.println("");
        }
    }
}
