public class PlayerIO extends Const {

    //----------------------------------------------------------------
    // 
    //----------------------------------------------------------------
    public static int getNextMove(int [][] grid) { 
        if (Game2048.conf_useStdIn) 
            return PlayerIO.getNextMove_fromStdIn();
        else
            return PlayerIO.getNextMove_fromKeyboard();
    }
    
    //----------------------------------------------------------------
    // Use StdIn.readChar to return a legal move as UP, DOWN, LEFT,
    // RIGHT or QUIT. Use a while loop to keep reading if input is not
    // one of the following or until StdIn.isEmpty() then return QUIT:
    // 
    // Interpret a,d,s,w as LEFT, RIGHT, DOWN, UP (same as A,D,S,W)
    // 
    // Interprect q,Q and end-of-file as QUIT
    //----------------------------------------------------------------
    public static int getNextMove_fromStdIn() {
        while (!StdIn.isEmpty()) {
            char c = StdIn.readChar();
            if (c == 'a' || c == 'A') return LEFT;
            if (c == 'd' || c == 'D') return RIGHT;
            if (c == 's' || c == 'S') return DOWN;
            if (c == 'w' || c == 'W') return UP;
            if (c == 'q' || c == 'Q') return QUIT;
        }
        return QUIT;
    }
    
    //----------------------------------------------------------------
    // Use StdDraw.nextKeyTyped for GUI use
    //----------------------------------------------------------------
    public static int getNextMove_fromKeyboard() {
        int ret = 0 ;
        return ret;
    }
    
    

} ;