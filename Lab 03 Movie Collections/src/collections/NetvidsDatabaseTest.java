package collections;

import junit.framework.TestCase;
import java.util.NoSuchElementException;
/**
 *  Tests all the methods in NetvidsDatabase to
 * make sure they run and perform as expected
 *
 *  @author  Sean Sy (906311775)
 *  @version 2020.09.11
 */

public class NetvidsDatabaseTest extends TestCase {
    private NetvidsDatabase net;
    private Movie movie;
    
    /**
     * Sets up each test method before it runs
     */
    public void setUp()
    {
        net = new NetvidsDatabase();
        movie = new Movie("Spiderman");
        net.addMovie(movie);
    }
    
    /**
     * Tests that the addMovie method returns true when successfully
     * adding a movie and returns false when unsuccessful in adding a movie 
     */
    public void testAddMovie()
    {
        Movie movie1 = new Movie("Spiderman1");
        assertTrue(net.addMovie(movie1));
        assertFalse(net.addMovie(movie));
    }
    
    /**
     * Tests that the remove method returns the removed movie object, throws
     * an IllegalArgumentException when the movie object is null, and throws
     * a NoSuchElementException when the movie object isn't in the database
     */
    public void testRemove()
    {
        net.addMovie(movie);
        assertEquals(movie, net.remove(movie));
        Movie movie1 = null;
        Movie movie2 = new Movie("Spiderman");
        IllegalArgumentException myIAE = null;
        NoSuchElementException myNSEE = null;
        try 
        {
            net.remove(movie1);
        }
        catch (IllegalArgumentException iae)
        {
            myIAE = iae;
        }
        assertNotNull(myIAE);
        try
        {
            net.remove(movie2);
        }
        catch (NoSuchElementException nsee)
        {
            myNSEE = nsee;
        }
        assertNotNull(myNSEE);
    }
    
    /**
     * Tests that the contains method returns true if the database
     * contains the movie object and returns false if it does not
     */
    public void testContains()
    {
        assertTrue(net.contains(movie));
        net.remove(movie);
        assertFalse(net.contains(movie));
    }
    
    /**
     * Tests that the isEmpty method returns true if the database
     * is empty and returns false if the database is not empty
     */
    public void testIsEmpty()
    {
        assertFalse(net.isEmpty());
        net.remove(movie);
        assertTrue(net.isEmpty());
    }
    
    /**
     * Tests that the size method returns the correct
     * amount of movie objects in the database
     */
    public void testSize()
    {
        assertEquals(1, net.size());
        net.remove(movie);
        assertEquals(0, net.size());
    }
    
    /**
     * Tests that the capacity method returns the correct length
     * of the database
     */
    public void testCapacity()
    {
        assertEquals(10, net.capacity());
    }
    
    /**
     * Tests that the expandCapacity method is triggered when attempting
     * to add a movie object when the database is full and correctly 
     * double the capacity
     */
    public void testExpandCapacity()
    {
        Movie[] movies = new Movie[10];
        for (int i = 0; i < 10; i++)
        {
            movies[i] = new Movie("Spiderman" + i);
            net.addMovie(movies[i]);
        }
        assertEquals(20, net.capacity());
    }

}
