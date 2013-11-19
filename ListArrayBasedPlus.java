import java.io.*;
import java.util.*;

/**
 * Extended class of ListArrayBased with some modified methods
 *
 * @author Chris Crouch
 * @author Donald Aufiero
 *
 */
public class ListArrayBasedPlus extends ListArrayBased
{

    /**
     * constructor for list ADT specifying the exact size needed
     *
     * @param size size of the array to be created
     */
    public ListArrayBasedPlus(int size)
    {
        items = new Object[size];
        numItems = 0;
    }

    /**
     * empty constructor
     */
    public ListArrayBasedPlus()
    {

    }

    /**
     * add an item in the specified location.
     * modified to assume correct input anywhere possible in the size of the array
     *
     * @param index position in array to add item
     * @param item item to be added at position
     *
     */
    public void add(int index, Object item)
    {
        items[index] = item;
        numItems++;
    }

    /**
     * retrieve an item from the list.
     * modified to assume correct input as any position in array
     *
     * @param index position to retrieve item from
     *
     * @return returns the item in the position or null if no item in position
     */
    public Object get(int index)
    {
        return items[index];
    }

    /**
     * remove an item from the specified location.
     * modified to assume correct input as any position in the array
     *
     * @param index position to remove item from
     */
    public void remove(int index)
    {
        numItems--;
        items[index] = null;
    }

    /**
     * returns a string of the list of items in the array
     *
     * @return string string of items in the array
     */
    public String toString()
    {
        String print = "";
        for (int x = 0; x < items.length; x++)
            if (items[x] != null)
                print = print + items[x] + " ";
        return print;
    }
}



