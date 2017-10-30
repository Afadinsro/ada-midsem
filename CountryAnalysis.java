//Import Statements
import java.util.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Write a description of class CountryAnalysis here.
 *
 * @author Joseph Mills
 * @version October 2017
 */
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

    /**
     * 
     */
    public void read(String filename){
        String line = null;
        try(BufferedReader reader = new BufferedReader(new FileReader(filename))){
            while(reader.ready() && (line = reader.readLine()) != null){
                // CSV file is delimited by a comma
                String[] arr = line.split(",");
                // Create country objects from the data
                Country temp = new Country(arr[0], Integer.parseInt(arr[1]));
                countries.add(temp);
            }
        }catch(FileNotFoundException e){
            
        }catch(IOException io){
            
        }
        
    }
    
    /**
     * 
     */
    public ArrayList<Country> countries(){
        return this.countries;
    }
}
