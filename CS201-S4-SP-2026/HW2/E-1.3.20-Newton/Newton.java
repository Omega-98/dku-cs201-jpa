
public class Newton {

    // task: use newtons method to find the kth root of n

    public static void main(String[] args) {

        // Raed n,k from command line
        int n = Integer.parseInt(args[0]);
        int k = Integer.parseInt(args[1]);
        
        // initial_guess
        double initial_guess = Math.random() * 100; // initial value

        // smaller epsilon, denotes more accuracy
        double epsilon = 0.000001;

        // keep the result here
        double kth_root_of_n  ;

        // Complete the code here, see README on course website for problem description and instructions.
        double x_t0 = initial_guess;
        double x_t1 = initial_guess - 1;
        double dif = 114514;
        while(dif >= epsilon){
            x_t1 = (k-1)*x_t0 / k + n / (k*Math.pow(x_t0, k-1));
            dif = Math.abs(x_t1 - x_t0);
            x_t0 = x_t1;
        }

        kth_root_of_n = x_t1;
        
        // Don't touch from here
        
        // only print 5 digits after the decimal point (precision-wise)
        System.out.printf("%sth root of %s is %.5f\n", k, n, kth_root_of_n); 
    }
}