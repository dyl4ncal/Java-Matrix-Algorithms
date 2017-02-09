package ca.dylancalado.matrixexperiments;

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
        System.out.println("Initializing a tri-diagonal matrix:");
        for (int i = 0; i < tdMatrix.length; i++)
        {
            for (int j = 0; j < tdMatrix[i].length; j++)
            {
                System.out.print(tdMatrix[i][j] + " ");
            }
            System.out.println();
        }
        
        System.out.println("\nStoring tri-diagonal matrix to a 1d array(order: upper,main,lower):");
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
26 30 0 0 0 
35 14 44 0 0 
0 25 86 41 0 
0 0 91 49 97 
0 0 0 51 35 

Storing tri-diagonal matrix to a 1d array(order: upper,main,lower):
30 44 41 97 26 14 86 49 35 35 25 91 51 

Retrieving a value from 1d array(based on indices of tri-diagonal matrix): 
From top diagonal: 30
From main diagonal: 86
From lower diagonal: 25

Experiment 2 complete!

Matrix Experiments Main Menu:
-----------------------------
1. Run Experiment by Number
2. Run Related Unit Tests
3. Run All Unit Tests
4. Exit Program
4
BUILD SUCCESSFUL (total time: 2 seconds)
*/
