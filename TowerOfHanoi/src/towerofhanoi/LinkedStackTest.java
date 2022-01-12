//Virginia Tech Honor Code Pledge:
//As a Hokie, I will conduct myself with honor and integrity at all times. I
//Will not lie, cheat, or steal, nor will I accept the actions of those who do
//-- Sean Sy (906311775)
package towerofhanoi;
import java.util.EmptyStackException;

/**
* Tests that the methods in LinkedStack run and perform as expected
* 
* @author Sean Sy 906311775
* @version 10/20/2020
*/
public class LinkedStackTest extends student.TestCase {

    private LinkedStack<String> stack;
    
    /**
     * Set up for all test methods to be run before each test
     */
    public void setUp() { 
        
        stack = new LinkedStack<String>();
        stack.push("object");
    }
    
    /**
     * Tests that size method returns correct amount of Nodes in the Stack
     */
    public void testSize() {
        
        assertEquals(1, stack.size());
        stack.pop();
        assertEquals(0, stack.size());
    }
    
    /**
     * Tests that clear method removes all Nodes from the LinkedStack
     */
    public void testClear() {
        
        stack.push("object1");
        stack.push("object2");
        assertFalse(stack.isEmpty());
        
        stack.clear();
        assertTrue(stack.isEmpty());
    }
    
    /**
     * Tests that isEmpty method returns false if there
     * are no Nodes in LinkedStack, otherwise true
     */
    public void testIsEmpty() {
        
        assertFalse(stack.isEmpty());
        stack.pop();
        assertTrue(stack.isEmpty());
    }
    
    /**
     * Tests that peek method returns the data of the topNode of the stack
     * without removing the Node from the Stack, throws EmptyStackException
     * if the LinkedStack is empty
     */
    public void testPeek() {
        
        assertEquals("object", stack.peek());
        
        stack.pop();
        Exception thrown = null;
        try {
            stack.peek();
        }
        catch (EmptyStackException exception) {
            thrown = exception;
        }
        assertNotNull(thrown);
    }
    
    /**
     * Tests that pop method returns the data of the topNode of the stack
     * and removes that  Node from the Stack, throws EmptyStackException
     * if the LinkedStack is empty
     */
    public void testPop() {
        
        assertEquals("object", stack.pop());
        assertEquals(0, stack.size(), 0.1);
        
        Exception thrown = null;
        try {
            stack.pop();
        }
        catch (EmptyStackException exception) {
            thrown = exception;
        }
        assertNotNull(thrown);
    }
    
    /**
     * Tests that push method correctly adds a new entry to the LinkedStack
     * as the topNode of the Stack
     */
    public void testPush() {
        
        assertEquals(1, stack.size(), 0.1);
    }
    
    /**
     * Tests that toString method returns the
     * contents of LinkedStack as a String
     */
    public void testToString() {
        
        stack.push("object1");
        stack.push("object2");
        String test = stack.toString();
        assertEquals("[object2, object1, object]", test);
    }
}
