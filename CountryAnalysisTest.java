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
        
        System.out.println("Testing isString()...");
        System.out.println("kofi?: " + CountryAnalysis.isString("kofi"));
        System.out.println("999?: " + CountryAnalysis.isString("999"));
        System.out.println("ko-fi*?: " + CountryAnalysis.isString("ko-fi*"));
        
        /*
        System.out.println("Testing read()...");
        ArrayList<Country> countries = CountryAnalysis.read("test.csv");
        for(Country c: countries){
            System.out.println(c);
        }*/
        
        
    }
}
