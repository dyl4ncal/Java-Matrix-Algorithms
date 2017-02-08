package ca.dylancalado.unittests;

import ca.dylancalado.matrixexperiments.Experiment3;
import ca.dylancalado.matrixexperiments.Matrix;
import java.util.Arrays;

/**
 *
 * @author Dylan
 */
public class Experiment3UnitTests 
{
    public static boolean testGetNumberOfTerms()
    {
        Matrix m = new Matrix(3, 3);
        int[][] sparseMatrix = {{5, 0, 0}, {0, 0, 0}, {0, 3, 0}};
        
        int actualOutput = Experiment3.getNumberOfTerms(m, sparseMatrix);
        int expectedOutput = 2;
        
        boolean result = actualOutput == expectedOutput;

        System.out.print("Get number of terms test passed? ");
        return result;
    }
    
    public static boolean testBuildSparseMatrix()
    {
        Matrix m = new Matrix(100, 100);
        
        int[][] sparseMatrix = Experiment3.buildSparseMatrix(m);
        
        int actualOutput = Experiment3.getNumberOfTerms(m, sparseMatrix);
        int expectedOutput = 100;
        
        boolean result = actualOutput == expectedOutput;

        System.out.print("Build sparse matrix test passed? ");
        return result;
    }
    
    public static boolean testStoreNonZeroEntries()
    {
        Matrix m = new Matrix(3, 3);
        
        int[][] sparseMatrix = {{0, 0, 3}, {0, 0, 0}, {0, 7, 0}};
        
        Experiment3.getNumberOfTerms(m, sparseMatrix);
        Experiment3.storeNonZeroEntries(m, sparseMatrix);
        
        int[] rowExpected = {1, 3, 0};
        int[] colExpected = {3, 2, 0};
        int[] valueExpected = {3, 7, 0};
        
        boolean result = false;
        
        if(Arrays.equals(Experiment3.getRowNum(), rowExpected)
            & Arrays.equals(Experiment3.getColNum(), colExpected)
            & Arrays.equals(Experiment3.getValue(), valueExpected))
        {
              result = true;      
        }
        
        System.out.print("Store nonzero entries test passed? ");
        return result;
    }
    
    public static boolean testTransposeSparseMatrix()
    {
        Matrix m = new Matrix(3, 3);
        
        int[][] sparseMatrix = {{0, 0, 3}, {0, 0, 0}, {0, 7, 0}};
        
        Experiment3.getNumberOfTerms(m, sparseMatrix);
        Experiment3.storeNonZeroEntries(m, sparseMatrix);
        Experiment3.transposeSparseMatrix(Experiment3.getRowNum(), Experiment3.getColNum(), Experiment3.getValue());
        
        int[] rowTranspose = {2, 3};
        int[] colTranspose = {3, 1};
        int[] valueTranspose = {7, 3};
        
        boolean result = false;
        
        if(Arrays.equals(Experiment3.getRowNumTransposed(), rowTranspose)
            & Arrays.equals(Experiment3.getColNumTransposed(), colTranspose)
            & Arrays.equals(Experiment3.getValueTransposed(), valueTranspose))
        {
              result = true;      
        }
       
        System.out.print("Transpose sparse matrix test passed? ");
        return result;
    }
    
    public static void testAllExperimentMethods()
    {
        System.out.println("Unit Tests Related to Experiment 3:\n");
        System.out.println(testGetNumberOfTerms());
        System.out.println(testBuildSparseMatrix());
        System.out.println(testStoreNonZeroEntries());
        System.out.println(testTransposeSparseMatrix() + "\n");
    }
}
