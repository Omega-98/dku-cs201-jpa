
/*
 *
 * Don't modify this file, this file is not submitted.
 * */

import java.util.Random;
public class Game2048_main { 


    //----------------------------------------------------------------
    // Main
    //----------------------------------------------------------------    
    public static void main (String [] args){
        
        // Set random seed
        int seed = 0;
        if(args.length>0) seed = Integer.parseInt(args[0]);
        
        Game2048.seed = seed;

        // Configure from input
        if(args.length>1) Game2048.conf_GUI = Boolean.parseBoolean(args[1]);
        if(args.length>2) Game2048.conf_useStdIn = Boolean.parseBoolean(args[2]);
        
        // Start the game
        game_start(seed);
    } 
    
    //----------------------------------------------------------------
    // Game start
    //----------------------------------------------------------------    
   public static void game_start(int seed){
        
       // init
       Control.init(seed);
       
       // printing 
       Grid.print_grid(Game2048.grid, "Starting");
       
       
       // Game run
       Control.run (Game2048.grid, Game2048.old, Game2048.new2);
    }
    

} ;