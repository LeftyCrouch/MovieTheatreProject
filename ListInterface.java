/**
 * Interface for ListArrayBased class
 *
 * @author Chris Crouch
 * @author Donald Aufiero
 *
 */
public interface ListInterface
{
    /**
     * determines whether a list is empty.
     *
     * @see ListArrayBased method - isEmpty()
     */
    boolean isEmpty();

    /**
     * return the size of the list
     *
     * @see ListArrayBased method - size()
     *
     */
    int size();

    /**
     * add an item o the list at specified position
     *
     * @see ListArrayBased method - add(int index, Object item) throws ListIndexOutOfBoudnsException
     *
     */
    void add(int index, Object item)
    throws ListIndexOutOfBoundsException;

    /**
     * return an item from a specified location if one is located there
     *
     * @see ListArrayBased method - get(int index) throws ListIndexOutOfBoundsException
     */
    Object get(int index)
    throws ListIndexOutOfBoundsException;

    /**
     * remove item at specified lposition if position is not null
     *
     * @see ListArraybased method - remove(int index) throws ListIndexOutOfBoundsException
     */
    void remove(int index)
    throws ListIndexOutOfBoundsException;

    /**
     * clears the list of all items
     *
     * @see ListArrayBased method - removeAll()
     */
    void removeAll();
}  // end ListInterface

