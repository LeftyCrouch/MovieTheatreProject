
/**
 *
 * Customer Class is used to store information concerning the
 * customers name, party size, movie of their choice, and
 * if they have a member of the age of 12 or under
 *
 * @author Chris Crouch
 * @author Donald Aufiero
 *
 * @date 12/5/11
 *
 * edited by Chris Crouch and Donald Aufiero
 *
 */
public class Customer
{
    private String name;    // name of group of customers
    private int partySize;  // the size of the group
    private String movie;   // name of movie they want to see
    private boolean twelve; // true if they have a child twelve or younger

    /**
     * Constructor for objects of class Customer
     * and initialization of parameters for customer
     *
     * @param name Name of group
     * @param partySize Size of the group
     * @param movie Movie they choose to see
     * @param twelve True/False if they have a child twelve or under
     *
     */
    public Customer(String name, int partySize, String movie, boolean twelve)
    {
        this.name = name;
        this.partySize = partySize;
        this.movie = movie;
        this.twelve = twelve;
    }

    /**
     * Access the name of the customer
     *
     * @return name - returns name of customer group
     */
    public String getName()
    {
        return name;
    }

    /**
     * Access the party size of the customer
     *
     * @return partySize - returns the size of the customers party
     */
    public int getPartySize()
    {
        return partySize;
    }

    /**
     * Access the movie the customer wants to see
     *
     * @return movie - returns the movie that the customer wants to see
     */
    public String getMovie()
    {
        return movie;
    }

    /**
     * Access the boolean of whether a child twelve or under is present
     *
     * @return twelve - returns a boolean if customer has a child twelve or under
     */
    public boolean getTwelve()
    {
        return twelve;
    }

    /**
     * toString method to print out information concerning the customer
     *
     * @return String - returns a string with the information about the customer
     */
    public String toString()
    {
        String information = "Customer " + name + " party of " + partySize + " is in line for the " + movie + " movie.";

        return information;
    }

}

