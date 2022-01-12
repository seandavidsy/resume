package collections;
/**
 * Tests all the methods in Movie to
 * make sure they run and perform as expected
 *
 *  @author  Sean Sy (906311775)
 *  @version 2020.09.11
 */

public class MovieTest extends student.TestCase {
    private Movie movie;
    
    /**
     * Sets up each test method before it runs
     */
    public void setUp() 
    {
        movie = new Movie("Spiderman");
        movie.setGenre("Action");
        movie.setYear(2002);
        movie.setRating(4);
    }
    
    /**
     * Tests that the genre matches
     */
    public void testGetGenre()
    {
        assertEquals("Action", movie.getGenre());
        movie.setGenre("Romance");
        assertEquals("Romance", movie.getGenre());
    }
    
    /**
     * Tests that the year matches
     */
    public void testGetYear()
    {
        assertEquals(2002, movie.getYear());
        movie.setYear(2005);
        assertEquals(2005, movie.getYear());
    }
    
    /**
     * Tests that the rating matches
     */
    public void testGetRating()
    {
        assertEquals(4, movie.getRating());
        movie.setRating(10);
        assertEquals(10, movie.getRating());
    }
    
    /**
     * Tests that two movie objects are equal when
     * the title matches and are not equal when the
     * titles don't match or if the object is null
     */
    public void testEquals()
    {
        Movie movie1 = new Movie("Thor");
        Movie movie2 = new Movie("Spiderman");
        Movie movie3 = null;
        Object other = new Object();
        assertTrue(movie.equals(movie));
        assertFalse(movie.equals(movie3));
        assertFalse(movie.equals(movie1));
        assertTrue(movie.equals(movie2));
        assertFalse(movie.equals(other));
    }
    
}
