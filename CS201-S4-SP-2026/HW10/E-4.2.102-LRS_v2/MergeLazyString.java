public class MergeLazyString {
    private static LazyString[] aux;

    public static void merge(LazyString[] a, int lo, int mid, int hi) {
        int i = lo, j = mid, N = hi - lo;
        for (int k = 0; k < N; k++) {
            if (i == mid) aux[k] = a[j++];
            else if (j == hi) aux[k] = a[i++];
            else if (a[j].compareTo(a[i]) < 0) aux[k] = a[j++];
            else aux[k] = a[i++];
        }
        for (int k = 0; k < N; k++)
            a[lo + k] = aux[k];
    }

    public static void sort(LazyString[] a) {
        aux = new LazyString[a.length];
        sort(a, 0, a.length);
    }

    public static void sort(LazyString[] a, int lo, int hi) {
        int N = hi - lo;
        if (N <= 1) return;
        int mid = lo + N / 2;
        sort(a, lo, mid);
        sort(a, mid, hi);
        merge(a, lo, mid, hi);
    }

    public static void main(String[] args) {
        String[] strings = StdIn.readAllStrings();
        LazyString[] a = new LazyString[strings.length];
        for (int i = 0; i < strings.length; i++) {
            a[i] = new LazyString(strings[i]);
        }
        sort(a);
        for (int i = 0; i < a.length; i++)
            StdOut.println(a[i]);
    }
}