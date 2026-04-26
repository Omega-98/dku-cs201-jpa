import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CountMatches {
    public static void main(String[] args) { 
        int count = 0;
        String input = null;
        String regexp = StdIn.readLine();
        Pattern pattern = Pattern.compile(regexp);
        Matcher matcher = null;
        // Complete the code here, see README on course website for problem description and instructions.
        while(!StdIn.isEmpty()){
            input = StdIn.readString();
            matcher = pattern.matcher(input);
            while(matcher.find()){
                count ++;
            
        }
        StdOut.println(count);
    }
    
}
}