public class ComplementWatsonCrick
{
    public static void main(String[] args) {
        // Exercise 3.1.10 ComplementWatsonCrick
        // TODO: your own description
        
        String s = StdIn.readString();
            
        System.out.println( Complement(s));
    } 
    
    public static String Complement(String s){
        // Complete the code here, see README on course website for problem( description and instructions.
        s = s.replace("A", "t").replace("T", "a").replace("C", "g").replace("G", "c").toUpperCase();
        return s;



    }
}