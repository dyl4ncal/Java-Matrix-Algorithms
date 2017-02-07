package ca.dylancalado.matrixexperiments.unittests;

import ca.dylancalado.matrixexperiments.Matrix;

/**
 *
 * @author Dylan
 */
public class MatrixUnitTests
{
    //Test creating, accessing, filling, etc


    public static boolean testCreateMatrix()
    {
        Matrix m = new Matrix(5, 5);
        double[][] testMatrix = new double[m.getNumRows()][m.getNumColumns()];
        boolean result = (testMatrix != null);
        
        System.out.print("Create matrix test passed? ");
        return result;
    }
    
    public static boolean testFillMatrix()
    {
        Matrix m = new Matrix(4, 4);
        double[][] matrix = new double[m.getNumRows()][m.getNumColumns()];

        m.fillMatrix(matrix);

        boolean result = true;
        
        if (matrix == null)
        {
            result = false;
        }

        System.out.print("Fill matrix test passed? ");
        return result;
    }  
    
    public static void testAllMatrixMethods()
    {
        System.out.println("Unit Tests Related to Matrices:\n");
        System.out.println(testCreateMatrix());
        System.out.println(testFillMatrix() + "\n");
    }
}
