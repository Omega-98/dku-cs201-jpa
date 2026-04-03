public class OrderCheck
{
    public static void main(String[] args)
    {
        // Exercise 1.2.28 OrderCheck
        // check if the three arguments are strictly ascending or descending 

        // Complete the code here, see README on course website for problem description and instructions.
        double x = Double.parseDouble(args[0]);
        double y = Double.parseDouble(args[1]);
        double z = Double.parseDouble(args[2]);
        if((x>y && x>z && y>z) || (x<y && x<z && y<z)){
            System.out.println(true);
        }else{
            System.out.println(false);
        }



        return;
    }
}