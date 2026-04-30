public class Chop {

    public static void chop(short n) {
        int value = n & 0xFFFF;  // treat as unsigned 16-bit
        int bitPos = 0;

        while (value != 0) {  // don't change this line
            if ((value & 1) != 0) {
                int power = 1 << bitPos;
                System.out.printf("%04X\n", power);
            }
            value >>>= 1;
            bitPos++;
        }
    }

    public static void main(String[] args) {
        if (args.length == 0) {
            System.err.println("Usage: java Chop <hex short>");
            return;
        }

        String s = args[0];

        
        if (s.startsWith("0x") || s.startsWith("0X")) {
            s = s.substring(2);
        }

        int val;

        try {
            
            val = Integer.parseInt(s, 16);
        } catch (NumberFormatException e) {
            
            String abs = s.startsWith("-") ? s.substring(1) : s;
            int absVal = Integer.parseInt(abs, 16);
            
            val = (0x10000 - absVal) & 0xFFFF;
        }

        short n = (short) val;
        chop(n);
    }
}