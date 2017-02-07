package ca.dylancalado.matrixexperiments;

/**
 *
 * @author Dylan
 */
public class Matrix 
{
    private int numRows;
    private int numColumns;
    
    public Matrix()
    {
        this.numRows = 0;
        this.numColumns = 0;
    }
    
    public Matrix(int numRows, int numColumns)
    {
        this.numRows = numRows;
        this.numColumns = numColumns;
    }
    
    public void fillMatrix(double[][] matrix)
    {
        double value = 1.0;
        for(int row = 0; row < numRows; row++)
        {
            for(int column = 0; column < numColumns; column++)
            {
                matrix[row][column] = value;
                value++;
            }
        }
            
    }  

    public int getNumRows() 
    {
        return numRows;
    }    
    
    public int getNumColumns() 
    {
        return numColumns;
    }

    public void setNumRows(int numRows) 
    {
       this.numRows = numRows;
    }
    
    public void setNumColumns(int numColumns) 
    {
       this.numColumns = numColumns;
    }
}
