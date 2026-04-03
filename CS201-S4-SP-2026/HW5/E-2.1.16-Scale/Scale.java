import java.util.Arrays;

public class Scale {
    // textbook 2.1.16
    
    public static double max(double[] arr){
        // Complete the code here, see README on course website for problem description and instructions.
        double max_value = 0;
        for(int i=0; i<arr.length; i++){
            if(arr[i]>max_value){
                max_value = arr[i];
            }else{
                continue;
            }
        }
        return max_value;
    }


    public static double min(double[] arr){
        // Complete the code here, see README on course website for problem description and instructions.
        double min_value = Double.MAX_VALUE;
        for(int i=0; i<arr.length; i++){
            if(arr[i]<min_value){
                min_value = arr[i];
            }else{
                continue;
            }
        }
        return min_value;



    }
    public static void scale(double[] arr){
        // Complete the code here, see README on course website for problem description and instructions.
        double max_value = max(arr);
        double min_value = min(arr);
        double difference = Math.abs(max_value-min_value);
        for(int i=0; i<arr.length; i++){
            arr[i] = (arr[i] - min_value) / difference;
        }
        

    }

    public static void main(String[] args) {
        // Do not change this part
        double[] arr=StdIn.readAllDoubles();
        scale(arr);
        StdOut.println(Arrays.toString(arr));
    }
}