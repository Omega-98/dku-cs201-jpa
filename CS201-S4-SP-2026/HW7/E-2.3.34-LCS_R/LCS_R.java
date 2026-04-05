public class LCS_R
{
    public static void main(String[] args)  {
        String a = args[0];
        String b = args[1];

        String ret = LCS_r(a,b);
        System.out.println(ret);
    }
    
    public static String LCS_r(String x, 
                               String y) {

        // Complete the code here, see README on course website for problem description and instructions.
        int M = x.length();
        int N = y.length();
        //int[][] opt = new int[M+1][N+1]; //why M + 1 and N + 1 ? in case of the boundary case.
        if(x.length()==0||y.length()==0){
            return "";
        }
        if (x.charAt(0)==y.charAt(0)) {
            return x.charAt(0) + LCS_r(x.substring(1,M),y.substring(1,N));
        }
        else{
            String a = LCS_r(x, y.substring(1,N));
            String b = LCS_r(x.substring(1,M), y);
            return (a.length()>=b.length()) ? a : b;
            
        }




    }
}