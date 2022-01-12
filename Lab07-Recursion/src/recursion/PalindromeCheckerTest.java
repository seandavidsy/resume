package recursion;

/**
 * Tests that PalindromeChecker runs and executes as intended
 * 
 * @author Sean Sy (906311775)
 * @version 2020.10.09
 */
public class PalindromeCheckerTest extends student.TestCase {

    @SuppressWarnings("unused")
    private PalindromeChecker testPalindrome = new PalindromeChecker();
    
    /**
     * Tests that static isPalindrome method returns true if the given String
     * is a palindrome and false otherwise, ignoring special characters,
     * spaces, and capital letters
     */
    public void testIsPalindrome() {
        
        assertTrue(PalindromeChecker.isPalindrome(""));
        assertTrue(PalindromeChecker.isPalindrome("a"));
        assertTrue(PalindromeChecker.isPalindrome("racecar"));
        assertTrue(PalindromeChecker.isPalindrome("deIfied"));
        assertTrue(PalindromeChecker.isPalindrome("Hannah"));
        assertTrue(PalindromeChecker.isPalindrome("Civic"));
        assertTrue(PalindromeChecker.isPalindrome("spacecaps"));
        assertFalse(PalindromeChecker.isPalindrome("hello"));
        assertFalse(PalindromeChecker.isPalindrome("goodbye"));
        assertTrue(PalindromeChecker.isPalindrome("Go hang a salami, "
            + "I'm a lasagna hog."));
        assertTrue(PalindromeChecker.isPalindrome("A Toyota! Race fast, "
            + "safe car. A Toyota."));
        assertTrue(PalindromeChecker.isPalindrome("\"Tie Mandie,\" "
            + "I'd name it."));
        assertTrue(PalindromeChecker.isPalindrome("Wonton? Not now."));
        assertTrue(PalindromeChecker.isPalindrome("Wonton? Not now."));
       
    }
}
