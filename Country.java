
/**
 * Write a description of class Country here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

import java.util.*;

public class Country implements Comparable<Country> 
{
    // instance variables
    private String name;
    private Integer population;
    /*private int literacy;
    private int internet;
    private int mobile;
    private int electProd;
    private int electCons;*/
    

    /**
     * Constructor for objects of class Country
     */
    public Country(String name, Integer population)
    {
        // initialise instance variables
        this.name = name;
        this.population = population;
    }

    /**
     * Returns the name of the Country
     *
     * @return    the population of this Country object
     */
    public Integer population()
    {
        return this.population;
    }
    
    /**
     * Returns the name of the Country
     *
     * @return    the name of this Country object
     */
    public String name()
    {
        return this.name;
    }
    
    /**
     * Compares this Country to the specified object
     *
     * @return    true if the specified object has the same name as this Country,
     * and false if otherwise.
     */
    @Override
    public boolean equals(Object other)
    {
        boolean equals = false;
        // check if other is an instance of the Country class
        if(other instanceof Country){
            // check if both Countries have the same name
            Country another = (Country) other;
            equals = this.name().equals(another.name());
        }
        return equals;
    }
    
    
    @Override
    public int compareTo(Country other)
    {
        return this.population().compareTo(other.population());
    }
}
