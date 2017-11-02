// import packages
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

/**
 * Write a description of class CountryTestRunner here.
 *
 * @author (your name)
 * @version (a version number or a date)
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
