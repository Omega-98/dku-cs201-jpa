//import  java.util.Arrays;

public class BigNatADT{
    // This class support number of digits arbitrarily


    //-------------------------------------------------
    // Member variables
    //-------------------------------------------------

    // The type int here can be replaced with 'byte', using `int` is
    // simpler and avoid type casting

    // Note: we use an array m_digits to reprsent the number, and
    // m_digits[0] is the least significant digit

    private int [] m_digits;


    //-------------------------------------------------
    // Constructor 1 
    //-------------------------------------------------
    // create a BigNatADT from a string 
    public BigNatADT(String s) {
        
        m_digits = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            
            m_digits[i] = s.charAt(s.length() - 1 - i) - '0';
        }
    }
    
    //-------------------------------------------------
    // Constructor 2
    //-------------------------------------------------
    // create a n-digit zero value
    public BigNatADT( int n) {
        m_digits = new int[n];
        
        for (int i = 0; i < n; i++) {
            m_digits[i] = 0;
        }
    } 

    //-------------------------------------------------
    // Instance method
    //-------------------------------------------------

    // convert it to string, charAt(0) is the most significant digit
    public String  toString() {
        
        StringBuilder sb = new StringBuilder();
        for (int i = m_digits.length - 1; i >= 0; i--) {
            sb.append(m_digits[i]);
        }
        return sb.toString();
    } 

    // return number of digits
    public  int nDigits() { return m_digits.length;}

    public int getIthDigit(int i){
        // Note:  if nDigits() >= i , then return 0
        if (i >= m_digits.length) return 0;
        return m_digits[i];
    }
    
    public boolean equals ( BigNatADT a) {
        int N = Math.max(a.nDigits(), nDigits());
        for (int i =0;i<N;i++ ) {
            if ( a.getIthDigit(i) != getIthDigit(i)) return false;
        }
        return true;
    }
    
    // add x, y and create a new object, without modify x,y
    public static BigNatADT add ( BigNatADT x, BigNatADT y){
        
        // To guarantee precision, we uniformly add 1-digit to the
        // resulting value for the carry, so the number of digits in
        // the resulting value is as follows:
        
        int N = Math.max(x.nDigits(), y.nDigits() )+1;
        BigNatADT result = new BigNatADT(N); 
        int carry = 0;
        
        
        for (int i = 0; i < N - 1; i++) { 
            int sum = x.getIthDigit(i) + y.getIthDigit(i) + carry;
            result.m_digits[i] = sum % 10;  
            carry = sum / 10;               
        }
        
        
        result.m_digits[N - 1] = carry;
        
        
        return result;
    }

    // multiply two numbers and create a new one
    public static BigNatADT times ( BigNatADT a,  BigNatADT b) { 
        BigNatADT r = new BigNatADT(a.nDigits() + b.nDigits()); 
        
        
        for (int i = 0; i < a.nDigits(); i++) {
            int carry = 0; 
            for (int j = 0; j < b.nDigits(); j++) {
                
                int product = a.getIthDigit(i) * b.getIthDigit(j) + carry + r.m_digits[i + j];
                r.m_digits[i + j] = product % 10;  
                carry = product / 10;              
            }
            
            if (carry > 0) {
                r.m_digits[i + b.nDigits()] += carry;
            }
        }
        
        
        return r;
    } 

    //-------------------------------------------------
    // Method (private)
    //-------------------------------------------------
    
    // Reverse the digits (from index 0 to nDigits()-1).  Example: if
    // the current value is 1234 then after reverse, it becomes 4321
    private void reverse(){
       
        for (int i = 0; i < m_digits.length / 2; i++) {
            swap(i, m_digits.length - 1 - i);
        }
    }
    
    // This function is given, can use it in reverse() method
    private void swap(int i, int j){
        int tmp = m_digits[i];
        m_digits[i] = m_digits[j];
        m_digits[j] = tmp;
    }

    //-------------------------------------------------
    // Test client
    //-------------------------------------------------

    public static void main(String[] args) {
     
        BigNatADT x = new BigNatADT(args[0]);
        BigNatADT y = new BigNatADT(args[1]);
        System.out.println("input: x = " +  x);
        System.out.println("input: y = " +  y);


        BigNatADT z = add(x,y);

        System.out.println("add: " + x + " + " + y +  " = "  + z);

        System.out.println("add: " + y + " + " + x +  " = "  +  add(y,x));

        System.out.println("check: " +  add(x,y).equals(add(y,x)));

        {
            
            BigNatADT xy = times(x,y);
            System.out.printf("times: %s * %s  = %s\n", x, y , xy);
            xy = times(y,x);
            System.out.printf("times: %s * %s  = %s\n", y,x , xy);
            System.out.println("check: " +  times(x,y).equals(times(y,x)));
        }

        
        return;
    }
}