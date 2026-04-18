import java.util.*;

public class Tabulate {

    public static final String COLUMNDELIMITER = ";";
    public static final int SEP_WIDTH=2;

    public static String[][] ReadCSV(String fname){
        int nRows = CountCsvRows(fname);
        return ReadCSV(fname, nRows);
    }

    public static String[][] ReadCSV(String fname, int nRows) {
        In fp = new In(fname);
        String[][] rows = new String[nRows][];
        for (int i = 0; i < nRows; i++) {
            String line = fp.readLine();
            rows[i] = line.split(COLUMNDELIMITER, -1);
        }
        fp.close();
        return rows;
    }

    public static int CountCsvRows(String fname) {
        In fp = new In(fname);
        int count = 0;
        while (!fp.isEmpty()) {
            fp.readLine();
            count++;
        }
        fp.close();
        return count;
    }

    public static void Tabulate(String[][] rows) {
        String[] header = rows[0];
        String[][] body = Arrays.copyOfRange(rows, 1, rows.length);
        Tabulate(body, header);
    }
    
    public static void Tabulate(String [][] body , String[] header) {
        int[] wx = MaxWidth (body, header);
        PrintRow(header, wx, "|");
        PrintDashSeparator(wx);
        for (String[] i: body) {
            PrintRow(i, wx, "|");
        } 
    } 
    
    public static void PrintRow(String[] row, int[] columnWidth, String separator) {
        String sep = " ".repeat(SEP_WIDTH) + separator + " ".repeat(SEP_WIDTH);
        System.out.print("    ");
        for (int i = 0; i < row.length; i++) {
            if (i > 0) System.out.print(sep);
            System.out.print(PadOnLeft(row[i], columnWidth[i]));
        }
        System.out.println();
    }
 
    public static String  PadOnLeft(String a, int width){
        assert (a.length() <= width);
        int len = (""+a).length();
        return " ".repeat(width - len) + a;
    }
    
    public static int[] MaxWidth(String[][] body, String[] header) {
        int[] wx = new int[header.length];
        UpdateMaxWidth(wx, header);
        for (String[] row : body) {
            UpdateMaxWidth(wx, row);
        }
        return wx;
    }

    public static void UpdateMaxWidth( int [] columnWidth,  String [] row ){
        for (int i=0;i<columnWidth.length;i++) {
            columnWidth[i] = Math.max(columnWidth[i], row[i].length());
        }
        return ;
    }

    public static void PrintDashSeparator(int[] columnWidth) {
        System.out.print("    "); 
        
        for (int i = 0; i < columnWidth.length; i++) {
            int dashes;
      
            if (columnWidth.length == 1) {
                dashes = columnWidth[i];
            } 
            else if (i == 0 || i == columnWidth.length - 1) {
                dashes = columnWidth[i] + SEP_WIDTH;
            } 
            else {
                dashes = columnWidth[i] + SEP_WIDTH * 2;
            }
            for (int k = 0; k < dashes; k++) {
                System.out.print("-");
            }
            if (i < columnWidth.length - 1) {
                System.out.print("+");
            }
        }
        System.out.println();
    }
    public static void Tabulate2(String[][] a) {
        int[] wx = new int[a[0].length];
        for (int i = 0; i < a.length; i++) {
            UpdateMaxWidth(wx, a[i]);
        }
        for (int i = 0; i < a.length; i++) {
            PrintDashSeparator(wx);
            PrintRow(a[i], wx, "|");
        }
        PrintDashSeparator(wx);
    }

    public static void main(String[] args) {
        String  fname = args[0];
        String[][] k= ReadCSV(fname);
        StdOut.println("Debug prints(content of csv file)");
        StdOut.println("-".repeat(60));
        for (String[] i :k)
            StdOut.println(Arrays.toString(i));
        StdOut.println();
        StdOut.println();
        Tabulate(k);
        return;
    }
}