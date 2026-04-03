public class PrimeCounter {
    // task: Write a program PrimeCounter that takes an integer
    // command-line argument n and finds all primes less than or equal to
    // n.
    
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        // Complete the code here, see README on course website for problem description and instructions.
    int i = 1;
    while(i <= n){
        boolean a = true;
        for(int j=2; j< i; j++){            //judge whether i is a prime
            if(i%j==0){                     //Do not judge i == 1 here, since when i == 1, j > i.
                a = false;
            }
        }
        if(a == true && i != 1){
            System.out.println(i);
        }
        i += 1;
    }



    }

}