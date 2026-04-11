public class ImproveNo2Slash
{
    public static void main(String[] args)
    {
        // Exercise 4.1.30 ImproveNo2Slash
        String url= StdIn.readString() ;

        // Complete the code here, see README on course website for problem description and instructions.

        // Double index algorithm
        char[] input = url.toCharArray();
        char[] output = new char[input.length];
        int write = 0;
        for(int read = 0; read < input.length && write < input.length; read ++){
            if(read>1 && input[read] == '/' && input[read-1] == '/'){
                continue;
            }else{
                output[write] = input[read];
                write ++;
            }
        }
        String outputString = new String(output, 0, write); //obtain output array from 0 to write.
        System.out.println(outputString);




        return;
    }
}