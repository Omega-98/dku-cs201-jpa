public class MergesortTrace {
    private static String[] aux;

    public static void sort(String[] a) {
        aux = new String[a.length];
        sort(a, 0, a.length);
    }

    public static void sort(String[] a, int lo, int hi) {
        int N = hi - lo;
        if (N <= 1) return;
        int mid = lo + N / 2;
        sort(a, lo, mid);
        sort(a, mid, hi);
        merge(a, lo, mid, hi);
    }

    public static void merge(String[] a, int lo, int mid, int hi) {
        int i = lo, j = mid, N = hi - lo;
        for (int k = 0; k < N; k++) {
            if (i == mid) aux[k] = a[j++];
            else if (j == hi) aux[k] = a[i++];
            else if (a[j].compareTo(a[i]) < 0) aux[k] = a[j++];
            else aux[k] = a[i++];
        }
        for (int k = 0; k < N; k++)
            a[lo + k] = aux[k];

        // Indent based on lo * 4
        int indent = lo * 4;
        StringBuilder sb = new StringBuilder();
        for (int k = 0; k < indent; k++) sb.append(" ");
        for (int k = lo; k < hi; k++) {
            sb.append(a[k]);
            if (k < hi - 1) sb.append(" ");
        }
        StdOut.println(sb.toString());
    }

    public static void main(String[] args) {
        String[] a = StdIn.readAllStrings();
        int n = a.length;

        // Print initial array
        for (int i = 0; i < n; i++) {
            StdOut.print(a[i] + " ");
        }
        StdOut.println();

        sort(a);
    }
}