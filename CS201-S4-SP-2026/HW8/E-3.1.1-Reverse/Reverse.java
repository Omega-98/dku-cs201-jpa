public class Reverse
{
    public static void main(String[] args)
    {
        // Exercise 3.1.1 Reverse
        // Do not change this part
        System.out.println(Reverse(args[0]));

        return;
    }
    // Implement a static Reverse method that returns a String. The
    // returned String is the reverse of its argument

    // Complete the code here, see README on course website for problem description and instructions.

    public static String Reverse(String s){
        return new StringBuilder(s).reverse().toString();
    }



}