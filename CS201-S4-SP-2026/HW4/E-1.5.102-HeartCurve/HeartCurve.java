public class HeartCurve {
    public static void main(String[] args) {
     
        String fname= args.length>0 ? args[0] : null;

        StdDraw.enableDoubleBuffering();
        StdDraw.setPenColor(StdDraw.PINK);
        int a = 1;
        
        StdDraw.setXscale(-4, +4);
        StdDraw.setYscale(-4, +4);
        double N = 360;

        double x0 = 0, y0 = 0;

        for (double t = 0.0; t <= N; t += 0.1) {
            
            // compute (x1,y1) and draw the line (x0,y0) to (x1, y1)

            // Complete the code here, see README on course website for problem description and instructions.
          double phi = Math.toRadians(t);
          double x1 = 2 * a * (1-Math.cos(phi)) * Math.sin(phi);
          double y1 = 2 * a * (1-Math.cos(phi)) * Math.cos(phi);
          StdDraw.line(x0,y0,x1,y1);
          x0=x1;
          y0=y1;
        }
        
				//--------------------------------------
        // Don't modify anything below this line
				//--------------------------------------
				
        StdDraw.show();

				// The following code just says if you give a file name at the
				// command line it will write the drawing into the file and
				// exit, otherwise the drawing window would stay open until
				// you close it manually.

				// This is purely for SAG checking to dump the drawing in .png
				// file and compare with the golden reference.
				
        if (fname != null) {
            StdDraw.save(fname); // fname must end with .png
            System.exit(0);
        }
        return;
    }
    


}