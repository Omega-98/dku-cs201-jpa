import java.util.Random;


// This is Eve the player who puts a tile on to the board
public class Eve extends Const {
    
    public static int gen_tile(){
        // generate either a 2 or 4
        if (Game2048.rGen.nextDouble()>0.5) return 4;
        else return 2;
    }


    /* Note: this method return 3 things
       1. value of the new tile
       2. the resulting grid after adding the new tile
       3. the location of the new tile

       Review pass-by-reference in chap 2.1 2.2 if in doubt
     */
    public static int create_tile(int[][] grid, int [] new2) {

        // the algorithm: from left to right, top to down, there
        // should N empty slots, number from 0 to N-1.
        
        // so, we generate a random number between [0..N-1] and fill
        // in that slot with a random 2 or 4 

        int N = Grid.empty_count(grid);
        int n = Game2048.rGen.nextInt(N);
        int nextTile = gen_tile();
        /*
          For the following grid

          2 2 0 4
          4 2 4 0
          8 2 0 4
          0 0 4 4
          
          N = 5
          
          And the empty slots is the ordered list of 

          (0,2), (1,3), (2,2), (3,0) and (3,1)

          For the random number `n`, it will set the n_th empty-slot
          with `nextTile`
          
          The filled empty-slot's coordinate should be put `new2` to
          be returned (pass-by-reference).
         */
        
        
        // Complete the code here, see README on course website for problem description and instructions.
        int idx = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 0) {
                    if (idx == n) {
                        grid[i][j] = nextTile;
                        new2[0] = i;
                        new2[1] = j;
                        i = grid.length;
                        break;
                    }
                    idx++;
                }
            }
        }

        return grid[new2[0]][new2[1]];
        
    } 


} ;