// HW2 2-d array Problems
// CharGrid encapsulates a 2-d grid of chars and supports
// a few operations on the grid.

import java.sql.SQLOutput;
import java.util.Scanner;

public class CharGrid {
    private char[][] grid;

    /**
     * Constructs a new CharGrid with the given grid.
     * Does not make a copy.
     * @param grid
     */
    public CharGrid(char[][] grid) {
        this.grid = grid;
    }
    /**
     * Returns the area for the given char in the grid. (see handout).
     * @param ch char to look for
     * @return area for given char
     */
    public int charArea(char ch) {
        int min_x = Integer.MAX_VALUE;
        int min_y = Integer.MAX_VALUE;
        int max_x = 0;
        int max_y = 0;
        boolean flag = false;
        for(int i = 0 ; i<grid.length ; i++){
            for( int j = 0; j < grid[i].length ; j++){
                if(grid[i][j] == ch){
                    flag = true;
                    min_x = Math.min(min_x,j);
                    min_y = Math.min(min_y,i);
                    max_y = Math.max(max_y,i);
                    max_x = Math.max(max_x,j);
                }
            }
        }
        if(!flag) return 0;
        else{
            return (max_y - min_y + 1) * (max_x - min_x + 1);
        }
    }

    /**
     * Returns the count of '+' figures in the grid (see handout).
     * @return number of + in grid
     */
    public int countPlus() {
        int count = 0;
        boolean[][] mark_table = new boolean[grid.length][grid[0].length];
        for(int i = 0 ; i < grid.length ; i++){
            for(int j = 0 ; j < grid[i].length; j++){
                if(mark_table[i][j] == true){
                    continue;
                }
                mark_table[i][j] = true;
                int left = 0;
                int right = 0;
                int top = 0;
                int bottom = 0;
                char sample = grid[i][j];
                //right
                for(int k = j ; k < grid[i].length ; k++){
                    if(grid[i][k] == sample ){
                        right ++;
                        mark_table[i][j] = true;
                    }
                    else{
                        break;
                    }
                }
                //left
                for(int k = j ; k >= 0 ; k--){
                    if(grid[i][k] == sample ){
                        left ++;
                        mark_table[i][j] = true;
                    }
                    else{
                        break;
                    }
                }
                //top
                for(int k =i ; k >=0 ; k--){
                    if(grid[k][j] == sample ){
                        top ++;
                        mark_table[i][j] = true;
                    }
                    else{
                        break;
                    }
                }
                //bottom
                for(int k =i ; k < grid.length ; k++){
                    if(grid[k][j] == sample ){
                        bottom ++;
                        mark_table[i][j] = true;
                    }
                    else{
                        break;
                    }
                }
                if(left == right && right == top && top == bottom && bottom>=2){
                    count ++;
                }
            }
        }
        return count; // YOUR CODE HERE
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[][] grid = new char[][]{{'c','a','b','u','t'},
                {'a','a','a','i','t'},
                {'c','a','i','i','i'},
                {'o','o','o','i','p'}};
        CharGrid c = new CharGrid(grid);
        System.out.println(c.charArea('a') );
        System.out.println(c.countPlus());
    }
}
