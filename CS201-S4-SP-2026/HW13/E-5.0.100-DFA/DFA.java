/*public class DFA {
    // Complete the code here, see README on course website for problem description and instructions.
    private int start;
    private boolean[] action;
    private ST<Character, Integer>[] next;
    public DFA(String filename){  
        In in = new In(filename);
        int N = in.readInt();
        
        action = new boolean[N];
        next = (ST<Character, Integer>[]) new ST[N];
        
        for(int i=0; i<N; i++){
            next[i] = new ST<Character, Integer>();
            String lable = in.readString();
            action[i] = lable.equalsIgnoreCase("True") || lable.equals("1");
        }
        
        while(!in.isEmpty()){
            int from = in.readInt();
            String symbol = in.readString();
            int to = in.readInt();
            next[from].put(symbol.charAt(0), to);
        }
        } 
    public boolean recognizes(String input){
        int state = start; 
        System.out.print(state);
        for (int i = 0; i < input.length(); i++){
            //char c = input.charAt(i);
            if(!next[state].contains(input.charAt(i))){
                System.out.print(" #" + input.charAt(i) + "-> Error");
                System.out.println();
                return false;
            }
            state = next[state].get(input.charAt(i)); 
            System.out.print(" #" + input.charAt(i) + "-> " + state);
        }
        boolean isAccepted = action[state];
        System.out.println(isAccepted ? " Yes" : " No");
        return action[state]; 
    

    }
    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Usage: java DFA <filename>");
            return;
        }

        DFA dfa = new DFA(args[0]);
        while (!StdIn.isEmpty()) {
            String input = StdIn.readString();
            dfa.recognizes(input);
        }
    }


}*/
public class DFA {
    private int start;
    private boolean[] action;
    private ST<Character, Integer>[] next;

    @SuppressWarnings("unchecked")
    public DFA(String filename) {
        In in = new In(filename);

        // Read number of states
        int numStates = in.readInt();

        // Read alphabet, for example "ab"
        String alphabet = in.readString();

        // Read start state
        start = in.readInt();

        // Initialize arrays
        action = new boolean[numStates];
        next = (ST<Character, Integer>[]) new ST[numStates];

        // Read each state's accepting status and transition table
        for (int state = 0; state < numStates; state++) {
            next[state] = new ST<Character, Integer>();

            // Read True / False
            action[state] = in.readBoolean();

            // Read transition for each symbol in alphabet
            for (int i = 0; i < alphabet.length(); i++) {
                char c = alphabet.charAt(i);
                int nextState = in.readInt();
                next[state].put(c, nextState);
            }
        }
    }

    public boolean recognizes(String input) {
        int state = start;

        // Print starting state
        StdOut.print(state);

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);

            int nextState = next[state].get(c);

            StdOut.print(" #" + c + "-> " + nextState);

            state = nextState;
        }

        return action[state];
    }

    public static void main(String[] args) {
        DFA dfa = new DFA(args[0]);

        while (!StdIn.isEmpty()) {
            String input = StdIn.readString();

            if (dfa.recognizes(input)) {
                StdOut.println(" Yes");
            } else {
                StdOut.println(" No");
            }
        }
    }
}