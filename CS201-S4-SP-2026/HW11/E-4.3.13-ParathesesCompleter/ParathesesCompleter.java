public class ParathesesCompleter {
    public static void main(String[] args)
    {
        Stack<String> elements = new Stack<>();
        Stack<String> operator = new Stack<>();
        String []sx = StdIn.readAllStrings();
        
        // Complete the code here, see README on course website for problem description and instructions.
        
        for(int i=0; i<sx.length; i++){
            if(sx[i].equals(")")){
                String rightElement = elements.pop();
                String leftElement = elements.pop();
                String middleOperator = operator.pop();
                String item = "(" +  leftElement + middleOperator + rightElement + ")";
                elements.push(item);
            }else if(sx[i].equals("+") || sx[i].equals("-") || sx[i].equals("*") || sx[i].equals("/")){
                operator.push(sx[i]);
            }else{
                elements.push(sx[i]);
            }
        }
        System.out.println(elements.pop());


        return;
    }
}