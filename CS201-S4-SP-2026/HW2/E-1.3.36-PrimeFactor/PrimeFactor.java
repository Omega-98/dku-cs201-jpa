public class PrimeFactor {
    // task: Write a program PrimeCounter that takes an integer
    // command-line argument n and finds all primes less than or equal to
    // n.
    
    public static void main(String[] args) {
        
        // Complete the code here, see README on course website for problem description and instructions.
        long n = Long.parseLong(args[0]);
        long count = 0;
        long tempN = n;
        for (long i = 2; i * i <= tempN; i++) {
            if (tempN % i == 0) {
                count += 1;
                
                while (tempN % i == 0) {
                    tempN /= i;
                }
            }
        }
        if(tempN > 1){
            count += 1;
        }
        /*
        for(int i=2; i<=n; i++){
            boolean ifPrimeFactor = false;
            long a = 0;
            if(n%i==0){                     //judge if is a factor
                for(int j=2; j<i; j++){     //judge if is a prime factor
                    if(i%j==0){
                        a += 1;
                    }else{
                        continue;
                    }

                }
                if(a==0){
                    ifPrimeFactor = true;
                }
            }

            if(ifPrimeFactor==true){
                count += 1;
            }
        }*/
        

        
    
    System.out.println(n + " has "+count +" distinct prime factors.");
    }

}
