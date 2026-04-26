
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class VowelsInOrder
{
    public static void main(String[] args) { 
        String arg = args[0];
        String regexp = null;
        // Complete the code here, see README on course website for problem description and instructions.
        Pattern pattern = Pattern.compile("[^aeiou]*a[^aeiou]*e[^aeiou]*i[^aeiou]*o[^aeiou]*u[^aeiou]");
        Matcher matcher = pattern.matcher(args[0]);
        if(matcher.matches()){
            System.out.println("Yes");
        }else{
            System.out.println("No");
        }


    }
}