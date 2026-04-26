public class Gen_Heap_BST {
    // Complete the code here, see README on course website for problem description and instructions.
    public static String Heap_BST(int lo, int hi){
        if(lo >= hi){
            return "";
        }
        int N = hi - lo;
        int L = getLeftSize(N);
        int rootValue = lo + L;
        String left = Heap_BST(lo, rootValue);
        String right = Heap_BST(rootValue + 1, hi);
        return rootValue + " " + left + right;
    }
    public static int getLeftSize(int N){
        int pow = 0;
        int P = 1;
        while (P * 2 <= N + 1) {
            P = P * 2;
        }
        int R = N - (int)(P - 1); // R is the number of the Node in the bottom layer.
        return P / 2 - 1 + Math.min(R, P/2);

    }



    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        
        // Hint: Heap_BST should be recursive func with lo, hi as
        // input parameters

        String r = Heap_BST(0, N);
        
        StdOut.println(r);
        return;
    }
}