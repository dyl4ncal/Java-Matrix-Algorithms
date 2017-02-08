package ca.dylancalado.userinterface;

import ca.dylancalado.unittests.Experiment1UnitTests;
import ca.dylancalado.unittests.Experiment3UnitTests;
import ca.dylancalado.matrixexperiments.*;
import ca.dylancalado.unittests.Experiment2UnitTests;
import ca.dylancalado.unittests.MatrixUnitTests;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Dylan
 */
public class UI
{
    private static Scanner userInput = new Scanner(System.in);
    
    //User interface which provides a user-friendly menu for navigation.
    public static void runUI() throws IOException
    {
        while (true)
        {
            System.out.println("\nMatrix Experiments Main Menu:\n-----------------------------");
            System.out.println("1. Run Experiment by Number\n"
                + "2. Run Related Unit Tests\n3. Run All Unit Tests\n"
                + "4. Exit Program");
            
            switch (userInput.next()) 
            {
                case "1":
                    runExperimentByNumber();
                    break;
                case "2":
                    selectUnitTest();
                    break;
                case "3":
                    runAllUnitTests();
                    break;
                case "4":
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid Input");
                    break;
            }
        }
    }
    
    //Method to run individual experiments.
    public static void runExperimentByNumber() throws IOException
    {
        System.out.println("Pick an experiment to run:\n"
                + "1. Experiment 1 \n2. Experiment 2\n3. Experiment 3\n");

        System.gc();
        //MemoryUsage.memoryCurrentlyUsed();
        switch (userInput.next())
        {
            case "1":
                Experiment1.runExperiment1();
                System.out.println("\nExperiment 1 complete!");
                break;
            case "2":
                Experiment2.runExperiment2();
                System.out.println("\nExperiment 2 complete!");
                break;
            case "3":
                Experiment3.runExperiment3();
                System.out.println("\nExperiment 3 complete!");
                break;   
            default:
                System.out.println("Invalid Input");
                break;
        }  
    }
    
    //Method to select related groups of unit tests.
    public static void selectUnitTest() throws IOException
    {
        System.out.println("1. Run Test Methods for Matrix Class\n"
                           + "2. Run Test Methods for Experiment1 Class\n"
                           + "3. Run Test Methods for Experiment2 Class\n"
                           + "4. Run Test Methods for Experiment3 Class\n");
        
        switch (userInput.next())
        {
            case "1":
                System.out.println(MatrixUnitTests.testCreateMatrix());
                System.out.println(MatrixUnitTests.testFillMatrix());
                break;
            case "2":
                System.out.println(Experiment1UnitTests.testRowMajorMapping());
                System.out.println(Experiment1UnitTests.testRowMajorAccess());
                System.out.println(Experiment1UnitTests.testColumnMajorMapping());
                System.out.println(Experiment1UnitTests.testColumnMajorAccess());
                break;
            case "3":
                System.out.println(Experiment2UnitTests.testInitializeTridiagonalMatrix());
                break;
            case "4":
                System.out.println(Experiment3UnitTests.testGetNumberOfTerms());
                System.out.println(Experiment3UnitTests.testBuildSparseMatrix());
                System.out.println(Experiment3UnitTests.testStoreNonZeroEntries());
                System.out.println(Experiment3UnitTests.testTransposeSparseMatrix());
                break;
        }           
    } 
    
    //Method to run all unit tests at once.
    public static void runAllUnitTests() throws IOException
    {
       MatrixUnitTests.testAllMatrixMethods();
       Experiment1UnitTests.testAllExperimentMethods();
       Experiment3UnitTests.testAllExperimentMethods();
    }
}
