//Import Statements
import java.util.ArrayList;
import java.util.regex.Pattern;
import java.util.Collections;
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
    public static final int INFINITY = 1000000000;
    
    /**
     * 
     */
    public static ArrayList<Country> read(String filename)
    {
        String line = null;
        ArrayList<Country> countries = new ArrayList();
        // try-with resources approach used to handle closure of resources automatically
        try(BufferedReader reader = new BufferedReader(new FileReader(filename))){
            int count = 0;
            while(reader.ready() && (line = reader.readLine()) != null){
                // ignore the first line of the file, thats the header row
                if(count >= 1){
                    // CSV file is delimited by a comma
                    String[] arr = line.split(",");
                    // Country data variables
                    int population = 0;
                    String name = null;
                    // Get the right name and population from the Strings from the split
                    if(isInt(arr[1])){
                        population = Integer.parseInt(arr[1]);
                        name = arr[0];
                    }else if(isInt(arr[2])){
                        // if the Country's name has a comma
                        // eg. Gambia, The
                        population = Integer.parseInt(arr[2]);
                        // Country names with commas are surrounded by ""
                        //main name has " as first char
                        String main = arr[0].substring(1);
                        /*
                         * prefix has " as last char
                         * remove leading whitespace of prefix
                         * last but one element is at index=arr[1].length()-2, because trimming
                        */
                        String prefix = arr[1].trim().substring(0, arr[1].length() - 2);
                        // form Country name
                        name = prefix + " " + main;
                    }
                    // Create country objects from the data
                    Country temp = null;
                    try{
                        temp = new Country(name, population);
                    }catch(NullPointerException e){}
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
        return countries;
    }
    
    /**
     * 
     */
    public static boolean isInt(String text)
    {
        // Regex covers integers only
        return Pattern.matches("^\\d+$", text); 
    }
    
    /**
     * 
     * Collections.sort() uses merge sort which has a runtime of nlog(n)
     * Runtime: nlog(n)
     */
    public static ArrayList<Country> sort(ArrayList<Country> countries){
        // sort list using Collections package
        Collections.sort(countries);
        return countries;
    }
    
    /**
     * 
     */
    public static Country[] median(ArrayList<Country> countries){
        int size = countries.size();
        int medianIndex = 0;
        Country[] medianCountries = new Country[2];
        // Odd size
        if(size % 2 == 1){
            medianIndex = (size / 2) + 1;
            medianCountries[0] = countries.get(medianIndex);
        }else{
            //Even size
            medianIndex = (size / 2);
            // Add countries add indices size/2 & size/2 + 1
            medianCountries[0] = countries.get(medianIndex);
            medianCountries[1] = countries.get(++medianIndex);
        }
        return medianCountries;
    }
    
    /**
     * 
     */
    public static Country[] mostSimilarPair(ArrayList<Country> countries, int ...criteria){
        Country[] mostSimilarPair = new Country[2];
        int difference = INFINITY;
        
        for(int i = 0; i < countries.size() - 1; i++){
            for(int j = i+1; j < countries.size(); j++){
                int temp = 0;
                if(criteria.length == 1){
                    switch(criteria[0]){
                        case 1:
                            
                    }
                }
            }
        }
        
        return mostSimilarPair;
    }
}
