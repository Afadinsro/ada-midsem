/**
 * Test class for Country class.
 *
 * @author Joseph Mills
 * @version 2nd November 2017
 */
public class CountryTest
{
    public static void main(String[] args){
        Country ghana = new Country("Ghana", 20000000, 111, 222);
        Country nigeria = new Country("Nigeria", 100000000, 333, 444);
        Country congo = new Country("Congo", 20000000, 555, 666);
        
        System.out.println("Testing getter methods...");
        System.out.println("Ghana name: " + ghana.name());
        System.out.println("Ghana population: " + ghana.population());
        System.out.println("Ghana literacy rate: " + ghana.literacy());
        System.out.println("Ghana internet users: " + ghana.internet());
        
        System.out.println("Testing equals()...");
        System.out.println("ghana=nigeria: " + ghana.equals(nigeria));
        System.out.println("congo=ghana: " + congo.equals(ghana));
        
        System.out.println("Testing toString()...");
        System.out.println(ghana);
        
        System.out.println("Testing compareTo()...");
        System.out.println("ghana-nigeria: " + ghana.compareTo(nigeria));
        System.out.println("congo-ghana: " + congo.compareTo(ghana));
    }
}