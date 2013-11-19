/**
 * Exception handling for Queue ADT
 *
 * @author Chris Crouch
 * @author Donald Aufiero
 */

public class QueueException extends RuntimeException
{

    /**
     * queue exception calling from super class of RuntimeException
     *
     * @param string string to print when exception is thrown
     */
    public QueueException(String s)
    {
        super(s);
    }  // end constructor
}  // end QueueException
