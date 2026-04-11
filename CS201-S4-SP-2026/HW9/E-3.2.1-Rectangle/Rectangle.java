// Exercise 3.2.1 Rectangle
// Please fill in the perimeter(), intersects() and contains() methods.

public class Rectangle
{

    
    private final double x, y;    // center of rectangle
    private final double width;   // width of rectangle
    private final double height;  // height of rectangle
    
    // Complete the code here, see README on course website for problem description and instructions.
    public Rectangle(double x0, double y0, double w, double h)
    {
        x = x0;
        y = y0;
        width = w;
        height = h;
    }
    public double area()
    {  return width * height;  }

    public double perimeter(){
        return 2 * (width + height);
    }

    public boolean intersects(Rectangle other){
        // current rectangle
        double leftA = x - width/2;
        double rightA = x + width/2;
        double bottomA = y - height/2;
        double topA = y + height/2;

        // input rectangle
        double leftB = other.x - other.width/2;
        double rightB = other.x + other.width/2;
        double bottomB = other.y - other.height/2;
        double topB = other.y + other.height/2;

        // exclude the conditions that two do not intersect
        if(leftA>=rightB || rightA<=leftB || bottomA>=topB || topA<=bottomB){
            return false;
        }else{
            return true;
        }


    }

    public boolean contains(Rectangle other){ // some rectangle contains other
        // current rectangle
        double leftA = x - width/2;
        double rightA = x + width/2;
        double bottomA = y - width/2;
        double topA = y + height/2;

        // input rectangle
        double leftB = other.x - other.width/2;
        double rightB = other.x + other.width/2;
        double bottomB = other.y - other.width/2;
        double topB = other.y + other.height/2;

        if(leftA<=leftB && rightA>=rightB && topA>=topB && bottomA<=bottomB){
            return true;
        }else{
            return false;
        }

    }

    public String toString() {
        return "Rectangle "+ width + "x"+ height + " centered at (" + x + ", " + y + ").";
    }
        
    public String infoString() {
        return "   perimeter = " + perimeter() + ", area = " + area();
    }

    public static Rectangle CreateRectangleFromStdin(){
        double x = StdIn.readDouble();
        double y = StdIn.readDouble();
        double w = StdIn.readDouble();
        double h = StdIn.readDouble();
        return new Rectangle(x,y,w,h);
    }
    
    public static void main(String[] args)
    {
        Rectangle A =  CreateRectangleFromStdin();
        Rectangle B =  CreateRectangleFromStdin();
        System.out.println("A : " + A + A.infoString());
        System.out.println("B : " + B + B.infoString());
        
        System.out.println("A contains B: " + A.contains(B));
        System.out.println("B contains A: " + B.contains(A));
        
        System.out.println("A intersects B: " + A.intersects(B));
        System.out.println("B intersects A: " + B.intersects(A));
    }
}