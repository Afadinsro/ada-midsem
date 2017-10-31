
/**
 * This class models a real-world Country
 * Every Country object has a name and a population
 * The name of every Country object should be unique.
 * @author Joseph Mills
 * @version October 2017
 */
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
     * A Country's name cannot be NULL
     */
    public Country(String name, Integer population)
    {
        // initialise instance variables
        if(name != null){
            this.name = name;
            this.population = population;
        }
        
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
        return this.population().compareTo(other.population());
    }
    
    /**
     * 
     * @return 
     */
    public String toString(){
        return name() + ": " + population();
    }
}
