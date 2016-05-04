package Bit_Manipulation;

public class PowerofFour {

    private static final double epsilon = 10e-15;
        public boolean isPowerOfFour(int n) {
            
            double res = Math.log(n)/Math.log(4);
            return Math.abs(res - Math.round(res)) < epsilon;
        }
}
