// Import statements
import java.lang.NullPointerException;

/**
 * This class models a real-world Country
 * Every Country object has a name, population, literacy rate and number of internet subscribers
 * The name of every Country object should be unique.
 * This class implements the Comparable interface on the population
 * Methods:
 * ->int population()
 * ->int name()
 * ->int literacy()
 * ->int internet()
 * ->boolean equals(Country other)
 * ->int compareTo(Country other)
 * ->String toString()
 * 
 * @author Joseph Mills
 * @version 2nd November 2017
 */
public class Country implements Comparable<Country> 
{
    // instance variables
    private String name;
    private int population;
    private int literacy;
    private int internet;
    

    /**
     * Constructor for objects of class Country
     * A Country's name cannot be NULL
     * @throws NullPointerException
     */
    public Country(String name, int population, int literacy, int internet) throws NullPointerException
    {
        // Throw exception when name is null
        if(name == null){
            throw new NullPointerException("Country name cannot be null.");
        }
        // initialise instance variables
        this.name = name;
        this.population = population;
        this.literacy = literacy;
        this.internet = internet;
    }

    /**
     * Returns the population of the Country
     * @return    the population of this Country object
     */
    public int population()
    {
        return this.population;
    }
    
    /**
     * Returns the name of the Country
     * @return    the name of this Country object
     */
    public String name()
    {
        return this.name;
    }
    
    /**
     * Returns the literacy of the Country
     * @return    the literacy rate of this Country object
     */
    public int literacy()
    {
        return this.literacy;
    }
    
    /**
     * Returns the number of internet users in the Country
     * @return    number of internet users in this Country object
     */
    public int internet()
    {
        return this.internet;
    }
    
    /**
     * Compares this Country to the specified object
     * Two Country objects are equal if they have the same name.
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
    
    /**
     * Compares this object to the Specified country.
     * The order of comparison depends on the Country's population. 
     * The higher the population, the higher the order.
     * @param       other The specified Country to be compared to this object
     * @return      a negative integer, 0 or positive integer when this object is less than, 
     * equal to or greater than the specified object.
     */
    @Override
    public int compareTo(Country other)
    {
        int val = 0;
        if(this.population() < other.population()){
            val = -1;
        }else if(this.population() > other.population()){
            val = 1;
        }
        return val;
    }
    
    /**
     * Represents a Country object in a formatted text
     * @return  A formatted String representation of a Country object.
     */
    public String toString()
    {
        return name() + ": Pop.:" + population() + ", Lit.:" + literacy() + ", Int.:" + internet();
    }
}
