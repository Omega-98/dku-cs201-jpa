public class SATBasedSubset{

    private int sum;
    private int[] arr;
    private boolean[] inSubset;
    private final int n;
    private boolean solutionFound;

    public SATBasedSubset(int sum, int[] arr)
    {
        this.sum = sum;
        this.arr = arr;
        n = arr.length;
        inSubset = new boolean[n];
        solutionFound = false;
        
        while (next()){
            if(check(sum, inSubset, arr)) {
                solutionFound = true;
                return;
            }
        }
    }

    private boolean next()
    {
        
        int i = 0;
        while (i < n && inSubset[i]) {
            inSubset[i] = false;
            i++;
        }
        
        if (i == n) {
            return false;
        }
        
        inSubset[i] = true;
        return true;
    }


    public static boolean check(int sum, boolean[] inSubset, int []arr)
    {
        
        int currentSum = 0;
        for (int i = 0; i < inSubset.length; i++) {
            if (inSubset[i]) {
                currentSum += arr[i];
                
                if (currentSum > sum) {
                    return false;
                }
            }
        }
        
        return currentSum == sum;
    }

    public String toString(){
        
        if (solutionFound) {
            StringBuilder sb = new StringBuilder();
            for (boolean b : inSubset) {
                sb.append(b ? '1' : '0');
            }
            return sb.toString();
        } else {
            return "No solution found";
        }
    }

    public static void main(String[] args){
        int sum = StdIn.readInt();
        int []arr = StdIn.readAllInts();
        SATBasedSubset solver = new SATBasedSubset(sum, arr); 
        StdOut.println("Solution: " + solver);
    }
}