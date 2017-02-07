package ca.dylancalado.matrixexperiments;

/**
 *
 * @author Dylan
 */
public class Experiment2 
{
    private Matrix m = new Matrix();
    private int[] array = new int[(m.getNumRows()*3) - 2];
    
    public static void runExperiment2()
    {
        
    }
    
    public void initializeTridiagonalMatrix(Matrix m)
    {
        
    }
    
    public void store(int i, int j, int x)
    {
        switch(i-j)
        {
            case -1:
                array[2 * m.getNumRows() - 2 + i] = x;
                break;
            case 0:
                array[m.getNumRows() + i - 2] = x;
                break;
            case 1:
                array[i-2] = x;
                break;
            default:
                System.out.println("Program Error");
                    break;
        }
                
    }
    
    public double retrieve(int i, int j, int x)
    {
        switch(i-j)
        {
            case -1:
                return array[2 * m.getNumRows() - 2 + i];
            case 0:
                return array[m.getNumRows() + i - 2];
            case 1:
                return array[i - 2];
            default:
                System.out.println("Program Error");
                break;
        }
        return 0.696969696969696969;
    }
}

/*

*************Output******************



*/
