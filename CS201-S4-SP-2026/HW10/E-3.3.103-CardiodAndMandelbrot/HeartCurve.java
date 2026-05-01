public class HeartCurve {
    String fname;
    public HeartCurve() {}
    public void init (String [] args) {}

    public static Point turnLeft(double x, double y, double delta){
        double r = Math.sqrt(x * x + y * y);
        double theta = Math.atan2(y, x);
        double new_x = r * Math.sin(theta + delta);
        double new_y = r * Math.cos(theta + delta);
        return new Point(new_x, new_y);
    }

    public static Point moveRight(Point p, double distance) {
        p.x += distance;
        return p;
    }

    public void run() {
        StdDraw.enableDoubleBuffering();
        StdDraw.setPenColor(StdDraw.PINK);
        StdDraw.setPenRadius(0.005);
        double a = 0.25;

        double N = 360;

        double x0 = 0.25, y0 = 0;

        for (double t = 0.0; t <= N; t += 0.1) {
            double theta = Math.toRadians(t);
            double c = Math.cos(theta);
            double u = 2 * a * (1 - c);

            double x1 = u * c;
            double y1 = u * Math.sin(theta);

            Point p = turnLeft(x1, y1, Math.PI / 2);
            p = moveRight(p, 0.25);

            StdDraw.line(x0, y0, p.x, p.y);

            x0 = p.x;
            y0 = p.y;
        }

        StdDraw.show();
    }

    public static void main(String[] args) {
        String fname = args.length > 0 ? args[0] : null;
        StdDraw.enableDoubleBuffering();
        HeartCurve h = new HeartCurve();
        h.run();
    }
}