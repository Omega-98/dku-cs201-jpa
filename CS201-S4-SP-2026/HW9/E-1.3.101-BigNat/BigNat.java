
public class BigNat{
    public static void main(String[] args) {

        // convert input args into char array
        char [] a =  args[0].toCharArray();
        char [] b =  args[1].toCharArray();

        // Time to reverse it
        reverse(a);
        reverse(b);
        
        // To debug, you can print the a and b
        //System.out.println(Arrays.toString(a));
        //System.out.println(Arrays.toString(b));

        
        int N = Math.max(a.length, b.length);
        

        // 1. declare x, y and convert a,b to x,y
        int [] x = new int[N+1]  ;
        int [] y = new int[N+1]  ;

            
        // 2. Convert char array into int array, e.g. '9' to 9, '8' to 8 etc.
        // Your code here
        for (int i = 0; i < a.length; i++) {
                x[i] = a[i] - '0';
            }
        
        for (int i = 0; i < b.length; i++) {
                y[i] = b[i] - '0';
        }

        // 3. Conduct/simulate the carry-addion of decimal values as
        // we learned in primary school,         
        // Your code here
        int[] result = new int[N+1];
        int carry = 0;
        for (int i = 0; i < N+1; i++) {
            /*if(x[i]+y[i]>=10){
                result[i] = (x[i]+y[i]) % 10; //if here the result is 10, the next step cannot execute carry, which is wrong.
                carry = 1;
            }else{
                result[i] = x[i] + y[i] + carry;
                carry = 0;
            }*/
            int sum = x[i] + y[i] + carry;
            result[i] = sum % 10;
            carry = sum / 10;
        }

        StringBuilder sb = new StringBuilder();
        boolean isLeadingZero = true;
        for(int i=N; i>=0; i--){
            if(isLeadingZero && result[i]==0 && i!=0){
                continue;
            }
            isLeadingZero = false;
            sb.append(result[i]);
        }

        
        
        
            
        // Debug prints
        //System.out.println(Arrays.toString(x));
        //System.out.println(Arrays.toString(y));
        //System.out.println(Arrays.toString(z)));

        // Now, produce the output string
        String s = args[0] + " + " + args[1] +  " = " + sb.toString();

        // 4. Append r to s


        // Print s
        System.out.println(s);
        
        return;
    }
    
    public static void reverse(char [] x){
        for (int i=0;i<x.length/2;i++){
            char tmp = x[i];
            x[i] = x[x.length - i -1];
            x[x.length - i -1] = tmp;
        }
    }
}
