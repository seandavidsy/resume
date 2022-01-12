package recursion;

/**
 * Checks if a String is a palindrome, regardless of special
 * charactesr, spaces, or capitalized letters
 * 
 * @author Sean Sy (906311775)
 * @version 2020.10.09
 */
public class PalindromeChecker {

    /**
     * Static method used to check if a String is a palindrome using recursion
     * 
     * @param str the String that is being checked as a palindrome or not
     * @return true if the String is found to be a palindrome, false otherwise
     */
    public static boolean isPalindrome(String str) {
        
        str = str.toUpperCase(); 
        str = str.replaceAll("[^a-zA-Z0-9]", "");  
        str = str.replaceAll(" ", "");
        
        if (str.length() == 1 || str.length() == 0) {
            return true;
        }       
        if ((str.charAt(0)) == str.charAt(str.length() - 1)) {
            return isPalindrome(str.substring(1, str.length() - 1));
        }
        return false;
    }
}
