public class Reversename
{
    public static void main(String[] args)    {
        // Exercise 3.1.17 Reversename
        
        String a = args[0];
        

        System.out.println(reverseName(a));

        return;
    }
    public static String reverseName(String sequence) {
        // Complete the code here, see README on course website for problem description and instructions.
        String[] parts = sequence.split("\\.");
        String[] resultArr = new String[parts.length];
        for(int i=0; i<parts.length; i++){
            resultArr[i] = parts[parts.length-i-1];
        }
        String resultString = String.join(".", resultArr);
        return resultString;
    }
}