package turtlehunter.NeuralNetworks.matrix;

/**
 * turtlehunter.NeuralNetworks.matrix - uriel NeuralNetworks 6/12/2015
 */
public class MatrixMath {
    public static Matrix add(final Matrix a, final Matrix b) {
        final double result[][] = new double[a.getRows()][a.getCols()];
        for (int resultRow = 0; resultRow < a.getRows(); resultRow++) {
            for (int resultCol = 0; resultCol < a.getCols(); resultCol++) {
                result[resultRow][resultCol] = a.get(resultRow, resultCol) + b.get(resultRow, resultCol);
            }
        }
        return new Matrix(result);

    }
    public static Matrix divide(final Matrix a, final double b) {
        final double result[][] = new double[a.getRows()][a.getCols()];
        for (int row = 0; row < a.getRows(); row++) {
            for (int col = 0; col < a.getCols(); col++) {
                result[row][col] = a.get(row, col) / b;
            }
        }
        return new Matrix(result);
    }
    public static double dotProduct(final Matrix a, final Matrix b) {
        final double aArray[] = a.toPackedArray();
        final double bArray[] = b.toPackedArray();

        double result = 0;
        final int length = aArray.length;
        for (int i = 0; i < length; i++) {
            result += aArray[i] * bArray[i];
        }
        return result;
    }
    public static Matrix identity(final int size)
    public static Matrix multiply(final Matrix a, final double b)
    public static Matrix multiply(final Matrix a, final Matrix b)
    public static Matrix subtract(final Matrix a, final Matrix b)
    public static Matrix transpose(final Matrix input)
    public static double vectorLength(final Matrix input)
}
