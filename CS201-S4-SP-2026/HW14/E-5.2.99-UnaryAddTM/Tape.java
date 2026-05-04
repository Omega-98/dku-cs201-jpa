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
        // Build the result by collecting all tape contents
        Stack<Character> allChars = new Stack<Character>();

        // Left side in reverse order (pop from left, push to allChars)
        Stack<Character> leftReversed = new Stack<Character>();
        while (!left.isEmpty()) {
            leftReversed.push(left.pop());
        }
        while (!leftReversed.isEmpty()) {
            allChars.push(leftReversed.pop());
        }

        // Current
        allChars.push(current);

        // Right side (pop from right, push to allChars)
        Stack<Character> rightReversed = new Stack<Character>();
        while (!right.isEmpty()) {
            rightReversed.push(right.pop());
        }
        while (!rightReversed.isEmpty()) {
            allChars.push(rightReversed.pop());
        }

        // Build input part (before =) and result part (after =)
        // First pass: collect all non-# characters in order
        java.util.List<Character> tapeList = new java.util.ArrayList<Character>();
        while (!allChars.isEmpty()) {
            char c = allChars.pop();
            if (c != '#') {
                tapeList.add(c);
            }
        }

        // tapeList now has all non-# chars in reverse order (from pop)
        // Reverse it to get correct order
        java.util.Collections.reverse(tapeList);

        // The input part is from original input (skip #)
        // The result part is tapeList (which should be the current tape state)
        StringBuilder inputPart = new StringBuilder();
        boolean first = true;
        for (int i = 0; i < originalInput.length(); i++) {
            char c = originalInput.charAt(i);
            if (c != '#') {
                if (!first) inputPart.append(" ");
                inputPart.append(c);
                first = false;
            }
        }

        StringBuilder resultPart = new StringBuilder();
        first = true;
        for (char c : tapeList) {
            if (!first) resultPart.append(" ");
            resultPart.append(c);
            first = false;
        }

        return inputPart.toString() + " = " + resultPart.toString();
    }
}