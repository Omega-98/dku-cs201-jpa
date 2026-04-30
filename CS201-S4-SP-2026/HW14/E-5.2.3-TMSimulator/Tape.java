public class Tape {
    public Stack<Character> left = new Stack<Character>();
    public Stack<Character> right = new Stack<Character>();
    private char current;

    public Tape(String input) {
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
        // Create a temporary stack to hold all tape symbols
        Stack<Character> temp = new Stack<Character>();
        
        // Move all symbols from left to right (correct order)
        while (!left.isEmpty()) {
            temp.push(left.pop());
        }
        temp.push(current);
        while (!right.isEmpty()) {
            temp.push(right.pop());
        }
        
        // Remove all trailing '#' symbols
        while (!temp.isEmpty() && temp.peek() == '#') {
            temp.pop();
        }
        
        // Move all symbols to right stack to remove leading '#'
        while (!temp.isEmpty()) {
            right.push(temp.pop());
        }
        
        // Remove all leading '#' symbols
        while (!right.isEmpty() && right.peek() == '#') {
            right.pop();
        }
        
        // Move back to temp for final representation
        while (!right.isEmpty()) {
            temp.push(right.pop());
        }
        
        // Use Stack.toString() to get the final representation
        return temp.toString().trim();
    }
}