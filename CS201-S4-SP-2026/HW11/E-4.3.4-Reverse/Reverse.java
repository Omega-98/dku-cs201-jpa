import java.util.*;

public class Reverse
{
    public static void main(String[] args)
    {
        // Exercise 4.3.4 Reverse
        // read strings from input and print them in reverse order

        // Complete the code here, see README on course website for problem description and instructions.
        //Stack<String> stack = new Stack<>();
        Deque<String> stack = new ArrayDeque<>();
        while(!StdIn.isEmpty()){
            String item = StdIn.readString();
            stack.push(item);
        }
        while(!stack.isEmpty()){
            System.out.println(stack.pop());
        }
        return;
    }
}