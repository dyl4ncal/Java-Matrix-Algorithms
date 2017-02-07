package ca.dylancalado.matrixexperiments;

/**
 *
 * @author Dylan
 */
public class Timer
{
    private static long tStart;
    private static long tFinish;
    private static long totalSortTime;
    
    public static long startTimer()
    {
        tStart = System.nanoTime();
        return tStart;
    }
    
    public static long endTimer()
    {
         tFinish = System.nanoTime();
         return tFinish;
    }
    
    public static long calculateSortTime()
    {
        totalSortTime = tFinish - tStart;
        return totalSortTime;
    }
}
