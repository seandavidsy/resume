package icecream;

/**
 * 
 * The IceCreamConeTest class tests the methods from IceCreamCone class
 * 
 * @author Sean Sy (906311775)
 * 
 * @version 9.18.2020
 *
 */

public class IceCreamConeTest extends student.TestCase 
{ 
    private IceCreamCone cone;
    private IceCreamCone empty;
    
    /**
     *  Sets up each test method before it is ran
     */
    public void setUp()
    {
        cone = new IceCreamCone();
        empty = new IceCreamCone();
        cone.addScoop("chocolate");
        cone.addScoop("vanilla");
        cone.addScoop("strawberry");        
    }
    
    /**
     * Tests that eatScoop() removes and returns the string at the top of the
     * flavors stack
     * 
     */
    public void testEatScoop()
    {
        assertEquals("strawberry", cone.eatScoop());
    }
    
    /**
     * Tests that addScoop() adds a new string at the top of the flavors stack
     * 
     */
    public void testAddScoop()
    {
        cone.addScoop("mint");
        assertTrue(cone.contains("mint"));
    }
    
    /**
     * Tests that numScoops() returns the correct amount of scoops on the cone
     * 
     */
    public void testNumScoops()
    {
        assertEquals(3, cone.numScoops());
    }
    
    /**
     * Tests that contains() returns true when the flavors stack contains the
     * string parameter and false when the flavors stack does not
     * 
     */
    public void testContains()
    {
        assertTrue(cone.contains("chocolate"));
        assertFalse(cone.contains("mint"));
    }
    
    /**
     * Tests that emptyCone() returns true when numScoops = 0 and returns
     * false when numScoops is not 0
     * 
     */
    public void testEmptyCone()
    {
        assertFalse(cone.emptyCone());
        assertTrue(empty.emptyCone());
    }
    
    /**
     * Tests that currentScoop() returns the correct string at the top of the
     * flavors stack without removing it
     * 
     */
    public void testCurrentScoop()
    {
        assertEquals("strawberry", cone.currentScoop());
    }
    
    /**
     * Tests that toString() returns a string representation of the ice cream
     * cone in the format: [flavor1, flavor2, flavor3]
     * 
     */
    public void testToString()
    {
        assertEquals("[chocolate, vanilla, strawberry]", cone.toString());
    }
    
    /**
     * Tests that equals() returns true when the two ice cream cones being
     * compared contain the same flavors in the same order and returns false
     * otherwise
     * 
     */
    public void testEquals()
    {
        IceCreamCone cone1 = new IceCreamCone();
        IceCreamCone nullCone = null;
        Object obj = new Object();
        
        cone1.addScoop("chocolate");
        cone1.addScoop("vanilla");
        cone1.addScoop("strawberry");
        
        assertTrue(cone.equals(cone));
        assertTrue(cone.equals(cone1));
        assertFalse(cone.equals(nullCone));
        assertFalse(cone.equals(obj));        
    }
}
