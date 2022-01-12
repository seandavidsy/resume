package recursion;

/**
 * Generates the reversed form of a String
 * 
 * @author Sean Sy (906311775)
 * @version 2020.10.09
 */
public class ReverseStringGenerator {

    /**
     * Static method used to reverse a String using recursion
     * 
     * @param str the String to be reversed
     * @return the reversed String upon reaching the base case,
     * otherwise calls the recursive case until the base case is reached
     */
    public static String reverse(String str) {
        
        if (str.length() == 0) {
            return str;
        }
        else {
            return reverse(str.substring(1)) + str.charAt(0);            
        }
    }
}
