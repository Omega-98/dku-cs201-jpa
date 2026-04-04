public class Ruler {

    public static String ruler(int n) {

        String ret= "";
        if (n == 0) {
            //ret = "\n";         
            return ret;
        } else {
            ret =  ruler(n-1) + " ".repeat(n) + n + "\n"+  ruler(n-1);
        }

        return ret;
    }     
    public static void main(String[] args) {
 
        // TODO: your own description

        // Complete the code here, see README on course website for problem description and instructions.
        int n = Integer.parseInt(args[0]);
        String output = ruler(n);

        System.out.println("Ruler of " + n + ": " + "\n" + "==========" + "\n" + output);




        return;
    }
}