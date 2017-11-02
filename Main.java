// Import statements
import java.util.ArrayList;

/**
 * This is the main program that solves Problem 2.
 *
 * @author Joseph Mills
 * @version 2nd November 2017
 */
public class Main
{
    public static void main(String args[]){
        // Read in countries from file
        ArrayList<Country> countries = CountryAnalysis.read("country_data.csv");
        // Sort countries in increasing order of population
        countries = CountryAnalysis.sort(countries);
        // get median country
        Country medCountry = CountryAnalysis.median(countries);
        //display result
        System.out.println("Problem 2 (a)");
        System.out.println("Country with median population is " + medCountry.name() + ".");
        System.out.println(medCountry.name() + " has a population of " + medCountry.population() + ".");
        
        System.out.println("\nProblem 2 (c)");
        Country[] mostSimilarOne = CountryAnalysis.mostSimilarPair(countries, 1);
        System.out.println("Most similar pair in terms of population: " + mostSimilarOne[0].name() 
            + "(" + mostSimilarOne[0].population() + ")" + " and " + mostSimilarOne[1].name()
            + "(" + mostSimilarOne[1].population() + ")" + ".");
        
        Country[] mostSimilarTwo = CountryAnalysis.mostSimilarPair(countries, 2, 3);
        System.out.println("Most similar pair in terms of literacy rate and internet usage: " 
            + mostSimilarTwo[0].name() + "(" + mostSimilarTwo[0].literacy() + ", " 
            + mostSimilarTwo[0].internet() + ")" + " and " + mostSimilarTwo[1].name() 
            + "(" + mostSimilarTwo[1].literacy() + ", " + mostSimilarTwo[1].internet() + ")" + ".");
    }
}
