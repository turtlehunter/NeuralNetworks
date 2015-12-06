package turtlehunter.NeuralNetworks.matrix;

/**
 * turtlehunter.NeuralNetworks.matrix - uriel NeuralNetworks 5/12/2015
 */
public class BiPolarUtil {
    public static double bipolar2double(final boolean b) {
        return b ? 1 : -1;
    }
    public static double[] bipolar2double(final boolean b[]) {
        double[] ds = new double[b.length];
        for(int i = 0; i<b.length; i++) {
            ds[i] = bipolar2double(b[i]);
        }
        return ds;
    }
    public static double[][] bipolar2double(final boolean b[][]) {
        double[][] dss = new double[b.length][];
        for (int i = 0; i<b.length; i++) {
            dss[i] = bipolar2double(b[i]);
        }
        return dss;
    }
    public static boolean double2bipolar(final double d) {
        return d != -1;
    }
    public static boolean[] double2bipolar(final double d[]) {
        boolean[] bs = new boolean[d.length];
        for (int i=0; i<d.length;i++) {
            bs[i] = double2bipolar(d[i]);
        }
        return bs;
    }
    public static boolean[][] double2bipolar(final double d[][]) {
        boolean[][] bss = new boolean[d.length][];
        for (int i = 0; i<d.length; i++) {
            bss[i] = double2bipolar(d[i]);
        }
        return bss;
    }
}
