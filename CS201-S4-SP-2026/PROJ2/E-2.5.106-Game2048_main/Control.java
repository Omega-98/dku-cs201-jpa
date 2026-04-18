import java.util.Random;

public class Control extends Const {
    
    
    public static void run (int [][]grid, int [][] old, int [] new2) {
        
        boolean done = false;

        // create the first randome 2
        Eve.create_tile(grid, new2);
        
        Grid.print_grid(grid, "INIT");

        // make sure first time grid!=old
        old[0][0]  = 1;
        
        boolean win = false, lose = false, quit = false;
        while ( ! win && ! lose && ! quit ) {
            
            // can only a crate a new tile if the grid changed
            if (!Grid.eq_grid(grid, old) && ! Grid.full(grid)) {
                // new2 return the (x,y) of the new tile coordinates
                Game2048.tileSum+= Eve.create_tile(grid, new2);
                Game2048.validRoundCount ++;
                if (Game2048.validRoundCount < 400)
                    Grid.print_grid(grid, new2[0], new2[1], "New tile created");
                else
                    System.out.println("New tile created");
                
            }
            
            // get a move from user
            int move = PlayerIO.getNextMove(grid);
            
            if (move == QUIT) {
                quit = true;
                break;
            }
            
            // Copy grid to old and then update it
            Array.copy (grid, old);
            Grid.update_grid(grid, move);      
            
            // print message if the grid has been updated or not.
            boolean same =Grid.eq_grid(old, grid);
            String msg = !same ? ("User move: " + MOVE[move]) 
                :  ("No change move: " + MOVE[move]);
            if (!same){
                if (Game2048.validRoundCount < 400)

                    Grid.print_grid(grid, msg);
                else
                    System.out.println(msg);
            }  else
                System.out.println("No change move: " + MOVE[move]);
            
            win = Grid.win(grid, WIN_LABEL);
            lose = Grid.game_over(grid);
        }
        if (win) StdOut.println("Win");
        if (lose)StdOut.println("Lose");
        if (quit)StdOut.println("Quit");
        Grid.print_grid(grid, "Last grid (otherwise skipped since 40th round)");
        StdOut.printf("Round played: %d\nTileSum: %d\nMaxTile: %d\n", 
                      Game2048.validRoundCount ,
                      Game2048.tileSum,
                      Array.max(grid));
    } 
    
    public static  void init(int seed) {
        // that is it
        Game2048.grid = new int [4][4];
        Game2048.old = new int [4][4];
        Game2048.new2 = new int[2];

        Game2048.rGen = new Random(seed);
        Game2048.validRoundCount = 0 ;
        Game2048.tileSum = 0 ;
        
        if (Game2048.conf_GUI){
            init_GUI();
        }
    }

    public static void init_GUI() {

    } 

} ;