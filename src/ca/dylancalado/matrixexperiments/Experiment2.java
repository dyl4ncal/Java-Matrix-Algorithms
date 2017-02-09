package ca.dylancalado.matrixexperiments;

import java.util.Arrays;
import java.util.Random;

/**
 * This experiment stores a tri-diagonal matrix in a one dimensional 
 * array diagonal-wise(top diagonal, main, then lower) with initialize,
 * store and retrieve operations.
 * 
 * 
 * @author Dylan
 */
public class Experiment2 
{
    private static Matrix m = new Matrix(4, 4);
    private static int[] array = new int[((m.getNumRows()+1)*3) - 2];
    
    public static void runExperiment2()
    {
        Matrix m = new Matrix(4, 4);
        int[][] tdMatrix = initializeTridiagonalMatrix(m);
        System.out.println("Initializing a tri-diagonal matrix: \n");
        for (int i = 0; i < tdMatrix.length; i++)
        {
            for (int j = 0; j < tdMatrix[i].length; j++)
            {
                System.out.print(tdMatrix[i][j] + " ");
            }
            System.out.println();
        }
        
        System.out.println("Storing tri-diagonal matrix to a 1d array(order: upper,main,lower):");
        for(int i = 0; i <= m.getNumRows(); i++)
        {
            for(int j = 0; j <= m.getNumRows(); j++)
            {
                store(i, j, tdMatrix[i][j]);       
            }
        }
        for(int index = 0; index < array.length; index++)
        {
            System.out.print(array[index] + " ");
        }
        
        
        System.out.println("\n\nRetrieving a value from 1d array(based on indices of tri-diagonal matrix): \n"
                + "From top diagonal: " + retrieve(0,1)
                + "\nFrom main diagonal: " + retrieve(2,2)
                + "\nFrom lower diagonal: " + retrieve(2,1));
    }
    
    //Creates a matrix with nonzero values along three diagonals.
    public static int[][] initializeTridiagonalMatrix(Matrix m)
    {
        int[][] tdMatrix = new int[m.getNumRows()+1][m.getNumColumns()+1];
        Random r = new Random();
        
        for(int i = 0; i < 2; i++)
        {
            tdMatrix[0][i] = r.nextInt(100);
        }
        
        int rowIndex = 1;
        for(int i = 0; i < m.getNumRows()-1; i++)
        {    
            int colIndex = i;
            
            for (int j = 0; j < 3; j++)
            {
                tdMatrix[rowIndex][colIndex] = r.nextInt(100);
                colIndex++;
            }
            rowIndex++;
        }

        for(int i = 0; i < 2; i++)
        {
            tdMatrix[m.getNumRows()][m.getNumColumns()-1] = r.nextInt(100);
            if(i == 1)
            {
                tdMatrix[m.getNumRows()][m.getNumColumns()] = r.nextInt(100);
            }
        }
        return tdMatrix;
    }
    
    public static void store(int i, int j, int x)
    {
        switch(i - j)
        {
            case 1:
                array[2 * (m.getNumRows()+1) - 2 + i] = x;
                break;
            case 0:
                array[(m.getNumRows()+1) + i - 1] = x;
                break;
            case -1:
                array[i] = x;
                break;
            default:
                break;
        }
    }
    
    public static int retrieve(int i, int j)
    {
        int value;
        switch(i - j)
        {
            case 1:
                return value = array[2 * (m.getNumRows()+1) - 2 + i];
            case 0:
                return value = array[(m.getNumRows()+1) + i - 1];
            case -1:
                return value = array[i];
            default:
                value = 0;
                break;
        }
        return value;
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

2
Initializing a tri-diagonal matrix: 
[[96, 93, 0, 0, 0], [16, 14, 18, 0, 0], [0, 94, 50, 88, 0], [0, 0, 63, 87, 38], [0, 0, 0, 20, 4]]

Storing tri-diagonal matrix to a 1d array(order: upper,main,lower):
93 18 88 38 96 14 50 87 4 16 94 63 20 

Retrieving a value from 1d array(based on indices of tri-diagonal matrix): 
From top diagonal: 93
From main diagonal: 50
From lower diagonal: 94

Experiment 2 complete!

Matrix Experiments Main Menu:
-----------------------------
1. Run Experiment by Number
2. Run Related Unit Tests
3. Run All Unit Tests
4. Exit Program
4
BUILD SUCCESSFUL (total time: 7 seconds)
*/
