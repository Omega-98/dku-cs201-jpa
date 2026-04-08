public class Password {
    public static void main(String[] args){
        // Do not change this part

        // password is readin from stdio
        String password = StdIn.readAll();
        
        boolean is_safe = IsSafePassword(password);
        
        System.out.println(is_safe);
    }
    // Implement static method IsSafePassword.
    
    // Complete the code here, see README on course website for problem description and instructions.

    public static boolean IsSafePassword(String s){
        if(s.length() < 8){return false;}
        int count_uppercase = 0;
        int count_lowercase = 0;
        int count_digit = 0;
        int count_specialchar = 0;
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(ch >= 'A' && ch <= 'Z'){ //at least one uppercase
                count_uppercase += 1;
            }else if(ch >= 'a' && ch <= 'z'){ //at least one lowercase
                count_lowercase += 1;
            }else if(ch >= '0' && ch <= '9'){ //at least one digit
                count_digit += 1;
            }else if(!(ch >= '0' && ch <= '9') && !(ch >= 'A' && ch <= 'Z') && !(ch >= 'a' && ch <= 'z')){
                count_specialchar += 1;
            }else{
                continue;
            }
        }
        return (count_digit>0 && count_lowercase>0 && count_specialchar>0 && count_uppercase>0) ? true : false;
    }



}