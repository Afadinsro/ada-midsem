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
        //get number of countries
        int size = countries.size();
        int medianIndex = size / 2;
        
        for(Country c: countries){
            System.out.println(c);
        }
    }
}
