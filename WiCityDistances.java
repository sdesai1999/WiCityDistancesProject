import java.io.File;
import java.util.*;

/**
 * Chapter 8 AP Comp Sci Project with 2D Arrays
 * 
 * @author Saurav Desai
 * @version 1/15/16
 */
public class WiCityDistances 
{
    private int[][] distances = new int[17][17];

    /**
     * Constructor for objects of class WiCityDistances
     * this constructor initializes the 2D distances array, so all the data can be used throughout the class
     */
    public WiCityDistances() throws Exception
    {
        File myFile = new File("Mileage.csv");
        Scanner myScan = new Scanner(myFile);
        String[] splitData;
        String dataFromFile = "";
        int lineCount = 0;

        while (myScan.hasNext())
        {
            dataFromFile = myScan.nextLine();
            splitData = dataFromFile.split(",");

            if (lineCount == 0)
            {

            }
            else
            {
                for (int i = 0; i < splitData.length; i++)
                {
                    distances[lineCount-1][i] = Integer.parseInt(splitData[i]);
                }
            }

            lineCount++;
        }

    }

    /**
     * method printTable
     * will print the 2D array in a neat, table format when called in the main method
     * 
     * @param  none
     * @return     none
     */
    public void printTable()
    {
        for (int x = 0; x < distances.length; x++)
        {
            if (x == 0)
            {
                System.out.print("\t" + "[" + (x+1) + "]" + "\t");
            }
            else
            {
                System.out.print("[" + (x+1) + "]" + "\t");
            }
        }

        System.out.println();

        for (int i = 0; i < distances.length; i++)
        {
            for (int j = 0; j < distances[0].length; j++)
            {
                if (j == 0)
                {
                    System.out.print("[" + (i+1) + "]" + "\t");
                }
                System.out.print(distances[i][j] + "\t");
            }
            System.out.println();
        }
    }

    /**
     * method aveDist
     * will calculate the average distance to other cities from one city
     * the user enters a city in the main method, and the location of it in the array is inputted into this method
     * the average doesn't include the distance to itself
     * 
     * @param  integer --> a
     * @return     double --> averageDist
     */
    public double aveDist(int a)
    {
        double total = 0.0;
        int count = 0;

        for (int j = 0; j < distances[0].length; j++)
        {
            if (distances[a][j] == 0)
            {
                total = total;
                count = count;
            }
            else
            {
                total += distances[a][j];
                count++;
            }
        }

        double averageDist = total/count;
        return averageDist;
    }

    /**
     * method smallDist
     * will find the shortest distance between any two cities in the array
     * returns an array with the index of the two cities, and the actual distance between them
     * 
     * @param  none
     * @return     int[] --> data
     */
    public int[] smallDist()
    {
        int indexA = -1;
        int indexB = -1;
        int smallDist = Integer.MAX_VALUE;

        for (int i = 0; i < distances.length; i++)
        {
            for (int j = 0; j < distances[0].length; j++)
            {
                if ((distances[i][j] < smallDist) && (distances[i][j] != 0))
                {
                    smallDist = distances[i][j];
                    indexA = i;
                    indexB = j;
                }
            }
        }

        int[] data = new int[] { smallDist, indexA, indexB };
        return data;
    }

    /**
     * method largeDist
     * will find the largest distance between any two cities in the array
     * returns an array with the index of the two cities, and the actual distance between them
     * 
     * @param  none
     * @return     int[] --> data
     */
    public int[] largeDist()
    {
        int indexA = -1;
        int indexB = -1;
        int largeDist = -1;

        for (int i = 0; i < distances.length; i++)
        {
            for (int j = 0; j < distances[0].length; j++)
            {
                if ((distances[i][j] > largeDist) && (distances[i][j] != 0))
                {
                    largeDist = distances[i][j];
                    indexA = i;
                    indexB = j;
                }
            }
        }

        int[] data = new int[] { largeDist, indexA, indexB };
        return data;
    }

    /**
     * method distBetween
     * will find the distance between any 2 cities based on what the user enters in the main method
     * uses the distances array to find the distance between the 2 cities using the indexes
     * 
     * @param  int --> a, b
     * @return     int --> distances[a][b]
     */
    public int distBetween(int a, int b)
    {
        return distances[a][b];
    }
}