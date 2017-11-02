// import statements
import java.util.*;
/**
 * Test class for CountryAnalysis class
 *
 * @author Joseph Mills
 * @version 2nd November 2017 
 */
public class CountryAnalysisTest
{
    public static void main(String[] args){
        
        
        Country ghana = new Country("Ghana", 20000000, 111, 222);
        Country nigeria = new Country("Nigeria", 100000000, 333, 444);
        Country congo = new Country("Congo", 20000000, 555, 666);
        
        System.out.println("Testing isInt()...");
        System.out.println(".25?: " + CountryAnalysis.isInt(".25"));
        System.out.println("999?: " + CountryAnalysis.isInt("999"));
        System.out.println("2=5?: " + CountryAnalysis.isInt("2=5"));
        System.out.println("10.56?: " + CountryAnalysis.isInt("10.56"));
        
        System.out.println("Testing read()...");
        ArrayList<Country> countries = CountryAnalysis.read("test.csv");
        for(Country c: countries){
            System.out.println(c);
        }
        
        System.out.println("Testing sort()...");
        countries = CountryAnalysis.sort(countries);
        for(Country c: countries){
            System.out.println(c);
        }
        
        System.out.println("Testing median()...");
        Country medianCountry = CountryAnalysis.median(countries);
        System.out.println(medianCountry);
        
        System.out.println("Testing mostSimilarPair()...");
        Country[] mostSimilar = CountryAnalysis.mostSimilarPair(countries, 1);
        System.out.println("Most similar pair in terms of population: " + mostSimilar[0] + " and " + mostSimilar[1] + ".");
        
        Country[] mostSimilar2 = CountryAnalysis.mostSimilarPair(countries, 2, 3);
        System.out.println("Most similar pair in terms of literacy rate and internet usage: " + mostSimilar2[0] + " and " + mostSimilar2[1] + ".");
        
    }
}
