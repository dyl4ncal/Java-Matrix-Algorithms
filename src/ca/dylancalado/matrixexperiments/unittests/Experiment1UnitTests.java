package ca.dylancalado.matrixexperiments.unittests;

import ca.dylancalado.matrixexperiments.Experiment1;
import ca.dylancalado.matrixexperiments.Matrix;
import java.util.Arrays;

/**
 *
 * @author Dylan
 */
public class Experiment1UnitTests 
{
    public static boolean testRowMajorMapping()
    {
        Matrix m = new Matrix(3, 3);
        double[][] testMatrix = { {1.0, 2.0, 3.0}, {4.0, 5.0, 6.0}, {7.0, 8.0, 9.0}};
        
        double[] actualOutput = Experiment1.rowMajorMapping(m, testMatrix);
        double[] expectedOutput = {1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0};
        
        boolean result = Arrays.equals(actualOutput, expectedOutput);

        System.out.print("Row-major mapping test passed? ");
        return result;
    }
    
    public static boolean testRowMajorAccess()
    {
        Matrix m = new Matrix(3, 3);
        double[] rowMajorMatrix = {1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0};
        double expectedOutput = 9.0;
        
        boolean result = (expectedOutput == Experiment1.rowMajorAccess(3, 3, m, rowMajorMatrix));

        System.out.print("Row-major access test passed? ");
        return result;
    }
    
    public static boolean testColumnMajorMapping()
    {
        Matrix m = new Matrix(3, 3);
        double[][] testMatrix = { {1.0, 2.0, 3.0}, {4.0, 5.0, 6.0}, {7.0, 8.0, 9.0}};
        
        double[] actualOutput = Experiment1.columnMajorMapping(m, testMatrix);
        double[] expectedOutput = {1.0, 4.0, 7.0, 2.0, 5.0, 8.0, 3.0, 6.0, 9.0};
        
        boolean result = Arrays.equals(actualOutput, expectedOutput);

        System.out.print("Column-major mapping test passed? ");
        return result;
    }
    
    public static boolean testColumnMajorAccess()
    {
        Matrix m = new Matrix(3, 3);
        double[] columnMajorMatrix = {1.0, 4.0, 7.0, 2.0, 5.0, 8.0, 3.0, 6.0, 9.0};
        double expectedOutput = 5.0;

        boolean result = (expectedOutput == Experiment1.columnMajorAccess(2, 2, m, columnMajorMatrix));
        
        System.out.print("Column-major access test passed? ");
        return result;
    }
    
    public static void testAllExperimentMethods()
    {
        System.out.println("Unit Tests Related to Experiment 1:\n");
        System.out.println(testRowMajorMapping());
        System.out.println(testRowMajorAccess());
        System.out.println(testColumnMajorMapping());
        System.out.println(testColumnMajorAccess() + "\n");
    }
}
