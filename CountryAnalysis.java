
/**
 * Write a description of class CountryAnalysis here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

//Import Statements
import java.util.*;
import java.io.BufferedReader;
import java.io.FileReader;

public class CountryAnalysis
{
    // instance variables
    ArrayList<Country> countries;

    /**
     * Constructor for objects of class CountryAnalysis
     */
    public CountryAnalysis(String filename)
    {
        // initialise instance variables
        countries = new ArrayList();
        
        
    }

    public void read(String filename){
        
        try(BufferedReader reader = new BufferedReader(new FileReader(filename))){
            
        }catch(){
            
        }
        
    }
    
}
