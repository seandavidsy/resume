package collections;
/**
 *  MovieCollection represents a database of Movie objects.
 *
 *  @author  Sean Sy (906311775)
 *  @version 2020.09.11
 */
public interface MovieCollection
{
    // ----------------------------------------------------------
    /**
     * Add a movie object to the database. 
     * Duplicate movies are not allowed.
     * @param aMovie The movie to be added.
     * @return true if a movie was added, false if unable to add
     */
    public boolean addMovie(Movie aMovie);

    // ----------------------------------------------------------
    /**
     * Removes a specific movie.
     * @param movie The movie to be removed.
     * @return the Movie object that was removed.
     */
    public Movie remove(Movie movie);

    // ----------------------------------------------------------
    /**
     * Determines whether or not the database contains a specific movie.
     * @param movie The movie to be checked.
     * @return Returns true if the movie exists in the database.
     */
    public boolean contains(Movie movie);

    // ----------------------------------------------------------
    /**
     * Determines if the database has any movies.
     * @return Returns true if the database is empty (0 Movie objects).
     */
    public boolean isEmpty();

    // ----------------------------------------------------------
    /**
     * The number of Movie objects currently in the database.
     * @return The number of movies.
     */
    public int size();

    // ----------------------------------------------------------
    /**
     * The number of movies that the database can currently hold
     * before expanding its capacity.
     * @return The number of slots.
     */
    public int capacity();
}