public class WCPalindrome
{
    public static void main(String[] args) {
        // Exercise 3.1.11 WCPalindrome
        // Do not change this part
        System.out.println(isWatsonCrickPalindrome(args[0]));
        
        return;
    }

    public static boolean isWatsonCrickPalindrome(String sequence) {
    // Complete the code here, see README on course website for problem description and instructions.
    String complementSequence = sequence.replace("A", "t").replace("T", "a").replace("C", "g").replace("G", "c").toUpperCase();
    char[] complementSequenceArray = complementSequence.toCharArray();
    char[] reverseComplementArray = new char[complementSequence.length()];
    for(int i=0; i<complementSequence.length(); i++){
        reverseComplementArray[i] = complementSequenceArray[complementSequence.length() - i - 1];
    }
    String reverseComplementString = new String(reverseComplementArray);
    if(sequence.equals(reverseComplementString)){
        return true;
    }else{
        return false;
    }



}
}