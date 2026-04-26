
import java.util.regex.Matcher;
import java.util.regex.Pattern;

 


public class RE_match {
    // Complete the code here, see README on course website for problem description and instructions.
    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Usage: java RE_match <regex>");
            return;
        }
        String regex = args[0];
        Pattern pattern = Pattern.compile(regex);
        int count = 0;
        while(!StdIn.isEmpty()){
            String input = StdIn.readString();
            Matcher matcher = pattern.matcher(input);
            if(matcher.find()){
                count ++;
            }
        }
        StdOut.println("#matching string: " + count);
    }



}