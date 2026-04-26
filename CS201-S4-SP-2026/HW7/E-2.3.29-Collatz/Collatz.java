public class Collatz {
    public static long[] memo = new long[40000000];

    public static long collatzLen(long n) {
        if (n < 40000000 && memo[(int) n] != 0) {
            return memo[(int) n];
        }
        long res;
        if (n == 1) {
            res = 1;
        } else if (n % 2 == 0) {
            res = 1 + collatzLen(n / 2);
        } else {
            res = 1 + collatzLen(3 * n + 1);
        }
        if (n < 40000000) {
            memo[(int) n] = res;
        }
        return res;
    }

    public static void main(String[] args) {
        long n = Integer.parseInt(args[0]);
        long maxLen = 0;
        long bestI = 1;
        
        for (long i = 1; i < n; i++) {
            long len = collatzLen(i);
            if (len > maxLen) {
                maxLen = len;
                bestI = i;
            }
        }
        
        System.out.println(bestI);
    }
}