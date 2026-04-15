/*
  Created by Yantao Mei and Jiang Long

  Jan 2022

  CS201.003.2022.SP

*/

import java.util.Random;

public class Array {

    public static Random rGen= new Random(1023);

    //----------------------------------------------------------------
    // Swap a[i] with a[j]
    //----------------------------------------------------------------    
    public static void swap(int [] a, int i, int j){
        // Complete the code here, see README on course website for problem description and instructions.
        int temp_i = a[i];
        int temp_j = a[j];
        a[i] = temp_j;
        a[j] = temp_i;     



    } 
    
    //----------------------------------------------------------------
    // Transpose the 2D array: swap grid[i][j] and grid[j][i]
    //----------------------------------------------------------------    
    public static void transpose(int [][] grid){
        // this is in-place transpose
        assert (grid.length == grid[0].length);
        // Complete the code here, see README on course website for problem description and instructions.
        for(int i=0; i<grid.length; i++){
            for(int j=i+1; j<grid.length; j++){
                int temp = grid[i][j];
                grid[i][j] = grid[j][i];
                grid[j][i] = temp;
            }
        }



    } 
    
    //----------------------------------------------------------------
    // Reverse each row of the grid, create a left-right mirror 
    //
    // call reverse(int[]) on each row
    //----------------------------------------------------------------    
    public static void mirror2D_LR(int [][] grid) {
        // Complete the code here, see README on course website for problem description and instructions.
        for(int i=0; i<grid[0].length; i++){
            for(int j=0; j<grid[0].length; i++){
                int temp = grid[i][j]
                grid[i][j] = grid[i][grid[0].length - 1 - j];
                grid[i][grid[0].length - 1 - j] = temp;

            }
        }



    } 
    
    //----------------------------------------------------------------
    // Reverse a 1D array
    //----------------------------------------------------------------    
    public static void reverse(int []row){
        for(int i=0;i<row.length/2;i++)
            swap (row, i, row.length-i-1);
    }
    
    //----------------------------------------------------------------
    // Move all non-zero cells to the left, fill the right with zeros
    //----------------------------------------------------------------    
    public static void collapse(int []row){
        // Complete the code here, see README on course website for problem description and instructions.
        for(int i=0; i<grid[0].length; i++){
            for(int j=grid[0].length-1; j>0; j--){
                if(grid[i][j] != 0 && grid[i][j-1] == 0){
                    swap(grid[i], j, j-1);
                }
            }
        }


    }

    //----------------------------------------------------------------
    // Collapse each row of the grid
    //----------------------------------------------------------------    
    public static void collapse_row(int [][] grid ) {
        // Complete the code here, see README on course website for problem description and instructions.
        



    } 

    //----------------------------------------------------------------
    // Clone an array, create a new one
    //----------------------------------------------------------------    
    public static int[][] clone ( int [][] a) {
        // Complete the code here, see README on course website for problem description and instructions.




    } 


    //----------------------------------------------------------------
    // Copy a to b
    //----------------------------------------------------------------    
    public static void copy ( int [][] a, int[][] to){ // 
        // Complete the code here, see README on course website for problem description and instructions.




    } 

    //----------------------------------------------------------------
    // Check if two 2D array are the same
    //----------------------------------------------------------------    
    public static boolean eq (int[][] a, int[][] b){
        // Complete the code here, see README on course website for problem description and instructions.




    }

    //----------------------------------------------------------------
    // Sum all the cells
    //----------------------------------------------------------------    
    public static int sum (int[][] a){
        // Complete the code here, see README on course website for problem description and instructions.




    }

    //----------------------------------------------------------------
    // Return the max of all the cells
    //----------------------------------------------------------------    
    public static int max (int[][] a){
        // Complete the code here, see README on course website for problem description and instructions.




    }


    //----------------------------------------------------------------
    // Random fill
    //----------------------------------------------------------------    
    public static void rand_fill(int [] r, int min, int max, Random rGen) {
        // read the two array and does the following
        for (int i=0;i<r.length; i++){
            r[i] = rGen.nextInt(max-min) + min;
        }
            
    } 

    public static void rand_fill(int [][] r, int min, int max) {
        // read the two array and does the following
        for (int i=0;i<r.length; i++){
            rand_fill(r[i], min, max, rGen); 
        }
            
    } 

    public static void rand_fill(int [][] r, int min, int max, Random rGen) {
        // read the two array and does the following
        for (int i=0;i<r.length; i++){
            rand_fill(r[i], min, max, rGen);
        }            
    } 
    
    //----------------------------------------------------------------
    // Print 2D
    //
    // Note: Should convert to String[][] and call modified
    // Tabulate.Tabulate to fit for this function as we need to
    // calculate the width of each to align the printout
    // ----------------------------------------------------------------
    public static void print_2d(int [][] grid, String msg) {
        // Complete the code here, see README on course website for problem description and instructions.




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

        int [][] m = new int [N][N];
        

        rand_fill(m, 0 , N);
        print_2d(m, "m (after rand_fill)");
        
        transpose(m);
        print_2d(m, "Transpose");

        mirror2D_LR(m);
        print_2d(m, "mirror2D_LR");

        collapse_row(m);
        print_2d(m, "collapse");
        
        int max_value = max(m);
        int sum_value = sum(m);
        
        StdOut.printf("max: %d\nsum: %d\n", max_value, sum_value);

        int [][] m2 = clone(m);
        boolean same = eq(m2, m);
        m2[m.length-1][m[m.length-1].length-1] = 0 ;
        boolean same2 = eq(m2, m);
        StdOut.printf("same: %s\n", ""+same);
        StdOut.printf("same2: %s\n", ""+same2);
    } 

    
} ;