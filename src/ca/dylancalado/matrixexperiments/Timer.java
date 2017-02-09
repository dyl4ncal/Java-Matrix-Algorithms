package ca.dylancalado.matrixexperiments;

/**
 * A timing class for testing the runtime performance of pieces of code.
 * 
 * @author Dylan
 */
public class Timer
{
    private static long tStart;
    private static long tFinish;
    private static long totalRunTime;
    
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
    
    public static long calculateRunTime()
    {
        totalRunTime = tFinish - tStart;
        return totalRunTime;
    }
}
