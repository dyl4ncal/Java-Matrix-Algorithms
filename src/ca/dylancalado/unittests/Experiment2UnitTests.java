package ca.dylancalado.unittests;

import static ca.dylancalado.matrixexperiments.Experiment2.*;
import ca.dylancalado.matrixexperiments.Matrix;

/**
 *
 * @author Dylan
 */
public class Experiment2UnitTests 
{
    public static boolean testInitializeTridiagonalMatrix()
    {
        Matrix m = new Matrix(3, 3);
        int[][] tdm = initializeTridiagonalMatrix(m);
        
        boolean result = false;
        
        //Confirms no nonzero entires exist off diagonals.
        if(tdm[2][0]==0 && tdm[3][0]==0 && tdm[3][1]==0
           & tdm[1][3]==0 && tdm[0][2]==0 && tdm[0][3]==0)
        {
            result = true;
        }
        
        System.out.print("Initialize tridiagonal matrix test passed? ");
        return result;
    }

    public static void testAllExperimentMethods()
    {
        System.out.println("Unit Tests Related to Experiment 2:\n");
        System.out.println(testInitializeTridiagonalMatrix() + "\n");
    }
}
