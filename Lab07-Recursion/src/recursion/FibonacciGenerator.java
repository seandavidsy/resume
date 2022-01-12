package recursion;

/**
 * Generates the nth term in the fibonacci sequence
 * 
 * @author Sean Sy (906311775)
 * @version 2020.10.09
 */
public class FibonacciGenerator {   //precondition: n is non-negative
    
    /**
     * Static method used to generate the nth  term fibonacci number
     * using recursion
     * 
     * @param n representing the nth term in the fibonacci sequence
     * @return the value of n if the base case, otherwise returns the
     * recursive case until the base case is reached
     */
    public static int fib(int n) {
        
        if (n == 1 || n == 0) {     //base case
            return n;
        }
        else {
            return fib(n - 2) + fib(n - 1);     //recursive case
        }
    }

}
