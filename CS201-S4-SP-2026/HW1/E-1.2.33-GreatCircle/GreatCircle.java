public class GreatCircle {
    public static void main(String[] args) {
        double distance ;

        // convert into from degree to radians
        double x_1 = Math.toRadians(Double.parseDouble(args[0]));
        double y_1 = Math.toRadians(Double.parseDouble(args[1]));
        double x_2 = Math.toRadians(Double.parseDouble(args[2]));
        double y_2 = Math.toRadians(Double.parseDouble(args[3]));

        double angle ;

        // This part has the form `angle = Math.acos (...)` from the formula in
        // the problem description

        // Complete the code here, see README on course website for problem description and instructions.
        double intev = Math.acos(Math.sin(x_1)*Math.sin(x_2)+Math.cos(x_1)*Math.cos(x_2)*Math.cos(y_1-y_2));
    


        // convert it to degress and multiply 60
        angle = Math.toDegrees(intev);
        distance = 60 * angle;

        
        System.out.println(distance + " nautical miles");
    }
}