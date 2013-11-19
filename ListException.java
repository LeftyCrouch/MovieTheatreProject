
/**
 * Exception handling for list ADT
 *
 * @author Chris Crouch
 * @author Donald Aufiero
 */
public class ListException extends RuntimeException
{
    /**
     * list exception calling from super class of RuntimeException
     *
     * @param string  string to print when exception is thrown
     */
    public ListException(String s)
    {
        super(s);
    }  // end constructor
}  // end ListException

