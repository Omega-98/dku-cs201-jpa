public class TuringMachine {
    private String[] action;
    private ST<Character, Integer>[] next;
    private ST<Character, Character>[] out;

    public TuringMachine(String filename) {
        In in = new In(filename);
        int n = in.readInt();
        String alphabet = in.readString();
        action = new String[n];
        next = (ST<Character, Integer>[]) new ST[n];
        out = (ST<Character, Character>[]) new ST[n];
        for (int st = 0; st < n; st++) {
            action[st] = in.readString();
            if (action[st].equals("Halt") || action[st].equals("Yes") || action[st].equals("No"))
                continue;
            
            next[st] = new ST<Character, Integer>();
            for (int i = 0; i < alphabet.length(); i++) {
                int state = in.readInt();
                next[st].put(alphabet.charAt(i), state);
            }
            out[st] = new ST<Character, Character>();
            for (int i = 0; i < alphabet.length(); i++) {
                char symbol = in.readString().charAt(0);
                out[st].put(alphabet.charAt(i), symbol);
            }
        }
    }

    public String scanFor(int curState) {
        if (action[curState].equals("Halt") || action[curState].equals("Yes") || action[curState].equals("No")) {
            return "";
        }
        ST<Character, Integer> st = next[curState];
        ST<Character, Character> st2 = out[curState];
        StringBuilder res = new StringBuilder();
        // 按照模板原有逻辑进行遍历
        for (Character c : st.keys()) {
            if (st.get(c) != curState) {
                res.append(c);
            } else if (!st2.get(c).equals(c)) {
                res.append(c);
            }
        }
        return res.toString();
    }

    public String simulate(String input) {
        Tape tape = new Tape(input);
        int state = 0;
        
        while (action[state].equals("L") || action[state].equals("R")) {
            // 预测下一步将会读取到的字符，用于推断 nextState
            char nextChar = '#';
            if (action[state].equals("R")) {
                nextChar = tape.right.isEmpty() ? '#' : tape.right.peek();
            } else if (action[state].equals("L")) {
                nextChar = tape.left.isEmpty() ? '#' : tape.left.peek();
            }
            
            int nextState = next[state].get(nextChar);
            String scanStr = scanFor(nextState);
            String nextAction = action[nextState];
            
            // 严格还原对齐布局: Action 占 7 字符（左对齐），Tape右对齐到16宽，状态切换精确预留位置
            StdOut.printf("%-7s%16s   %2d -> %d", action[state], tape.toString(), state, nextState);
            
            if (nextAction.equals("Halt") || nextAction.equals("Yes") || nextAction.equals("No")) {
                StdOut.printf(" %-6s\n", nextAction);
            } else {
                if (scanStr.length() > 0) {
                    StdOut.printf(" scanning for  %s\n", scanStr);
                } else {
                    StdOut.println();
                }
            }
            
            // 发生实质转移
            if (action[state].equals("R"))
                tape.moveRight();
            if (action[state].equals("L"))
                tape.moveLeft();
            char c = tape.read();
            tape.write(out[state].get(c));
            state = next[state].get(c);
        }
        
        // 循环外，打印停机时刻 (格式完全根据示例分析对齐)
        return action[state] + " " + tape.toString();
    }

    public static void main(String[] args) {
        TuringMachine tm = new TuringMachine(args[0]);
        while (StdIn.hasNextLine()) {
            String temp = StdIn.readLine();
            if (temp.equals("-1")) {
                StdOut.println("Terminated");
                break;
            }
            StdOut.println(tm.simulate(temp));
        }
    }
}