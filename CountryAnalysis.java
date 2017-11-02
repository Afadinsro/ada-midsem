//Import Statements
import java.util.ArrayList;
import java.util.regex.Pattern;
import java.util.Collections;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * This class contains static methods to analyse data about countries.
 * Methods:
 * ->ArrayList<Country> read(String filename)
 * ->boolean isInt(String text)
 * ->ArrayList<Country> sort(ArrayList<Country> countries)
 * ->Country[] median(ArrayList<Country> countries)
 * ->Country[] mostSimilarPair(ArrayList<Country> countries, int ...criteria)
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
     * Sorts the countries in ascending order of the country's population.
     * Collections.sort() uses merge sort which has a runtime of nlog(n)
     * Runtime: nlog(n)
     * @param   countries   An ArrayList of unsorted countries
     * @return  A sorted ArrayList of countries.
     */
    public static ArrayList<Country> sort(ArrayList<Country> countries)
    {
        // sort list using Collections package
        Collections.sort(countries);
        return countries;
    }
    
    /**
     * Returns the 
     */
    public static Country median(ArrayList<Country> countries)
    {
        int size = countries.size();
        int medianIndex = 0;
        Country median = null;
        // Odd size
        if(size % 2 == 1){
            medianIndex = (size / 2) + 1;
            median = countries.get(medianIndex);
        }else{
            //Even size
            medianIndex = (size / 2);
            median = countries.get(medianIndex);
        }
        return median;
    }
    
    /**
     * 
     */
    public static Country[] mostSimilarPair(ArrayList<Country> countries, int ...criteria)
    {
        Country[] mostSimilarPair = new Country[2];
        int difference = INFINITY;
        
        for(int i = 0; i < countries.size() - 1; i++){
            for(int j = i+1; j < countries.size(); j++){
                int temp = 0;
                // One Criteria
                if(criteria.length == 1){
                    switch(criteria[0]){
                        /*
                         * Criteria
                         * 1 - Population
                         * 2 - Literacy rate
                         * 3 - Number of internet users
                         * 4 - Number of mobile subscriptions
                         */
                        
                        //criteria = literacy rate
                        case 1:
                            // compute difference in criteria for the pair of countries
                            temp = countries.get(i).population() - countries.get(j).population();
                            // Difference is less than the least distance so far
                            if(temp < difference){
                                // update least distance
                                difference = temp;
                                // get most similar pair
                                mostSimilarPair[0] = countries.get(i);
                                mostSimilarPair[1] = countries.get(j);
                            }
                            break;
                        //criteria = literacy rate
                        case 2:
                            // compute difference in criteria for the pair of countries    
                            temp = countries.get(i).literacy() - countries.get(j).literacy();
                            // Difference is less than the least distance so far
                            if(temp < difference){
                                // update least distance
                                difference = temp;
                                // get most similar pair
                                mostSimilarPair[0] = countries.get(i);
                                mostSimilarPair[1] = countries.get(j);
                            }
                            break;
                        //criteria = number of internet users
                        case 3:
                            // compute difference in criteria for the pair of countries
                            temp = countries.get(i).internet() - countries.get(j).internet();
                            // Difference is less than the least distance so far
                            if(temp < difference){
                                // update least distance
                                difference = temp;
                                // get most similar pair
                                mostSimilarPair[0] = countries.get(i);
                                mostSimilarPair[1] = countries.get(j);
                            }
                            break;
                    }
                    // Two criteria
                }else if(criteria.length == 2){
                    // criteria = literacy(2) & number of internet users(3)
                    if((criteria[0] == 2 && criteria[1] == 3) || 
                        (criteria[0] == 3 && criteria[1] == 2)){
                        // compute sum of criteria values for each country
                        int iSum = countries.get(i).literacy() + countries.get(i).internet();
                        int jSum = countries.get(j).literacy() + countries.get(j).internet();
                        // compute difference in criteria for the pair of countries
                        temp = iSum - jSum;
                        // Difference is less than the least distance so far
                        if(temp < difference){
                            // update least distance
                            difference = temp;
                            // get most similar pair
                            mostSimilarPair[0] = countries.get(i);
                            mostSimilarPair[1] = countries.get(j);
                        }
                    }
                }
            }
        }
        
        return mostSimilarPair;
    }
}
