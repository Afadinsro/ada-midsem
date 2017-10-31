//Import Statements
import java.util.*;
import java.util.regex.Pattern;
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
    // static instance variables
    private static ArrayList<Country> countries = new ArrayList();

    /**
     * 
     */
    public static ArrayList<Country> read(String filename){
        String line = null;
        // try-with resources approach used to handle closure of resources automatically
        try(BufferedReader reader = new BufferedReader(new FileReader(filename))){
            int count = 0;
            while(reader.ready() && (line = reader.readLine()) != null){
                // ignore the first line of the file, thats the header row
                if(count >= 1){
                    // CSV file is delimited by a comma
                    String[] arr = line.split(",");
                    // Create country objects from the data
                    int population = 0;
                    String name = null;
                    if(isInt(arr[1])){
                        population = Integer.parseInt(arr[1]);
                        name = arr[0];
                    }else if(isInt(arr[2])){
                        // if the Country's name has a comma
                        // eg. Gambia, The
                        population = Integer.parseInt(arr[2]);
                        name = arr[1] + arr[0];
                    }
                    Country temp = new Country(name, population);
                    // Add countries to the list
                    countries.add(temp);
                }
                //increase counter
                count++;
            }
        }catch(FileNotFoundException e){
            
        }catch(IOException io){
            
        }
        // return list of countries
        return countries();
    }
    
    /**
     * 
     */
    public static ArrayList<Country> countries(){
        return countries;
    }
    
    /**
     * 
     */
    public static int numCountries(){
        return countries.size();
    }
    
    /**
     * 
     */
    public static boolean isNumeric(String text){
        // Regex covers both integers and decimals
        return Pattern.matches("^\\d+$|^\\d*[.]\\d+$", text);
    }
    
    /**
     * 
     */
    public static boolean isInt(String text){
        // Regex covers integers only
        return Pattern.matches("^\\d+$", text); 
    }
}
