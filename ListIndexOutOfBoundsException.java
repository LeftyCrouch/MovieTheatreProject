/**
 * Exception handling for lis ADT
 *
 * @author Chris Crouch
 * @author Donald Aufiero
 */

public class ListIndexOutOfBoundsException
    extends IndexOutOfBoundsException
{

    /**
     * list exception calling from the super class of IndexOutOfBoundsException
     *
     * @param string string to print when the exception is thrown
     */
    public ListIndexOutOfBoundsException(String s)
    {
        super(s);
    }  // end constructor
}  // end ListIndexOutOfBoundsException

