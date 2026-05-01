import java.util.*;

public class InsertionSortTrace {
    public static void main(String[] args) {
        String[] a = StdIn.readAllStrings();
        int n = a.length;

        // Print initial array
        for (int i = 0; i < n; i++) {
            StdOut.print(a[i] + " ");
        }
        StdOut.println();

        // Insertion sort with trace
        for (int i = 1; i < n; i++) {
            String temp = a[i];
            int j = i;
            while (j > 0 && a[j-1].compareTo(temp) > 0) {
                a[j] = a[j-1];
                j--;
            }
            a[j] = temp;

            // Print after each insertion
            for (int k = 0; k < n; k++) {
                StdOut.print(a[k] + " ");
            }
            StdOut.println();
        }
    }
}