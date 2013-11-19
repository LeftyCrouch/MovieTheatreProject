
/**
 * list implementation for the list ADT.
 * list can add, remove, and get items from any position specified at the method call
 *
 * @author Chris Crouch
 * @author Donald Aufiero
 *
 */
public class ListArrayBased implements ListInterface
{

    private static final int MAX_LIST = 3;
    protected Object []items;  // an array of list items
    protected int numItems;  // number of items in list

    /**
     * basic constructor to make a list of size MAX_LIST
     */
    public ListArrayBased()
    {
        items = new Object[MAX_LIST];
        numItems = 0;
    }  // end default constructor

    /**
     * returns whether or not the list is empty
     *
     * @return boolean returns true if list is empty or false if it is not.
     *
     */
    public boolean isEmpty()
    {
        return (numItems == 0);
    } // end isEmpty

    /**
     * returns the size of the array
     *
     * @return numItems returns an int with the size of the array
     */
    public int size()
    {
        return numItems;
    }  // end size

    /**
     * clears the array of all items
     */
    public void removeAll()
    {
        // Creates a new array; marks old array for
        // garbage collection.
        items = new Object[MAX_LIST];
        numItems = 0;
    } // end removeAll

    /**
     * adds an item to the array at the specified position
     * throws an exception if it is out of index of the array
     *
     * @param index position at where to add item
     * @param item item to be added at specified position
     *
     */
    public void add(int index, Object item)
    throws  ListIndexOutOfBoundsException
    {
        if (numItems >= items.length) //fixes implementation error and fixes programming style
        {
            throw new ListException("ListException on add");
        }  // end if
        if (index >= 0 && index <= numItems)
        {
            // make room for new element by shifting all items at
            // positions >= index toward the end of the
            // list (no shift if index == numItems+1)
            for (int pos = numItems-1; pos >= index; pos--)  //textbook code modified to eliminate logic error causing ArrayIndexOutOfBoundsException
            {
                items[pos+1] = items[pos];
            } // end for
            // insert new item
            items[index] = item;
            numItems++;
        }
        else
        {
            // index out of range
            throw new ListIndexOutOfBoundsException(
                "ListIndexOutOfBoundsException on add");
        }  // end if
    } //end add

    public Object get(int index)
    throws ListIndexOutOfBoundsException
    {
        if (index >= 0 && index < numItems)
        {
            return items[index];
        }
        else
        {
            // index out of range
            throw new ListIndexOutOfBoundsException(
                "ListIndexOutOfBoundsException on get");
        }  // end if
    } // end get

    /**
     * removes an item from the array at the position specified.
     * throws expection if the position is out of bounds.
     *
     * @param index position to remove item from
     */
    public void remove(int index)
    throws ListIndexOutOfBoundsException
    {
        if (index >= 0 && index < numItems)
        {

            // delete item by shifting all items at
            // positions > index toward the beginning of the list
            // (no shift if index == size)
            for (int pos = index+1; pos < size(); pos++) //textbook code modified to eliminate logic error causing ArrayIndexOutOfBoundsException

            {
                items[pos-1] = items[pos];
            }  // end for
            numItems--;
            items[numItems] = null; //fixes memory leak
        }
        else
        {
            // index out of range
            throw new ListIndexOutOfBoundsException(
                "ListIndexOutOfBoundsException on remove");
        }  // end if
    } //end remove
}
