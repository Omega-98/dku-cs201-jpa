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
        
        String result;
        if(n==0){
            return "";
        }
        
        recur_depth++;
        result = ConvertToBinary(n/2) + n%2;
        for(int i=0; i<recur_depth; i++){
            System.out.print("  "); 
        }      
        
              
        System.out.printf("%d --> %s\n", n, result);      
        recur_depth--;
    
        return result;
    }
}