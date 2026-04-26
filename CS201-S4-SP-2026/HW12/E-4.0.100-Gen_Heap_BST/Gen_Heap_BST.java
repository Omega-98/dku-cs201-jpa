public class Gen_Heap_BST {
    // Complete the code here, see README on course website for problem description and instructions.





    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        
        // Hint: Heap_BST should be recursive func with lo, hi as
        // input parameters

        String r = Heap_BST(0, N);
        
        StdOut.println(r);
        return;
    }
}