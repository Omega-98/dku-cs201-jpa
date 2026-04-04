public class Permutation_v1
{
    

    public static void main(String[] args)
    {
        int n  = Integer.parseInt(args[0]); 
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        
        String s = alphabet.substring(0, n);
        // Create an char [] for permutation use
        perm("",s);
        
    }

    public static void perm(String prepend, String s){

        if (s.length()==0) System.out.println(prepend);

        // Complete the code here, see README on course website for problem description and instructions.
        for(int i=0; i<s.length(); i++){
            char current = s.charAt(i);
            String next_s = s.substring(0,i) + s.substring(i+1); //(0,i) is the front one, which will cause disorder
            perm(prepend + current, next_s);
        }



    }
}