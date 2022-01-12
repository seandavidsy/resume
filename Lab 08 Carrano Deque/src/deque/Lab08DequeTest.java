package deque;

import student.TestCase;

/**
 * Tests for the DLinkedDeque class.
 *
 * @author Sean Sy 906311775
 * @version 10/17/2020
 */
public class Lab08DequeTest extends TestCase
{

    private Lab08Deque<String> deque;

    /**
     * Creates two brand new, empty sets for each test method.
     */
    public void setUp()
    {
        deque = new Lab08Deque<String>();
    }

    /**
     * Tests that addToFront method works as intended.
     */
    public void testAddToFront() { 
        
        assertEquals(0, deque.size(), 0.1);
        deque.addToFront("object");
        assertEquals(deque.firstNode.getData(), "object");
        assertEquals(deque.lastNode.getData(), "object");
        deque.addToFront("object1");
        assertEquals(deque.firstNode.getData(), "object1");
        assertEquals(2, deque.size(), 0.1);
    }
    
    /**
     * Tests that addToBack method works as intended.
     */
    public void testAddToBack() {
        
        assertEquals(0, deque.size(), 0.1);
        deque.addToBack("object");
        assertEquals(deque.firstNode.getData(), "object");
        assertEquals(deque.lastNode.getData(), "object");
        deque.addToBack("object1");
        assertEquals(deque.lastNode.getData(), "object1");
        assertEquals(2, deque.size(), 0.1);
        
    }
    
    /**
     * Tests that removeFront method works as intended.
     */
    public void testRemoveFront() {
        
        deque.addToFront("object");
        deque.addToFront("object1");
        assertEquals(2, deque.size(), 0.1);
        assertEquals("object1", deque.removeFront());
        assertEquals("object", deque.removeFront());
        assertEquals(0, deque.size(), 0.1);
    }
    
    /**
     * Tests that removeFront method works on empty deque.
     */
    public void testremoveFrontException()
    {
        Exception exception = null;
        try
        {
            deque.removeFront();
            fail("removeFront() is not throwing an exception when it should");
        }
        catch (Exception e)
        {
            exception = e;
        }
        assertTrue("removeFront() is throwing the wrong type of exceptions",
                   exception instanceof EmptyQueueException);
    }
    
    /**
     * Tests that removeBack method works as intended.
     */
    public void testRemoveBack() {
       
        deque.addToBack("object");
        deque.addToBack("object1");
        assertEquals(2, deque.size(), 0.1);
        assertEquals("object1", deque.removeBack());
        assertEquals("object", deque.removeBack());
        assertEquals(0, deque.size(), 0.1);
    }
    
    /**
     * Tests that the removeBack method works on empty deque.
     */
    public void testremoveBackException()
    {
        Exception exception = null;
        try
        {
            deque.removeBack();
            fail("removeBack() is not throwing an exception when it should");
        }
        catch (Exception e)
        {
            exception = e;
        }
        assertTrue("removeBack() is throwing the wrong type of exceptions",
                   exception instanceof EmptyQueueException);
    }
    
    /**
     * Tests that getFront method works as intended.
     */
    public void testGetFront() {     
        
        deque.addToFront("object");
        deque.addToFront("object1");
        assertEquals("object1", deque.getFront());
    }
    
    /**
     * Tests that getFront method works on empty deque.
     */
    public void testgetFrontException()
    {
        Exception exception = null;
        try
        {
            deque.getFront();
            fail("getFront() is not throwing an exception when it should");
        }
        catch (Exception e)
        {
            exception = e;
        }
        assertTrue("getFront() is throwing the wrong type of exceptions",
                   exception instanceof EmptyQueueException);
    }
    
    /**
     * Tests that getBack method works as intended.
     */
    public void testGetBack() {
        
        deque.addToBack("object");
        deque.addToBack("object1");
        assertEquals("object1", deque.getBack());
    }
    
    /**
     * Tests that getBack method works on empty deque.
     */
    public void testgetBackException()
    {
        Exception exception = null;
        try
        {
            deque.getBack();
            fail("getBack() is not throwing an exception when it should");
        }
        catch (Exception e)
        {
            exception = e;
        }
        assertTrue("getBack() is throwing the wrong type of exceptions",
                   exception instanceof EmptyQueueException);
    }
    
    /**
     * Tests that isEmpty method works as intended.
     */
    public void testIsEmpty() {
        
        assertTrue(deque.isEmpty());
        deque.addToBack("object");
        assertFalse(deque.isEmpty());
    }
    
    /**
     * Tests that clear method works as intended.
     */
    public void testClear() {
        
        deque.addToFront("object");
        assertFalse(deque.isEmpty());
        deque.clear();
        assertTrue(deque.isEmpty());
    }
    
    /**
     * Tests that toString method works as intended.
     */
    public void testToString() {
        
        deque.addToBack("object2");
        deque.addToFront("object1");
        assertEquals("[object1, object2]", deque.toString());
    }
    
    public void testRemoveSecond() {
        
        Exception thrown = null;
        try {
            deque.removeSecond();
        }
        catch (EmptyQueueException exception) {
            thrown = exception;
        }
        assertNotNull(thrown);
        
        deque.addToFront("object1");
        assertNull(deque.removeSecond());
        
        deque.addToFront("object2");
        deque.addToFront("object3");
        assertEquals("object2", deque.removeSecond());
        assertEquals(2, deque.size(), 0.1);
    }
    
    public void testRemoveSecondToLast() {
        
        Exception thrown = null;
        try {
            deque.removeSecondToLast();
        }
        catch (EmptyQueueException exception) {
            thrown = exception;
        }
        assertNotNull(thrown);
        
        deque.addToBack("object1");
        assertNull(deque.removeSecondToLast());
        
        deque.addToBack("object2");
        deque.addToBack("object3");
        assertEquals("object2", deque.removeSecondToLast());
        assertEquals(2, deque.size(), 0.1);
    }
}

