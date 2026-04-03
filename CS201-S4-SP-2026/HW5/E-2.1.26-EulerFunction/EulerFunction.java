public class EulerFunction{
    // Complete the code here, see README on course website for problem description and instructions.
    public static boolean isPrime(int n) {
        boolean isPrime = true;
        for(int i=2; i<n;i++){
            if(n%i==0){
                isPrime = false;
                return isPrime;
            }
        }
        return true;
    }
    public static int euler(int n){
        double result = 1;
        for(int i=2; i<=n; i++){
            if(isPrime(i) && n%i==0){
                int power = 0;
                int temp = n;
                while(temp%i==0){
                    temp = temp/i;
                    power += 1;
                }
                result *= (i-1) * Math.pow((double)i, (double)power - 1);
            }else{
                continue;
            }
        }
        return (int)result;
    }



    public static void main(String[] args) {
        // Do not change this
        int n=Integer.parseInt(args[0]);
        System.out.println(euler(n));
    }
	
}