import java.util.*;

public class IntegerProperty
{
    public static void main(String[] args)
    {
        // don't change this
        int a = Integer.parseInt(args[0]);
        int b = Integer.parseInt(args[1]);

        System.out.println("a: "+ a);
        System.out.println("b: "+ b);
        System.out.println("isPrime(a): "+ isPrime(a));
        System.out.println("isPrime(b): "+ isPrime(b));
        System.out.println("isRelativePrime(a+b): " + isRelativePrime(a, b));

        System.out.print("distinct factors of (a): ");
        for (int f : factor(a))
            System.out.print(f + " ");
        System.out.println();

        System.out.print("distinct factors of (b): ");
        for (int f : factor(b))
            System.out.print(f + " ");
        System.out.println();

        System.out.println("gcd(a+b): " + gcd(a, b));
        System.out.println("lcm(a+b): "+ lcm(a, b));
        System.out.println("phi(a): "+ phi(a));
        System.out.println("phi(b): "+ phi(b));
    }

    // Exercise 2.2.23 IntegerProperty
    // create the functions below: isPrime(), isRelativePrime(), factor(), gcd(), lcm(), phi()

    public static boolean isPrime(int x)
    {
        if (x <= 1) return false;
        if (x == 2) return true;
        if (x % 2 == 0) return false;
        for (int i = 3; i * i <= x; i += 2) {
            if (x % i == 0) return false;
        }
        return true;
    }

    public static boolean isRelativePrime(int a, int b)
    {
        return gcd(a, b) == 1;
    }

    public static int[] factor(int x)
    {
        int[] temp = new int[32];  // log2( Integer.MAX_VALUE ) < 32
        int count = 0;
        int n = x;

        for (int p = 2; p * p <= n; p++) {
            if (n % p == 0) {
                temp[count++] = p;
                while (n % p == 0) {
                    n = n / p;
                }
            }
        }
        if (n > 1) {
            temp[count++] = n;
        }

        int[] result = new int[count];
        for (int i = 0; i < count; i++) {
            result[i] = temp[i];
        }
        return result;
    }

    public static int gcd(int a, int b)
    {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public static long lcm(int a, int b)
    {
        return (long) a / gcd(a, b) * b;
    }

    public static long phi(int x)
    {
        long result = x;
        int n = x;
        int p = 2;

        while (p * p <= n) {
            if (n % p == 0) {
                result = result / p * (p - 1);
                while (n % p == 0) {
                    n = n / p;
                }
            }
            p++;
        }
        if (n > 1) {
            result = result / n * (n - 1);
        }
        return result;
    }
}