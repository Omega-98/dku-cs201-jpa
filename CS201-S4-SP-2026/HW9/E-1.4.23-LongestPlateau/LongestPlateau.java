// This homework is assisted with Gemini 3.1 Pro

public class LongestPlateau
{
    public static void main(String[] args)
    {
        // Exercise 1.4.23 LongestPlateau

        int maxPlateauLen = 0;         // max record
        int maxPlateauStartPos = -1;

        // Read the terrain info from command line 
        int[] A = new int[args.length];
        for (int i = 0 ; i < args.length ; i++){
            A[i] = Integer.parseInt(args[i]);        
        }
        
        // Complete the code here, see README on course website for problem description and instructions.
        if (A.length > 0) {
            int currentStart = 0;
            int currentLen = 1;
            boolean isLeftValid = true;

            for (int i = 1; i < A.length; i++) {
                if (A[i] == A[i - 1]) {
                    currentLen++;
                } else if (A[i] > A[i - 1]) {
                    currentStart = i;
                    currentLen = 1;
                    isLeftValid = true;
                } else { 
                    if (isLeftValid && currentLen > maxPlateauLen) {
                        maxPlateauLen = currentLen;
                        maxPlateauStartPos = currentStart;
                    }
                    currentStart = i;
                    currentLen = 1;
                    isLeftValid = false;
                }
            }
            
            if (isLeftValid && currentLen > maxPlateauLen) {
                maxPlateauLen = currentLen;
                maxPlateauStartPos = currentStart;
            }
        }


        
        System.out.println("maxPlateauLen = "  + maxPlateauLen);
        System.out.println("startPos = " + maxPlateauStartPos);

        return;
    }
}