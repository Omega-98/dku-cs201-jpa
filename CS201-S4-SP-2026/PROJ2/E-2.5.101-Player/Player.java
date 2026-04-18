/*
  Created by Yantao Mei and Jiang Long

  Jan 2022 

  CS201.003.2022.SP

*/


import java.util.Random;
public class Player {
    
    public static Random rGen= new Random(1023);
    //----------------------------------------------------------------
    // User press 'a' to move all cells to the left
    //----------------------------------------------------------------
    public static void move_left(int [][] grid) {
        for (int i=0;i<grid.length;i++) {
            move_left(grid[i]);
        } 
    }
    //----------------------------------------------------------------
    // User press 'a' to move all cells to the left
    //
    // Implement this with a combinationi of merge and Array.collapse.
    //
    // Need to collapse before and after the merge
    //
    //----------------------------------------------------------------
    public static void move_left(int [] row){
        // Complete the code here, see README on course website for problem description and instructions.
        Array.collapse(row);
        for(int i=0; i<row.length-1; i++){
            if(row[i] !=0 && row[i] == row[i+1]){
                row[i] *= 2;
                row[i+1] = 0;
                i++;
            }
        }
        Array.collapse(row);
    }
    
    //----------------------------------------------------------------
    // User press 'd' to move all cells to the right
    //
    // Implementation: reverse each row (Array.mirror2D_LR) , move_left, reverse back
    //----------------------------------------------------------------
    public static void move_right( int [][] grid) {
        // Complete the code here, see README on course website for problem description and instructions.
        Array.mirror2D_LR(grid);
        move_left(grid);
        Array.mirror2D_LR(grid);
    }
    
    //----------------------------------------------------------------
    // User press 'w' to move all cells up
    //
    // Implementation: Array.transpose, move_left, Array.transpose
    //----------------------------------------------------------------
    public static void move_up(int [][] grid) {
        // Complete the code here, see README on course website for problem description and instructions.
        Array.transpose(grid);
        move_left(grid);
        Array.transpose(grid);
    }
    
    //----------------------------------------------------------------
    // User press 's' to move all cells down
    //
    // Implementation: Array.transpose, move_right, Array.transpose
    //----------------------------------------------------------------
    public static void move_down(int [][] grid) {
        // Complete the code here, see README on course website for problem description and instructions.
        Array.transpose(grid);
        move_right(grid);
        Array.transpose(grid);
    }

    //----------------------------------------------------------------
    // Random fill (for testing use)
    //----------------------------------------------------------------    
    public static void rand_fill(int [][] grid, int max) {
        Array.rand_fill(grid, 0, max, rGen);
        Array.print_2d(grid, "rand_fill raw:");
        // If grid[i][j] is not 0, change it to 2^grid[i][j] ( use Math.pow)
        // Complete the code here, see README on course website for problem description and instructions.
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[i].length; j++){
                    if(grid[i][j]!=0){
                        double power = grid[i][j];
                        grid[i][j] = (int) Math.pow(2, power);
                    }
            }
        }
    } 

    //----------------------------------------------------------------
    // Test client
    //----------------------------------------------------------------    
    public static void main(String [] args) {
        
        int N = 6;
        // read the two array and does the following
        if (args.length>0) {
            N = Integer.parseInt(args[0]);
            rGen = new Random(N);
        }
        int [][] m = new int [4][4];
        rand_fill(m, 5);
        Array.print_2d(m, "grid:");
        

        move_left(m);
        Array.print_2d(m, "move LEFT:");
        move_left(m);
        Array.print_2d(m, "move LEFT:");
        
        move_right(m);
        Array.print_2d(m, "move RIGHT:");
        move_right(m);
        Array.print_2d(m, "move RIGHT:");
        
        move_up(m);
        Array.print_2d(m, "move UP:");
        move_up(m);
        Array.print_2d(m, "move UP:");
        
        move_down(m);
        Array.print_2d(m, "move DOWN:");
        move_down(m);
        Array.print_2d(m, "move DOWN:");


    }
} ;