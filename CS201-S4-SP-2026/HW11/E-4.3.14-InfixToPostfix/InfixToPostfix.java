
public class InfixToPostfix

{ 
    // Complete the code here, see README on course website for problem description and instructions.
    public static void main(String[] args){
    Stack<String> element = new Stack<>();
    Stack<String> operator = new Stack<>();
    //Stack<String> input = new Stack<>();
    while(!StdIn.isEmpty()){
        String token = StdIn.readString();
        if(token.equals("(")){
          continue;
        }else if(token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")){
          operator.push(token);
        }else if(token.equals(")")){
          String rightNum = element.pop();
          String leftNum = element.pop();
          String middleOperator = operator.pop();
          String concatenation = leftNum + " " + rightNum + " " + middleOperator;
          element.push(concatenation);
        }else{
          element.push(token);
        }
    }
    System.out.println(element.pop());
     }
}
/*
  Excerpt From
  Computer Science
  Sedgewick, Robert,Wayne, Kevin
  This material may be protected by copyright.
*/