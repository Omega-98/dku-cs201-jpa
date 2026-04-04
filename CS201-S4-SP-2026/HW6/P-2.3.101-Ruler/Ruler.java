public class Ruler {
    static int depth = 0;

    public static String ruler(int n) {
        
        String ret= "";
        if (n == 0) {
            //ret = "\n";         
            return ret;
        } else {
            depth ++;
            ret =  ruler(n-1) + " ".repeat(depth*2-2) + n + "\n"+  ruler(n-1);
            depth --;
        }
        
        return ret;
    }     
    public static void main(String[] args) {
        // TODO: your own description

        // Complete the code here, see README on course website for problem description and instructions.
        int n = Integer.parseInt(args[0]);
        String output = ruler(n);

        System.out.println(output);




        return;
    }
}