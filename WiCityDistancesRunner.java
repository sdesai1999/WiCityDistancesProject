import java.util.*;
import java.io.File;

/**
 * Chapter 8 AP Comp Sci Project with 2D Arrays
 * 
 * @author Saurav Desai 
 * @version 1/19/16
 */
public class WiCityDistancesRunner
{
    public static void main(String[] args) throws Exception
    {
        System.out.print("\f");

        WiCityDistances w1 = new WiCityDistances();
        File myFile = new File("Mileage.csv");
        Scanner myScan = new Scanner(myFile);
        String[] splitData;
        String dataFromFile = "";
        String[] cities = new String[17];

        dataFromFile = myScan.nextLine();
        splitData = dataFromFile.split(",");

        
        cities = splitData;
        
        
        System.out.println("Welcome to Wisconsin City Distances! There are different tasks you can do in this program: ");
        System.out.println("\t • Print The Table: ENTER \"Print\"");
        System.out.println("\t • Find the average distance from one city to the rest: ENTER \"Average\"");
        System.out.println("\t • Find the cities with the smallest distance in between: ENTER \"Smallest Distance\"");
        System.out.println("\t • Find the cities with the largest distance in between: ENTER \"Largest Distance\"");
        System.out.println("\t • Find the distance between 2 two cities of your choice: ENTER \"Distance Between\"");
        System.out.println("\t • Quit the program: ENTER \"Quit\"");
        System.out.println();
        System.out.println("TABLE KEY (when you print it): ");
        System.out.println("[1] = Bayfield");
        System.out.println("[2] = Chicago");
        System.out.println("[3] = Eau Claire");
        System.out.println("[4] = Green Bay");
        System.out.println("[5] = Hayward");
        System.out.println("[6] = La Crosse");
        System.out.println("[7] = Madison");
        System.out.println("[8] = Milwaukee");
        System.out.println("[9] = Minneapolis");
        System.out.println("[10] = Prairie du Chein");
        System.out.println("[11] = Rhinelander");
        System.out.println("[12] = Rockford");
        System.out.println("[13] = Sheboygan");
        System.out.println("[14] = Sturgeon Bay");
        System.out.println("[15] = Superior");
        System.out.println("[16] = Wausau");
        System.out.println("[17] = Wisconsin Dells");

        System.out.println();

        System.out.print("What would you like to do?: ");
        // asks user to enter a valid command
        Scanner scan1 = new Scanner(System.in);
        String input = scan1.nextLine();

        while (input.equals("Quit") == false)
        {
            if (input.equals("Print")) // calls the method to print the table of distances
            {
                w1.printTable(); // table is printed
                System.out.println();
                System.out.println();
            }
            else if (input.equals("Average")) // calls the method that prints the average distances from one city to other cities
            {
                System.out.print("What city would you like to use as a reference for finding averages?: ");

                String reference = scan1.nextLine();
                boolean isValid1 = false;
                int a = -1;

                for (int i = 0; i < cities.length; i++)
                {
                    if (cities[i].equals(reference)) // checks to see if the entered city is a valid city
                    {
                        isValid1 = true;
                        a = i;
                        break;
                    }
                }

                while (isValid1 == false) // if the entered city isn't valid, user will be prompted to enter a valid city until they do
                {
                    System.out.print("Please enter a valid reference city: ");
                    reference = scan1.nextLine();
                    for (int i = 0; i < cities.length; i++)
                    {
                        if (cities[i].equals(reference))
                        {
                            isValid1 = true;
                            a = i;
                            break;
                        }
                    }

                }

                System.out.println("The average distance from " + cities[a] + " to all other cities is " + w1.aveDist(a) + " miles.");
                // prints the average distances ^^^
                System.out.println();
                System.out.println();
            }
            else if (input.equals("Smallest Distance")) // prints the smallest distance between any 2 cities
            {
                System.out.println("The smallest distance between any two cities is " + w1.smallDist()[0] + " miles. It is the distance");
                System.out.println("between " + cities[w1.smallDist()[1]] + " and " + cities[w1.smallDist()[2]] + ".");
                // prints the distance on 1 line, prints the cities on the next line
                System.out.println();
                System.out.println();
            }
            else if (input.equals("Largest Distance")) // prints the largest distance between any 2 cities
            {
                System.out.println("The largest distance between any two cities is " + w1.largeDist()[0] + " miles. It is the distance");
                System.out.println("between " + cities[w1.largeDist()[1]] + " and " + cities[w1.largeDist()[2]] + ".");
                // prints the distance on 1 line, prints the cities on the next line
                System.out.println();
                System.out.println();
            }
            else if (input.equals("Distance Between")) // prints the distance between any 2 valid cities entered by the user
            {
                System.out.print("What is the first city you want to choose?: ");
                String city1 = scan1.nextLine();
                boolean isValid2 = false;
                int b = -1;

                for (int i = 0; i < cities.length; i++)
                {
                    if (cities[i].equals(city1)) // checks if entered first city is valid
                    {
                        isValid2 = true;
                        b = i;
                        break;
                    }
                }

                while (isValid2 == false) // if the entered first city is invalid, user will be prompted to enter a valid first city until they do
                {
                    System.out.print("Please enter a valid first city: ");
                    city1 = scan1.nextLine();
                    for (int i = 0; i < cities.length; i++)
                    {
                        if (cities[i].equals(city1))
                        {
                            isValid2 = true;
                            b = i;
                            break;
                        }
                    }

                }

                System.out.print("What is the second city you want to choose?: ");
                String city2 = scan1.nextLine();
                boolean isValid3 = false;
                int c = -1;

                for (int i = 0; i < cities.length; i++)
                {
                    if (cities[i].equals(city2)) // checks if entered second city is valid
                    {
                        isValid3 = true;
                        c = i;
                        break;
                    }
                }

                while (isValid3 == false) // if the entered second city is invalid, user will be prompted to enter a valid second city until they do
                {
                    System.out.print("Please enter a valid second city: ");
                    city2 = scan1.nextLine();
                    for (int i = 0; i < cities.length; i++)
                    {
                        if (cities[i].equals(city2))
                        {
                            isValid3 = true;
                            c = i;
                            break;
                        }
                    }

                }

                System.out.println("The distance between " + cities[b] + " and " + cities[c] + " is " + w1.distBetween(b, c) + " miles.");
                // prints the distance between the 2 cities, and prints the city names
                System.out.println();
                System.out.println();
            }
            else if (input.equals("Quit")) // if the user enters "Quit", the program will exit the loop
            {
                break;
            }
            else // if the user enters an invalid command, user will be prompted to enter a valid one
            {
                System.out.println("Invalid command. Please try one of the valid tasks listed above.");
                System.out.println();
                System.out.println();
            }

            System.out.print("What would you like to do?: ");
            // asks user to enter a new command
            input = scan1.nextLine();
        }
        
        System.out.println();
        System.out.println();
        System.out.println("Goodbye!"); // prints goodbye as the user exits the program
    }
}

