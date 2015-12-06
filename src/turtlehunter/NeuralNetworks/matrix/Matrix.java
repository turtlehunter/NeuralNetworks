package turtlehunter.NeuralNetworks.matrix;

/**
 * turtlehunter.NeuralNetworks.matrix - uriel NeuralNetworks 5/12/2015
 */
public class Matrix {
    double[][] matrix;

    public Matrix(double[][] matrix) {
         this.matrix = matrix;
    }

    public static Matrix createColumnMatrix(final double input[]) {
        double[][] matrix = new double[0][input.length];
        Matrix m = new Matrix(matrix);
        for(int i=0; i<input.length; i++) {
            m.add(0, i, input[i]);
        }
        return m;
    }
    public static Matrix createRowMatrix(final double input[]) {
        double[][] matrix = new double[input.length][0];
        Matrix m = new Matrix(matrix);
        for(int i=0; i<input.length; i++) {
            m.add(i, 0, input[i]);
        }
        return m;
    }
    public void add(final int row, final int col, final double value) {
        if(this.matrix.length < row) {
            double[][] nm;
            if(this.matrix[0].length < col) {
                nm = new double[row][col];
            } else {
                nm = new double[row][this.matrix[0].length];
            }
            for (int x = 0; x<getRows();) {
                for (int y = 0; x<getCols();) {
                    nm[x][y] = this.matrix[x][y];
                }
            }
            this.matrix = nm;
        } else if(this.matrix[0].length < col) {
            double[][] nm = new double[this.matrix.length][col];
            for (int x = 0; x<getRows();) {
                for (int y = 0; x<getCols();) {
                    nm[x][y] = this.matrix[x][y];
                }
            }
            this.matrix = nm;
        }
        this.matrix[row][col] = value;

    }
    public void clear() {
        for (int x = 0; x<getRows();) {
            for (int y = 0; x<getCols();) {
                this.matrix[x][y] = 0;
            }
        }
    }
    public Matrix clone() {
        try {
            super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return new Matrix(this.matrix);
    }
    public boolean equals(final Matrix matrix) {
        return equals(matrix, 0);
    }
    public boolean equals(final Matrix matrix, int precision) {
        int p = 0;
        if (matrix.getCols() != getCols() || matrix.getRows() != getRows()) p++;
        if(p>precision) return false;
        for (int x = 0; x < getRows(); ) {
            for (int y = 0; x < getCols(); ) {
                if (matrix.get(x, y) != get(x, y)) p++;
                if(p>precision) return false;
            }
        }
        return true;
    }

    public double get(final int row, final int col) {
        return this.matrix[row][col];
    }
    public Matrix getCol(final int col) {
        double[][] temp = new double[getRows()][getCols()];
        for(int i=0; i<getRows(); i++) {
            temp[i][col] = this.matrix[i][col];
        }
        return new Matrix(temp);
    }
    public int getCols() {
        return this.matrix[0].length;
    }
    public Matrix getRow(final int row) {
        double[][] temp = new double[0][getCols()];
        temp[0] = this.matrix[row];
        return new Matrix(temp);
    }
    public int getRows() {
        return this.matrix.length;
    }
    public boolean isVector() {
        return getRows() == 1 || getCols() == 1;
    }
    public boolean isZero() {
        for (int x = 0; x < getRows(); ) {
            for (int y = 0; x < getCols(); ) {
                if(get(x, y) != 0) return false;
            }
        }
        return true;
    }
    public void set(final int row, final int col, final double value) {
        add(row, col, value);
    }
    public double sum() {
        double sum = 0;
        for (int x = 0; x < getRows(); ) {
            for (int y = 0; x < getCols(); ) {
                sum += get(x, y);
            }
        }
        return sum;
    }
    public double[] toPackedArray() {
        double[] ds = new double[getCols()*getRows()];
        for (int x = 0; x < getRows(); ) {
            for (int y = 0; x < getCols(); ) {
                ds[getRows()*x+y] = get(x, y);
            }
        }
        return ds;
    }
}
