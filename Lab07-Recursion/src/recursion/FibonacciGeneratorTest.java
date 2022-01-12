package recursion;

/**
 * Tests that FibonacciGenerator runs and executes as intended
 * 
 * @author Sean Sy (906311775)
 * @version 2020.10.09
 */
public class FibonacciGeneratorTest extends student.TestCase {
    
    @SuppressWarnings("unused")
    private FibonacciGenerator testFib = new FibonacciGenerator();
    
    /**
     * Tests that static fib method returns the correct number in
     * the fibonacci sequence
     */
    public void testFib() {
        
        assertEquals(0, FibonacciGenerator.fib(0), 0.1);
        assertEquals(1, FibonacciGenerator.fib(1), 0.1);
        assertEquals(1, FibonacciGenerator.fib(2), 0.1);
        assertEquals(2, FibonacciGenerator.fib(3), 0.1);
        assertEquals(3, FibonacciGenerator.fib(4), 0.1);
        assertEquals(5, FibonacciGenerator.fib(5), 0.1);
        assertEquals(8, FibonacciGenerator.fib(6), 0.1);
        assertEquals(13, FibonacciGenerator.fib(7), 0.1);
        assertEquals(21, FibonacciGenerator.fib(8), 0.1);
        assertEquals(34, FibonacciGenerator.fib(9), 0.1);
        assertEquals(55, FibonacciGenerator.fib(10), 0.1);
    }
}
