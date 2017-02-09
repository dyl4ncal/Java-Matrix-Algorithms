package ca.dylancalado.matrixexperiments;

import java.util.Arrays;
import java.util.Random;

/**
 * This experiment compares the performance of transposing a sparse matrix
 * using two different algorithms.
 * 
 * @author Dylan
 */
public class Experiment3 
{
    private static int numTerms;
    private static int[] value;
    private static int[] rowNum;
    private static int[] colNum;
    private static int[] valueTransposed;
    private static int[] rowNumTransposed;
    private static int[] colNumTransposed;
    private static int[][] originalMatrix;
    
    //I experimented on a 3000x3000 matrix as anything larger would take long to transpose.
    //10000x10000 matrix couldn't be transposed given two hours unfortunately.
    public static void runExperiment3()
    {
        System.out.println("Transposing a 3000x3000 Sparse Matrix (Linear Complexity Algorithm VS Inefficient Algorithm) Experiment:\n");
        
        Matrix m1 = new Matrix(3000, 3000);
        int[][] matrix1 = buildSparseMatrix(m1);
        numTerms = getNumberOfTerms(m1, matrix1);
        storeNonZeroEntries(m1, matrix1);
        transposeSparseMatrix(rowNum, colNum, value);
        Timer.endTimer();
        System.out.println("Linear complexity algorithm time: " + Timer.calculateRunTime() + " nanoseconds\n");
        
        
        Matrix m2 = new Matrix(3000, 3000);
        int[][] matrix2 = buildSparseMatrix(m2);
        int[][] transposedMatrix = inefficientTranspose(matrix2);
        Timer.endTimer();
        System.out.println("Inefficient algorithm time: " + Timer.calculateRunTime() + " nanoseconds\n");
        System.out.print("Sparse matrix transpose correct? " + checkTransposeCorrectness(transposedMatrix));
    }
    
    //Method to create a sparse matrix where ~1% of elements are nonzero.
    public static int[][] buildSparseMatrix(Matrix m)
    {
        int[][] sparseMatrix = new int[m.getNumRows()][m.getNumColumns()];
        //First fill matrix of a given size with zeros.
        for(int row = 0; row < m.getNumRows(); row++)
        {
            for(int column = 0; column < m.getNumColumns(); column++)
            {
                sparseMatrix[row][column] = 0;
            }
        }
        
        //If number of nonzero terms is less than ~1%, insert values at random locations 
        //in matrix until it is ~1% filled with nonzero terms.
        while(m.getNumRows() * m.getNumColumns() * 0.01 > getNumberOfTerms(m, sparseMatrix))
        {
            Random r = new Random();
            int minIndex = 0;
            int maxIndex = m.getNumRows();
            int randomIndex1 = r.nextInt(maxIndex - minIndex) + minIndex;
            int randomIndex2 = r.nextInt(maxIndex - minIndex) + minIndex;
            sparseMatrix[randomIndex1][randomIndex2] = r.nextInt(100);
        }
        originalMatrix = sparseMatrix;
        return sparseMatrix;
    }
    
    //Calculate the number of nonzero terms in a matrix and store the terms in an array.
    public static int getNumberOfTerms(Matrix m, int[][] matrix) 
    {
        numTerms = 0;
        for (int row = 0; row < m.getNumRows(); row++)
        {
            for (int column = 0; column < m.getNumColumns(); column++)
            {
                if (matrix[row][column] != 0) 
                {
                    numTerms++;
                }
            }
        }
        return numTerms;
    }
    
    //O(n^2) count through matrix, but this way you don't need to guess 1D array size.
    public static void storeNonZeroEntries(Matrix m, int[][] matrix)
    {
        value = new int[numTerms + 1];
        rowNum = new int[numTerms + 1];
        colNum = new int[numTerms + 1];
        rowNumTransposed = new int[numTerms];
        colNumTransposed = new int[numTerms];
        valueTransposed = new int[numTerms];
        int counter = 0;
        for(int row = 0; row < m.getNumRows(); row++)
        {
            for(int column = 0; column < m.getNumColumns(); column++) 
            {
                if (matrix[row][column] != 0)
                {
                    value[counter] = matrix[row][column];//Stores Values
                    rowNum[counter] = row + 1;           //Stores row #
                    colNum[counter] = column + 1;        //Stores col #
                    counter++;
                }
            }
        }
    }
    
    //Transposes a sparse matrix in linear time.
    public static void transposeSparseMatrix(int[] row, int[] column, int[] value)
    {
        Timer.startTimer();
        
        int[] columnSize = new int[column.length + 1];
        int[] rowNext = new int[row.length + 1];
        
        for(int i = 1; i <= column.length; i++)
        {
            columnSize[i] = 0;
        }
        for(int i = 0; i < numTerms; i++)
        {
            columnSize[colNum[i]]++;
        }
        
        rowNext[1] = 0;
        for(int i = 2; i <= column.length; i++)
        {
            rowNext[i] = rowNext[i-1] + columnSize[i-1];
        }
        
        for(int i = 0; i < numTerms; i++)
        {
            int j = rowNext[colNum[i]]++;
            rowNumTransposed[j] = colNum[i];
            colNumTransposed[j] = rowNum[i];
            valueTransposed[j] = value[i];
        }
    }
    
    //Bad method for transposing a large sparse matrix.
    public static int[][] inefficientTranspose(int[][] matrix)
    {
        Timer.startTimer();
        
        int value;
        for(int row = 0; row < ((matrix.length/2) + 1); row++)
        {
            for(int column = row; column < (matrix[0].length); column++)
            {
                value = matrix[row][column];
                matrix[row][column] = matrix[column][row];
                matrix[column][row] = value;
            }
        }
        return matrix;
    }
    
    //Check if the transpose is correct by transposing a second time,
    //which should produce a matrix identical to the original.
    public static boolean checkTransposeCorrectness(int[][] transposedMatrix)
    {
        
        if(Arrays.equals(transposedMatrix, originalMatrix))
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    public static int[] getValue() 
    {
        return value;
    }    
    
    public static int[] getRowNum() 
    {
        return rowNum;
    }
    
    public static int[] getColNum() 
    {
        return colNum;
    }
    
    public static int[] getValueTransposed() 
    {
        return valueTransposed;
    }
    
    public static int[] getRowNumTransposed() 
    {
        return rowNumTransposed;
    }
    
    public static int[] getColNumTransposed() 
    {
        return colNumTransposed;
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

3
Transposing a 3000x3000 Sparse Matrix (Linear Complexity Algorithm VS Inefficient Algorithm) Experiment:

Linear complexity algorithm time: 3939917 nanoseconds

Inefficient algorithm time: 55596050 nanoseconds

Sparse matrix transpose correct? true
Experiment 3 complete!

Matrix Experiments Main Menu:
-----------------------------
1. Run Experiment by Number
2. Run Related Unit Tests
3. Run All Unit Tests
4. Exit Program
4
BUILD SUCCESSFUL (total time: 16 minutes 6 seconds)
*/
