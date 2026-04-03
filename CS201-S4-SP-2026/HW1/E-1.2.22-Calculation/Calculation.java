public class Calculation
{
    public static void main(String[] args)
    {
        // Exercise 1.2.22 
        // Complete the code here, see README on course website for problem description and instructions.
        double x_0 = Double.parseDouble(args[0]);
        double v_0 = Double.parseDouble(args[1]);
        double t = Double.parseDouble(args[2]);
        double g = 9.80665;
        double displacement = x_0 + v_0 * t - 0.5 * g * Math.pow(t,2);
        System.out.println(displacement);

        




        return;
    }
}