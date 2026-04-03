import java.text.DecimalFormat;
import java.util.Random;
public class Montehall_simplified {
    public static void main(String[] args) {

        int n = Integer.parseInt(args[0]);
        double percentage1, percentage2;
        DecimalFormat df = new DecimalFormat("##.##");// for formating percentage to 2 decimal places
        
        int seed = Integer.parseInt(args[0]);
        Random generator = new Random(seed);
        
        // Note: use generator.nextDouble() to generate a random number
        // between 0 and 1.
        
        // Complete the code here, see README on course website for problem description and instructions.
        double win_notChange = 0;
        double win_Change = 0;
        /*int lose_notChange = 0;
        int lose_Change = 0;*/
        int hostOpen = 1;
        for(int i=0;i<n;i++) {                                              //for not changing
            int p = (int) (generator.nextDouble() * 3);
            if(p == 0){
                // hostOpen = (int) (generator.nextDouble() * 2 + 1);
                win_notChange += 1;
            }else if (p == 1 || p == 2) {
                // hostOpen = 3 - p;
                //lose_notChange += 1;                
            }
        }
        for(int j=0;j<n;j++) {                                              //for changing
            int p = (int) (generator.nextDouble() * 3);                         //if change, when not choosing 0, it must win
            if(p == 0){
                // hostOpen = (int) (generator.nextDouble() * 2 + 1);
                //lose_Change += 1;
            }else if (p == 1 || p == 2) {
                win_Change += 1;               
            }
        

            

        }
        percentage1 = (double)win_notChange/n*100;
        percentage2 = (double)win_Change/n*100;



        
        System.out.println("Sucess rate of no switch: " + df.format(percentage1) + "%");
        System.out.println("Sucess rate of switching gate: " + df.format(percentage2) + "%");
        
    }
}
