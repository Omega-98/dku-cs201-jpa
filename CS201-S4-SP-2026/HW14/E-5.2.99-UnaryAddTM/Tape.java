public class Tape {
    public Stack<Character> left = new Stack<Character>();
    public Stack<Character> right = new Stack<Character>();
    private char current;
    private String originalInput;

    public Tape(String input) {
        originalInput = input;
        right.push('#');
        for (int i = input.length() - 1; i >= 0; i--)
            right.push(input.charAt(i));
        current = right.pop();
    }
    public static String reverse(String s) {
        /* Finish reverse() used in toString*/
        String left_half = null;
        String right_half = null;
        int N = s.length();
        if (N <= 1) return s;
        left_half = s.substring(0, N/2);
        right_half = s.substring(N/2, N);
        return reverse(right_half) + reverse(left_half);

    }
    public char read() {
        return current;
    }

    public void write(char symbol) {
        current = symbol;
    }

    public void moveLeft() {
        right.push(current);
        if (left.isEmpty())
            left.push('#');
        current = left.pop();
    }

    public void moveRight() {
        left.push(current);
        if (right.isEmpty())
            right.push('#');
        current = right.pop();
    }
    public String toString() {
        // Complete the code here, see README on course website for problem description and instructions.
        Stack<Character> temp = new Stack<Character>();
        
        
        while (!left.isEmpty()) {
            temp.push(left.pop());
        }
        temp.push(current);
        while (!right.isEmpty()) {
            temp.push(right.pop());
        }
        
        
        java.util.List<Character> chars = new java.util.ArrayList<Character>();
        while (!temp.isEmpty()) {
            char c = temp.pop();
            if (c != '#') {  // Skip '#' symbols
                chars.add(c);
            }
        }
        
        // Now build the result with spaces
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < chars.size(); i++) {
            result.append(chars.get(i));
            if (i < chars.size() - 1) {
                result.append(" ");
            }
        }
        
        
        StringBuilder formattedResult = new StringBuilder();
        boolean first = true;
        for (int i = 0; i < originalInput.length(); i++) {
            char c = originalInput.charAt(i);
            if (c != '#') {  // Skip '#' symbols
                if (!first) {
                    formattedResult.append(" ");
                }
                formattedResult.append(c);
                first = false;
            }
        }
        formattedResult.append(" = ");
        formattedResult.append(result.toString());
        
        return formattedResult.toString();
    }
}