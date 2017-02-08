package ca.dylancalado.matrixexperiments;

/**
 *
 * @author Dylan
 */
public class Experiment1 
{
    public static void runExperiment1()
    {
        //Performance test on row-major access vs column-major access for 100x100 matrix.
        System.out.println("100x100 Matrix:");
        Matrix m1 = new Matrix(100, 100);
        double[][] matrix1 = new double[m1.getNumRows()][m1.getNumColumns()];
        m1.fillMatrix(matrix1);
        
        rowMajorAccess(100, 100, m1, rowMajorMapping(m1, matrix1));
        Timer.endTimer();
        System.out.println("Row-major access time: " + Timer.calculateRunTime() + " nanoseconds");
        columnMajorAccess(100, 100, m1, columnMajorMapping(m1, matrix1));
        Timer.endTimer();
        System.out.println("Column-major access time: " + Timer.calculateRunTime() + " nanoseconds\n");
        
        //Performance test on row-major access vs column-major access for 1000x1000 matrix.
        System.out.println("1000x1000 Matrix:");
        Matrix m2 = new Matrix(1000, 1000);
        double[][] matrix2 = new double[m2.getNumRows()][m2.getNumColumns()];
        m2.fillMatrix(matrix2);
        
        rowMajorAccess(1000, 1000, m2, rowMajorMapping(m2, matrix2));
        Timer.endTimer();
        System.out.println("Row-major access time: " + Timer.calculateRunTime() + " nanoseconds");
        columnMajorAccess(1000, 1000, m2, columnMajorMapping(m2, matrix2));
        Timer.endTimer();
        System.out.println("Column-major access time: " + Timer.calculateRunTime() + " nanoseconds\n");
        
        //Performance test on row-major access vs column-major access for 10000x10000 matrix.
        System.out.println("10000x10000 Matrix:");
        Matrix m3 = new Matrix(10000, 10000);
        double[][] matrix3 = new double[m3.getNumRows()][m3.getNumColumns()];
        m3.fillMatrix(matrix3);
        
        rowMajorAccess(10000, 10000, m3, rowMajorMapping(m3, matrix3));
        Timer.endTimer();
        System.out.println("Row-major access time: " + Timer.calculateRunTime() + " nanoseconds");
        columnMajorAccess(10000, 10000, m3, columnMajorMapping(m3, matrix3));
        Timer.endTimer();
        System.out.println("Column-major access time: " + Timer.calculateRunTime() + " nanoseconds");
    }
    
    //Maps a 2D array onto a 1D array using row-major mapping.
    public static double[] rowMajorMapping(Matrix m, double[][] matrix)
    {
        double[] array = new double[m.getNumRows() * m.getNumColumns()];
        int i = 0;
        
        for (int row = 0; row < m.getNumRows(); row++)
        {
            for (int column = 0; column < m.getNumColumns(); column++)
            {
                array[i] = matrix[row][column];
                if(i < array.length-1)
                {
                    i++;
                }
            }
        }  
        return array;
    }
  
    //Maps a 2D array onto a 1D array using column-major mapping.
    public static double[] columnMajorMapping(Matrix m, double[][] matrix)
    {
        double[] array = new double[m.getNumRows() * m.getNumColumns()];
        int i = 0;
        
        for (int column = 0; column < m.getNumColumns(); column++)
        {
            for (int row = 0; row < m.getNumRows(); row++)
            {
                array[i] = matrix[row][column];
                if(i < array.length-1)
                {
                    i++;
                }
            }
        }
        return array;
    }   
    
    //Retrieves an array element based on the row-major index function.
    public static double rowMajorAccess(int index1, int index2, Matrix m, double[] array)
    {
        Timer.startTimer();
        return array[(index1 - 1) * (m.getNumColumns()) + (index2 - 1)];
    }
    
    //Retrieves an array element based on the column-major index function.
    public static double columnMajorAccess(int index1, int index2, Matrix m, double[] array)
    {
        Timer.startTimer();
        return array[(index1 - 1) + (m.getNumRows() * (index2 - 1))];
    }
}

/*

*************Output******************
run:

Matrix Experiments Main Menu:
-----------------------------
1. Run Experiment by Number
2. Run Related Unit Tests
3. Run All Unit Tests
4. Exit Program
1
Pick an experiment to run:
1. Experiment 1 
2. Experiment 2
3. Experiment 3

1
100x100 Matrix:
Row-major access time: 1862 nanoseconds
Column-major access time: 621 nanoseconds

1000x1000 Matrix:
Row-major access time: 3103 nanoseconds
Column-major access time: 2483 nanoseconds

10000x10000 Matrix:
Row-major access time: 4034 nanoseconds
Column-major access time: 3724 nanoseconds

Experiment 1 complete!

Matrix Experiments Main Menu:
-----------------------------
1. Run Experiment by Number
2. Run Related Unit Tests
3. Run All Unit Tests
4. Exit Program
4
BUILD SUCCESSFUL (total time: 41 seconds)
*/

