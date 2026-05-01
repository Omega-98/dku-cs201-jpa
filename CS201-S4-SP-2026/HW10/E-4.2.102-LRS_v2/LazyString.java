public class LazyString implements Comparable<LazyString> {

    //---------------------------------------------
    // Instance var
    //---------------------------------------------

    private final String parent;
    private final int start;
    private final int length;

    //---------------------------------------------
    // Constructor O(1)
    //---------------------------------------------
    public LazyString(String p, int start, int end) {
        // O(1) in time and memory
        this.parent = p;
        this.start = start;
        this.length = end - start;
    }

    public LazyString(String p) {
        // O(1) in time and memory
        this.parent = p;
        this.start = 0;
        this.length = p.length();
    }

    //---------------------------------------------
    // Instance method
    //---------------------------------------------
    public int length() {
        // O(1) in time and memory
        return this.length;
    }

    public char charAt(int i) {
        // O(1) in time and memory

        return this.parent.charAt(this.start + i);
    }

    public String toString() {
        // O(length()) in time and memory

        return this.parent.substring(this.start, this.start + this.length);
    }

    public LazyString substring(int start, int end) {
        // O(1) in time and memory
        // Note: call a String.substring here will not result in O(1) memory and time.


        return new LazyString(this.parent, this.start + start, this.start + end);
    }

    public LazyString substring(int start) {
        // O(1) in time and memory
        // Note: String.substring is not a O(1) operation
        return new LazyString(this.parent, this.start + start, this.start + this.length);
    }

    public int compareTo(LazyString s) {
        // O(n) in time, O(1) in memory
        // The same semantics as String.compareTo with perforamnce requirement that memory usage is O(1)

        int len1 = this.length();
        int len2 = s.length();
        int lim = Math.min(len1, len2);

        for (int k = 0; k < lim; k++) {
            char c1 = this.charAt(k);
            char c2 = s.charAt(k);
            if (c1 != c2) {
                return c1 - c2;
            }
        }

        return len1 - len2;
    }

    //---------------------------------------------
    // Test client
    //---------------------------------------------
    public static void main(String[] args) {
        String x = args.length > 0 ? args[0] : "abcdef";
        String y = args.length > 1 ? args[1] : "bcdefg";
        LazyString a = new LazyString(x);
        LazyString b = new LazyString(y);


        StdOut.println("LazyString a: " + a);
        StdOut.println("a.charAt(3): " + a.charAt(3));
        StdOut.println("LazyString a.substring(1): " + a.substring(1));
        StdOut.println("LazyString a.substring(1, 5): " + a.substring(1, 5));
        StdOut.println("LazyString x.substring(1, 5): " + x.substring(1, 5));
        StdOut.println("LazyString a.substring(1, 5).substring(2): " + a.substring(1, 5).substring(2));
        StdOut.println("LazyString a.substring(1, 5).substring(2, 4): " + a.substring(1, 5).substring(2, 4));
        StdOut.println("LazyString x.substring(1, 5).substring(2, 4): " + x.substring(1, 5).substring(2, 4));
        StdOut.println("LazyString x.substring(1, 5).substring(2): " + x.substring(1, 5).substring(2));
        StdOut.println("LazyString x.substring(1, 5).charat(2): " + x.substring(1, 5).charAt(2));
        StdOut.println("LazyString a.substring(1, 5).substring(1).toString().equals(x.substring(1,5).substring(2)): " + a.substring(1, 5).substring(1).toString().equals(x.substring(1, 5).substring(1)));

        StdOut.println("LazyString a.substring(0, 3): " + a.substring(0, 3));
        StdOut.println("LazyString a.substring(0): " + a.substring(0));
        StdOut.println("LazyString b: " + b);
        StdOut.println("LazyString b.legnth: " + b.length);
        StdOut.println("a.compareTo(b): " + a.compareTo(b));
        StdOut.println("b.compareTo(a): " + b.compareTo(a));
        StdOut.println("LazyString a.substring(1): " + a.substring(1));
        StdOut.println("LazyString b.substring(0,b.length-1): " + b.substring(0, b.length - 1));
        StdOut.println("a.substring(1).compareTo(b.substring(0,b.length-1)): " + a.substring(1).compareTo(b.substring(0, b.length - 1)));
    }
}