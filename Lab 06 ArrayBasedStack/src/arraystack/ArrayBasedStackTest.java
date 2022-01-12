package arraystack;

import java.util.EmptyStackException;

/**
 *  Tests all the methods in ArrayBasedStack to
 * make sure they run and perform as expected
 *
 *  @author  Sean Sy (906311775)
 *  @version 2020.10.03
 */
public class ArrayBasedStackTest extends student.TestCase {

    private ArrayBasedStack<String> tester;
    
    /**
     * Set up for each test method before it is ran
     */
    public void setUp() {
        tester = new ArrayBasedStack<String>(); 
    }
    
    /**
     * Tests that the isEmpty method returns true when the stack is empty
     * and returns false when the stack is not empty
     */
    public void testIsEmpty() {
        
        assertTrue(tester.isEmpty());
        tester.push("object");
        assertFalse(tester.isEmpty());
    }

    /**
     * Tests that the peek method throws an EmptyStackException when called
     * on an empty ArrayBasedStack. When called on a non-empty stack will 
     * return the object without removing it.
     */
    public void testPeek() {
        
        Exception thrown = null;
        try 
        {
            tester.peek();
        }
        catch (Exception exception)
        {
            thrown = exception;
        }
        
        //Checks whether an exception was actually thrown
        assertNotNull(thrown);
        
        //Checks whether the right type of exception was thrown
        assertTrue(thrown instanceof EmptyStackException);
        
        tester.push("object");
        assertEquals("object", tester.peek());
    }

    /**
     * Tests that the pop method throws an EmptyStackException when called
     * on an empty ArrayBasedStack. When called on a non-empty stack will 
     * remove the object at the top of the stack, decrease size by 1, and
     * return the removed object
     */
    public void testPop() {
        
        Exception thrown = null;
        try
        {
            tester.pop();
        }
        catch (Exception exception)
        {
            thrown = exception;
        }
        
        assertNotNull(thrown);
        assertTrue(thrown instanceof EmptyStackException);
        
        tester.push("object");
        assertEquals("object", tester.pop());
        assertEquals(0, tester.size());
    }

    /**
     * Tests that the push method adds the new object to the ArrayBasedStack
     * at the top of the stack and increases the size variable
     */
    public void testPush() {
        
        tester.push("object1");
        tester.push("object2");
        tester.push("object3");
        assertEquals(3, tester.size());
        
        for (int i = 0; i < 98; i++) {
            tester.push("object" + i);
        }
        assertEquals(101, tester.size());
    }

    /**
     * Tests that the contain method returns false when the object parameter
     * isn't in the ArrayBasedStack and true when the object parameter is in
     * the ArrayBasedStack
     */
    public void testContains() {
        
        tester.push("object1");      
        tester.push("object2");
        tester.push("object3");
        
        assertFalse(tester.contains("object"));
        assertTrue(tester.contains("object1"));
        assertTrue(tester.contains("object2"));
        assertTrue(tester.contains("object3"));
    }

    /**
     * Tests that the size method returns the number of items in the
     * ArrayBasedStack
     */
    public void testSize() {
        
        tester.push("object");
        assertEquals(1, tester.size());
    }

    /**
     * Tests that the clear method completely empties the ArrayBasedStack
     */
    public void testClear() {
        
        for (int i = 0; i < 10; i++) {
            tester.push("object" + i);
        }
        tester.clear();
        assertTrue(tester.isEmpty());
    }

    /**
     * Tests that the toArray method returns the array representation of
     * ArrayBasedStack with the bottom of the stack being at the beginning
     * of the array
     */
    public void testToArray() {
        
        for (int i = 0; i < 10; i++) {
            tester.push("object" + i);
        }
        Object[] compare = tester.toArray();
        for (int i = compare.length - 1; i > 0; i--) {
            assertEquals(compare[i], tester.pop());
        }
        
    }
    
    /**
     * Tests that the toString method returns the string representation of
     * ArrayBasedStack in the format of [bottom, item, item, ..., top]
     */
    public void testToString() {
        
        assertEquals("[]", tester.toString());
        
        for (int i = 0; i < 3; i++) {
            tester.push("object" + i);
        }
        assertEquals("[object0, object1, object2]", tester.toString());
    }
    
    /**
     * Tests that the equals method returns true only when the two 
     * ArrayBasedStacks have the same size and contains the same objects
     * in the same order
     */
    public void testEquals() {
        
        Object object = new Object();
        ArrayBasedStack<String> tester2 = new ArrayBasedStack<String>();
        ArrayBasedStack<String> tester3 = new ArrayBasedStack<String>();
        ArrayBasedStack<String> tester4 = null;
        
        assertTrue(tester.equals(tester));
        assertFalse(tester.equals(tester4));
        assertFalse(tester.equals(object));
        
        tester.push("object");
        assertFalse(tester.equals(tester2));
        
        tester2.push("object1");
        assertFalse(tester.equals(tester2));
        
        tester.push("object1");
        tester2.push("object");
        assertFalse(tester.equals(tester2));
        
        tester3.push("object");
        tester3.push("object1");
        assertTrue(tester.equals(tester3));       
    }
    
    public void testDebuggerViews()

    {

        //Put a breakpoint on the line below
        ArrayBasedStack<String> testStack = new ArrayBasedStack<String>();

        //Put a breakpoint on the line below. Use Step Over to see each push.
        testStack.push("blizzard");
        testStack.push("barrage");
        testStack.push("deadeye");
        testStack.push("resurrect");

        assertTrue(testStack.toString().equals("[blizzard, barrage, deadeye, resurrect]"));
         
        //Put a breakpoint on the line below. Hit Step Over once to watch the pop.
        testStack.pop();
       
        assertTrue(testStack.toString().equals("[blizzard, barrage, deadeye]"));
         
        Object[] toArrayResult = testStack.toArray();
        
        //Drop a breakpoint on the line below.
        //Use the debugger mode to compare toArrayResult to testStack.
        assertTrue(toArrayResult[0].toString().equals("blizzard"));
        assertEquals(toArrayResult.length, 3);
         
        //The following test fails because the stack still has entries in it. However,
        //"expected <true> but was: <false>" is not very helpful.
        //Drop a breakpoint on the line below to see what the toString SHOULD look like.
        assertTrue(testStack.toString().equals("[]"));
    }
}