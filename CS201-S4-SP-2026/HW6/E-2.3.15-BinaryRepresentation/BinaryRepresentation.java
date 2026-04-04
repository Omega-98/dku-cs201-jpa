public class BinaryRepresentation
{


    public static int recur_depth = -1;
    public static void main(String[] args)   {
        int n = Integer.parseInt(args[0]);
        String output = ConvertToBinary(n);
        System.out.printf("Result: %d -> %s\n", n, output);
    }
    
    public static String ConvertToBinary(int n){
    // Complete the code here, see README on course website for problem description and instructions.
        recur_depth++;
        String result;
        if(n==0){
            result =  String.valueOf(0);
        }
        for(int i=0; i<recur_depth; i++){
            System.out.print("  "); 
        }      

        result = n%2 + ConvertToBinary(n/2);      
        System.out.printf("%d --> %s\n", n, result);      
        
        recur_depth--;
        return result;
    }
}