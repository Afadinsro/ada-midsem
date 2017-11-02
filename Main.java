// Import statements
import java.util.ArrayList;

/**
 * Write a description of class Main here.
 *
 * @author Joseph Mills
 * @version October 2017
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
        System.out.println("Country with median population is " + medCountry.name() + ".");
        System.out.println(medCountry.name() + " has a population of " + medCountry.population() + ".");
        
    }
}
