// import statements
import java.util.*;
/**
 * Write a description of class CountryAnalysisTest here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class CountryAnalysisTest
{
    public static void main(String[] args){
        
        Country ghana = new Country("Ghana", 20000000);
        Country nigeria = new Country("Nigeria", 100000000);
        Country congo = new Country("Congo", 20000000);
        
        System.out.println("Testing read()...");
        ArrayList<Country> countries = CountryAnalysis.read("country_data.csv");
        for(Country c: countries){
            System.out.println(c);
        }
    }
}
