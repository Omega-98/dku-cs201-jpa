
public class Calculator3
{
    public static void main(String[] args)
    {
        // Complete the code here, see README on course website for problem description and instructions.
        while(!StdIn.isEmpty()){
            int a = StdIn.readInt();
            char op1 = StdIn.readString().charAt(0);
            int b = StdIn.readInt();
            char op2 = StdIn.readString().charAt(0);
            int c = StdIn.readInt();
            int result = 0;
            if(isPrior(op1)==false && isPrior(op2)==true){
                int temp = calculate(b, op2, c);
                result = calculate(a, op1, temp);
            }else{
                int temp = calculate(a, op1, b);
                result = calculate(temp, op2, c);
            }
            StdOut.println(a + " " + op1 + " " + b + " " + op2 + " " + c + " = " + result);

        }

    }
    public static int calculate(int a, char op, int b) {
        switch(op){
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            case '/':
                return a / b;
            case '%':
                return a % b;
            default:
                return 0;

        }
        
    }
    public static boolean isPrior(char op){
        if(op == '*' || op == '/' || op == '%'){
            return true;
        }else{return false;}
    }
}