import java.util.*;

class CheckDuplicate_intArray{

    public static void main(String args[]){
        
        // Fill in the blanks

        int[] a = new int[args.length];   // same as previous exercise


        for (int i = 0; i < args.length ; i++) { // same as previous exercise


            a[i] = Integer.parseInt(args[i]);


        }

        int [] counter = new int[args.length];

        for (int j=0; j<args.length; j++) {


            counter[a[j]-1] += 1 ;

        }

        System.out.println(Arrays.toString(counter));

        for (int i =0; i<counter.length; i++) {


            if (counter[i]>=2) {


                System.out.println("There are duplicate values");


                return;

            }
        }

        System.out.println("There is no duplicate value");
    }
}
